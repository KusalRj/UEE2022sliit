package com.example.helpi;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;



import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.helpi.R;
import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;

public class viewacceptedjobs extends AppCompatActivity {

    SwipeRefreshLayout swipeRefreshLayout;
    RecyclerView recyclerView;
    viewaccjobadapter adapter;
    DAOEAcceptedjob dao;


    boolean isLoading=false;
    String key=null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewacceptedjobs);
        swipeRefreshLayout=findViewById(R.id.swip);
        recyclerView =findViewById(R.id.rvAccjob);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager manager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        adapter=new viewaccjobadapter(this);
        recyclerView.setAdapter(adapter);
        dao =new DAOEAcceptedjob();
        loadData();





        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                LinearLayoutManager linearLayoutManager=(LinearLayoutManager) recyclerView.getLayoutManager();
                int totalItem= linearLayoutManager.getItemCount();
                int lastVisible= linearLayoutManager.findLastCompletelyVisibleItemPosition();
                if (totalItem<lastVisible+3){
                    if (!isLoading){
                        isLoading=true;
                        loadData();
                    }
                }
            }





        });
    }

    private void loadData() {
        dao.get(key).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ArrayList<ACJOBS> acjs=new ArrayList<>();
                for(DataSnapshot data:snapshot.getChildren()){
                    ACJOBS acj=data.getValue(ACJOBS.class);
                    acjs.add(acj);

                    key=data.getKey();


                }
                adapter.setItems(acjs);
                adapter.notifyDataSetChanged();

                isLoading=false;
                swipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }
}