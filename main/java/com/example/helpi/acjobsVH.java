package com.example.helpi;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class acjobsVH extends RecyclerView.ViewHolder {

    public TextView acctitle_rv_itm,accpostdate_rv_itm,accname_rv_itm,accdescription_rv_itm,accpossition_rv_itm,accaccdate_rv_itm,accphno_rv_itm;

    public acjobsVH(@NonNull View itemView) {
        super(itemView);
        acctitle_rv_itm= itemView.findViewById(R.id.accTitle_rv_itm);
        accpostdate_rv_itm= itemView.findViewById(R.id.accPostdate_rv_itm);
        accname_rv_itm=itemView.findViewById(R.id.accName_rv_itm);
        accdescription_rv_itm=itemView.findViewById(R.id.accDescription_rv_itm);
        accpossition_rv_itm=itemView.findViewById(R.id.accPossition_rv_itm);
        accaccdate_rv_itm=itemView.findViewById(R.id.accAccdate_rv_itm);
        accphno_rv_itm=itemView.findViewById(R.id.accPhno_rv_itm);


    }
}
