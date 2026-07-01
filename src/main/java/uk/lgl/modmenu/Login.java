package uk.lgl.modmenu;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.os.Process;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.io.IOException;
import android.view.View.OnClickListener;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.text.method.PasswordTransformationMethod;
import android.widget.CheckBox;
import android.provider.Settings;
import android.os.Build;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import java.io.RandomAccessFile;
import java.io.File;
import android.widget.ScrollView;
import android.widget.Toast;
import android.util.DisplayMetrics;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.text.method.HideReturnsTransformationMethod;
import android.view.View.OnTouchListener;
import android.view.MotionEvent;
import android.content.SharedPreferences;
import android.widget.FrameLayout;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.text.Html;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.LinkMovementMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.UUID;
import android.widget.RelativeLayout;
import android.graphics.drawable.GradientDrawable;
import android.content.res.AssetManager;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileOutputStream;
import android.widget.FrameLayout;
import android.view.ViewGroup;
import android.util.TypedValue;
import android.util.DisplayMetrics;
import android.graphics.drawable.Drawable;
import android.graphics.Typeface;
import android.widget.ScrollView;
import android.view.WindowManager;
import android.graphics.PixelFormat;
import android.content.res.ColorStateList;

public class Login extends Activity {
	
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
	
	Prefs prefs;
	public String sGameActivity = "com.dts.freefireth.FFMainActivity";
	
	public static RandomAccessFile raf;
    public final String PASS = "PASS";
    public final String USER = "USER";
    public static String Username;
    public static String Password;
    public WindowManager.LayoutParams params;
	
