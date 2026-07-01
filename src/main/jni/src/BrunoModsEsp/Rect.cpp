#include "Rect.h"

void Rect2::Cleanup() {
    env->DeleteGlobalRef(m_Rect);
    delete[] this;
}

int Rect2::getLeft() {
    return env->GetIntField(this->m_Rect, this->leftId);
}

int Rect2::getRight(){
    return env->GetIntField(this->m_Rect, this->rightId);
}

int Rect2::getTop(){
    return env->GetIntField(this->m_Rect, this->topId);
}

int Rect2::getBottom(){
    return env->GetIntField(this->m_Rect, this->bottomId);
}

int Rect2::getWidth() {
    return getRight() - getLeft();
}

int Rect2::getHeight() {
    return getBottom() - getTop();
}

