package com.example.devbhoomi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class UserChoice extends AppCompatActivity {
    private CardView SHO, SSP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_choice);
        SHO = findViewById(R.id.SHO);
        SSP = findViewById(R.id.SSP);
        SHO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // opening a login activity on clicking login text.
                Intent i = new Intent(UserChoice.this, LoginActivity.class);
                startActivity(i);
            }
        });
        SSP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // opening a login activity on clicking login text.
                Intent i = new Intent(UserChoice.this, LoginActivitySSP.class);
                startActivity(i);
            }
        });

    }
}