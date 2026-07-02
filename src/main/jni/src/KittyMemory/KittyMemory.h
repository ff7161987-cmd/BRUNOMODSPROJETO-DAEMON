#pragma once
#include <stdio.h>
#include <string>
#include <unistd.h>
#include <sys/mman.h>
#include <vector>

namespace KittyMemory {
    struct mapsCache {
        uintptr_t startAddr;
        uintptr_t endAddr;
        size_t length;
        std::string perms;
        std::string pathname;
    };
    uintptr_t getAbsoluteAddress(const char *libraryName, uintptr_t relativeAddr, bool useCache = true);
    bool setBaseAddress(const char *libraryName);
    uintptr_t getBaseAddress();
}
