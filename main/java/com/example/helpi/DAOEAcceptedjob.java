package com.example.helpi;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class DAOEAcceptedjob {
    private DatabaseReference databaseReference;
    public DAOEAcceptedjob(){
        FirebaseDatabase db=FirebaseDatabase.getInstance();
        databaseReference=db.getReference(ACJOBS.class.getSimpleName());

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

    public Task<Void> add(ACJOBS acj){
        return databaseReference.push().setValue(acj);
    }
}
