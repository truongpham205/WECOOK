package com.example.cookhappy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText username,password;
    Button   login;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        login   = (Button)findViewById(R.id.login);
        DB = new DBHelper(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                if(user.equals("")||pass.equals(""))
                    Toast.makeText(Login.this,"Xin hãy điền thông tin",Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkuserpass = DB.checkusernamepassword(user,pass);
                    if(checkuserpass== true){
                        Toast.makeText(Login.this,"Đăng nhập thành công",Toast.LENGTH_SHORT).show();
                        Intent e = new Intent(getApplicationContext(),nav.class);
                        startActivity(e);
                    }else {
                        Toast.makeText(Login.this,"Đăng nhập thất bại ",Toast.LENGTH_SHORT).show();


                    }
                }
            }
        });
    }
}