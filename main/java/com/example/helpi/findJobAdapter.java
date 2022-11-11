package com.example.helpi;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
public class findJobAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context context;
    ArrayList<FINDJOBS> list = new ArrayList<>();

    public findJobAdapter(Context ctx) {
        this.context = ctx;
    }

    public void setItems(ArrayList<FINDJOBS> request) {
        list.addAll(request);
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.findjibsitems, parent, false);
        return new findJobVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        findJobVH viewHolder = (findJobVH) holder;
        FINDJOBS request = list.get(position);
        viewHolder.description.setText(request.getDescription());
        viewHolder.service.setText(request.getService());

        viewHolder.moreBtn.setOnClickListener(view -> {
            Intent intent = new Intent(context, viewFindJob.class);
            intent.putExtra("Edits", request);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
