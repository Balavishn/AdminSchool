package com.example.adminschooll;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class LeaveRequest extends AppCompatActivity {
RecyclerView recyclerView;
    DatabaseReference reference;
    List<ModelLeaveReq> listdata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leave_request);
        recyclerView = findViewById(R.id.recycle);

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        listdata = new ArrayList<>();
        reference = FirebaseDatabase.getInstance().getReference("leave");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    String days=dataSnapshot.child("days").getValue().toString();
                    String name=dataSnapshot.child("name").getValue().toString();
                    String id=dataSnapshot.child("id").getValue().toString();
                    String leave=dataSnapshot.child("leave").getValue().toString();
                    ModelLeaveReq l =new ModelLeaveReq(name,id,leave,days);
                    listdata.add(l);
                    Log.d("Msg", l.getName());
                }
                CustomAdapterLeave customAdapter = new CustomAdapterLeave(getApplicationContext() ,(ArrayList<ModelLeaveReq>) listdata);
                recyclerView.setAdapter(customAdapter);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}

