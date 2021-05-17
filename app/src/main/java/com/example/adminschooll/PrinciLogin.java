package com.example.adminschooll;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PrinciLogin extends AppCompatActivity {

    EditText name,password;
    Button login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_princi_login);
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
                    Toast.makeText(PrinciLogin.this, "Enter name and password", Toast.LENGTH_SHORT).show();
                }else {
                    if(adminname.equals("principal@gmail.com")&&adminpass.equals("principal")){
                        startActivity(new Intent(getApplicationContext(), Principal_MainActivity.class));
                        finish();
                    }
                    else Toast.makeText(PrinciLogin.this, "Enter correct name and password", Toast.LENGTH_SHORT).show();


                }


            }
        });
    }
}