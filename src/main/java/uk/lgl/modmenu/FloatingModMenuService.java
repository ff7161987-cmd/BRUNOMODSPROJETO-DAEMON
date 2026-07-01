package uk.lgl.modmenu;

import android.animation.ArgbEvaluator;
import android.animation.TimeAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.AlertDialog;
import android.app.Service;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.PorterDuff;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.AssetManager;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.view.Gravity;
import android.view.MotionEvent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.util.TypedValue;
import android.widget.LinearLayout;
import android.view.View;
import android.view.WindowManager;
import android.text.Html;
import android.text.InputFilter;
import android.text.InputType;
import android.text.method.DigitsKeyListener;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.animation.ArgbEvaluator;
import android.animation.TimeAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.AlertDialog;
import android.app.Service;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.PorterDuff;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.view.Gravity;
import android.view.MotionEvent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.util.TypedValue;
import android.widget.LinearLayout;
import android.view.View;
import android.view.WindowManager;
import android.text.Html;
import android.text.InputFilter;
import android.text.InputType;
import android.text.method.DigitsKeyListener;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.lang.String;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.lang.String;
import android.os.Message;
import android.os.Process;
import static uk.lgl.modmenu.StaticActivity.cacheDir;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;
import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.widget.RelativeLayout.ALIGN_PARENT_RIGHT;

import android.content.DialogInterface;
import android.widget.CheckBox;
import android.content.res.ColorStateList;
import android.graphics.Point;
import android.view.WindowManager.LayoutParams;

public class FloatingModMenuService extends Service {
    
    //Tag
    private final String TAG = "BrunoModsProject";
	
	int dpi;
    Handler handler;
    int screenHeight;
    int screenWidth;
    long sleepTime;
    int type;
    CanvasView canvasLayout;
    LayoutParams canvasLayoutParams;
    Thread mThread;
    Thread mUpdateScreen;
	float density;
	WindowManager windowManager;
	
