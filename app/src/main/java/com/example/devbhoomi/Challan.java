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

public class Challan extends AppCompatActivity {

    private EditText name , age, phone, city, date, vehicleno, desc, officer;
    private Button mSaveBtn;
    private FirebaseFirestore db;
    //private String uTitle, uDesc , uId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challan);

        name = findViewById(R.id.ChallanName);
        age = findViewById(R.id.ChallanAge);
        phone = findViewById(R.id.PayerPhone);
        city = findViewById(R.id.ChallanCity);
        date = findViewById(R.id.ChallanDate);
        vehicleno = findViewById(R.id.VehicleNo);
        desc = findViewById(R.id.OffenceDesc);
        officer = findViewById(R.id.OficerName);
        mSaveBtn = findViewById(R.id.AddChallan);


        db= FirebaseFirestore.getInstance();



        mSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Name = name.getText().toString();
                String Age = age.getText().toString();
                String Date = date.getText().toString();
                String vehicleNo = vehicleno.getText().toString();
                String Phone = phone.getText().toString();
                String Desc = desc.getText().toString();
                String Officer = officer.getText().toString();
                String City = city.getText().toString();
                String id=UUID.randomUUID().toString();

                saveToFireStore(id,Name,Age,Date,vehicleNo,Desc,Phone,City,Officer);
            }
        });
    }


    private void saveToFireStore(String id , String Name , String Age,String City,String Date,String Officer,String Desc,String Phone, String vehicleNo){

        if (!Name.isEmpty() && !Age.isEmpty() && !Phone.isEmpty() && !City.isEmpty() && !Date.isEmpty() && !Officer.isEmpty() && !Desc.isEmpty() && !vehicleNo.isEmpty()){
            HashMap<String , Object> map = new HashMap<>();
            map.put("id" , id);
            map.put("PayerName" , Name);
            map.put("OffenceDescription" , Desc);
            map.put("PayerAge" , Age);
            map.put("Payer Phone Number" , Phone);
            map.put("Date of Registration" , Date);
            map.put("VehicleNo." , vehicleNo);
            map.put("Officer on Duty" , Officer);


            db.collection("Challan").document(id).set(map)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(Challan.this, "Data Saved !!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(Challan.this, "Failed !!", Toast.LENGTH_SHORT).show();
                }
            });

        }else
            Toast.makeText(this, "Empty Fields not Allowed", Toast.LENGTH_SHORT).show();
    }
}