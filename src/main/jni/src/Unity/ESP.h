#ifndef ESP_H
#define ESP_H

#include <jni.h>
#include "StructsCommon.h"

  class ESP {
    private:
    JNIEnv *_env;
    jobject _cvsView;
    jobject _cvs;

    public:
    ESP() {
     _env = nullptr;
     _cvsView = nullptr;
     _cvs = nullptr;
    }

    ESP(JNIEnv *env, jobject cvsView, jobject cvs) {
        this->_env = env;
        this->_cvsView = cvsView;
        this->_cvs = cvs;
    }
	
	

	/*---isValid---*/
    bool isValid() const {
        return (_env != nullptr && _cvsView != nullptr && _cvs != nullptr);
    }

	/*---getWidth---*/
    int getWidth() const {
        if (isValid()) {
            jclass canvas = _env->GetObjectClass(_cvs);
            jmethodID width = _env->GetMethodID(canvas, "getWidth", "()I");
            return _env->CallIntMethod(_cvs, width);
        }
        return 0;
    }
	
    /*---getHeight---*/
    int getHeight() const {
        if (isValid()) {
            jclass canvas = _env->GetObjectClass(_cvs);
            jmethodID width = _env->GetMethodID(canvas, "getHeight", "()I");
            return _env->CallIntMethod(_cvs, width);
        }
        return 0;
    }
	
	/*---DrawLine---*/
    void DrawLine(Color color, float thickness, Vector3 start, Vector3 end) {
        if (isValid()) {
            jclass canvasView = _env->GetObjectClass(_cvsView);
            jmethodID drawline = _env->GetMethodID(canvasView, "DrawLine", "(Landroid/graphics/Canvas;IIIIFFFFF)V");
            _env->CallVoidMethod(_cvsView, drawline, _cvs, (int) color.a, (int) color.r, (int) color.g, (int) color.b, thickness, start.X, start.Y, end.X, end.Y);
        }
    }
	
    /*---DrawText---*/
    void DrawText(Color color, const char *txt, Vector3 pos, float size) {
        if (isValid()) {
            jclass canvasView = _env->GetObjectClass(_cvsView);
            jmethodID drawtext = _env->GetMethodID(canvasView, "DrawText", "(Landroid/graphics/Canvas;IIIILjava/lang/String;FFF)V");
            _env->CallVoidMethod(_cvsView, drawtext, _cvs, (int) color.a, (int) color.r, (int) color.g, (int) color.b, _env->NewStringUTF(txt), pos.X, pos.Y, size);                               
        }
    }
	
    /*---DrawCircle---*/
    void DrawCircle(Color color, float stroke, Vector3 pos, float radius) {
        if (isValid()) {
            jclass canvasView = _env->GetObjectClass(_cvsView);
            jmethodID drawcircle = _env->GetMethodID(canvasView, "DrawCircle", "(Landroid/graphics/Canvas;IIIIFFFF)V");
            _env->CallVoidMethod(_cvsView, drawcircle, _cvs, (int) color.a, (int) color.r, (int) color.g, (int) color.b,stroke, pos.X, pos.Y, radius);
        }
    }
	
    /*---DrawFilledRect---*/
    void DrawFilledRect(Color color, Vector3 pos, float width, float height) {
        if (isValid()) {
            jclass canvasView = _env->GetObjectClass(_cvsView);
            jmethodID drawfilledrect = _env->GetMethodID(canvasView, "DrawFilledRect", "(Landroid/graphics/Canvas;IIIIFFFF)V");
            _env->CallVoidMethod(_cvsView, drawfilledrect, _cvs, (int) color.a, (int) color.r, (int) color.g, (int) color.b, pos.X, pos.Y, width, height);
        }
    }
	
    /*---DrawFilledCircle---*/
    void DrawFilledCircle(Color color, Vector3 pos, float radius) {
        if (isValid()) {
            jclass canvasView = _env->GetObjectClass(_cvsView);
            jmethodID drawfilledcircle = _env->GetMethodID(canvasView, "DrawFilledCircle", "(Landroid/graphics/Canvas;IIIIFFF)V");
            _env->CallVoidMethod(_cvsView, drawfilledcircle, _cvs, (int) color.a, (int) color.r, (int) color.g, (int) color.b, pos.X, pos.Y, radius);
        }
    }
	
    /*---DrawBox---*/
    void DrawBox(Color color, float stroke, Rect rect) {
        Vector3 v1 = Vector3(rect.x, rect.y);
        Vector3 v2 = Vector3(rect.x + rect.width, rect.y);
        Vector3 v3 = Vector3(rect.x + rect.width, rect.y + rect.height);
        Vector3 v4 = Vector3(rect.x, rect.y + rect.height);

		
        DrawLine(color, stroke, v1, v2); // LINE UP
        DrawLine(color, stroke, v2, v3); // LINE RIGHT
        DrawLine(color, stroke, v3, v4); // LINE DOWN
        DrawLine(color, stroke, v4, v1); // LINE LEFT
    }

	/*---DrawHorizontalHealthBar---*/
	void DrawHorizontalHealthBar(Vector3 screenPos, float width, float maxHealth, float currentHealth) {
        screenPos -= Vector3(0.0f, 8.0f);
        DrawBox(Color(0, 0, 0, 255), 3, Rect(screenPos.X, screenPos.Y, width + 2, 5.0f));
        screenPos += Vector3(1.0f, 1.0f);
        Color clr = Color(0, 255, 0, 255);
        float hpWidth = (currentHealth * width) / maxHealth;
        if (currentHealth <= (maxHealth * 0.6)) {
            clr = Color(255, 255, 0, 255);
        }
        if (currentHealth < (maxHealth * 0.3)) {
            clr = Color(255, 0, 0, 255);
        }
        DrawBox(clr, 3, Rect(screenPos.X, screenPos.Y, hpWidth, 3.0f));
    }
	
	void DrawVerticalHealth(Vector3 end, float h, float health) {

        float x = end.X;
        float y = end.Y;
        h = -h;

        Color clr = Color(0, 255, 0, 255);

        float hpwidth = h-h*health/100;

        if (health <= (100 * 0.6)) {
            clr = Color(255, 255, 0, 255);
        }
        if (health < (100 * 0.3)) {
            clr = Color(255, 0, 0, 255);
        }

        Rect hpbar((x+h/4)-8,y,4.0f,-h);
        Rect hp((x+h/4)-8,y-hpwidth,2.0f,-h+hpwidth);

        DrawBox(Color(0,0,0,255), 3, hpbar);

        DrawBox(clr,3, hp);

    }
	
    /*---DrawCrosshair---*/
    void DrawCrosshair(Color clr, Vector3 center, float size = 20) {
        float x = center.X - (size / 2.0f);
        float y = center.Y- (size / 2.0f);
        DrawLine(clr, 3, Vector3(x, center.Y), Vector3(x + size, center.Y));
        DrawLine(clr, 3, Vector3(center.X, y), Vector3(center.X, y + size));
    }
};


Color Distance(int distance){
Color ColorDistance;
	if (distance < 150)
        ColorDistance = Color::Purple();
    if (distance < 145)
        ColorDistance = Color::Gray();
    if (distance < 140)
        ColorDistance = Color::Magenta();
    if (distance < 130)
        ColorDistance = Color::Cyan();
    if (distance < 120)
        ColorDistance = Color::Yellow();
    if (distance < 110)
        ColorDistance = Color::Black();
    if (distance < 100)
        ColorDistance = Color::White();
    if(distance < 90)
        ColorDistance = Color::Blue();
    if(distance < 85)
        ColorDistance = Color::Green();
    if(distance < 80)
        ColorDistance = Color::Red();
    if(distance < 70) 
        ColorDistance = Color::Orange();
    if(distance < 60)
        ColorDistance = Color::Teal();
    if(distance < 50)
        ColorDistance = Color::SteelBlue();
    if(distance < 40) 
        ColorDistance = Color::DeepPink();
    if(distance < 30)
        ColorDistance = Color::Yellow();
    if(distance < 20) 
        ColorDistance = Color::Green();
    if(distance < 10)
        ColorDistance = Color::White();
    if(distance < 5)
        ColorDistance = Color::Red();
    return ColorDistance;
}

#endif

