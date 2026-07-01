LOCAL_PATH := $(call my-dir)
MAIN_LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)
LOCAL_MODULE := libAegisGL
LOCAL_SRC_FILES := src/Unity/GL/libAegisGL.a
LOCAL_EXPORT_C_INCLUDES := $(LOCAL_PATH)/src/Unity/GL/include
include $(PREBUILT_STATIC_LIBRARY)

include $(CLEAR_VARS)

LOCAL_MODULE := BrunoModder

LOCAL_ARM_MODE := arm
LOCAL_CFLAGS := -Wno-error=format-security -fpermissive -fvisibility=hidden -fvisibility-inlines-hidden
LOCAL_CFLAGS += -fno-rtti -fno-exceptions -g0 -fomit-frame-pointer -ffunction-sections -fdata-sections
LOCAL_CPPFLAGS += -fvisibility=hidden -ffunction-sections -fdata-sections
LOCAL_LDFLAGS += -Wl,--strip-all

LOCAL_C_INCLUDES += $(MAIN_LOCAL_PATH)
LOCAL_SRC_FILES := src/main.cpp \
 src/Substrate/hde64.c \
 src/DHook/dhook.cpp \
 src/Unity/Chams.h \
 src/Substrate/SubstrateDebug.cpp \
 src/Substrate/SubstrateHook.cpp \
 src/Substrate/SubstratePosixMemory.cpp \
 src/BrunoModsEsp/Rect.cpp \
 src/BrunoModsEsp/Paint.cpp \
 src/BrunoModsEsp/Canvas.cpp \
 src/BrunoModsEsp/Typeface.cpp \
 src/KittyMemory/KittyMemory.cpp \
 src/KittyMemory/MemoryPatch.cpp \
 src/KittyMemory/MemoryBackup.cpp \
 src/KittyMemory/KittyUtils.cpp \
 src/memory/Ptrace.cpp \
 src/memory/Memory.cpp
 
LOCAL_LDLIBS := -llog -landroid -lEGL -lGLESv2
LOCAL_STATIC_LIBRARIES := libAegisGL

include $(BUILD_SHARED_LIBRARY)
