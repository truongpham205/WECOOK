package com.example.cookhappy.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.cookhappy.R;
import com.example.cookhappy.utils.SQLiteHelper;

public class infofood extends AppCompatActivity {

    EditText edtmon, edtnguyenlieu, edthuongdan;
    Button btnadd, btnchoose, btnlist;
    ImageView image;

    final int REQUEST_CODE_GALLERY = 999;

    public static SQLiteHelper sqLiteHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infofood);
        init();
        sqLiteHelper = new SQLiteHelper(this, "FoodDB.sqltie",null, 1);
        sqLiteHelper.querydata("CREATE TABLE IF NOT EXISTS FOOD (Id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR,nguyenlieu VARCHAR,huongdan VARCHAR,image BLOG)");
        btnchoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCompat.requestPermissions(
                        infofood.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        REQUEST_CODE_GALLERY
                );
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if(requestCode == REQUEST_CODE_GALLERY){
            if(grantResults.length >0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, REQUEST_CODE_GALLERY);
            }else {
                Toast.makeText(getApplicationContext(),"Không cho phép bạn lấy file!",Toast.LENGTH_SHORT).show();
            }
            return;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    private void init(){
        edtmon=(EditText)findViewById(R.id.edtmon);
        edthuongdan=(EditText)findViewById(R.id.edthuongdan);
        edtnguyenlieu =(EditText)findViewById(R.id.edtnguyenlieu);
        btnadd =(Button)findViewById(R.id.btnadd);
        btnchoose =(Button)findViewById(R.id.btnchoose);
        btnlist =(Button)findViewById(R.id.btnlist);
        image =(ImageView)findViewById(R.id.imageview);

    }


}