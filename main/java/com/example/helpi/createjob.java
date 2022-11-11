package com.example.helpi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class createjob extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createjob);

        final EditText editTitle =findViewById(R.id.insTitle);
        final EditText editDescription =findViewById(R.id.insDescription);
        final EditText editDate =findViewById(R.id.insDate);
        final EditText editName =findViewById(R.id.insName);
        final EditText editPossition =findViewById(R.id.insPossition);
        Button addJob=findViewById(R.id.addjob);
        DAOECreatejob dao=new DAOECreatejob();

        CREJOBS crj_edit=(CREJOBS) getIntent().getSerializableExtra("Edit");
        if(crj_edit !=null){
            addJob.setText("UPDATE");
            editTitle.setText(crj_edit.getTitle());
            editDescription.setText(crj_edit.getDescription());
            editDate.setText(crj_edit.getPsotdate());
            editName.setText(crj_edit.getName());
            editPossition.setText(crj_edit.getPossition());

        }
        else {
            addJob.setText("ADD");

        }

        addJob.setOnClickListener(v-> {
                    CREJOBS crejobs = new CREJOBS(
                            editTitle.getText().toString(),
                            editDescription.getText().toString(),
                            editName.getText().toString(),
                            editPossition.getText().toString(),
                            editDate.getText().toString()

                    );
                    if (crj_edit == null){
                        dao.add(crejobs).addOnSuccessListener(suc -> {
                            Toast.makeText(this, "Inserted", Toast.LENGTH_SHORT).show();
                        }).addOnFailureListener(er -> {
                            Toast.makeText(this, "" + er.getMessage(), Toast.LENGTH_SHORT).show();
                        });
                }


            else {

            HashMap<String,Object> hashMap=new HashMap<>();
            hashMap.put("title",editTitle.getText().toString());
            hashMap.put("description",editDescription.getText().toString());
            hashMap.put("name",editName.getText().toString());
            hashMap.put("possition",editPossition.getText().toString());
            hashMap.put("psotdate",editDate.getText().toString());

            dao.update(crj_edit.getKey(),hashMap).addOnSuccessListener(suc->{
                Toast.makeText(this,"Updated",Toast.LENGTH_SHORT).show();
                finish();
            }).addOnFailureListener(er->{
                Toast.makeText(this,""+er.getMessage(),Toast.LENGTH_SHORT).show();
            });

                    }


        });

    }

}