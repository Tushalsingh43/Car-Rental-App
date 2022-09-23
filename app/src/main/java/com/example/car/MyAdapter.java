package com.example.car;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;

    ArrayList<Userdata> list;

    public MyAdapter(Context context, ArrayList<Userdata> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.bookingdetails,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Userdata userdata = list.get(position);
        holder.Name.setText(userdata.getName());
        holder.Pickup.setText(userdata.getPickupDate());
        holder.Return.setText(userdata.getReturnDate());
        holder.vehicleName.setText(userdata.getVehicleName());
        holder.email.setText(userdata.getEmail());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView Name,Pickup,Return,vehicleName,email;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            Name = itemView.findViewById(R.id.customerName);
            Pickup = itemView.findViewById(R.id.pickupDate);
            Return = itemView.findViewById(R.id.returnDate);
            vehicleName = itemView.findViewById(R.id.vehicleName);
            email = itemView.findViewById(R.id.email);
        }
    }

}
