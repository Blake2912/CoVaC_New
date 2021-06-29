package com.example.covactrial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FirstDoseVaccineSchedule extends AppCompatActivity {
    private EditText ePinCode,eFirstDoseDateIp;
    private Button eCheckAvailability1BTN;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_dose_vaccine_schedule);

        String phone_number = getIntent().getStringExtra("Phone_number1");
        String password_temp = getIntent().getStringExtra("Password1");

        ePinCode = findViewById(R.id.InputPinNo);
        eFirstDoseDateIp = findViewById(R.id.InputFirstDoseDate);
        eCheckAvailability1BTN = findViewById(R.id.ContFirstReg);

        UserDetailsBackEndDBDatabase userDetailsBackEndDBDatabase = UserDetailsBackEndDBDatabase.getUserDetailsBackEndDBDatabase(getApplicationContext());
        final UserDetailsBackEndDBDao userDetailsBackEndDBDao = userDetailsBackEndDBDatabase.userDetailsBackEndDBDao();

        eCheckAvailability1BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        UserDetailsBackEndDB userDetailsBackEndDB = userDetailsBackEndDBDao.findName(phone_number,password_temp);
                        String eTempDate = eFirstDoseDateIp.getText().toString();
                        String eTempPin = ePinCode.getText().toString();
                        userDetailsBackEndDB.setFirst_Dose_Date(eTempDate);
                        userDetailsBackEndDB.setPinCode(eTempPin);
                        userDetailsBackEndDBDao.update(userDetailsBackEndDB);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(FirstDoseVaccineSchedule.this,"Updated in database!",Toast.LENGTH_SHORT).show();
                                // Call intent here
                            }
                        });
                    }
                }).start();
            }
        });
    }
}

/*
TODO::
    Create a new activity for finding hospital and make multiple activities for both
    first and second dose, call the API can link it...
 */