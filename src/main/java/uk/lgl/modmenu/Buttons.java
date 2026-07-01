package uk.lgl.modmenu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.TypedValue;

public class Buttons {
	
	protected static String encript(String enc) {
        if (enc.equals("!")) {
            return "a";
        } else if (enc.equals(";")) {
            return "b";
        } else if (enc.equals('"')) {
            return "c";
        } else if (enc.equals("#")) {
            return "d";
        } else if (enc.equals("÷")) {
            return "e";
        } else if (enc.equals("$")) {
            return "f";
        } else if (enc.equals("%")) {
            return "g";
        } else if (enc.equals("^")) {
            return "h";
        } else if (enc.equals("£")) {
            return "i";
        } else if (enc.equals("&")) {
            return "j";
        } else if (enc.equals("*")) {
            return "k";
        } else if (enc.equals("(")) {
            return "l";
        } else if (enc.equals("?")) {
            return "m";
        } else if (enc.equals(",")) {
            return "n";
        } else if (enc.equals("¥")) {
            return "o";
        } else if (enc.equals("₩")) {
            return "p";
        } else if (enc.equals("+")) {
            return "q";
        } else if (enc.equals("=")) {
            return "r";
        } else if (enc.equals("@")) {
            return "s";
        } else if (enc.equals("/")) {
            return "t";
        } else if (enc.equals("€")) {
            return "u";
        } else if (enc.equals(":")) {
            return "v";
        } else if (enc.equals("×")) {
            return "w";
        } else if (enc.equals("'")) {
            return "x";
        } else if (enc.equals("_")) {
            return "y";
        } else if (enc.equals("-")) {
            return "z";
        }
        return "FALHA!!!";
	}
    
    public static GradientDrawable botoes(Context context) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setStroke(5, Color.parseColor((String)"#00ffff"));
        gradientDrawable.setCornerRadius(TypedValue.applyDimension((int)1, (float)5.0f, (DisplayMetrics)context.getResources().getDisplayMetrics()));
        return gradientDrawable;
    }

    public static GradientDrawable botoes_ativados(Context context) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setStroke(5, Color.parseColor((String)"#00ffff"));
        gradientDrawable.setColor(Color.BLUE);
        gradientDrawable.setCornerRadius(TypedValue.applyDimension((int)1, (float)5.0f, (DisplayMetrics)context.getResources().getDisplayMetrics()));
        return gradientDrawable;
    }

    public static StateListDrawable botoes_hover(Context context) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, (Drawable)Buttons.botoes_ativados(context));
        stateListDrawable.addState(new int[]{16842908}, (Drawable)Buttons.botoes_ativados(context));
        stateListDrawable.addState(new int[]{-16842908, -16842919}, (Drawable)Buttons.botoes(context));
        return stateListDrawable;
    }
}
