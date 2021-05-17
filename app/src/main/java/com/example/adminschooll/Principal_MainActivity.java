package com.example.adminschooll;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.adminschooll.ui.attendace_tab.Attendance_tab;

import androidx.appcompat.app.AppCompatActivity;

public class Principal_MainActivity extends AppCompatActivity {
Button leave,attendance,perforamance,logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_main);

        leave=findViewById(R.id.leave);
        attendance=findViewById(R.id.attendence);
        perforamance=findViewById(R.id.performance);
        logout=findViewById(R.id.principal_logout);

        attendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Attendance_tab.class));
            }
        });

        perforamance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Perforamce_tab.class));
            }
        });

        leave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(),LeaveRequest.class));
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Dashboard.class));
            }
        });
    }
}