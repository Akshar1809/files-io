package com.akshar.Akshar1809_FilesIO;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class SplashScreen extends AppCompatActivity {

    ImageView arrow;
    ImageView phone1;
    ImageView phone2;
    TextView appname;
    Animation animation;
    LottieAnimationView lottieAnimationView;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        animation= AnimationUtils.loadAnimation(SplashScreen.this,R.anim.rotate);

        arrow=findViewById(R.id.arrow);
        phone1=findViewById(R.id.phone1);
        phone2=findViewById(R.id.phone2);
        appname=findViewById(R.id.appname);
        lottieAnimationView=findViewById(R.id.lottie);

        arrow.setAnimation(animation);
        ObjectAnimator anim = ObjectAnimator.ofInt(appname, "textColor", Color.RED,Color.YELLOW,Color.RED);
        anim.setDuration(4000);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setRepeatMode(Animation.ABSOLUTE);
        anim.start();

        phone2.animate().translationX(-100).setDuration(2000).setStartDelay(100);
        arrow.animate().translationY(300).setDuration(2000).setStartDelay(100);
        phone1.animate().translationX(100).setDuration(2000).setStartDelay(100);
        lottieAnimationView.animate().translationY(1400).setDuration(1000).setStartDelay(4000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(SplashScreen.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },4000);
    }
}