package com.example.cookhappy.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cookhappy.adapter.MonanDD;
import com.example.cookhappy.R;
import com.example.cookhappy.adapter.Buaanadapter;
import com.example.cookhappy.models.BuaAn;

import java.util.ArrayList;

public class Lvplace extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView listView;
    public static ArrayList<BuaAn> arrTraicay;
    Buaanadapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lvplace);
        listView = (ListView) findViewById(R.id.lvBuaan);
        arrTraicay = new ArrayList<>();
        arrTraicay.add(new BuaAn("Bữa Sáng 1", "Cháo trà xanh", R.drawable.buasang1));
        arrTraicay.add(new BuaAn("Bữa Sáng 2", "Cháo trai bổ dưỡng", R.drawable.buasang2));
        arrTraicay.add(new BuaAn("Bữa Sáng 3", "Mỳ tôm Nhật thật", R.drawable.buasang3));
        arrTraicay.add(new BuaAn("Bữa Trưa 1", "Đậu, thịt, đỗ, kho", R.drawable.buatrua1));
        arrTraicay.add(new BuaAn("Bữa Trưa 2", "Đậu, xương, đu đủ, thịt, tàu", R.drawable.buatrua2));
        arrTraicay.add(new BuaAn("Bữa Trưa 3", "Cá, măng, đỗ, đậu, thịt", R.drawable.buatrua3));
        arrTraicay.add(new BuaAn("Bữa Tối 1", "Dừa, khoai, cà chua, thịt, tàu", R.drawable.buatoi1));
        arrTraicay.add(new BuaAn("Bữa Tối 2", "Suplor, tôm, măng, thịt, cá", R.drawable.buatoi2));
        arrTraicay.add(new BuaAn("Bữa Tối 2", "Dưa, măng, cá, thịt, trứng", R.drawable.buatoi3));
        adapter = new Buaanadapter(this,R.layout.list_mon_an, arrTraicay);
        listView.setAdapter(adapter);
        //Bắt sự kiện click
        listView.setOnItemClickListener(this);

    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuright, menu);
        SearchView searchView;
        searchView = (SearchView) findViewById(R.id.txtSearch);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.filter(s.trim());
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.update:
                Intent intent = new Intent(Lvplace.this, capnhat.class);
                startActivity(intent);
                break;
            case R.id.dinhduong:
                Intent intent1 = new Intent(Lvplace.this, MonanDD.class);
                startActivity(intent1);
                break;

        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent=new Intent(this, viewthucdon.class);
        startActivity(intent);
    }
}