package com.example.adminschooll;


import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Attendence extends AppCompatActivity {
    ListView myPDFListView;
    DatabaseReference databaseReference;
    //List<uploadAttendence> uploadPDFs;
    Spinner cls,sec;
    String cls1,sec1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendence);
        myPDFListView=(ListView)findViewById(R.id.myListView);
        cls=findViewById(R.id.sec);
        sec=findViewById(R.id.sub);
        cls1=cls.getSelectedItem().toString();
        sec1=sec.getSelectedItem().toString();
        databaseReference=FirebaseDatabase.getInstance().getReference();

    }
}