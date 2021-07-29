package com.example.cookhappy.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cookhappy.R;
import com.example.cookhappy.models.ThucDon;
import com.example.cookhappy.utils.DBHelper;

public class AddThucDonActivity extends AppCompatActivity {

    EditText edtTen, edtNoiDung, edtMota;
    Button btnThem;
    DBHelper dbHelper;

    void init() {
        edtTen = findViewById(R.id.etd_ten);
        edtNoiDung = findViewById(R.id.etd_noidung);
        edtMota = findViewById(R.id.etd_mota);
        btnThem = findViewById(R.id.btn_them);
        dbHelper = new DBHelper(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_thuc_don);
        init();
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ThucDon thucDon = new ThucDon(edtTen.getText().toString(), edtMota.getText().toString(), edtNoiDung.getText().toString());
                boolean isInsert =  dbHelper.insertThucDon(thucDon);
                Log.d("====insert====", "onClick: "+ isInsert);

            }
        });
    }
}