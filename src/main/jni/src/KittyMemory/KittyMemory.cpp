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

struct mapsCache {
    std::string identifier;
    ProcMap2 map;
};

static std::vector<mapsCache> __mapsCache;

bool KittyMemory::ProtectAddr(void *addr, size_t length, int protection) {
    uintptr_t pageStart = _PAGE_START_OF_(addr);
    uintptr_t pageLen   = _PAGE_LEN_OF_(addr, length);
    return (mprotect(reinterpret_cast<void *>(pageStart), pageLen, protection) != -1);
}

Memory_Status2 KittyMemory::memWrite(void *addr, const void *buffer, size_t len) {
    if (addr == NULL) return INV_ADDR;
    if (buffer == NULL) return INV_BUF;
    if (len < 1) return INV_LEN;
    if (!ProtectAddr(addr, len, _PROT_RWX_)) return INV_PROT;
    if (memcpy(addr, buffer, len) != NULL && ProtectAddr(addr, len, _PROT_RX_)) return SUCCESS;
    return FAILED;
}

Memory_Status2 KittyMemory::memRead(void *buffer, const void *addr, size_t len) {
    if (addr == NULL) return INV_ADDR;
    if (buffer == NULL) return INV_BUF;
    if (len < 1) return INV_LEN;
    if (memcpy(buffer, addr, len) != NULL) return SUCCESS;
    return FAILED;
}

std::string KittyMemory::read2HexStr(const void *addr, size_t len) {
    std::string ret;
    unsigned char *temp = (unsigned char *)malloc(len);
    if (memRead(temp, addr, len) != SUCCESS) {
        free(temp);
        return ret;
    }
    char buf[3];
    for (size_t i = 0; i < len; i++) {
        sprintf(buf, "%02X", temp[i]);
        ret += buf;
    }
    free(temp);
    return ret;
}

ProcMap2 KittyMemory::getLibraryMap(const char *libraryName) {
    ProcMap2 retMap = {};
    char line[512] = {0};
    FILE *fp = fopen("/proc/self/maps", "rt");
    if (fp != NULL) {
        while (fgets(line, sizeof(line), fp)) {
            if (strstr(line, libraryName)) {
                char tmpPerms[5] = {0}, tmpDev[12] = {0}, tmpPathname[444] = {0};
                sscanf(line, "%llx-%llx %s %*ld %s %d %s",
                       (long long unsigned *) &retMap.startAddr,
                       (long long unsigned *) &retMap.endAddr,
                       tmpPerms, tmpDev, &retMap.inode, tmpPathname);
                retMap.length = retMap.endAddr - retMap.startAddr;
                retMap.perms = tmpPerms;
                retMap.dev = tmpDev;
                retMap.pathname = tmpPathname;
                break;
            }
        }
        fclose(fp);
    }
    return retMap;
}

uintptr_t KittyMemory::getAbsoluteAddress(const char *libraryName, uintptr_t relativeAddr, bool useCache) {
    ProcMap2 libMap = {};
    if (useCache) {
        for (size_t i = 0; i < __mapsCache.size(); i++) {
            if (__mapsCache[i].identifier == libraryName) {
                libMap = __mapsCache[i].map;
                break;
            }
        }
    }
    if (!libMap.isValid()) {
        libMap = getLibraryMap(libraryName);
        if (libMap.isValid() && useCache) {
            __mapsCache.push_back({libraryName, libMap});
        }
    }
    return libMap.isValid() ? (libMap.startAddr + relativeAddr) : 0;
}
