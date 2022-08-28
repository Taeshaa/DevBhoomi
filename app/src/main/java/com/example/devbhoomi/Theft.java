package com.example.devbhoomi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.UUID;

public class Theft extends AppCompatActivity {

    private EditText name , time, phone, place, desc, officer;
    private Button mSaveBtn, mShowBtn;
    private FirebaseFirestore db;
    //private String uTitle, uDesc , uId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theft);

        name = findViewById(R.id.TheftName);
        time = findViewById(R.id.TheftTime);
        place = findViewById(R.id.TheftPlace);
        officer = findViewById(R.id.OfficerDuty);
        desc = findViewById(R.id.TheftDesc);
        mSaveBtn = findViewById(R.id.AddTheft);
        mShowBtn = findViewById(R.id.ShowTheft);
        phone = findViewById(R.id.ComplPhone);


        db= FirebaseFirestore.getInstance();



        mSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Name = name.getText().toString();
                String Time = time.getText().toString();
                String Place = place.getText().toString();
                String Officer = officer.getText().toString();
                String Phone = phone.getText().toString();
                String Desc = desc.getText().toString();
                String id=UUID.randomUUID().toString();

                saveToFireStore(id,Name,Time,Place,Officer,Desc,Phone);
            }
        });
        mShowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // opening a login activity on clicking login text.
                Intent i = new Intent(Theft.this, ShowActivity.class);
                startActivity(i);
            }
        });
    }


    private void saveToFireStore(String id , String Name , String Time,String Place,String Officer,String Desc,String Phone){

        if (!Name.isEmpty() && !Time.isEmpty() && !Phone.isEmpty() && !Place.isEmpty() && !Officer.isEmpty() && !Desc.isEmpty()){
            HashMap<String , Object> map = new HashMap<>();
            map.put("id" , id);
            map.put("Complainant Name" , Name);
            map.put("Complainant Phone" , Phone);
            map.put("Theft Time" , Time);
            map.put("Theft Place" , Place);
            map.put("Officer On Duty" , Officer);
            map.put("Theft Description" , Desc);


            db.collection("Theft").document(id).set(map)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(Theft.this, "Data Saved !!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(Theft.this, "Failed !!", Toast.LENGTH_SHORT).show();
                }
            });

        }else
            Toast.makeText(this, "Empty Fields not Allowed", Toast.LENGTH_SHORT).show();
    }
}