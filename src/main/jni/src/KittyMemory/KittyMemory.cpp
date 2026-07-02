#include "KittyMemory.h"
#include <cstdio>
#include <cstring>
#include <vector>

#define _SYS_PAGE_SIZE_ (sysconf(_SC_PAGE_SIZE))
#define _PAGE_START_OF_(x)    ((uintptr_t)x & ~(uintptr_t)(_SYS_PAGE_SIZE_ - 1))
#define _PAGE_END_OF_(x, len) (_PAGE_START_OF_((uintptr_t)x + len - 1))
#define _PAGE_LEN_OF_(x, len) (_PAGE_END_OF_(x, len) - _PAGE_START_OF_(x) + _SYS_PAGE_SIZE_)
#define _PROT_RWX_ (PROT_READ | PROT_WRITE | PROT_EXEC)
#define _PROT_RX_  (PROT_READ | PROT_EXEC)

using namespace KittyMemory;

static std::vector<mapsCache> __mapsCache;

static mapsCache findMapInCache(const char* libraryName) {
    for (size_t i = 0; i < __mapsCache.size(); i++) {
        if (__mapsCache[i].pathname.find(libraryName) != std::string::npos) {
            return __mapsCache[i];
        }
    }
    return {};
}

static mapsCache getLibraryMap(const char *libraryName) {
    mapsCache retMap = {};
    char line[512] = {0};
    FILE *fp = fopen("/proc/self/maps", "rt");
    if (fp != NULL) {
        while (fgets(line, sizeof(line), fp)) {
            if (strstr(line, libraryName)) {
                char tmpPerms[5] = {0}, tmpDev[12] = {0}, tmpPathname[444] = {0};
                long offset;
                int inode;
                sscanf(line, "%llx-%llx %s %ld %s %d %s",
                       (long long unsigned *) &retMap.startAddr,
                       (long long unsigned *) &retMap.endAddr,
                       tmpPerms, &offset, tmpDev, &inode, tmpPathname);
                retMap.length = (uintptr_t) retMap.endAddr - (uintptr_t) retMap.startAddr;
                retMap.perms = tmpPerms;
                retMap.pathname = tmpPathname;
                break;
            }
        }
        fclose(fp);
    }
    return retMap;
}

uintptr_t KittyMemory::getAbsoluteAddress(const char *libraryName, uintptr_t relativeAddr, bool useCache) {
    mapsCache libMap = {};
    if (useCache) {
        libMap = findMapInCache(libraryName);
        if (libMap.startAddr != 0)
            return (libMap.startAddr + relativeAddr);
    }
    libMap = getLibraryMap(libraryName);
    if (libMap.startAddr == 0)
        return 0;
    if (useCache) {
        __mapsCache.push_back(libMap);
    }
    return (libMap.startAddr + relativeAddr);
}
