package com.example.cookhappy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Signup extends AppCompatActivity {
     EditText username, password, confirmpassword;
     Button signup;
     DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        confirmpassword = (EditText)findViewById(R.id.confirmpassword);
        signup = (Button)findViewById(R.id.signup);
        DB = new DBHelper(this);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String confirm = confirmpassword.getText().toString();

                if (user.equals("")||pass.equals("")||confirm.equals("")) {
                    Toast.makeText(Signup.this, "Hãy điền thông tin đầy đủ ", Toast.LENGTH_SHORT).show();
                }else{
                    if(pass.equals(confirm)){
                        Boolean checkeruser = DB.checkusername(user);
                        if(checkeruser ==false){
                            Boolean insert = DB.insertData(user, pass);
                            if(insert==true){
                                Toast.makeText(Signup.this,"Đăng kí thành công", Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(getApplicationContext(),Login.class);
                                startActivity(i);

                            }else{
                                Toast.makeText(Signup.this,"Đăng kí thất bại!",Toast.LENGTH_SHORT).show();
                            }

                        }else{
                            Toast.makeText(Signup.this,"Username đã tồn tại!",Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(Signup.this,"Password không khớp",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}