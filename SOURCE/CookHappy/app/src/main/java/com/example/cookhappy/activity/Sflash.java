package com.example.cookhappy.activity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cookhappy.R;
import com.example.cookhappy.receiver.NetworkChangeReceiver;

public class Sflash extends AppCompatActivity implements Animation.AnimationListener {
    RelativeLayout layout;
    ImageView imglogo;
    BroadcastReceiver broadcastReceiver;

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
        broadcastReceiver = new NetworkChangeReceiver();
        registerNetworkReceiver();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterNetworkReceiver();
    }

    protected void registerNetworkReceiver() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
            registerReceiver(broadcastReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
        }

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            registerReceiver(broadcastReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
        }
    }

    protected void unregisterNetworkReceiver(){
        try{
            unregisterReceiver(broadcastReceiver);

        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
    }


    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}