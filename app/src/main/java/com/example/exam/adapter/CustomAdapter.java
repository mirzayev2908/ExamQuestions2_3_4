package com.example.exam.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.exam.R;
import com.example.exam.model.Member;

import java.util.ArrayList;
import java.util.List;


public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    List<Member> members;

    public CustomAdapter(Context context, List<Member> members) {
        this.context = context;
        this.members = members;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_custom_view,parent,false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Member member = members.get(position);
    }
    @Override
    public int getItemCount() {
        return members.size();
    }

    private class CustomViewHolder extends RecyclerView.ViewHolder {
        public CustomViewHolder(View view) {
            super(view);
        }
    }

    public void setMembers(List<Member> students) {
        this.members.addAll(students);
        notifyDataSetChanged();
    }
}