	public static byte[] Hex2b(String str) {
        CharSequence charSequence = " ";
        if (str.contains(charSequence)) {
            str = str.replace(charSequence, "");
        }
        if (str == null) {
            throw new IllegalArgumentException("hex == null");
        } else if (str.length() % 2 == 0) {
            byte[] bArr = new byte[(str.length() / 2)];
            for (int i = 0; i < bArr.length; i++) {
                bArr[i] = (byte) ((decodeHexDigit(str.charAt(i * 2)) << 4) + decodeHexDigit(str.charAt((i * 2) + 1)));
            }
            return bArr;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unexpected hex string: ");
            stringBuilder.append(str);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    public static int decodeHexDigit(char c) {
        if (c >= '0' && c <= '9') {
            return c - 48;
        }
        if (c >= 'a' && c <= 'f') {
            return (c - 97) + 10;
        }
        if (c >= 'A' && c <= 'F') {
            return (c - 65) + 10;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unexpected hex digit: ");
        stringBuilder.append(c);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public static void write(int i, String str) {
        try {
            raf.seek((long) i);
            raf.write(Hex2b(str));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(1024, 1024);
        Login();
    }
	
	private String MyTitulo() {
		return "Bruno Mods";
	}
	
    
    private int getLayoutType() {
        if (Build.VERSION.SDK_INT >= 26) {
            return 2038;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            return 2002;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            return 2005;
        }
        return 2003;
    }
    
    
    
	public void Login() {
        FrameLayout frameLayout = new FrameLayout(this);
        if (Build.VERSION.SDK_INT >= 26) {
            params = new WindowManager.LayoutParams(-2, -2, 2038, 8, -3);
        } else {
            params = new WindowManager.LayoutParams(-2, -2, 2002, 8, -3);
        }
        WindowManager.LayoutParams params = new WindowManager.LayoutParams(
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.WRAP_CONTENT,
            getLayoutType(),
            WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_SECURE,
            PixelFormat.TRANSLUCENT);
        //stopService(new Intent(this, FloatingModMenuService.class));
        this.prefs = Prefs.with(this);
        SharedPreferences sharedPreferences = getSharedPreferences("SavePref", 0);
        String struser = sharedPreferences.getString("User", null);
        String strpass = sharedPreferences.getString("Pass", null);
        Boolean rememberMe = Boolean.valueOf(sharedPreferences.getBoolean("RememberMe", false));
        frameLayout.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -2));
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams((ViewGroup.LayoutParams)new LinearLayout.LayoutParams(-1, -2));
        linearLayout.setBackgroundColor(Color.parseColor((String)"#292828"));
        linearLayout.setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.dp(40), this.dp(40));
        layoutParams.gravity = 5;
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setBackgroundColor(Color.parseColor("#292828"));
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.weight = 1.0f;
        linearLayout2.setLayoutParams((ViewGroup.LayoutParams)layoutParams4);
		
        Button button = new Button(this);
        button.setTag((Object)"btnFechar");
        button.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
        button.setText((CharSequence)"X");
        button.setBackgroundColor(Color.parseColor((String)"#00ffff"));
        button.setTextColor(Color.parseColor((String)"#ffffff"));
        button.setTypeface(null, 1);
        button.setTextSize(2, 21.0f);
        EditText editTextUser = new EditText(this);
        String str = "";
        if (!(struser == null || struser.isEmpty())) {
            editTextUser.setText(this.prefs.read(this.USER, str));
        }
		
        editTextUser.setHint((CharSequence)"Usu\u00e1rio");
        editTextUser.setTextColor(Color.parseColor((String)"#ffffff"));
        editTextUser.setHintTextColor(Color.parseColor((String)"#ffffff"));
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.setMarginStart(this.dp(8));
        layoutParams3.topMargin = this.dp(16);
        layoutParams3.setMarginEnd(this.dp(8));
        editTextUser.setLayoutParams((ViewGroup.LayoutParams)layoutParams3);
        final EditText editTextPass = new EditText(this);
        if (!(strpass == null || strpass.isEmpty())) {
            editTextPass.setText(this.prefs.read(this.PASS, str));
        }
        editTextPass.setHint((CharSequence)"Senha");
        editTextPass.setInputType(129);
        editTextPass.setTextColor(Color.parseColor((String)"#ffffff"));
        editTextPass.setHintTextColor(Color.parseColor((String)"#ffffff"));
        layoutParams3.setMarginStart(this.dp(8));
        layoutParams3.topMargin = this.dp(16);
        layoutParams3.setMarginEnd(this.dp(8));
        editTextPass.setLayoutParams((ViewGroup.LayoutParams)layoutParams3);
        CheckBox checkSaveLogin = new CheckBox(this);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams5.setMargins(this.dp(8), this.dp(8), 0, this.dp(8));
        checkSaveLogin.setLayoutParams((ViewGroup.LayoutParams)layoutParams5);
        checkSaveLogin.setText((CharSequence)"Lembrar");
        checkSaveLogin.setTextColor(Color.parseColor((String)"#ffffff"));
        checkSaveLogin.setChecked(true);
        checkSaveLogin.setChecked(rememberMe.booleanValue());
		checkSaveLogin.setButtonTintList(ColorStateList.valueOf(Color.parseColor("#00FFFF")));
		
		
        final Button btnLogin = new Button(this);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-2, this.dp(40));
        layoutParams7.gravity = 5;
        layoutParams7.weight = 1.0f;
        layoutParams7.topMargin = this.dp(8);
        layoutParams7.rightMargin = this.dp(8);
        layoutParams7.bottomMargin = this.dp(8);
        btnLogin.setLayoutParams((ViewGroup.LayoutParams)layoutParams7);
        btnLogin.setText((CharSequence)"Entrar");
        btnLogin.setTextColor(Color.parseColor((String)"#00ffff"));
        btnLogin.setTextSize(2, 12.0f);
        btnLogin.setBackground((Drawable)Buttons.botoes(this));
        btnLogin.setTypeface(null, Typeface.MONOSPACE.getStyle());
        LinearLayout linearLayout3 = new LinearLayout(this);
        linearLayout3.setBackgroundColor(Color.parseColor("#292828"));
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams6.weight = 1.0f;
        linearLayout3.setLayoutParams((ViewGroup.LayoutParams)layoutParams6);
        linearLayout3.setOrientation(1);
        linearLayout3.addView((View)btnLogin);
        linearLayout.addView((View)button);
        CheckBox mtLogin = new CheckBox(this);
        mtLogin.setLayoutParams((ViewGroup.LayoutParams)layoutParams5);
        mtLogin.setLayoutParams((ViewGroup.LayoutParams)layoutParams5);
        mtLogin.setText((CharSequence)"Mostrar Senha");
        mtLogin.setTextColor(Color.parseColor((String)"#FF0000"));
        mtLogin.setOnCheckedChangeListener(new OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        editTextPass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                    } else {
                        editTextPass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                    }
                }
            });
        // mtLogin.setTextColor(Color.parseColor(str3));
        mtLogin.setText("Mostrar Senha");
        linearLayout2.addView((View)checkSaveLogin);
        //linearLayout2.addView((View)mtLogin);

        Builder builder = new Builder(this);
        TextView textView = new TextView(this);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        textView.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
        textView.setText((CharSequence)MyTitulo());
        textView.setTextSize(2, 20.0f);
        textView.setTypeface(null, 1);
        textView.setBackgroundColor(Color.parseColor("#292828"));
        textView.setTextColor(Color.parseColor((String)"#00FFFF"));
        linearLayout.addView((View)textView);
        linearLayout.addView((View)editTextUser);
        linearLayout.addView((View)editTextPass);
        linearLayout.addView((View)linearLayout2);
        linearLayout.addView((View)linearLayout3);
        //builder.setCustomTitle(textView);
        builder.setCancelable(true);
        builder.setView(linearLayout);
        AlertDialog show = builder.show();
        final EditText editText3 = editTextUser;
        final EditText editText4 = editTextPass;
        final CheckBox checkSaveLogin2 = checkSaveLogin;
        AlertDialog alertDialog = show;
        show.setCancelable(true);
        
        button.setOnClickListener(new OnClickListener() {

                public void onClick(View view) {
                    // public void sair(View view) {
                    View view2 = view;
                    Process.killProcess(Process.myPid());
                }
            });

        btnLogin.setOnTouchListener(new OnTouchListener() {
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    String str = "#000000";
                    if (motionEvent.getAction() == 1) {
                        //btnLogin.setBackgroundColor(Color.parseColor(str));
                    } else if (motionEvent.getAction() == 0) {
                        //btnLogin.setBackgroundColor(Color.parseColor(str));
                    }
                    return false;
                }
            });
        View.OnClickListener onClickListener;
        final SharedPreferences sharedPreferences2 = sharedPreferences;
        View.OnClickListener anonymousClass4 = new View.OnClickListener() {
            public void onClick(View view) {
                String user = editText3.getText().toString().trim();
                String pass = editText4.getText().toString().trim();
                Login.this.prefs.write(Login.this.USER, user);
                Login.this.prefs.write(Login.this.PASS, pass);
                boolean isChecked = checkSaveLogin2.isChecked();
                Editor edit = sharedPreferences2.edit();
                if (isChecked) {
                    edit.putString("User", user);
                    edit.putString("Pass", pass);
                } else {
                    edit.clear();
                }
                edit.putBoolean("RememberMe", isChecked);
                edit.apply();
                new Auth(Login.this).execute(new String[]{user, pass, Login.rdStr()});
                try {
                    File theDir = new File("/storage/emulated/0/Android/data/com.dts.freefireth/files/contentcache/Compulsory/android/");
                    if (!theDir.exists()) {
                        theDir.mkdirs();
                    }
                    Login.raf = new RandomAccessFile("/storage/emulated/0/Android/data/com.dts.freefireth/files/contentcache/Compulsory/android/versioninfo", "rw");
                    Toast.makeText(Login.this.getApplicationContext(), "Aguarde...", 0).show();
                    Toast.makeText(Login.this.getApplicationContext(), "Sucess!!!", 0).show();
                    Login.write(0, "31 2E 35 38 2E 32 0A 30");
                } catch (FileNotFoundException e) {
                    Toast.makeText(Login.this.getApplicationContext(), "Aguarde...", 0).show();
                    Toast.makeText(Login.this.getApplicationContext(), "Sucess!!!", 0).show();
                    e.printStackTrace();
                }
            }
        };
        btnLogin.setOnClickListener(anonymousClass4);
    }
    
    

	
	
	public static void a(GradientDrawable var0, float var1, float var2, float var3, float var4) {
		var0.setCornerRadii(new float[]{var1, var1, var2, var2, var3, var3, var4, var4});
	}
	
	
    public int getResID(String name, String type) {
        return getResources().getIdentifier(name, type, getPackageName());
    }

    public int getID(String name) {
        return getResID(name, "id");
    }
    
    private int dp(int n) {
        return (int)TypedValue.applyDimension((int)1, (float)n, (DisplayMetrics)this.getResources().getDisplayMetrics());
    }
    public static String rdStr() {
        return UUID.randomUUID().toString().replace("-", "");
    }
    
}

