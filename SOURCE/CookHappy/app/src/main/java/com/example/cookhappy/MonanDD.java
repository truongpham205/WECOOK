package com.example.cookhappy;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MonanDD extends AppCompatActivity implements AdapterView.OnItemClickListener{
    ListView lstda;
    public static ArrayList<BuaAn> arrTraicay;
    Buaanadapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monan_d_d);
        lstda=findViewById(R.id.listdepda);
        arrTraicay = new ArrayList<>();
        arrTraicay.add(new BuaAn("depda1", "Cháo trà xanh", R.drawable.depda1));
        arrTraicay.add(new BuaAn("depda2", "Cháo trai bổ dưỡng", R.drawable.depda2));
        arrTraicay.add(new BuaAn("Thông minh đẳng cấp", "Mỳ tôm Nhật thật", R.drawable.thongminh1));
        arrTraicay.add(new BuaAn("Đệ nhất gia đình", "Đậu, thịt, đỗ, kho", R.drawable.thongminh2));
        adapter = new Buaanadapter(this, R.layout.list_mon_an, arrTraicay);
        lstda.setAdapter(adapter);
        //Bắt sự kiện click
        lstda.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent=new Intent(this,viewmonandd.class);
        startActivity(intent);
    }
}