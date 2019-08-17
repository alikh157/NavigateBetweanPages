package com.example.navigatebetweanpages;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class testRecyclerAdapter extends RecyclerView.Adapter<testRecyclerAdapter.TestRecyclerViewHolder> {

List<String> mylist;
    public testRecyclerAdapter(List<String> list) {
        mylist =list;

    }

    @NonNull
    @Override
    public TestRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.reee,parent,false);
        TestRecyclerViewHolder holder= new TestRecyclerViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull TestRecyclerViewHolder holder, int position) {
        String name=mylist.get(position);
        holder.txtname.setText(name);
    }

    @Override
    public int getItemCount() {
        return mylist.size();
    }

    class TestRecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView txtname;
        ImageView img;
        public TestRecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            txtname=itemView.findViewById(R.id.txtname);
        }
    }
}
