package com.example.cookhappy;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

public class Sflash extends AppCompatActivity implements Animation.AnimationListener {
    RelativeLayout layout;
    ImageView imglogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sflash);
        layout = (RelativeLayout) findViewById(R.id.layoutSpflash);
        imglogo = (ImageView) findViewById(R.id.imgsplash);
        Animation transitionAnim = AnimationUtils.loadAnimation(this, R.anim.transition_icon);
        imglogo.setAnimation(transitionAnim);

        Animation alphaAmin = AnimationUtils.loadAnimation(this,R.anim.alpha_background);
        layout.setAnimation(alphaAmin);
        alphaAmin.setAnimationListener(this);

    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        Intent i = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(i);
    }




    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}