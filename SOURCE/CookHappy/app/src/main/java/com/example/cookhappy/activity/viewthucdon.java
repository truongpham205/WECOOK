package com.example.cookhappy.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.cookhappy.R;
import com.example.cookhappy.adapter.BuaAnDetail_Adapter;
import com.example.cookhappy.models.BuaAn;

import java.util.ArrayList;

public class viewthucdon extends AppCompatActivity {
    ViewPager viewPager;
    BuaAnDetail_Adapter adapter;
    ArrayList<BuaAn> arr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewthucdon);
        viewPager=(ViewPager) findViewById(R.id.pager);
        adapter=new BuaAnDetail_Adapter(this, Home.Lvplace.arrTraicay);
        viewPager.setAdapter(adapter);
    }
}