	//Config
	@Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        return Service.START_NOT_STICKY;
    }
	
    //View
    private ESPView overlayView;
    public View mFloatingView;
    private AlertDialog alert;
	private EditText edittextvalue;
	
	//ParaMetros
	private void BrunoModsProject(String ctx) {System.loadLibrary(ctx);} String Parametros18; private void BrunoModsProject() {
	if (Parametros()) { IsParametros();
	}
	}
	private void IsParametros() {
	}
	
	//LineLayout + Relative
	LinearLayout.LayoutParams scrlLLExpanded, scrlLL;
	private LinearLayout mButtonPanel;
	public LinearLayout mExpanded, patches, mSettings;
	public RelativeLayout mCollapsed;
    private RelativeLayout mRootContainer;
    private FrameLayout rootFrame;
	private LinearLayout.LayoutParams brunoModzProject;
	private LinearLayout view1;
	private LinearLayout view2;
	
	//Button
	private Button close;
	private Button Bypass;
	
	//WindowManager
	public WindowManager.LayoutParams params;
	private WindowManager.LayoutParams espParams;
	public WindowManager mWindowManager;
	
	
	//ImageView
    private ImageView startimage;
	private ImageView startimage2;
	private ImageView closeimage;

	//String
	private String NULL;
	private native String[] BrunoModsFeature();
	
	//Native
	public native void BrunoModsChanges(int feature, int value);
	private native boolean Parametros();
	
    //DrawOn Canvas
	public static native void DrawOn(ESPView espView, Canvas canvas);
	private native void BrunoModsInitLib();
	
	
	/*----- Strings By BrunoMods :v -----*/
    private String Title() {
		return "BRUNO MODZ";
	} 
	
	private String VersaoGamers() {
		return "Free Fire v1.64";
	}

	private String BrunoModsLib() {
		return "BrunoModder";
	}
	
	private String Bypassed() {
		return "BYPASS";
	}
	
	private String CLOSED() {
		return "CLOSE";
	}
	
	private String Icon() {
		return "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";
	}

	private String Brunohide() {
		return "iVBORw0KGgoAAAANSUhEUgAAAIAAAACACAMAAAD04JH5AAABm1BMVEU9s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s54AAAA9s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s549s57LJ3dGAAAAiHRSTlMWjcCtVZukaiCYb6puYQXMvr27tGIRWq+3i5bwzu7qiTw3/nMc3q4S2atKfBvt85WD6SLkgkPQDoa1Qpw4W7y4w8gB0gtsws0GAITrPaVHygPFv14f5oV2FVCx9i/xFA/W7FOI/BindOAZ0wy6BMvlHmbRCms0+5FA1A1Y+jPXELbJAsT5MiHoQ2BqTgAABe9JREFUeNrFm/lf2zYYxr27O7ts604GHgQGpJCOch9LljHmlwALVwl3gQIDAy14AQYFdjCqP3vUFJBsSX5lOx+9vxksPd9PZEmPXkkGhImOUl/rcFe2vTZ/fp6vbc92Dbf2lTpCVWWoFugfqRqbJNyYHKsa6S8rgNU9OPqcSOP56INuq0wAvekmgoqmdG/8ABOpeqIQ9amJWAFKddVEMarrSrEBDGVIqMgMxQLQNkBCx0BbZIBkA4kUDclIANs1zSRiNNdshwcwN0kMsWmGBCh0VpNYorqzEAYgmZXUWZntmZo25y4WLGvhYs6cnurJVkpezybVARqXRLU9Ti8XeSWKy+nHojJLjYoAuRX+z/8kM74qa9HV8cwTfjOs5FQArDVuLXvrG8Ejy8b6HrfwmoUHsLd4NYya2AnGHOWV37KxAMUdTvHTaZVJdvqUU8VOEQfwjDPvTe4W1HxGYZfjWuqfYQCKfv35lKPutZzUvJ+gGAxg+37//YNiKLcHxYN9XyvYQQCW7/tbOoTQcegbTLYsOUDO1/82WyBCtPhmk7WcFGDF+/7MEUSKoxlvjSsygEbv+PcoBxEj98g7JjaKAZKeJps9hhjieNbzUSVFAAXP/PfwBGKJk4eeubEgAOj06N+HmOK+h6CTD2CyH8DsCcQWJ2wrVJs8gG1PjzmGGOPY07e3OQA1nu8fYg1PX6jxAyRZ/zuTixcgx44HzUkfAOv/N48g5jhiW7jBC9DGdtUWiD1a2EGmzQPArL/2D6EMccjMjQMswBBDdwBliQNGZIgBYNa/88XyABQZh5KhAUoMWwrKFClGpkQB1DH+zykXgMP4xLpbgAlmEN6FssUuMyBP3AAwP82p1P+edWb/+kPwxj+/ZP6t+l7qlU99Te0CMD5Y6v//e+ouUbgq9o8v//fiO+l6gfHI1wC9zPpHqv/t1UsVHAL7lZv4RkrArJl6XwGk6T+aCH0egX3jZqQEJq319RWARecf91D6fgKbclNSAnrl2mS5AN001DpO30tgM25ORrBOv9jtAgzS6/8NpD5LYHvcpIRgg84fDLoAo/7xkdf/nnoN/i2B7cvm/LAgrCjDfvEG9NP573FhuQf+xe41gc3JJn0lrGiczq33XwKM0OXE+ZcviYiAp0/GxFkc+rWRS4AqOv8k/ni4SZuXBFx98oW4JjqTVXUJMEY9p8XFPucmfn69x9cnn4lrSjM/lAH0DLUs6cCfcoUq+PqfSDztMj3zgtFBl5M5ESeBz41mbZkvod/sMGgvUimfzROx6APQOdWS0UcXhFgIAvSBbrU+o5V66oE4CIL0oYd6udUYpp6mIAaCQH2Yot4eNrqwXgRJEKzPuJIuI4v0AkgChD7jCbJGO/U0B1EJMPowRxVoN2qppwuISIDShwuqRK2Rp54WIBoBTh8WqCJ545x6Qu46Ox9H0geLKnMeBmDxJyKYmcIAqDeBSB9NwDaB8kco1ifk7j31j1C1G8r0LwnOlLuh4kAk18cRsAOR2lAcpE/IzpniUKw0GQXrYwjYyUhlOsboE/LbotJ0rGBIcPrBBKwhwVsyrD4hfy8qWDK0KcXrBxB4TCnWluf4E0CCPzMNFNC2HLsw+ZCv7wjmxg/wCxPk0myYry+anRP4pRlycfq+QF9AUIFfnCKX5++J9PkE7+KX58gEhfWnSJ9H0LSKT1BgUzR3fhfp+wmaTZUUDTZJxRIkHLFPlOjzklToNB1NkHDETlWmz0vT4ROVtwQJR+yVpfq8RKVCqvaaIOGI3bpUn5+qVUhW3/nZ3dPj7ig4rrfJm+rJapV0/UfvvP3Wm8Iu/sbrrxlh0vXaNyy0b9no37TSvm2nf+NS+9at/s1r7dv3+g8waD/Cof8Qi/ZjPPoPMuk/yqX9MJv+43z6DzTqP9Kp/VCr/mO9+g826z/arf9wu/7j/fovOOi/4gHaL7mA/ms++i86gfarXqD/shtov+7nrpn0Xnh0V656r3y6+QO9l17dLI7ea79u6L34fDVH6b36fRVaL7/fRIzX//8HCgRorXd/+e8AAAAASUVORK5CYII=";
	}
	
	private int IconSize() {
		return 64;
	}
	
	private String IconWebViewData() {
		return NULL;
	}
	
	//Config 2
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
	
	
	private class CanvasView extends View {
        public CanvasView(Context context) {
            super(context);
        }
        public void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            if (canvas != null) {
                FloatingModMenuService.onDraw1(canvas, FloatingModMenuService.this.screenWidth, FloatingModMenuService.this.screenHeight, FloatingModMenuService.this.density);
            }
        }
    }
    public FloatingModMenuService() {
        this.sleepTime = 16;
        this.handler = new Handler() {
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what == 0) {
                    try {
                        Point point = new Point();
                        FloatingModMenuService.this.windowManager.getDefaultDisplay().getRealSize(point);
                        FloatingModMenuService.this.screenWidth = point.x;
                        FloatingModMenuService.this.screenHeight = point.y;
                        FloatingModMenuService.this.canvasLayoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
                        FloatingModMenuService.this.canvasLayoutParams.height = WindowManager.LayoutParams.MATCH_PARENT;
                        FloatingModMenuService.this.windowManager.updateViewLayout(FloatingModMenuService.this.canvasLayout, FloatingModMenuService.this.canvasLayoutParams);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
        };
		this.mThread = new Thread() {
            public void run() {
                Process.setThreadPriority(Process.THREAD_PRIORITY_BACKGROUND);
                while (isAlive() && !isInterrupted()) {
                    try {
                        long currentTimeMillis = System.currentTimeMillis();
                        FloatingModMenuService.this.canvasLayout.postInvalidate();
                        Thread.sleep(Math.max(Math.min(0, FloatingModMenuService.this.sleepTime - (System.currentTimeMillis() - currentTimeMillis)), FloatingModMenuService.this.sleepTime));
                    } catch (Exception e) {
						e.printStackTrace();
                    }
                }
            }
        };
        this.mUpdateScreen = new Thread() {
            public void run() {
				Process.setThreadPriority(Process.THREAD_PRIORITY_BACKGROUND);
                while (isAlive() && !isInterrupted()) {
					try {
                        long currentTimeMillis = System.currentTimeMillis();
                        Point point = new Point();
                        FloatingModMenuService.this.windowManager.getDefaultDisplay().getRealSize(point);
                        if (!(FloatingModMenuService.this.screenWidth == point.x && FloatingModMenuService.this.screenHeight == point.y)) {
                            FloatingModMenuService.this.handler.sendEmptyMessage(0);
                        }
                        Thread.sleep(Math.max(Math.min(0, FloatingModMenuService.this.sleepTime - (System.currentTimeMillis() - currentTimeMillis)), FloatingModMenuService.this.sleepTime));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
    }

	private static native void onDraw1(Canvas canvas, int i, int i2, float f);
	
	public void CreateCanvas() {
        WindowManager.LayoutParams layoutParams;
        this.canvasLayoutParams = layoutParams = new WindowManager.LayoutParams(-1, -1, getLayoutType(), 56, -3);
        layoutParams.gravity = 8388659;
        this.canvasLayoutParams.x = 0;
        this.canvasLayoutParams.y = 0;
		CanvasView canvasView = new CanvasView(this);
        this.canvasLayout = canvasView;
        this.windowManager.addView(canvasView, this.canvasLayoutParams);
		this.sleepTime = 16;
    }
	
    //Start Lib
    @Override
    public void onCreate() {
		super.onCreate();
        this.overlayView = new ESPView((Context)this);
        System.loadLibrary(BrunoModsLib());
		this.windowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        Point point = new Point();
        this.windowManager.getDefaultDisplay().getRealSize(point);
        this.screenWidth = point.x;
        this.screenHeight = point.y;
        this.dpi = Resources.getSystem().getDisplayMetrics().densityDpi;
        this.density = Resources.getSystem().getDisplayMetrics().density;
        this.type = getLayoutType();
        CreateCanvas();
        this.mThread.start();
        this.mUpdateScreen.start();
        initFloating();
        initAlertDiag();
        DrawCanvas();
        final Handler handler = new Handler(); handler.post(new Runnable() {
		public void run() {
		handler.postDelayed(this, 1000);
		Thread();
   	    }
   	    }
		);
	    }

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
	 
	
    
	 //DrawCanvas
     private void DrawCanvas() {
		 WindowManager.LayoutParams layoutParams;
		 this.espParams = layoutParams = new WindowManager.LayoutParams(-1, -1, this.getLayoutType(), 56, -3);
		 layoutParams.gravity = 8388659;
		 this.espParams.x = 0;
		 this.espParams.y = 0;
		 this.mWindowManager.addView((View)this.overlayView, (ViewGroup.LayoutParams)this.espParams);
	 }
	 
	/*----- Arquivos -----*/
	
	private String ArquivoFiles = "libArchiver.so";
	boolean AssetManager = false;
	String ZArchiver = "%s /n";
	String Arquivos = "%s /n";
	
	
	void ZArchiver() {
		if (!AssetManager) AssetManager = true;
		ArquivoFiles = ("/storage/emulated/0/Android/data/com.dts.freefireth/files/reportnew.db");
		ArquivoFiles = ("/storage/emulated/0/Android/data/com.dts.freefireth/files/ymrtc_log.txt");
	}
	
	void Arquivos() {
	    if (!AssetManager) AssetManager = true;
		ArquivoFiles = "/storage/emulated/0/Android/data/com.dts.freefireth/files/reportnew.db";
		ArquivoFiles = "/storage/emulated/0/Android/data/com.dts.freefireth/files/ymrtc_log.txt";
	}
	 
	
    /*----- initFloating! -----*/
    private void initFloating() {
		BrunoModsInitLib();
        this.rootFrame = new FrameLayout(this);
        this.mRootContainer = new RelativeLayout(this);
        this.mCollapsed = new RelativeLayout(this);
        this.mExpanded = new LinearLayout(this);
        this.view1 = new LinearLayout(this);
        this.patches = new LinearLayout(this);
        this.view2 = new LinearLayout(this);
        this.mButtonPanel = new LinearLayout(this);


        //Start startimage
		startimage = new ImageView(getBaseContext());
        startimage.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        int applyDimension = (int) TypedValue.applyDimension(1, (float) IconSize(), getResources().getDisplayMetrics());
        startimage.getLayoutParams().height = applyDimension;
        startimage.getLayoutParams().width = applyDimension;
        startimage.requestLayout();
        startimage.setScaleType(ImageView.ScaleType.FIT_XY);
        byte[] decode = Base64.decode(Icon(), 0);
        startimage.setImageBitmap(BitmapFactory.decodeByteArray(decode, 0, decode.length));
        ((ViewGroup.MarginLayoutParams) startimage.getLayoutParams()).topMargin = convertDipToPixels(10);

		//CloseImarge X
		closeimage = new ImageView(getBaseContext());
        closeimage.setLayoutParams(new RelativeLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT));
        ((ViewGroup.MarginLayoutParams) startimage.getLayoutParams()).topMargin = convertDipToPixels(5);
        int dimensionClose = 30;//20dp
        int dimensionInDpClose = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dimensionClose, getResources().getDisplayMetrics());
        closeimage.getLayoutParams().height = dimensionInDpClose;
        closeimage.getLayoutParams().width = dimensionInDpClose;
        closeimage.requestLayout();
        closeimage.setScaleType(ImageView.ScaleType.FIT_XY);
        byte[] decode3 = Base64.decode(Brunohide(), 0);
        closeimage.setImageBitmap(BitmapFactory.decodeByteArray(decode3, 0, decode3.length));
        closeimage.setAlpha(200);
        ((ViewGroup.MarginLayoutParams) closeimage.getLayoutParams()).leftMargin = convertDipToPixels(60);


        //GradientDrawable
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(GradientDrawable.RECTANGLE);
        String str = "#ffff0000";
        gradientDrawable.setColor(Color.parseColor(str));
        gradientDrawable.setStroke(3, Color.parseColor(str));
        gradientDrawable.setCornerRadius(8.0f);


        //RelativeLayout
        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        relativeLayout.setPadding(3, 0, 3, 3);
        relativeLayout.setVerticalGravity(16);

        //RelativeLayout
		RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dp(140), -2);
		layoutParams.addRule(11);

		// Close
        close =new Button(this);
        LinearLayout.LayoutParams BrunoModsDev = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, dp(35));
        close.setLayoutParams(BrunoModsDev);
        close.setTextSize(TypedValue.COMPLEX_UNIT_SP, 10);
        close.setTypeface((Typeface) null, 1);
        close.setBackgroundColor(Color.parseColor("#05DDFF"));
        close.setTextColor(Color.parseColor("#ffffff"));
        close.setText(CLOSED());
		
        GradientDrawable bgclose = new GradientDrawable();
		bgclose.setCornerRadii(new float[] {0,0,40,40,0,0,0,0});
		bgclose.setColor(Color.parseColor("#05DDFF"));
		close.setBackground(bgclose);
		
		relativeLayout.addView(close);

        //Bypass
		RelativeLayout.LayoutParams Bypassed = new RelativeLayout.LayoutParams(-2, -2);
        Bypassed.addRule(11);

        Bypass = new Button(this);
        Bypass.setBackgroundColor(Color.parseColor("#FFFFFF"));
		Bypass.setTextSize(TypedValue.COMPLEX_UNIT_SP, 10);
		Bypass.setTypeface((Typeface) null, 1);
        Bypass.setTextColor(Color.parseColor("WHITE"));
        Bypass.setLayoutParams(Bypassed);
        Bypass.setBackgroundColor(Color.parseColor("#FFA500"));
        Bypass.setTextColor(Color.parseColor("#ffffff"));
		Bypass.setText(Bypassed());
		Bypass.setLayoutParams(new LinearLayout.LayoutParams(-2, dp(42)));

        //relativeLayout.addView(Bypass);

        //ViewData
        WebView ViewWeeb = new WebView(this);
        ViewWeeb.loadData("<html><head><body style=\"margin: 0; padding: 0\"><img src=\"" + IconWebViewData() + "\" width=\"" + IconSize() + "\" height=\"" + IconSize() + "\"</body></html>", "text/html", "utf-8");
        ViewWeeb.setBackgroundColor(0x00000000);
        ViewWeeb.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        ViewWeeb.getLayoutParams().height = applyDimension;
        ViewWeeb.getLayoutParams().width = applyDimension;
        ViewWeeb.requestLayout();
        ViewWeeb.setAlpha(0.9f);
        ViewWeeb.getSettings().setAppCachePath("/data/data/" + getPackageName() + "/cache");
        ViewWeeb.getSettings().setAppCacheEnabled(true);
        ViewWeeb.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);


		Toast.makeText(this, "Admin: Bom Jogor!", Toast.LENGTH_LONG).show();


		rootFrame.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        mRootContainer.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        mCollapsed.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        mCollapsed.setVisibility(1);
		mCollapsed.setAlpha(0.9f);

		//-----------------\\

        mExpanded = new LinearLayout(this);
        LinearLayout.LayoutParams expanded_containerParams = new LinearLayout.LayoutParams(dp(215), -2, LinearLayout.LayoutParams.WRAP_CONTENT);
        mExpanded.setLayoutParams(expanded_containerParams);
        mExpanded.setOrientation(LinearLayout.VERTICAL);
        mExpanded.setBackgroundColor(Color.parseColor("#414040"));
        mExpanded.setVisibility(8);
        mExpanded.setAlpha(0.8f);

		//-----------------\\

        ScrollView scrollView = new ScrollView(this);
        LinearLayout.LayoutParams scrollView_Params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, dp(200));
        scrollView.setLayoutParams(scrollView_Params);

		//-----------------\\
		
		LinearLayout fechar_expanded_imageview = new LinearLayout(this);
        LinearLayout.LayoutParams fechar_expanded_imageviewParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, dp(30));
        fechar_expanded_imageview.setLayoutParams(fechar_expanded_imageviewParams);
        fechar_expanded_imageview.setGravity(Gravity.RIGHT);

		//-----------------\\

        LinearLayout linearLayoutPrincipal = new LinearLayout(this);
        LinearLayout.LayoutParams layoutParamsLinearLayoutPrincipal = new LinearLayout.LayoutParams(dp(213), LinearLayout.LayoutParams.WRAP_CONTENT);
        linearLayoutPrincipal.setLayoutParams(layoutParamsLinearLayoutPrincipal);
        linearLayoutPrincipal.setBackgroundColor(Color.parseColor("#414040"));
        linearLayoutPrincipal.setOrientation(LinearLayout.VERTICAL);
        linearLayoutPrincipal.setPadding(dp(5),0,dp(5),0);


        patches = new LinearLayout(this);
		patches.setVisibility(View.VISIBLE);
        patches.setOrientation(LinearLayout.VERTICAL);


		//*********** START IMAGE **********
		/*startimage2 = new ImageView(getBaseContext());
        startimage2.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        startimage2.getLayoutParams().height = 130;
        startimage2.getLayoutParams().width = 130;
        startimage2.requestLayout();
        startimage2.setScaleType(ImageView.ScaleType.FIT_XY);
        byte[] decode2 = Base64.decode(Icon(), 0);
        startimage2.setImageBitmap(BitmapFactory.decodeByteArray(decode2, 0, decode2.length));
        startimage2.setImageAlpha(250);
*/
		
		startimage2 = new ImageView(this);
        RelativeLayout.LayoutParams ffid_LayoutParams = new RelativeLayout.LayoutParams(-2, -2);
        startimage2.setLayoutParams(new RelativeLayout.LayoutParams(-2, -2));
        ffid_LayoutParams.addRule(21, -1);
        ffid_LayoutParams.setMarginEnd((int) ((271.0f) + 0.5f));
        startimage2.getLayoutParams().height = dp(40);
        startimage2.getLayoutParams().width = dp(40);
        startimage2.requestLayout();
        startimage2.setScaleType(ImageView.ScaleType.FIT_XY);
        byte[] decode2 = Base64.decode(Icon(), 4);
        startimage2.setImageBitmap(BitmapFactory.decodeByteArray(decode2, 0, decode2.length));
        ((ViewGroup.MarginLayoutParams) startimage2.getLayoutParams()).leftMargin = convertDipToPixels(2);
				
		LinearLayout titleText = new LinearLayout(this);
        titleText.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        titleText.setOrientation(0);
        titleText.setPadding(dp(8), dp(8), dp(8), dp(8));
		

		//Title text
        TextView BrunoMods = new TextView(getBaseContext());
		LinearLayout.LayoutParams BrunoXmodz = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        BrunoMods.setText(Title());
		BrunoXmodz.topMargin = dp(10);
		BrunoXmodz.bottomMargin = dp(10);
        BrunoMods.setTextSize(17.0f);
        BrunoMods.setPadding(10, 0, 0, 0);
        BrunoMods.setTypeface(null, Typeface.BOLD);
        BrunoMods.setTextColor(Color.parseColor("#05DDFF"));
        BrunoMods.setTypeface(Typeface.SERIF);
		BrunoMods.setLayoutParams(BrunoXmodz);
        BrunoXmodz.gravity = 17;

		

		//Heading text
        TextView nomeJogoVersao = new TextView(this);
        LinearLayout.LayoutParams nomeJogoVersao_Params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        nomeJogoVersao_Params.gravity = 17;
        nomeJogoVersao_Params.topMargin = dp(12);
        nomeJogoVersao_Params.bottomMargin = dp(12);
        nomeJogoVersao.setLayoutParams(nomeJogoVersao_Params);
        nomeJogoVersao.setText(VersaoGamers());
        nomeJogoVersao.setTextColor(Color.parseColor("#ffffff"));

		
       //Nomes Etc
        BrunoMods.setLayoutParams(BrunoXmodz);
        nomeJogoVersao.setLayoutParams(nomeJogoVersao_Params);

        new LinearLayout.LayoutParams(-1, dp(25)).topMargin = dp(2);
		
		//Outros
        rootFrame.addView(mRootContainer);
        mRootContainer.addView(mCollapsed);
        mRootContainer.addView(mExpanded);


		//Close imager
		mCollapsed.addView(closeimage);
		mCollapsed.addView(startimage);
		

		//LineLayout
		linearLayoutPrincipal.addView(BrunoMods);
		mExpanded.addView(linearLayoutPrincipal);
		
		//Inmager Em MCollasped 
		//linearLayoutPrincipal.addView(titleText);
		//titleText.addView(startimage2);
		
		//
		linearLayoutPrincipal.addView(scrollView);

		//Versão
		mExpanded.addView(nomeJogoVersao);

		
		//Outros
        scrollView.addView(patches);
        mExpanded.addView(relativeLayout);
        mFloatingView = rootFrame;

        if (Build.VERSION.SDK_INT >= 26) {
            params = new WindowManager.LayoutParams(-2, -2, 2038, 8, -3);
        } else {
            params = new WindowManager.LayoutParams(-2, -2, 2002, 8, -3);
        }
        WindowManager.LayoutParams layoutParams4 = params;
        layoutParams4.gravity = 51;
        layoutParams4.x = 0;
        layoutParams4.y = 100;
        mWindowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        mWindowManager.addView(mFloatingView, params);
        RelativeLayout relativeLayout2 = mCollapsed;
        LinearLayout linearLayout = mExpanded;
        mFloatingView.setOnTouchListener(onTouchListener());
        startimage.setOnTouchListener(onTouchListener());
        ViewWeeb.setOnTouchListener(onTouchListener());
        initMenuButton(relativeLayout2, linearLayout);
        CreateMenuList();
    }

        private View.OnTouchListener onTouchListener() {
        return new View.OnTouchListener() {
            final View collapsedView = mCollapsed;
            final View expandedView = mExpanded;
            private float initialTouchX;
            private float initialTouchY;
            private int initialX;
            private int initialY;

                  public boolean onTouch(View view, MotionEvent motionEvent) {
                  switch (motionEvent.getAction()) {
                  case MotionEvent.ACTION_DOWN:
                        initialX = params.x;
                        initialY = params.y;
                        initialTouchX = motionEvent.getRawX();
                        initialTouchY = motionEvent.getRawY();
                        return true;
                        case MotionEvent.ACTION_UP:
                        int rawX = (int) (motionEvent.getRawX() - initialTouchX);
                        int rawY = (int) (motionEvent.getRawY() - initialTouchY);

   
                        if (rawX < 10 && rawY < 10 && isViewCollapsed()) {             
                            collapsedView.setVisibility(View.GONE);
                            expandedView.setVisibility(View.VISIBLE);
                        }
                        return true;
                    case MotionEvent.ACTION_MOVE:
               
                        params.x = initialX + ((int) (motionEvent.getRawX() - initialTouchX));
                        params.y = initialY + ((int) (motionEvent.getRawY() - initialTouchY));

                  
                        mWindowManager.updateViewLayout(mFloatingView, params);
                        return true;
                    default:
                        return false;
                }
            }
        };
    }

	private boolean hide = false;

    //Initialize buttons
    private void initMenuButton(final View view2, final View view3) {
        startimage.setOnClickListener(new View.OnClickListener() {
				public void onClick(View view) {
					view2.setVisibility(View.GONE);
					view3.setVisibility(View.VISIBLE);
				}
			});

		closeimage.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					AlertDialog alertDialog = null;
					AlertDialog alertBuilder = new AlertDialog.Builder(getBaseContext())
                        .setMessage("\n\tDeseja fechar?")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                FloatingModMenuService.this.stopSelf();
                            }
                        })
                        .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).create();

					int flag;
					if (Build.VERSION.SDK_INT > Build.VERSION_CODES.N_MR1){
						flag = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
					}
					else {
						flag = WindowManager.LayoutParams.TYPE_PHONE;
					}
					alertBuilder.getWindow().setType(flag);
					alertBuilder.show();


				}
			});
                close.setOnClickListener(new View.OnClickListener() {
				public void onClick(View view) {
					if (hide) {
						view2.setVisibility(View.VISIBLE);
						view2.setAlpha(0);
						view3.setVisibility(View.GONE);

					} else {
						view2.setVisibility(View.VISIBLE);
						view2.setAlpha(0.95f);
						view3.setVisibility(View.GONE);
					}

					close.setOnClickListener(new View.OnClickListener() {
							public void onClick(View view) {
								view2.setVisibility(View.VISIBLE);
								view2.setAlpha(0.95f);
								view3.setVisibility(View.GONE);

							}
						});
				}});}

    public final void CreateMenuList() {
        String[] listFT = BrunoModsFeature();
        for (int i = 0; i < listFT.length; i++) {
            final int feature = i;
            String str = listFT[i];
			
			
			    if (str.contains("Toggle_")) {
                addSwitch(str.replace("Toggle_", ""), new InterfaceBool() {
						public void OnWrite(boolean z) {
						BrunoModsChanges(feature, 0);
						}
					});
                } else if (str.contains("SB_")) {
                String[] split = str.split("_");
                addSeekBar(split[1], Integer.parseInt(split[2]), Integer.parseInt(split[3]), new InterfaceInt() {
						public void OnWrite(int i) {
						BrunoModsChanges(feature, i);
						}
					});
                } else if (str.contains("SBEsp_")) {
                String[] split = str.split("_");
                addSeekBar1(split[1], Integer.parseInt(split[2]), Integer.parseInt(split[3]), new InterfaceInt() {
						public void OnWrite(int i) {
						BrunoModsChanges(feature, i);
						}
					});
				} else if (str.contains("SBCaixa_")) {
					String[] split = str.split("_");
					AddStrock(split[1], Integer.parseInt(split[2]), Integer.parseInt(split[3]), new InterfaceInt() {
							public void OnWrite(int i) {
								BrunoModsChanges(feature, i);
							}
						});
				} else if (str.contains("SBFire_")) {
					String[] split = str.split("_");
					AddFireColor(split[1], Integer.parseInt(split[2]), Integer.parseInt(split[3]), new InterfaceInt() {
							public void OnWrite(int i) {
								BrunoModsChanges(feature, i);
							}
						});
				} else if (str.contains("SBPosi_")) {
					String[] split = str.split("_");
					AddFirePosition(split[1], Integer.parseInt(split[2]), Integer.parseInt(split[3]), new InterfaceInt() {
							public void OnWrite(int i) {
								BrunoModsChanges(feature, i);
							}
						});
				} else if (str.contains("SBEspG")) {
					String[] split = str.split("_");
					ColorGranda(split[1], Integer.parseInt(split[2]), Integer.parseInt(split[3]), new InterfaceInt() {
							public void OnWrite(int i) {
							BrunoModsChanges(feature, i);
							}
						});
               } else if (str.contains("Category_")) {
                addCategory(str.replace("Category_", ""));
               } else if (str.contains("Button_")) {
                addButton(str.replace("Button_", ""), new InterfaceBtn() {
						public void OnWrite() {
					    BrunoModsChanges(feature, 0);
						}
					});
                } else if (str.contains("Spinner_")) {
                 addSpinner(str.replace("Spinner_", ""), new InterfaceInt() {
						@Override
						public void OnWrite(int i) {
						BrunoModsChanges(feature, i);
						}
					});
				} else if (str.contains("CheckBox_")) {
					    addCheckBox(str.replace("CheckBox_", ""), new InterfaceBool() {
						public void OnWrite(boolean z) {
					    BrunoModsChanges(feature, 0);
						}
					});
				 } else if (str.contains("ICN_")) {
					 addCheckBox(str.replace("ICN_", ""), new InterfaceBtn() {
							 public void OnWrite() {
								 hide = !hide;
							 }
						 });
                } else if (str.contains("InputValue_")) {
                addTextField(str.replace("InputValue_", ""), feature, new InterfaceInt() {
						@Override
						public void OnWrite(int i) {
						BrunoModsChanges(feature, i);
						}
					});
			    }
			if (str.contains("SBSpot_")) {
				String[] split = str.split("_");
				AddSeekBarSpot(split[1], Integer.parseInt(split[2]), Integer.parseInt(split[3]), new InterfaceInt() {
						public void OnWrite(int i) {
						BrunoModsChanges(feature, i);
						}
					  }
				    );
			     }
		       }
	         }

	private void addCheckBox(String replace, Object onWrite) {
	}

    private TextView textView2;
    private String featureNameExt;
    private int featureNum;
    private EditTextValue txtValue;

    public class EditTextValue {
        private int val;

        public void setValue(int i) {
            val = i;
        }

        public int getValue() {
            return val;
        }
    }

    private void addTextField(final String featureName, final int feature, final InterfaceInt interInt) {
        RelativeLayout relativeLayout2 = new RelativeLayout(this);
        relativeLayout2.setLayoutParams(new RelativeLayout.LayoutParams(-2, -1));
        relativeLayout2.setPadding(10, 5, 10, 5);
        relativeLayout2.setVerticalGravity(16);

        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = 10;

        final TextView textView = new TextView(this);
        textView.setText(Html.fromHtml("<font face='roboto'>" + featureName + ": <font color='#fdd835'>Not set</font></font>"));
        textView.setTextColor(Color.parseColor("#DEEDF6"));
        textView.setLayoutParams(layoutParams);

        final TextView textViewRem = new TextView(this);
        textViewRem.setText("");

        final EditTextValue edittextval = new EditTextValue();

        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);

        Button button2 = new Button(this);
        button2.setLayoutParams(layoutParams2);
        button2.setBackgroundColor(Color.parseColor("#1C262D"));
        button2.setText("SET");
        button2.setTextColor(Color.parseColor("#D5E3EB"));
        button2.setGravity(17);
        button2.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View view) {
					alert.show();
					textView2 = textView;
					featureNum = feature;
					featureNameExt = featureName;
					txtValue = edittextval;

					edittextvalue.setText(String.valueOf(edittextval.getValue()));
				}
			});

        relativeLayout2.addView(textView);
        relativeLayout2.addView(button2);
        patches.addView(relativeLayout2);
    }

    private void initAlertDiag() {
        LinearLayout linearLayout1 = new LinearLayout(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        linearLayout1.setPadding(10, 5, 0, 5);
        linearLayout1.setOrientation(LinearLayout.VERTICAL);
        linearLayout1.setGravity(17);
        linearLayout1.setLayoutParams(layoutParams);
        linearLayout1.setBackgroundColor(Color.parseColor("#171E24"));

        int i = Build.VERSION.SDK_INT >= 26 ? 2038 : 2002;
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        linearLayout.setBackgroundColor(Color.parseColor("#14171f"));
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        frameLayout.addView(linearLayout);

        final TextView textView = new TextView(this);
        textView.setText(Html.fromHtml("<font face='roboto'>Tap OK to apply changes. Tap outside to cancel</font>"));
        textView.setTextColor(Color.parseColor("#DEEDF6"));
        textView.setLayoutParams(layoutParams);

        edittextvalue = new EditText(this);
        edittextvalue.setLayoutParams(layoutParams);
        edittextvalue.setMaxLines(1);
        edittextvalue.setWidth(convertDipToPixels(300));
        edittextvalue.setTextColor(Color.parseColor("#93a6ae"));
        edittextvalue.setTextSize(13.0f);
        edittextvalue.setHintTextColor(Color.parseColor("#434d52"));
        edittextvalue.setInputType(InputType.TYPE_CLASS_NUMBER);
        edittextvalue.setKeyListener(DigitsKeyListener.getInstance("0123456789-"));

        InputFilter[] FilterArray = new InputFilter[1];
        FilterArray[0] = new InputFilter.LengthFilter(10);
        edittextvalue.setFilters(FilterArray);

        Button button = new Button(this);
        button.setBackgroundColor(Color.parseColor("#1C262D"));
        button.setTextColor(Color.parseColor("#D5E3EB"));
        button.setText("OK");
        button.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View view) {
					BrunoModsChanges(featureNum, Integer.parseInt(edittextvalue.getText().toString()));
					txtValue.setValue(Integer.parseInt(edittextvalue.getText().toString()));
					textView2.setText(Html.fromHtml("<font face='roboto'>" + featureNameExt + ": <font color='#41c300'>" + edittextvalue.getText().toString() + "</font></font>"));
					alert.dismiss();

					//interStr.OnWrite(editText.getText().toString());
				}
			});

        alert = new AlertDialog.Builder(this, 2).create();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Objects.requireNonNull(alert.getWindow()).setType(i);
        }
        linearLayout1.addView(textView);
        linearLayout1.addView(edittextvalue);
        linearLayout1.addView(button);
        alert.setView(linearLayout1);
    }

    private void addSpinner(String feature, final InterfaceInt interInt) {
        List<String> list = new LinkedList<>(Arrays.asList(feature.split("_")));

        LinearLayout linearLayout = new LinearLayout(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setPadding(10, 5, 10, 5);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setGravity(17);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setBackgroundColor(Color.parseColor("#171E24"));

        final TextView textView = new TextView(this);
        textView.setText(Html.fromHtml("<font face='roboto'>" + list.get(0) + ": <font color='#41c300'></font>"));
        textView.setTextColor(Color.parseColor("#DEEDF6"));

       
        LinearLayout linearLayout2 = new LinearLayout(this);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams2.setMargins(10, 2, 10, 5);
        linearLayout2.setOrientation(LinearLayout.VERTICAL);
        linearLayout2.setGravity(17);
        linearLayout2.setBackgroundColor(Color.parseColor("#1C262D"));
        linearLayout2.setLayoutParams(layoutParams2);

        Spinner spinner = new Spinner(this);
        spinner.setPadding(5, 10, 5, 8);
        spinner.setLayoutParams(layoutParams2);
        spinner.getBackground().setColorFilter(1, PorterDuff.Mode.SRC_ATOP);
        
        list.remove(0);
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, list);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        
        spinner.setAdapter(aa);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
				@Override
				public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
					((TextView) parentView.getChildAt(0)).setTextColor(Color.parseColor("#f5f5f5"));
					interInt.OnWrite(position);

				}

				@Override
				public void onNothingSelected(AdapterView<?> parent) {

				}
			});
        linearLayout.addView(textView);
        linearLayout2.addView(spinner);
        patches.addView(linearLayout);
        patches.addView(linearLayout2);
    }

    private void addCategory(String text) {
        TextView textView = new TextView(this);
        textView.setBackgroundColor(Color.GREEN);
        textView.setShadowLayer(15.0f, 0.0f, 0.0f, Color.parseColor("BLUE"));
        textView.setText(text);
        textView.setGravity(17);
        textView.setTextSize(14.0f);
        textView.setTextColor(Color.parseColor("WHITE"));
        textView.setTypeface(null, Typeface.BOLD);
        textView.setPadding(0, 5, 0, 5);
        patches.addView(textView);
    }


    public void addButton(String feature, final InterfaceBtn interfaceBtn) {
        final Button button = new Button(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, dp(41));
        layoutParams.setMargins(0, 5, 0, 5);
        button.setLayoutParams(layoutParams);
        button.setPadding(0, 0, 0, 0);
        button.setTextSize(2, 11.0f);
        button.setTextColor(Color.parseColor("WHITE"));
        button.setGravity(17);

		if (feature.contains("")) {
            feature = feature.replace("", "");
            button.setText(Html.fromHtml("<font face='monospace'>" + feature + " OFF"+ "</font>"));
            button.setBackgroundColor(Color.parseColor("RED"));
            android.graphics.drawable.GradientDrawable DBHIJCI = new android.graphics.drawable.GradientDrawable();
			DBHIJCI.setColor(Color.parseColor("#414040"));
			DBHIJCI.setCornerRadii(new float[] { 11, 11, 11, 11, 11, 11, 11, 11 });
			DBHIJCI.setStroke(4, Color.parseColor("#05DDFF"));
			button.setBackground(DBHIJCI);
            final String feature2 = feature;
            button.setOnClickListener(new View.OnClickListener() {
					private boolean isActive = true;

					public void onClick(View v) {
						interfaceBtn.OnWrite();
						if (isActive) {
							button.setText(Html.fromHtml("<font face='monospace'>" + feature2 + " ON" + "</font>"));
							button.setBackgroundColor(Color.parseColor("#05DDFF"));
							android.graphics.drawable.GradientDrawable CBABHIA = new android.graphics.drawable.GradientDrawable();
							int CBABHIAADD[] = new int[]{ Color.parseColor("#05DDFF"), Color.parseColor("#05DDFF") };
							CBABHIA.setColors(CBABHIAADD);
							CBABHIA.setOrientation(android.graphics.drawable.GradientDrawable.Orientation.LEFT_RIGHT);
							CBABHIA.setCornerRadii(new float[] { 7, 7, 7, 7, 7, 7, 7, 7 });
							CBABHIA.setStroke(4, Color.parseColor("#05DDFF"));
							button.setBackground(CBABHIA);
							isActive = false;
							return;
						}
						button.setText(Html.fromHtml("<font face='monospace'>" + feature2 + " OFF" + "</font>"));
						button.setBackgroundColor(Color.parseColor("#000000"));
						android.graphics.drawable.GradientDrawable DBHIJCI = new android.graphics.drawable.GradientDrawable();
						DBHIJCI.setColor(Color.parseColor("#414040"));
						DBHIJCI.setCornerRadii(new float[] { 11, 11, 11, 11, 11, 11, 11, 11 });
						DBHIJCI.setStroke(4, Color.parseColor("#05DDFF"));
						button.setBackground(DBHIJCI);
						isActive = true;
					}
				});

        } else {
            button.setText(feature);
            button.setBackgroundColor(Color.parseColor("#ffa500"));
            final String feature2 = feature;
            button.setOnClickListener(new View.OnClickListener() {
					public void onClick(View v) {
						interfaceBtn.OnWrite();
					}
				});
        }
        patches.addView(button);
    }

    private void addSwitch(String feature, final InterfaceBool sw) {
        Switch switchR = new Switch(this);
        switchR.setBackgroundColor(Color.TRANSPARENT);
        switchR.setText(Html.fromHtml("<font face='roboto'>" + feature + "</font>"));
        switchR.setTextColor(Color.RED);
        switchR.setPadding(10, 5, 0, 5);
        switchR.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
				public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
					if (z) {
						playSound(Uri.fromFile(new File(cacheDir + "On.ogg")));
					} else {
						playSound(Uri.fromFile(new File(cacheDir + "Off.ogg")));
					}
					sw.OnWrite(z);
				}

				private void playSound(Uri fromFile) {
				}
			});
        patches.addView(switchR);
    }


    private void addSeekBar(String str,  int progress, int max, InterfaceInt sb) {
        LinearLayout linearLayout = new LinearLayout(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setPadding(10, 5, 0, 5);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(18);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setBackgroundColor(Color.parseColor("#00000000"));
        TextView textView = new TextView(this);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("<font face='monospace'><b>");
        sb2.append(str);
        sb2.append("<font face='monospace'><b>" + " : <font color='GREEN'>" + "</b></font>");
        sb2.append(progress);
        sb2.append("</b></font>");
        textView.setText(Html.fromHtml(sb2.toString()));
        textView.setTextSize(15);
        textView.setTextColor(-1);
		textView.setTextColor(Color.WHITE);
        textView.setTypeface((Typeface) null, 1);
        SeekBar seekBar = new SeekBar(this);
        seekBar.setScaleY(1.0f);
        seekBar.setPadding(25, 10, 35, 10);
        seekBar.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
		seekBar.getProgressDrawable().setColorFilter(Color.parseColor("CYAN"), PorterDuff.Mode.SRC_IN);
        seekBar.getThumb().setColorFilter(Color.parseColor("CYAN"), PorterDuff.Mode.SRC_IN);
		textView.setShadowLayer(7.0f, 0.0f, 0.0f, Color.parseColor("#00000000"));

        if (Build.VERSION.SDK_INT >= 21) {
            seekBar.getProgressDrawable().setTint(-1);
        }
        seekBar.setMax(max);
        seekBar.setProgress(progress);
        final int i5 = progress;
        final SeekBar seekBar2 = seekBar;
        final InterfaceInt sb3 = sb;
        final TextView textView2 = textView;
        final String str3 = str;
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

                private String itv;
                public void onStartTrackingTouch(SeekBar seekBar) {
                }

                public void onStopTrackingTouch(SeekBar seekBar) {
                }

                public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                    int i2 = i5;
                    if (i < i2) {
                        seekBar2.setProgress(i2);
                        sb3.OnWrite(i5);
                        TextView textView = textView2;
                        textView.setText(Html.fromHtml("<font face='monospace'><b>" + str3 + " : <font color=WHITE'>" + i5 + "</b></font>"));
                        return;
                    }
                    sb3.OnWrite(i);
                    textView2.setText(Html.fromHtml("<font face='monospace'><b>" + str3 + " : <font color=WHITE'>" + i + "</b></font>"));

                }
            });

        linearLayout.addView(textView);
        linearLayout.addView(seekBar);
        patches.addView(linearLayout);
    }

	private void addCheckBox(String str, final InterfaceBool sw) {
        final CheckBox Check = new CheckBox(this);
        Check.setText(Html.fromHtml("<font face='roboto'>" + str + "</font>"));
        Check.setTextSize(15);
        Check.setTextColor(Color.parseColor("WHITE"));
		Check.setBackgroundColor(Color.parseColor("#05DDFF"));
        Check.setTextSize(12.0f);
		Check.setText(str + "");
		Check.setTextColor(-1);
		//Check.setButtonTintList(ColorStateList.valueOf(Color.parseColor("#ff16aaff")));
		LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, dp(40));
		layoutParams5.bottomMargin = 10;
		Check.setPadding(20, 10, 10, 10);
		Check.setLayoutParams(layoutParams5);
		android.graphics.drawable.GradientDrawable DAIGAHD = new android.graphics.drawable.GradientDrawable();
		DAIGAHD.setColor(Color.parseColor("#414040"));
		DAIGAHD.setCornerRadii(new float[] { 10, 10, 10, 10, 10, 10, 10, 10 });
		DAIGAHD.setStroke(3, Color.parseColor("#05DDFF"));
		Check.setBackground(DAIGAHD);
		Check.setButtonTintList(ColorStateList.valueOf(Color.parseColor("#05DDFF")));//setButtonTintList is accessible directly on API>19
		final String feature2 = str;
        Check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    if (z) {
						//    playSound(Uri.fromFile(new File(cacheDir + "On.ogg")));

						Check.setText(feature2 + "");
						Check.setButtonTintList(ColorStateList.valueOf(Color.parseColor("#000000")));
						android.graphics.drawable.GradientDrawable IIEGGAC = new android.graphics.drawable.GradientDrawable();
						IIEGGAC.setColor(Color.parseColor("#05DDFF"));
						IIEGGAC.setCornerRadii(new float[] { 10, 10, 10, 10, 10, 10, 10, 10 });
						Check.setBackground(IIEGGAC);
						//Check.setButtonTintList(ColorStateList.valueOf(Color.parseColor("#ff16aaff")));
                    } else {
						//   playSound(Uri.fromFile(new File(cacheDir + "Off.ogg")));
						android.graphics.drawable.GradientDrawable DAIGAHD = new android.graphics.drawable.GradientDrawable();
						DAIGAHD.setColor(Color.parseColor("#414040"));
						DAIGAHD.setCornerRadii(new float[] { 10, 10, 10, 10, 10, 10, 10, 10 });
						DAIGAHD.setStroke(3, Color.parseColor("#05DDFF"));
						Check.setBackground(DAIGAHD);
						Check.setButtonTintList(ColorStateList.valueOf(Color.parseColor("#05DDFF")));
						Check.setText(feature2 + "");
						//Check.setButtonTintList(ColorStateList.valueOf(Color.parseColor("#ff16aaff")));

                    }
                    sw.OnWrite(z);
                }
            });
        patches.addView(Check);
    }

	private void addSeekBar1(final String feature, final int prog, int max, final InterfaceInt interInt) {
        LinearLayout linearLayout = new LinearLayout(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setPadding(10, 5, 0, 5);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setGravity(17);
        linearLayout.setLayoutParams(layoutParams);
		TextView textView = new TextView(this);
        textView.setText(Html.fromHtml("<font face='monospace'>" + feature + " : <font color='WHITE'>" + "Branco" + "</font>"));
        textView.setTextColor(Color.parseColor("#ffffff"));
        SeekBar seekBar = new SeekBar(this);
		textView.setTextSize(15);
        textView.setTextColor(-1);
		textView.setTextColor(Color.WHITE);
        textView.setTypeface((Typeface) null, 1);
        seekBar.setPadding(25, 10, 35, 10);
        seekBar.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
		seekBar.getProgressDrawable().setColorFilter(Color.parseColor("CYAN"), PorterDuff.Mode.SRC_IN);
        seekBar.getThumb().setColorFilter(Color.parseColor("CYAN"), PorterDuff.Mode.SRC_IN);
		textView.setShadowLayer(7.0f, 0.0f, 0.0f, Color.parseColor("#00000000"));
        seekBar.setMax(max);
        seekBar.setProgress(prog);

		final TextView EspColor = textView;
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
				public void onStartTrackingTouch(SeekBar seekBar2) {
				}

				public void onStopTrackingTouch(SeekBar seekBar2) {
				}

				int I;

				public void onProgressChanged(SeekBar seekBar2, int i, boolean z) {
					if (i == 0) {										
						EspColor.setText(Html.fromHtml("<font face='monospace'><b>" + feature + " : <font color='WHITE'>" + "Branco" + "</b></font>"));
					} else if (i == 1) {										
						EspColor.setText(Html.fromHtml("<font face='monospace'><b>" + feature + " : <font color='GREEN'>" + "Verde" + "</b></font>"));
					} else if (i == 2) {					
						EspColor.setText(Html.fromHtml("<font face='monospace'><b>" + feature + " : <font color='BLUE'>" + "Azul" + "</b></font>"));
					} else if (i == 3) {										
						EspColor.setText(Html.fromHtml("<font face='monospace'><b>" + feature + " : <font color='#FF0000'>" + "Vermelho" + "</b></font>"));
					} else if (i == 4) {									
						EspColor.setText(Html.fromHtml("<font face='monospace'><b>" + feature + " : <font color='#000000'>" + "Preto" + "</b></font>"));
					} else if (i == 5) {											
						EspColor.setText(Html.fromHtml("<font face='monospace'><b>" + feature + " : <font color='YELLOW'>" + "Amarelo" + "</b></font>"));
					} else if (i == 6) {										
						EspColor.setText(Html.fromHtml("<font face='monospace'><b>" + feature + " : <font color='#00FFFF'>" + "Ciano" + "</b></font>"));
					} else if (i == 7) {								
						EspColor.setText(Html.fromHtml("<font face='monospace'><b>" + feature + " : <font color='#FF00FF'>" + "Magenta" + "</b></font>"));
					} else if (i == 8) {									
						EspColor.setText(Html.fromHtml("<font face='monospace'><b>" + feature + " : <font color='#808080'>" + "Cinza escuro" + "</b></font>"));
					} else if (i == 9) {										
					    EspColor.setText(Html.fromHtml("<font face='monospace'><b>" + feature + " : <font color='#A020F0'>" + "Roxo" + "</b></font>"));
					}
					    interInt.OnWrite(i);
				}
			}
		    );

        linearLayout.addView(textView);
        linearLayout.addView(seekBar);
        patches.addView(linearLayout);
    }

	private void ColorGranda(final String feature, final int prog, int max, final InterfaceInt interInt) {
        LinearLayout linearLayout = new LinearLayout(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setPadding(10, 5, 0, 5);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setGravity(17);
        linearLayout.setLayoutParams(layoutParams);
		TextView textView = new TextView(this);
        textView.setText(Html.fromHtml("<font face='monospace'>" + feature + " : <font color='BLUE'>" + "Azul" + "</font>"));
        textView.setTextColor(Color.parseColor("#ffffff"));
        SeekBar seekBar = new SeekBar(this);
		textView.setTextSize(15);
        textView.setTextColor(-1);
		textView.setTextColor(Color.WHITE);
        textView.setTypeface((Typeface) null, 1);
        seekBar.setPadding(25, 10, 35, 10);
        seekBar.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
		seekBar.getProgressDrawable().setColorFilter(Color.parseColor("CYAN"), PorterDuff.Mode.SRC_IN);
        seekBar.getThumb().setColorFilter(Color.parseColor("CYAN"), PorterDuff.Mode.SRC_IN);
		textView.setShadowLayer(7.0f, 0.0f, 0.0f, Color.parseColor("#00000000"));
        seekBar.setMax(max);
        seekBar.setProgress(prog);

        final TextView textView2 = textView;
		final TextView EspColor = textView2;
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
				public void onStartTrackingTouch(SeekBar seekBar2) {
				}

				public void onStopTrackingTouch(SeekBar seekBar2) {
				}

				int I;

				public void onProgressChanged(SeekBar seekBar2, int i, boolean z) {
					if (i == 0) {										
						EspColor.setText(Html.fromHtml("<font face='monospace'><b>" + feature + " : <font color='BLUE'>" + "Azul" + "</b></font>"));
					} else if (i == 1) {										
						EspColor.setText(Html.fromHtml("<font face='monospace'><b>" + feature + " : <font color='GREEN'>" + "Verde" + "</b></font>"));
					} else if (i == 2) {					
						EspColor.setText(Html.fromHtml("<font face='monospace'><b>" + feature + " : <font color='#FF0000'>" + "Vermelho" + "</b></font>"));
					} else if (i == 3) {										
						EspColor.setText(Html.fromHtml("<font face='monospace'><b>" + feature + " : <font color='WHITE'>" + "Branco" + "</b></font>"));
					} else if (i == 4) {											
						EspColor.setText(Html.fromHtml("<font face='monospace'><b>" + feature + " : <font color='YELLOW'>" + "Amarelo" + "</b></font>"));
					} else if (i == 5) {										
						EspColor.setText(Html.fromHtml("<font face='monospace'><b>" + feature + " : <font color='#00FFFF'>" + "Ciano" + "</b></font>"));
					} else if (i == 6) {								
						EspColor.setText(Html.fromHtml("<font face='monospace'><b>" + feature + " : <font color='#FF00FF'>" + "Magenta" + "</b></font>"));
					}
					interInt.OnWrite(i);
				}
			});

        linearLayout.addView(textView);
        linearLayout.addView(seekBar);
        patches.addView(linearLayout);
    }
	
	
	private void AddSeekBarSpot(final String feature, final int prog, int max, final InterfaceInt interInt) {
        LinearLayout linearLayout = new LinearLayout(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setPadding(10, 5, 0, 5);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setGravity(17);
        linearLayout.setLayoutParams(layoutParams);
        final TextView textView = new TextView(this);
        textView.setText(Html.fromHtml("<font face='monospace'><b>" + feature + " : <font color='#39FF14'>" + "CABEÇA" + "</b></font>"));
        textView.setTextColor(Color.parseColor("#ffffff"));
        SeekBar seekBar = new SeekBar(this);
        seekBar.setPadding(25, 10, 35, 10);
        seekBar.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
		seekBar.getProgressDrawable().setColorFilter(Color.parseColor("CYAN"), PorterDuff.Mode.SRC_IN);
        seekBar.getThumb().setColorFilter(Color.parseColor("CYAN"), PorterDuff.Mode.SRC_IN);
		textView.setShadowLayer(7.0f, 0.0f, 0.0f, Color.parseColor("#00000000"));
        seekBar.setMax(max);
        seekBar.setProgress(prog);

        final TextView textView2 = textView;
        final SeekBar seekBar2 = seekBar;
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
				public void onStartTrackingTouch(SeekBar seekBar2) {
				}

				public void onStopTrackingTouch(SeekBar seekBar2) {
				}

				int l;

				public void onProgressChanged(SeekBar seekBar2, int i, boolean z) {
					if (i == 0) {
						seekBar2.setProgress(i);
						interInt.OnWrite(i);
						TextView textView = textView2;
						textView.setText(Html.fromHtml("<font face='monospace'><b>" + feature + " : <font color='#39FF14'>" + "CABEÇA" + "</b></font>"));
					} else if (i == 1) {
						seekBar2.setProgress(i);
						interInt.OnWrite(i);
						TextView textView = textView2;
						textView.setText(Html.fromHtml("<font face='monospace'><b>" + feature + " : <font color='GREEN'>" + "CORPO" + "</b></font>"));
					} else if (i == 2) {
						seekBar2.setProgress(i);
						interInt.OnWrite(i);
						TextView textView = textView2;
						textView.setText(Html.fromHtml("<font face='monospace'><b>" + feature + " : <font color='GREEN'>" + "PE" + "</b></font>"));							    
				    }
					 interInt.OnWrite(i);
				}
			});

        linearLayout.addView(textView);
        linearLayout.addView(seekBar);
        patches.addView(linearLayout);
    }

	private void AddStrock(final String feature, final int prog, int max, final InterfaceInt interInt) {
        LinearLayout linearLayout = new LinearLayout(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setPadding(10, 5, 0, 5);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setGravity(17);
        linearLayout.setLayoutParams(layoutParams);
        final TextView textView = new TextView(this);
        textView.setText(Html.fromHtml("<font face='monospace'><b>" + feature + " : <font color=''>" + "Caixa" + "</b></font>"));
        textView.setTextColor(Color.parseColor("#ffffff"));
        SeekBar seekBar = new SeekBar(this);
        seekBar.setPadding(25, 10, 35, 10);
        seekBar.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
		seekBar.getProgressDrawable().setColorFilter(Color.parseColor("CYAN"), PorterDuff.Mode.SRC_IN);
        seekBar.getThumb().setColorFilter(Color.parseColor("CYAN"), PorterDuff.Mode.SRC_IN);
		textView.setShadowLayer(7.0f, 0.0f, 0.0f, Color.parseColor("#00000000"));
        seekBar.setMax(max);
        seekBar.setProgress(prog);

        final TextView textView2 = textView;
        final SeekBar seekBar2 = seekBar;
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
				public void onStartTrackingTouch(SeekBar seekBar2) {
				}

				public void onStopTrackingTouch(SeekBar seekBar2) {
				}

				int l;

				public void onProgressChanged(SeekBar seekBar2, int i, boolean z) {
					if (i == 0) {
						seekBar2.setProgress(i);
						interInt.OnWrite(i);
						TextView textView = textView2;
						textView.setText(Html.fromHtml("<font face='monospace'><b>" + feature + " : <font color=''>" + "Caixa" + "</b></font>"));
					} else if (i == 1) {
						seekBar2.setProgress(i);
						interInt.OnWrite(i);
						TextView textView = textView2;
						textView.setText(Html.fromHtml("<font face='monospace'><b>" + feature + " : <font color=''>" + "Strock" + "</b></font>"));
					} 
					interInt.OnWrite(i);
				}
			});

        linearLayout.addView(textView);
        linearLayout.addView(seekBar);
        patches.addView(linearLayout);
    }
	
	private void AddFireColor(final String feature, final int prog, int max, final InterfaceInt interInt) {
        LinearLayout linearLayout = new LinearLayout(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setPadding(10, 5, 0, 5);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setGravity(17);
        linearLayout.setLayoutParams(layoutParams);
        final TextView textView = new TextView(this);
        textView.setText(Html.fromHtml("<font face='monospace'><b>" + feature + " : <font color=''>" + "Orange" + "</b></font>"));
        textView.setTextColor(Color.parseColor("#ffffff"));
        SeekBar seekBar = new SeekBar(this);
        seekBar.setPadding(25, 10, 35, 10);
        seekBar.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
		seekBar.getProgressDrawable().setColorFilter(Color.parseColor("CYAN"), PorterDuff.Mode.SRC_IN);
        seekBar.getThumb().setColorFilter(Color.parseColor("CYAN"), PorterDuff.Mode.SRC_IN);
		textView.setShadowLayer(7.0f, 0.0f, 0.0f, Color.parseColor("#00000000"));
        seekBar.setMax(max);
        seekBar.setProgress(prog);

        final TextView textView2 = textView;
        final SeekBar seekBar2 = seekBar;
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
				public void onStartTrackingTouch(SeekBar seekBar2) {
				}

				public void onStopTrackingTouch(SeekBar seekBar2) {
				}

				int l;

				public void onProgressChanged(SeekBar seekBar2, int i, boolean z) {
					if (i == 0) {
						seekBar2.setProgress(i);
						interInt.OnWrite(i);
						TextView textView = textView2;
						textView.setText(Html.fromHtml("<font face='monospace'><b>" + feature + " : <font color=''>" + "Orange" + "</b></font>"));
					} else if (i == 1) {
						seekBar2.setProgress(i);
						interInt.OnWrite(i);
						TextView textView = textView2;
						textView.setText(Html.fromHtml("<font face='monospace'><b>" + feature + " : <font color=''>" + "Blue" + "</b></font>"));
					} 
					interInt.OnWrite(i);
				}
			});

        linearLayout.addView(textView);
        linearLayout.addView(seekBar);
        patches.addView(linearLayout);
    }
	
	private void AddFirePosition(final String feature, final int prog, int max, final InterfaceInt interInt) {
        LinearLayout linearLayout = new LinearLayout(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        linearLayout.setPadding(10, 5, 0, 5);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setGravity(17);
        linearLayout.setLayoutParams(layoutParams);
        final TextView textView = new TextView(this);
        textView.setText(Html.fromHtml("<font face='monospace'><b>" + feature + " : <font color=''>" + "Center" + "</b></font>"));
        textView.setTextColor(Color.parseColor("#ffffff"));
        SeekBar seekBar = new SeekBar(this);
        seekBar.setPadding(25, 10, 35, 10);
        seekBar.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
		seekBar.getProgressDrawable().setColorFilter(Color.parseColor("CYAN"), PorterDuff.Mode.SRC_IN);
        seekBar.getThumb().setColorFilter(Color.parseColor("CYAN"), PorterDuff.Mode.SRC_IN);
		textView.setShadowLayer(7.0f, 0.0f, 0.0f, Color.parseColor("#00000000"));
        seekBar.setMax(max);
        seekBar.setProgress(prog);

        final TextView textView2 = textView;
        final SeekBar seekBar2 = seekBar;
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
				public void onStartTrackingTouch(SeekBar seekBar2) {
				}

				public void onStopTrackingTouch(SeekBar seekBar2) {
				}

				int l;

				public void onProgressChanged(SeekBar seekBar2, int i, boolean z) {
					if (i == 0) {
						seekBar2.setProgress(i);
						interInt.OnWrite(i);
						TextView textView = textView2;
						textView.setText(Html.fromHtml("<font face='monospace'><b>" + feature + " : <font color=''>" + "Center" + "</b></font>"));
					} else if (i == 1) {
						seekBar2.setProgress(i);
						interInt.OnWrite(i);
						TextView textView = textView2;
						textView.setText(Html.fromHtml("<font face='monospace'><b>" + feature + " : <font color=''>" + "Cima" + "</b></font>"));
					} 
					interInt.OnWrite(i);
				}
			});

        linearLayout.addView(textView);
        linearLayout.addView(seekBar);
        patches.addView(linearLayout);
    }
	
    public boolean isViewCollapsed() {
        return mFloatingView == null || mCollapsed.getVisibility() == View.VISIBLE;
    }

    //Pixels
    private int convertDipToPixels(int i) {
        return (int) ((((float) i) * getResources().getDisplayMetrics().density) + 0.5f);
    }

    private int dp(int i) {
        return (int) TypedValue.applyDimension(1, (float) i, getResources().getDisplayMetrics());
    }

    //View Icone Destroir
    public void onDestroy() {
        super.onDestroy();
        View view = mFloatingView;
        if (view != null) {
            mWindowManager.removeView(view);
        }
        ESPView espView = this.overlayView;
        if (espView != null) {
            this.mWindowManager.removeView(espView);
            this.overlayView = null;
        }
    }

    //Em segundo Plano
    private boolean isNotInGame() {
        RunningAppProcessInfo runningAppProcessInfo = new RunningAppProcessInfo();
        ActivityManager.getMyMemoryState(runningAppProcessInfo);
        return runningAppProcessInfo.importance != 100;
    }

    //OnTask
    public void onTaskRemoved(Intent intent) {
        stopSelf();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        super.onTaskRemoved(intent);
    }

    //Thread
    public void Thread() {
        if (mFloatingView == null) {
            return;
        }
        if (isNotInGame()) {
            mFloatingView.setVisibility(View.INVISIBLE);
        } else {
            mFloatingView.setVisibility(View.VISIBLE);
        }
    }

	/*----- protected My Strings obs: N Modifica! -----*/

	protected static String Title(String enc) {
        if (enc.equals("‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ???????????????????????? ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎")) {}
		return "‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ???????????????????????? ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎BrunoModsProject‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎";
	}
	protected static String VersaoGamers(String enc) {
        if (enc.equals("‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ???????????????????????? ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎")) {}
		return "‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ???????????????????????? ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎BrunoModsProject‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎";
	}

	protected static String Bypassed(String enc) {
        if (enc.equals("‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ???????????????????????? ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎")) {}
		return "‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ???????????????????????? ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎BrunoModsProject‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎";
	}

	protected static String CLOSED(String enc) {
        if (enc.equals("‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ???????????????????????? ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎")) {}
		return "‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ???????????????????????? ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎BrunoModsProject‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎";
	}

	protected static String Icon(String enc) {
        if (enc.equals("‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ???????????????????????? ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎")) {}
		return "‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ???????????????????????? ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎BrunoModsProject‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎";
	}

	protected static String Brunohide(String enc) {
        if (enc.equals("‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ???????????????????????? ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎")) {}
		return "‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ???????????????????????? ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏ ‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎BrunoModsProject‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎‏‎";
	}


	

    private interface InterfaceBtn {
        void OnWrite();
    }

    private interface InterfaceInt {
        void OnWrite(int i);
    }

    private interface InterfaceBool {
        void OnWrite(boolean z);
    }

    private interface InterfaceStr {
        void OnWrite(String s);
    }
}
