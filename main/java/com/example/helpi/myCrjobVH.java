package com.example.helpi;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class myCrjobVH extends RecyclerView.ViewHolder {


    public TextView date_rv_itm,title_rv_itm,description_rv_itm,name_rv_itm,possition_rv_itm,text_option;
    public myCrjobVH(@NonNull View itemView) {
        super(itemView);
        title_rv_itm=itemView.findViewById(R.id.title_rv_itm);
        date_rv_itm=itemView.findViewById(R.id.date_rv_itm);
        name_rv_itm=itemView.findViewById(R.id.name_rv_itm);
        description_rv_itm=itemView.findViewById(R.id.description_rv_itm);
        possition_rv_itm=itemView.findViewById(R.id.possition_rv_itm);
        text_option=itemView.findViewById(R.id.txt_option);
    }
}
