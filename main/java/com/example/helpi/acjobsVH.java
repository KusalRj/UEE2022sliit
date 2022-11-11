package com.example.helpi;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class acjobsVH extends RecyclerView.ViewHolder {

    public TextView acctitle_rv_itm,accpostdate_rv_itm;
    public Button moreBtn;

    public acjobsVH(@NonNull View itemView) {
        super(itemView);
        acctitle_rv_itm= itemView.findViewById(R.id.accTitle_rv_itm);
        accpostdate_rv_itm= itemView.findViewById(R.id.acclocation_rv_itm);
        moreBtn = itemView.findViewById(R.id.More);



    }
}
