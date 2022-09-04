package com.example.devbhoomi;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class ShowMurder extends AppCompatActivity {

    private RecyclerView recyclerView3;
    private FirebaseFirestore db;
    private MyAdapterMurder adapter;
    private List<ModelJ> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_murder);

        recyclerView3 = findViewById(R.id.recyclerview4);
        recyclerView3.setHasFixedSize(true);
        recyclerView3.setLayoutManager(new LinearLayoutManager(this));

        db= FirebaseFirestore.getInstance();
        list = new ArrayList<>();
        adapter = new MyAdapterMurder(this , list);
        recyclerView3.setAdapter(adapter);


        showData();
    }

    public void showData(){

        db.collection("CasesRegistered").whereEqualTo("Category", "Murder")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        list.clear();
                        for (DocumentSnapshot snapshot : task.getResult()){

                            ModelJ model = new ModelJ(snapshot.getString("Age") , snapshot.getString("Name") , snapshot.getString("Category") ,snapshot.getString("Bailable") ,snapshot.getString("City"),snapshot.getString("Date"),snapshot.getString("Description"),snapshot.getString("Id"));
                            list.add(model);
                        }
                        adapter.notifyDataSetChanged();
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(ShowMurder.this, "Oops ... something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
