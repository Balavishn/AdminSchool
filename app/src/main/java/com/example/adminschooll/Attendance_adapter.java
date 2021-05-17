package com.example.adminschooll;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



class Attendance_adapter extends RecyclerView.Adapter<Attendance_adapter.myperformance> {
    List<String> name;
    List<String>  no;

    public Attendance_adapter(List<String> name,List<String> no) {
        this.name = name;
        this.no = no;
    }

    @NonNull
    @Override
    public myperformance onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.single_leaderboard,parent,false);
        myperformance viewHold=new myperformance(v);
        return viewHold;
    }

    @Override
    public void onBindViewHolder(@NonNull myperformance holder, int position) {
        holder.rank.setText(no.get(position));
        holder.name.setText(String.valueOf(position+1)+"."+name.get(position));
    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    public class myperformance extends RecyclerView.ViewHolder{
        TextView rank,name;
        public myperformance(@NonNull View itemView) {
            super(itemView);
            rank=itemView.findViewById(R.id.single_rank_no);
            name=itemView.findViewById(R.id.single_rank_name);
        }
    }
}
