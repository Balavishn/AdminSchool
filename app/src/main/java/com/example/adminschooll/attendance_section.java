package com.example.adminschooll;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

public class attendance_section extends Fragment {

    Spinner classs,sec;
    Button get;
    DatabaseReference markref;
    List<String> student_name=new ArrayList<>();
    List<String> student_mark=new ArrayList<>();

    RecyclerView permance_rank;
    String[] name=new String[3];
    String[] mark=new String[3];



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.fragment_attendance_section, container, false);

        classs=v.findViewById(R.id.section_attendace_classs_attendace);
        sec=v.findViewById(R.id.section_attendace_sec_attendace);
        get=v.findViewById(R.id.section_attendace_get_leaderboard);
        markref= FirebaseDatabase.getInstance().getReference("Staff_Details").child("Academic");
        permance_rank=v.findViewById(R.id.section_attendance_recycle);
        permance_rank.setLayoutManager(new LinearLayoutManager(v.getContext()));
        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                markref= FirebaseDatabase.getInstance().getReference("Staff_Details").child("Academic");
                String class_name=classs.getSelectedItem().toString()+"-"+sec.getSelectedItem().toString();
                String classss=classs.getSelectedItem().toString();
                markref= markref.child(classss).child("Attendance").child(class_name);
                Log.d("buttoncalled",class_name);
                getdatamark();
               /* for (int i=0;i<student_name.size();i++){
                    Log.d("student-name-mark",student_name.get(i)+"-"+student_mark.get(i));
                }*/
            }
        });
        // Inflate the layout for this fragment
        return v;
    }
    public void getdatamark(){
        student_name.clear();
        Log.d("reference",markref.getRef().toString());
        markref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot date : snapshot.getChildren()) {
                    // student_name.add(data.getKey());
                    DataSnapshot student = date;

                    Log.d("jsonvalue",date.toString());
                    int present_count = 0;
                    int absent_count=0;
                    int count = 0;
                    for (DataSnapshot present : student.getChildren()) {
                        if(present.child(date.getKey()).getValue().toString().equals("present")){
                          //  present_count += Integer.parseInt(present.child(present.getKey()).getValue().toString());
                            Log.d("present",present.child(date.getKey()).getValue().toString());
                            present_count+=1;
                        }
                        else{
                          //  absent_count += Integer.parseInt(present.child(present.getKey()).getValue().toString());
                            Log.d("absent",present.child(date.getKey()).getValue().toString());
                        }

                        count += 1;
                        if (student.getChildrenCount() == count) {
                            //student_mark.add(total);
                            //student_name.add(new Student(present.getKey(),present_count));
                            Double tpresent_count=Double.valueOf(present_count);
                            double percentage=((double) tpresent_count/student.getChildrenCount())*100;
                            Log.d("totalpresent",String.format("%.2f",percentage));
                            student_name.add(date.getKey());
                            student_mark.add(String.format("%.2f",percentage));
                        }

                        Log.d("student m", present.getValue().toString());

                    }
                }
              //  Collections.sort(student_name,Collections.<Student_at>reverseOrder());
              //  int pos=0;
                /*for (Student s:student_name){
                    try {
                        name[pos]=s.getName();
                        mark[pos]=String.valueOf(s.getGrade());
                        pos++;
                        Log.d("student-name-mark",s.getName()+" "+String.valueOf(s.getGrade())+student_name.indexOf(s));
                    }
                    catch (Exception e){
                        break;
                    }
                }*/
                Attendance_adapter p=new Attendance_adapter(student_name,student_mark);
                permance_rank.setAdapter(p);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}