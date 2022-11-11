package com.example.helpi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class myjobs extends AppCompatActivity {


    private Button addJobBtn;
    private Button viewCreatedJobs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myjobs);
        addJobBtn=(Button) findViewById(R.id.createNewJobBtn);
        viewCreatedJobs=findViewById(R.id.viewCreatedJobsBtn);

        addJobBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openaddjobs();
            }

        });
        viewCreatedJobs.setOnClickListener(v->{
            Intent intent=new Intent(this,myCreatedJobsView.class);
            startActivity(intent);
        });
    }
    public void openaddjobs(){
        Intent intent= new Intent(this, createjob.class);
        startActivity(intent);
    }
}