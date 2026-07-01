#ifndef UTILS_H
#define UTILS_H

#include <pthread.h>
#include <android/log.h>
#include <jni.h>
#include <iostream>
#include <fstream>
#include <string>
#include <stdio.h>
#include <string.h>
#include <unistd.h>
#include <fcntl.h>
#include <arpa/inet.h>
#include <netdb.h>
#include <stdlib.h>
#include <assert.h>

#include "src/KittyMemory/MemoryPatch.h"
#include <src/Substrate/CydiaSubstrate.h>
#include "src/Unity/Unity.h"

typedef unsigned long DWORD;

DWORD libBase = 0;

const char* libName = "libil2cpp.so";

DWORD get_libBase(const char* libName);
DWORD getRealOffset(DWORD address);

DWORD get_libBase(const char* libName) {
    FILE *fp;
    DWORD addr = 0;
    char filename[32], buffer[1024];
    snprintf(filename, sizeof(filename), "/proc/%d/maps", getpid());
    fp = fopen(filename, "rt");
    if (fp != nullptr) {
        while (fgets(buffer, sizeof(buffer), fp)) {
            if (strstr(buffer, libName)) {
                addr = (uintptr_t) strtoul(buffer, nullptr, 16);
                break;
            }
        }
        fclose(fp);
    }
    return addr;
}

DWORD getRealOffset(DWORD address) {
    if (libBase == 0) {
        libBase = get_libBase(libName);
    }
    return (libBase + address);
}



//ForLibanogs
typedef unsigned long jumpOffset;
jumpOffset anogsBase = 0;


jumpOffset GetBaseAnogs(const char* anogsName);
jumpOffset AnogsRealOffset(jumpOffset address);


jumpOffset GetBaseAnogs(const char* anogsName) {
    char nameFile[32], buffer[1024];
    jumpOffset addr = 0;
    FILE* Files;
    
    snprintf(nameFile, sizeof(nameFile), "/proc/%d/maps", getpid());
    Files = fopen(nameFile, "rt");
    
    if (Files != nullptr) {
        while (fgets(buffer, sizeof(buffer), Files)) {
            if (strstr(buffer, anogsName)) {
                addr = (uintptr_t) strtoul(buffer, nullptr, 16);
                break;
            }
        }
        fclose(Files);
    }
    return addr;
}


jumpOffset AnogsRealOffset(jumpOffset address) {
    if (anogsBase == 0) {
        anogsBase = GetBaseAnogs("libanogs.so");
    }
    return (anogsBase + address);
}

#endif
