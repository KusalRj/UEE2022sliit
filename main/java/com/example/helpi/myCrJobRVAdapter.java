package com.example.helpi;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myCrJobRVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context context;
    ArrayList<CREJOBS> list=new ArrayList<>();

    public myCrJobRVAdapter(Context ctx) {
        this.context=ctx;
    }

    public void setItems(ArrayList<CREJOBS>crj){
        list.addAll(crj);
    }




    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.createdjobsviewitem,parent,false);

        return new myCrjobVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
       myCrjobVH vh= (myCrjobVH) holder;
       CREJOBS crj=list.get(position);
       vh.title_rv_itm.setText(crj.getTitle());
       vh.date_rv_itm.setText(crj.getPsotdate());
       vh.description_rv_itm.setText(crj.getDescription());
       vh.name_rv_itm.setText(crj.getName());
       vh.possition_rv_itm.setText(crj.getPossition());

       vh.text_option.setOnClickListener(v->{
           PopupMenu popupMenu=new PopupMenu(context,vh.text_option);
           popupMenu.inflate(R.menu.option_menu);
           popupMenu.setOnMenuItemClickListener(item ->{
               switch (item.getItemId()){
                   case R.id.menu_edit:
                       Intent intent=new Intent(context,createjob.class);
                       intent.putExtra("Edit",crj);
                       context.startActivity(intent);
                       break;

                   case R.id.menu_remove:
                       DAOECreatejob dao=new DAOECreatejob();
                       dao.remove(crj.getKey()).addOnSuccessListener(suc->{
                           Toast.makeText(context,"Deleted",Toast.LENGTH_SHORT).show();

                       }).addOnFailureListener(er->{
                           Toast.makeText(context,""+er.getMessage(),Toast.LENGTH_SHORT).show();
                       });
                       break;
               }
               return false;
           } );


           popupMenu.show();
       });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
