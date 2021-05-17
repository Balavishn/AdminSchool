package com.example.adminschooll;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminLogin extends AppCompatActivity {

    EditText name,password;
    Button login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);
        name=findViewById(R.id.adminname);
        password=findViewById(R.id.adminpass);
        login=findViewById(R.id.adminlogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String adminname,adminpass;
                adminname=name.getText().toString();
                adminpass=password.getText().toString();
                if(TextUtils.isEmpty(adminname)&&TextUtils.isEmpty(adminpass)){
                    Toast.makeText(AdminLogin.this, "Enter name and password", Toast.LENGTH_SHORT).show();
                }else {
                    if(adminname.equals("admin")&&adminpass.equals("admin")){
                        startActivity(new Intent(getApplicationContext(), Admin_MainActivity.class));
                        finish();
                    }
                    else Toast.makeText(AdminLogin.this, "Enter correct name and password", Toast.LENGTH_SHORT).show();


                }


            }
        });
    }
}