package com.example.simpleuserloginandregistrationtest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    //5 SECONDS
    private static int SPLASH_SCREEN = 5000;
    private final String TAG = getClass().getSimpleName();

    Animation topAnim, bottomAnim;
    ImageView image;
    TextView slogan1, slogan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        Resources res = getResources();
//        boolean bool = res.getBoolean(R.bool.trueValue);
//        Log.d(TAG, "onCreate:" + bool);
        super.onCreate(savedInstanceState);
        //Used to hide the status bar.
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);



        //Animation
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        //HOOKS
        image = findViewById(R.id.imageView);
        slogan = findViewById(R.id.textView);
        slogan1 = findViewById(R.id.textView2);

        image.setAnimation(topAnim);
        slogan.setAnimation(bottomAnim);
        slogan1.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, Login.class);

                //start animation for login screen , pass the view being animated and the view animation name
                Pair[] pairs = new Pair[2];
                pairs[0] = new Pair<View,String>(image, "logo_image");
                pairs[1] = new Pair<View,String>(slogan, "logo_text");

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, pairs);
                startActivity(intent, options.toBundle());
            }
        }, SPLASH_SCREEN);
    }
}