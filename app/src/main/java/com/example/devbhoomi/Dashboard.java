package com.example.devbhoomi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Dashboard extends AppCompatActivity {
    private CardView HS, Theft, Challan, Cases, Arrested, Drug;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        HS = findViewById(R.id.history);
        Theft = findViewById(R.id.TH);
        Challan = findViewById(R.id.CH);
        Cases = findViewById(R.id.Cases);
        Arrested = findViewById(R.id.AR);
        Drug = findViewById(R.id.DC);
        HS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // opening a login activity on clicking login text.
                Intent i = new Intent(Dashboard.this, HistorySheeters.class);
                startActivity(i);
            }
        });
        Theft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // opening a login activity on clicking login text.
                Intent i = new Intent(Dashboard.this, Theft.class);
                startActivity(i);
            }
        });
        Challan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // opening a login activity on clicking login text.
                Intent i = new Intent(Dashboard.this, Challan.class);
                startActivity(i);
            }
        });
        Cases.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // opening a login activity on clicking login text.
                Intent i = new Intent(Dashboard.this, ShowCases.class);
                startActivity(i);
            }
        });
        Arrested.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // opening a login activity on clicking login text.
                Intent i = new Intent(Dashboard.this, Arrest.class);
                startActivity(i);
            }
        });
        Drug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // opening a login activity on clicking login text.
                Intent i = new Intent(Dashboard.this, ShowCases.class);
                startActivity(i);
            }
        });
    }
}