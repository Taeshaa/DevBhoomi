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

public class CasesRegistered extends AppCompatActivity {

    private EditText name ,bailable, desc, city, date,category;
    private Button mSaveBtn;
    private FirebaseFirestore db;
    //private String uTitle, uDesc , uId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cases_registered);

        name = findViewById(R.id.idEdtOfficerName);
        bailable = findViewById(R.id.idEdtBailable);
        category = findViewById(R.id.idEdtCourseCategory);
        city = findViewById(R.id.idEdtCaseCity);
        date = findViewById(R.id.idEdtCaseDate);
        desc = findViewById(R.id.idEdtCaseDesc);
        mSaveBtn = findViewById(R.id.idBtnAddCourse);


        db= FirebaseFirestore.getInstance();



        mSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Name = name.getText().toString();
                String Category = category.getText().toString();
                String Date = date.getText().toString();
                String Bailable = bailable.getText().toString();
                String Desc = desc.getText().toString();
                String City = city.getText().toString();
                String id=UUID.randomUUID().toString();

                saveToFireStore(id,Name,Date,Category,Desc,Bailable,City);
            }
        });
    }


    private void saveToFireStore(String id , String Name , String Date,String Category,String Desc,String Bailable,String City){

        if (!Name.isEmpty() && !Bailable.isEmpty() && !Category.isEmpty() && !City.isEmpty() && !Date.isEmpty() && !Desc.isEmpty()){
            HashMap<String , Object> map = new HashMap<>();
            map.put("id" , id);
            map.put("Name" , Name);
            map.put("Description" , Desc);
            map.put("Category" , Category);
            map.put("Bailable" , Bailable);
            map.put("Date" , Date);
            map.put("City" , City);


            db.collection("CasesRegistered").document(id).set(map)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(CasesRegistered.this, "Data Saved !!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(CasesRegistered.this, "Failed !!", Toast.LENGTH_SHORT).show();
                }
            });

        }else
            Toast.makeText(this, "Empty Fields not Allowed", Toast.LENGTH_SHORT).show();
    }
}