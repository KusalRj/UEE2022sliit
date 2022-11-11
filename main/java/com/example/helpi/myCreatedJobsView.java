package com.example.helpi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class myCreatedJobsView extends AppCompatActivity {

    SwipeRefreshLayout swipeRefreshLayout;
    RecyclerView recyclerView;
    myCrJobRVAdapter adapter;
    DAOECreatejob dao;


    boolean isLoading=false;
    String key=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mycreatedjobsview);
        swipeRefreshLayout=findViewById(R.id.siwpviewcrjob);
        recyclerView=findViewById(R.id.rvCrjob);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager manager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        adapter=new myCrJobRVAdapter(this);
        recyclerView.setAdapter(adapter);
        dao=new DAOECreatejob();
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

        swipeRefreshLayout.setRefreshing(true);

        dao.get(key).addValueEventListener(new ValueEventListener(){

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ArrayList<CREJOBS> crjs=new ArrayList<>();
                for(DataSnapshot data:snapshot.getChildren()){
                    CREJOBS crj=data.getValue(CREJOBS.class);

                    crj.setKey(data.getKey());

                    crjs.add(crj);

                    key=data.getKey();

                }
                adapter.setItems(crjs);
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