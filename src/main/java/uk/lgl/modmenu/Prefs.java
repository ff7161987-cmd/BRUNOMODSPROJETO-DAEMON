package uk.lgl.modmenu;


import android.content.Context;
import android.content.SharedPreferences;

import java.util.Set;

public class Prefs {
	
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
	
    private static final String LENGTH = "_length";
    private static final String DEFAULT_STRING_VALUE = "";
    private static final int DEFAULT_INT_VALUE = -1;
    private static final double DEFAULT_DOUBLE_VALUE = -1d;
    private static final float DEFAULT_FLOAT_VALUE = -1f;
    private static final long DEFAULT_LONG_VALUE = -1L;
    private static final boolean DEFAULT_BOOLEAN_VALUE = false;
    private static Prefs prefsInstance;
    private SharedPreferences sharedPreferences;

    private Prefs(Context context) {
        sharedPreferences = context.getApplicationContext().getSharedPreferences(
                context.getPackageName() + "_preferences",
                Context.MODE_PRIVATE
        );
    }

    private Prefs(Context context, String preferencesName) {
        sharedPreferences = context.getApplicationContext().getSharedPreferences(
                preferencesName,
                Context.MODE_PRIVATE
        );
    }

    public static Prefs with(Context context) {
        if (prefsInstance == null) {
            prefsInstance = new Prefs(context);
        }
        return prefsInstance;
    }

    public static Prefs with(Context context, boolean forceInstantiation) {
        if (forceInstantiation) {
            prefsInstance = new Prefs(context);
        }
        return prefsInstance;
    }

    public static Prefs with(Context context, String preferencesName) {
        if (prefsInstance == null) {
            prefsInstance = new Prefs(context, preferencesName);
        }
        return prefsInstance;
    }

    public static Prefs with(Context context, String preferencesName,
                             boolean forceInstantiation) {
        if (forceInstantiation) {
            prefsInstance = new Prefs(context, preferencesName);
        }
        return prefsInstance;
    }

    // String related methods

    public String read(String what) {
        return sharedPreferences.getString(what, DEFAULT_STRING_VALUE);
    }

    public String read(String what, String defaultString) {
        return sharedPreferences.getString(what, defaultString);
    }

    public void write(String where, String what) {
        sharedPreferences.edit().putString(where, what).apply();
    }

    // int related methods

    public int readInt(String what) {
        return sharedPreferences.getInt(what, DEFAULT_INT_VALUE);
    }

    public int readInt(String what, int defaultInt) {
        return sharedPreferences.getInt(what, defaultInt);
    }

    public void writeInt(String where, int what) {
        sharedPreferences.edit().putInt(where, what).apply();
    }

    // double related methods

    public double readDouble(String what) {
        if (!contains(what))
            return DEFAULT_DOUBLE_VALUE;
        return Double.longBitsToDouble(readLong(what));
    }

    public double readDouble(String what, double defaultDouble) {
        if (!contains(what))
            return defaultDouble;
        return Double.longBitsToDouble(readLong(what));
    }

    public void writeDouble(String where, double what) {
        writeLong(where, Double.doubleToRawLongBits(what));
    }

    // float related methods

    public float readFloat(String what) {
        return sharedPreferences.getFloat(what, DEFAULT_FLOAT_VALUE);
    }

    public float readFloat(String what, float defaultFloat) {
        return sharedPreferences.getFloat(what, defaultFloat);
    }

    public void writeFloat(String where, float what) {
        sharedPreferences.edit().putFloat(where, what).apply();
    }

    // long related methods

    public long readLong(String what) {
        return sharedPreferences.getLong(what, DEFAULT_LONG_VALUE);
    }

    public long readLong(String what, long defaultLong) {
        return sharedPreferences.getLong(what, defaultLong);
    }

    public void writeLong(String where, long what) {
        sharedPreferences.edit().putLong(where, what).apply();
    }

    // boolean related methods

    public boolean readBoolean(String what) {
        return readBoolean(what, DEFAULT_BOOLEAN_VALUE);
    }

    public boolean readBoolean(String what, boolean defaultBoolean) {
        return sharedPreferences.getBoolean(what, defaultBoolean);
    }

    public void writeBoolean(String where, boolean what) {
        sharedPreferences.edit().putBoolean(where, what).apply();
    }

    // String set methods

    public void putStringSet(final String key, final Set<String> value) {
        sharedPreferences.edit().putStringSet(key, value).apply();
    }

    public Set<String> getStringSet(final String key, final Set<String> defValue) {
        return sharedPreferences.getStringSet(key, defValue);
    }

    // end related methods

    public void remove(final String key) {
        if (contains(key + LENGTH)) {
            // Workaround for pre-HC's lack of StringSets
            int stringSetLength = readInt(key + LENGTH);
            if (stringSetLength >= 0) {
                sharedPreferences.edit().remove(key + LENGTH).apply();
                for (int i = 0; i < stringSetLength; i++) {
                    sharedPreferences.edit().remove(key + "[" + i + "]").apply();
                }
            }
        }
        sharedPreferences.edit().remove(key).apply();
    }

    public boolean contains(final String key) {
        return sharedPreferences.contains(key);
    }

    public void clear() {
        sharedPreferences.edit().clear().apply();
    }
}
