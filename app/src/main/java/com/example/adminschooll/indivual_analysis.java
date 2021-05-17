package com.example.adminschooll;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class indivual_analysis extends AppCompatActivity {
    Spinner classs,sec;
    Button get;
    DatabaseReference markref;
    List<String> subject_name=new ArrayList<>();
    List<String> mark_in=new ArrayList<>();
    RecyclerView invi;
    TextView student_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indivual_analysis);
        student_name=findViewById(R.id.indivual_student_name);
        student_name.setText("Babu CSE 2021");
        markref= FirebaseDatabase.getInstance().getReference("Staff_Details").child("Academic");
//        String classsss=classs.getSelectedItem().toString();
        markref= markref.child("1").child("Mark").child("1-A").child("Babu CSE 2021");
        invi=findViewById(R.id.indivual_subject_list);
        invi.setLayoutManager(new LinearLayoutManager(this));

        getdatamark();

    }
    public void getdatamark(){
        markref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                    for (DataSnapshot subject : snapshot.getChildren()) {
                        subject_name.add(subject.getKey().toString());
                        mark_in.add(subject.child("Babu CSE 2021").getValue().toString());
                        }


                    indivual_student_adapter p = new indivual_student_adapter(subject_name, mark_in);
                    invi.setAdapter(p);
                }



            @Override
            public void onCancelled (@NonNull DatabaseError error){

            }

        });

    }
}