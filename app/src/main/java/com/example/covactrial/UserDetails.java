package com.example.covactrial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserDetails extends AppCompatActivity {
    private Button eNoButton;
    private Button eYesButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);
        eNoButton = findViewById(R.id.NoBtn);
        eYesButton = findViewById(R.id.YesBtn);


        eNoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserDetails.this,FirstDoseVaccineSchedule.class));
            }
        });

        eYesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(UserDetails.this,SecondDosePage.class));
            }
        });

    }
}