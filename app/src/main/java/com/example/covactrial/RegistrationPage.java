package com.example.covactrial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.QuickContactBadge;
import android.widget.TextView;
import android.widget.Toast;

public class RegistrationPage extends AppCompatActivity {

    private CheckBox eTermsNConditions;

    boolean TermsConditionsAccepted = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_page);
        Button eRegisterBTN = findViewById(R.id.RegistrationBTN);
        eTermsNConditions = findViewById(R.id.TermsAndConditions);

        eTermsNConditions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(eTermsNConditions.isChecked()){
                    TermsConditionsAccepted = true;
                }
                else{
                    TermsConditionsAccepted = false;
                }
            }
        });


        eRegisterBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TermsConditionsAccepted){
                    // Code to go back to login page after registration
                    Toast.makeText(RegistrationPage.this,"Registration Successful!",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(RegistrationPage.this,MainActivity.class));
                }
                else{
                    Toast.makeText(RegistrationPage.this,"Please Accept the Terms And Conditions",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}