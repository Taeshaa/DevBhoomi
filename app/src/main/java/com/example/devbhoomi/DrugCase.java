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

public class DrugCase extends AppCompatActivity {

    private EditText name , age, phone, city, start, quantity;
    private Button mSaveBtn;
    private FirebaseFirestore db;
    //private String uTitle, uDesc , uId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drug_case);

        name = findViewById(R.id.idEdtCulpritName);
        age = findViewById(R.id.idEdtCulpritAge);
        phone = findViewById(R.id.idEdtCulpritPh);
        city = findViewById(R.id.idEdtCulpritCity);
        start = findViewById(R.id.idEdtDrugDate);
        quantity = findViewById(R.id.idEdtQuantityFound);
        mSaveBtn = findViewById(R.id.idBtnAddCourse);


        db= FirebaseFirestore.getInstance();



        mSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Name = name.getText().toString();
                String Age = age.getText().toString();
                String Start = start.getText().toString();


                String Quantity = quantity.getText().toString();
                String City = city.getText().toString();
                String id=UUID.randomUUID().toString();

                saveToFireStore(id,Name,Age,Start,Quantity,City);
            }
        });
    }


    private void saveToFireStore(String id , String Name , String Age,String City,String Start,String Quantity ){

        if (!Name.isEmpty() && !Age.isEmpty() && !City.isEmpty() && !Start.isEmpty() &&  !Quantity.isEmpty()){
            HashMap<String , Object> map = new HashMap<>();
            map.put("id" , id);
            map.put("Name" , Name);
            map.put("Quantity Found" , Quantity);
            map.put("Age" , Age);

            map.put("Date" , Start);



            db.collection("DrugCases").document(id).set(map)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(DrugCase.this, "Data Saved !!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(DrugCase.this, "Failed !!", Toast.LENGTH_SHORT).show();
                }
            });

        }else
            Toast.makeText(this, "Empty Fields not Allowed", Toast.LENGTH_SHORT).show();
    }
}