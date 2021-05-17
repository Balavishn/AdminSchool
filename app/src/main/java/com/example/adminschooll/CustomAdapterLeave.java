package com.example.adminschooll;


//import android.support.v7.widget.RecyclerView;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



import java.util.ArrayList;

public class CustomAdapterLeave extends RecyclerView.Adapter<CustomAdapterLeave.MyViewHolder> {
    private ArrayList<ModelLeaveReq> listData;
    private Context context;
    public CustomAdapterLeave(Context context,ArrayList<ModelLeaveReq> listData) {
        this.listData = listData;
        this.context=context;
    }





    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // infalte the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.sample_list_leave_req, parent, false);
        // set the view's size, margins, paddings and layout parameters
        MyViewHolder vh = new MyViewHolder(v); // pass the view to View Holder
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final ModelLeaveReq ld=listData.get(position);
        holder.name.setText(ld.getName());
        holder.id.setText(ld.getId());
        holder.leave.setText(ld.getLeave());
        holder.days.setText(ld.getDays());
        holder.approval.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {


    }
});

    }


    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        // init the item view's
TextView name,id,leave,days;
Button approval;
        public MyViewHolder(View itemView) {
            super(itemView);
            // get the reference of item view's
            name=itemView.findViewById(R.id.Name);
            id=itemView.findViewById(R.id.Id);
            leave=itemView.findViewById(R.id.Leave);
            days=itemView.findViewById(R.id.Days);
            approval=itemView.findViewById(R.id.Approval);

        }
    }



}