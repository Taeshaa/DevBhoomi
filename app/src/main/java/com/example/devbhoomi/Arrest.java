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

public class Arrest extends AppCompatActivity {

    private EditText name , age, phone, city, start, offence;
    private Button mSaveBtn;
    private FirebaseFirestore db;
    //private String uTitle, uDesc , uId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arrest);

        name = findViewById(R.id.idEdtAccusedName);
        age = findViewById(R.id.idEdtAccusedAge);
        phone = findViewById(R.id.idEdtAccusedPh);
        city = findViewById(R.id.idEdtAccusedCity);
        start = findViewById(R.id.idEdtCaseDate);
        offence = findViewById(R.id.idEdtOffenceDesc);
        mSaveBtn = findViewById(R.id.idBtnAddCourse);


        db= FirebaseFirestore.getInstance();



        mSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Name = name.getText().toString();
                String Age = age.getText().toString();
                String Start = start.getText().toString();

                String Phone = phone.getText().toString();
                String Offence = offence.getText().toString();
                String City = city.getText().toString();
                String id=UUID.randomUUID().toString();

                saveToFireStore(id,Name,Age,Start,Phone,Offence,City);
            }
        });
    }


    private void saveToFireStore(String id , String Name , String Age,String City,String Start,String Offence ,String Phone){

        if (!Name.isEmpty() && !Age.isEmpty() && !Phone.isEmpty() && !City.isEmpty() && !Start.isEmpty() &&  !Offence.isEmpty()){
            HashMap<String , Object> map = new HashMap<>();
            map.put("id" , id);
            map.put("Name" , Name);
            map.put("Offence" , Offence);
            map.put("Age" , Age);
            map.put("Phone Number" , Phone);
            map.put("Date" , Start);



            db.collection("Arrested").document(id).set(map)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(Arrest.this, "Data Saved !!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(Arrest.this, "Failed !!", Toast.LENGTH_SHORT).show();
                }
            });

        }else
            Toast.makeText(this, "Empty Fields not Allowed", Toast.LENGTH_SHORT).show();
    }
}