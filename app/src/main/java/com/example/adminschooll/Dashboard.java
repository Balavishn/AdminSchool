package com.example.adminschooll;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Dashboard extends AppCompatActivity {
    CardView admin,principal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        admin=findViewById(R.id.Admin_card);
        principal=findViewById(R.id.principal_card);

        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),AdminLogin.class));
            }
        });
        principal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),PrinciLogin.class));
            }
        });
    }

  //  @Override
    /*protected void onResume() {
        super.onResume();
        startActivity(new Intent(getApplicationContext(),PrinciLogin.class));
    }*/
}