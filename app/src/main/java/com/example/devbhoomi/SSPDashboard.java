package com.example.devbhoomi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SSPDashboard extends AppCompatActivity {
    private CardView OP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        OP = findViewById(R.id.opium);
        setContentView(R.layout.activity_sspdashboard);
        OP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // opening a login activity on clicking login text.
                Intent i = new Intent(SSPDashboard.this, ShowCases.class);
                startActivity(i);
            }
        });
    }
}