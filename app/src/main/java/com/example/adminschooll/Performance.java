package com.example.adminschooll;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class Performance extends AppCompatActivity {



    Spinner classs,sec;
    Button get;
    DatabaseReference markref;
    List<Student> student_name=new ArrayList<>();
   // List<Integer> student_mark=new ArrayList<>();

    RecyclerView permance_rank;
    String[] name=new String[3];
    String[] mark=new String[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_performance);
        classs=findViewById(R.id.classs_mark);
        sec=findViewById(R.id.sec_mark);
        get=findViewById(R.id.get_leaderboard);
        markref= FirebaseDatabase.getInstance().getReference("Staff_Details").child("Academic");
        permance_rank=findViewById(R.id.performance_mark);
        permance_rank.setLayoutManager(new LinearLayoutManager(this));
        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String class_name=classs.getSelectedItem().toString()+"-"+sec.getSelectedItem().toString();
                String classss=classs.getSelectedItem().toString();
               markref= markref.child(classss).child(class_name).child("Mark");

               getdatamark();
               /* for (int i=0;i<student_name.size();i++){
                    Log.d("student-name-mark",student_name.get(i)+"-"+student_mark.get(i));
                }*/
            }
        });
    }

    public void getdatamark(){
        markref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot data : snapshot.getChildren()) {
                   // student_name.add(data.getKey());
                    DataSnapshot student = data;
                    int total = 0;
                    int count = 0;
                    for (DataSnapshot mark : student.getChildren()) {
                        total += Integer.parseInt(mark.child(data.getKey()).getValue().toString());
                        count += 1;
                        if (student.getChildrenCount() == count) {
                            //student_mark.add(total);
                            student_name.add(new Student(data.getKey(),total));
                        }

                        Log.d("student m", mark.child(data.getKey()).getValue().toString());

                    }
                }
                Collections.sort(student_name,Collections.<Student>reverseOrder());
                int pos=0;
                for (Student s:student_name){
                    name[pos]=s.getName();
                    mark[pos]=String.valueOf(s.getGrade());
                    pos++;
                    Log.d("student-name-mark",s.getName()+" "+String.valueOf(s.getGrade())+student_name.indexOf(s));

                }
                Performance_adapter p=new Performance_adapter(name,mark);
                permance_rank.setAdapter(p);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}