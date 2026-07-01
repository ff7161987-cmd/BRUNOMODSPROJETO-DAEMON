#ifndef CHAMS_H
#define CHAMS_H
#include <GLES2/gl2.h>
#include <dlfcn.h>

static void *handle;
static const char* shaderName;
static bool enableWallhack;

void setShader(const char* brunoModzDev) {
    shaderName = brunoModzDev;
}

const char* getShader() {
    return shaderName;
}

void SetWallhack(bool enable){
    enableWallhack = enable;
}

bool getWallhackEnabled(){
    return enableWallhack;
}

GLint (*BrunoDevold_glGetUniformLocation)(GLuint program, const char *name);
GLint BrunoDevnew_glGetUniformLocation(GLuint program, const char *name) {
    
    return BrunoDevold_glGetUniformLocation(program, name);
}

bool isCurrentShader(const char *shader) {
    GLint currProgram;
    glGetIntegerv(GL_CURRENT_PROGRAM, &currProgram);
    return BrunoDevold_glGetUniformLocation(currProgram, shader) != -1;
}


void (*BrunoDevDrawElements)(GLenum mode, GLsizei count, GLenum type, const void *indices);
void   BrunoDevglDrawElements(GLenum mode, GLsizei count, GLenum type, const void *indices) {
    BrunoDevDrawElements(mode, count, type, indices);
    if (mode != GL_TRIANGLES || count < 10000) return; {
        if (isCurrentShader(getShader())) {
            if (getWallhackEnabled()) {
                glDisable(GL_DEPTH_TEST);
                BrunoDevDrawElements(mode, count, type, indices);
                glEnable(GL_DEPTH_TEST);
				
             /* glDepthRangef(1, 0.5);
                glColorMask(ChamsColor, 1);
                glEnable(GL_BLEND);
                glBlendFunc(GL_SRC_ALPHA, GL_ONE);*/
                
            }
         /* BrunoDevDrawElements(mode, count, type, indices);
            glDepthRangef(0.5, 1);
            glColorMask(1, 1, 1, 1);
            glDisable(GL_BLEND);*/
        }
    }
}

bool mlovinit() {
    handle = 0;
    handle = dlopen("libGLESv2.so", RTLD_LAZY);
    if(!handle) {
        LOGE(("Cannot open library: %s"), dlerror());
        return false;
    }
    return true;
}

void LogShaders() {
    auto BrunoDevUniformLocation = (const void*(*)(...))dlsym(handle, ("glGetUniformLocation"));
    const char *dlsym_error = dlerror();
    if(dlsym_error) {
        LOGE(("BrunoModsDevlp 'glGetUniformLocation': %s"), dlsym_error);
        return;
    } else {
        MSHookFunction(reinterpret_cast<void*>(BrunoDevUniformLocation), reinterpret_cast<void*>(BrunoDevnew_glGetUniformLocation), reinterpret_cast<void**>(&BrunoDevold_glGetUniformLocation));
    }
}

void Wallhack() {
    auto BrunoDevp_glDrawElements = (const void*(*)(...))dlsym(handle, "glDrawElements");
    const char *dlsym_error = dlerror();
    if(dlsym_error){
        LOGE(("BrunoModsDevlp 'glDrawElements': %s"), dlsym_error);
        return;
    } else {
        MSHookFunction(reinterpret_cast<void*>(BrunoDevp_glDrawElements), reinterpret_cast<void*>(BrunoDevglDrawElements), reinterpret_cast<void**>(&BrunoDevDrawElements));
    }
}

#endif
