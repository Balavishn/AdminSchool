package com.example.adminschooll;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Admin_MainActivity extends AppCompatActivity {
Button fee,events,adminstraion,logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_main);
        events=findViewById(R.id.events);
        adminstraion=findViewById(R.id.administration);
        fee=findViewById(R.id.fee);
        logout=findViewById(R.id.logout);
        events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),AdminEvent.class));
            }
        });
        fee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),FeeStructure.class));
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Dashboard.class));
            }
        });
        adminstraion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Administration.class));
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //startActivity(new Intent(this,Dashboard.class));
    }
}