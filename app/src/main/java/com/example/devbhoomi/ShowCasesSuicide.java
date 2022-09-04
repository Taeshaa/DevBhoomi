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

public class ShowCasesSuicide extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FirebaseFirestore db;
    private MyAdapterSuicide adapter;
    private List<ModelS> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_cases_suicide);

        recyclerView = findViewById(R.id.recyclerview5);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        db= FirebaseFirestore.getInstance();
        list = new ArrayList<>();
        adapter = new MyAdapterSuicide(this , list);
        recyclerView.setAdapter(adapter);


        showData();
    }

    public void showData(){

        db.collection("CasesRegistered").whereEqualTo("Category", "Suicide")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        list.clear();
                        for (DocumentSnapshot snapshot : task.getResult()){

                            ModelS model = new ModelS(snapshot.getString("Age") , snapshot.getString("Name") , snapshot.getString("Category") ,snapshot.getString("Bailable") ,snapshot.getString("City"),snapshot.getString(" Registration Date"),snapshot.getString("Description"),snapshot.getString("id"));
                            list.add(model);
                        }

                        adapter.notifyDataSetChanged();
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(ShowCasesSuicide.this, "Oops ... something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}