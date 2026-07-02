#include "KittyUtils.h"
#include <cstdio>
#include <cstring>

static void xtrim(std::string &hex){
    if(hex.compare(0, 2, "0x") == 0){
        hex.erase(0, 2);
    }
    hex.erase(std::remove_if(hex.begin(), hex.end(), [](char c){
        return (c == ' ' || c == '\n' || c == '\r' ||
                c == '\t' || c == '\v' || c == '\f');
    }), hex.end());
}

bool KittyUtils::validateHexString(std::string &xstr){
    if(xstr.length() < 2) return false;
    xtrim(xstr);
    if(xstr.length() % 2 != 0) return false;
    for(size_t i = 0; i < xstr.length(); i++){
        if(!std::isxdigit((unsigned char)xstr[i])){
            return false;
        }
    }
    return true;
}

void KittyUtils::toHex(void *const data, const size_t dataLength, std::string &dest) {
    unsigned char *byteData = reinterpret_cast<unsigned char*>(data);
    dest.clear();
    dest.reserve(dataLength * 2);
    char buf[3];
    for(size_t index = 0; index < dataLength; ++index) {
        sprintf(buf, "%02x", byteData[index]);
        dest.append(buf);
    }
}

void KittyUtils::fromHex(const std::string &in, void *const data) {
    size_t length = in.length();
    unsigned char *byteData = reinterpret_cast<unsigned char*>(data);
    for(size_t strIndex = 0, dataIndex = 0; strIndex < length; strIndex += 2, ++dataIndex) {
        char tmpStr[3] = { in[strIndex], in[strIndex+1], 0 };
        int tmpValue = 0;
        sscanf(tmpStr, "%x", &tmpValue);
        byteData[dataIndex] = static_cast<unsigned char>(tmpValue);
    }
}
