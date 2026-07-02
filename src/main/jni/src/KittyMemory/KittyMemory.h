#ifndef KittyMemory_h
#define KittyMemory_h

#include <string>
#include <vector>
#include <sys/mman.h>
#include <unistd.h>
#include <iostream>

namespace KittyMemory {

    struct ProcMap2 {
        uintptr_t startAddr;
        uintptr_t endAddr;
        size_t length;
        std::string perms;
        std::string dev;
        int inode;
        std::string pathname;

        bool isValid() const { return startAddr > 0 && endAddr > startAddr; }
    };

    bool ProtectAddr(void *addr, size_t length, int protection);
    
    enum Memory_Status2 {
        SUCCESS,
        FAILED,
        INV_ADDR,
        INV_BUF,
        INV_LEN,
        INV_PROT
    };

    Memory_Status2 memWrite(void *addr, const void *buffer, size_t len);
    Memory_Status2 memRead(void *buffer, const void *addr, size_t len);
    std::string read2HexStr(const void *addr, size_t len);
    
    ProcMap2 getLibraryMap(const char *libraryName);
    uintptr_t getAbsoluteAddress(const char *libraryName, uintptr_t relativeAddr, bool useCache = true);

}

#endif
