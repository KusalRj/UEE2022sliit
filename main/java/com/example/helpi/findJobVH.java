package com.example.helpi;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class findJobVH extends RecyclerView.ViewHolder {

    public TextView description, service;
    public Button moreBtn;

    public findJobVH(@NonNull View itemView) {
        super(itemView);
        description = itemView.findViewById(R.id.Description);
        service = itemView.findViewById(R.id.Service);
        moreBtn = itemView.findViewById(R.id.More);
    }
}
