package com.example.cookhappy;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

public class viewmonandd extends AppCompatActivity {
    ViewPager viewPager;
    BuaAnDetail_Adapter adapter;
    ArrayList<BuaAn> arr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewmonandd);
        viewPager=(ViewPager) findViewById(R.id.pager2);
        adapter=new BuaAnDetail_Adapter(this,MonanDD.arrTraicay);
        viewPager.setAdapter(adapter);
    }
}