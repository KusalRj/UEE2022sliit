package com.example.helpi;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class acJobDetailView extends AppCompatActivity {
    Button updateBtn, deleteBtn;
    ImageView emailbtn;
    TextInputEditText service, position, location, method, description, email,emailtosent,sub;
    String Subject,sentmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ac_job_detail_view);

        email = findViewById(R.id.EmailAddress);
        service = findViewById(R.id.Service);
        position = findViewById(R.id.Position);
        location = findViewById(R.id.Location);
        method = findViewById(R.id.Method);
        description = findViewById(R.id.Description);
        emailbtn=findViewById(R.id.emailSendBtn);
        deleteBtn=findViewById(R.id.DeleteBtn);
        ACJOBS request = (ACJOBS) getIntent().getSerializableExtra("Edits");

        email.setText(request.getEmail());
        service.setText(request.getService());
        position.setText(request.getPosition());
        location.setText(request.getLocation());
        method.setText(request.getMethod());
        description.setText(request.getDescription());


        emailtosent=findViewById(R.id.EmailAddress);
        sub=findViewById(R.id.Service);
        sentmail=emailtosent.getText().toString();
        Subject= "Requesting details about "+sub.getText().toString();
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
        deleteBtn.setOnClickListener(view -> {

            AlertDialog.Builder builder = new AlertDialog.Builder(acJobDetailView.this);
            builder.setMessage("Do You Really Want to Delete This Service Request?");
            builder.setTitle("Alert!");
            builder.setCancelable(true);

            builder.setPositiveButton("Yes", (DialogInterface.OnClickListener) (dialog, which) -> {

                DAOEAcceptedjob dao = new DAOEAcceptedjob();

                dao.remove(request.getKey()).addOnSuccessListener(suc -> {

                    Toast.makeText(this, "Job Terminated", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(acJobDetailView.this, viewacceptedjobs.class).putExtra("key", request.getEmail()));

                }).addOnFailureListener(er -> {
                    Toast.makeText(this, "Service Request Delete Failed" + er.getMessage(), Toast.LENGTH_SHORT).show();
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