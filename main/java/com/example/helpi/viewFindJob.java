package com.example.helpi;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class viewFindJob extends AppCompatActivity {

    Button  updateBtn, deleteBtn;
    ImageView emailbtn;
    TextInputEditText service, position, location, method, description, email,emailtosent,sub;
    String Subject,sentmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewfindjob);
        email = findViewById(R.id.EmailAddress);
        service = findViewById(R.id.Service);
        position = findViewById(R.id.Position);
        location = findViewById(R.id.Location);
        method = findViewById(R.id.Method);
        description = findViewById(R.id.Description);
        emailbtn=findViewById(R.id.emailSendBtn);
        deleteBtn=findViewById(R.id.DeleteBtn);

        DAOEAcceptedjob addDao=new DAOEAcceptedjob();

        FINDJOBS request = (FINDJOBS) getIntent().getSerializableExtra("Edits");

        email.setText(request.getEmail());
        service.setText(request.getService());
        position.setText(request.getPosition());
        location.setText(request.getLocation());
        method.setText(request.getMethod());
        description.setText(request.getDescription());



        emailtosent=findViewById(R.id.EmailAddress);
        sub=findViewById(R.id.Service);
        sentmail=emailtosent.getText().toString();
        Subject= "I would like to help with "+sub.getText().toString();

        emailbtn.setOnClickListener(v-> {
            Intent intent=new Intent(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_EMAIL,new String[]{sentmail});

            intent.putExtra(Intent.EXTRA_SUBJECT,Subject );
            intent.setType("message/rfc822");
            /*intent.setData(Uri.parse("mailto:"));*/


            if (intent.resolveActivity(getPackageManager() )!= null) {
                startActivity(intent);
            }else{
                System.out.println(emailtosent+""+""+service+""+sub);
                Toast.makeText(this, "No Application to handle this method", Toast.LENGTH_SHORT).show();
            }

        });



        deleteBtn.setOnClickListener(v->{
            ACJOBS acjobs=new ACJOBS(
              email.getText().toString(),
              service.getText().toString(),
              position.getText().toString(),
              location.getText().toString(),
              method.getText().toString(),
              description.getText().toString()

            );

//---------------------------------------------------------------------------------
            AlertDialog.Builder builder = new AlertDialog.Builder(viewFindJob.this);
            builder.setMessage("Do You Really Want to Add This to your jobs?");
            builder.setTitle("Alert!");
            builder.setCancelable(true);

            builder.setPositiveButton("Yes", (DialogInterface.OnClickListener) (dialog, which) -> {

                DAOFindjob dao = new DAOFindjob();
                addDao.add(acjobs).addOnSuccessListener(suc -> {
                    Toast.makeText(this, "Inserted", Toast.LENGTH_SHORT).show();
                }).addOnFailureListener(er -> {
                    Toast.makeText(this, "" + er.getMessage(), Toast.LENGTH_SHORT).show();
                });


                dao.remove(request.getKey()).addOnSuccessListener(suc -> {

                    Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(viewFindJob.this, viewacceptedjobs.class).putExtra("key", request.getEmail()));

                }).addOnFailureListener(er -> {
                    Toast.makeText(this, "" + er.getMessage(), Toast.LENGTH_SHORT).show();
                });
            });

            builder.setNegativeButton("No", (DialogInterface.OnClickListener) (dialog, which) -> {
                dialog.cancel();;
            });

            AlertDialog alertDialog = builder.create();

            alertDialog.show();


        });


    }



}