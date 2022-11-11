package com.example.helpi;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class viewaccjobadapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    ArrayList<ACJOBS> list= new ArrayList<>();
    public viewaccjobadapter(Context ctx){
        this.context=ctx;
    }
    //add data into list array
    public void setItems(ArrayList<ACJOBS> acj){
        list.addAll(acj);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Setting Item layout
        View view= LayoutInflater.from(context).inflate(R.layout.accjobitems,parent,false);
        return new acjobsVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        //Bind data
        //Set ViewHolder
        acjobsVH vh=(acjobsVH) holder;

        //Model class
        ACJOBS acj=list.get(position);
        //View Holder and model class
        vh.acctitle_rv_itm.setText(acj.getTitle());
        vh.accpostdate_rv_itm.setText(acj.getPostdate());
        vh.accname_rv_itm.setText(acj.getReqname());
        vh.accphno_rv_itm.setText(String.valueOf(acj.getPhno()));
        vh.accaccdate_rv_itm.setText(acj.getAccepteddate());
        vh.accdescription_rv_itm.setText(acj.getDescription());
        vh.accpossition_rv_itm.setText(acj.getPossition());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
