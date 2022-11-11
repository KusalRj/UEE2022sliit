package com.example.helpi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button viewaccjobsbtn;
    private Button createJobsbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewaccjobsbtn=(Button) findViewById(R.id.viewAccJobBtnHome);
        viewaccjobsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openViewAccjobs();
            }
        });
        createJobsbtn=(Button) findViewById(R.id.createJobBtnHome);
        createJobsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCreatejobs();
            }
        });

    }


    public void openViewAccjobs(){
        Intent intent= new Intent(MainActivity.this, viewacceptedjobs.class);
        startActivity(intent);
    }
    public void openCreatejobs(){
        Intent intent= new Intent(this, myjobs.class);
        startActivity(intent);
    }
}