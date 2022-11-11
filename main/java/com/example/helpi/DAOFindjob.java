package com.example.helpi;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.HashMap;


public class DAOFindjob {
    private DatabaseReference databaseReference;

    public DAOFindjob() {

        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference(FINDJOBS.class.getSimpleName());
    }
    public Query get(String key){

        if (key==null){
            return databaseReference.orderByKey().limitToFirst(8);
        }
        return databaseReference.orderByKey().startAfter(key).limitToFirst(8);
    }

    public Task<Void> remove(String key) {
        return databaseReference.child(key).removeValue();
    }


}
