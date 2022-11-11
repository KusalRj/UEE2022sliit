package com.example.helpi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class findJob extends AppCompatActivity {
    SwipeRefreshLayout swipeRefreshLayout;
    RecyclerView recyclerView;
    findJobAdapter adapter;
    DAOFindjob dao;



    boolean isLoading=false;
    String key=null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_job);
        Bundle extras = getIntent().getExtras();
        swipeRefreshLayout = findViewById(R.id.SwipFj);
        recyclerView = findViewById(R.id.RecyclerViewFj);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        adapter = new findJobAdapter(this);
        recyclerView.setAdapter(adapter);
        dao = new DAOFindjob();
        loadData();
//This  place could make errors



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

                ArrayList<FINDJOBS> requests = new ArrayList<>();
                for (DataSnapshot data : snapshot.getChildren()) {

                    FINDJOBS request = data.getValue(FINDJOBS.class);
                    requests.add(request);
                    request.setKey(data.getKey());
                    key=data.getKey();


                }
                adapter.setItems(requests);
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