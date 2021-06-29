package com.example.covactrial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SecondDosePage extends AppCompatActivity {

    private EditText ePinCode, eSecondDoseDateIp;
    private Button eCheckAvailability2BTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_dose_page);

        String phone_number = getIntent().getStringExtra("Phone_number1");
        String password_temp = getIntent().getStringExtra("Password1");

        ePinCode = findViewById(R.id.InputPinNoSecondDose);
        eSecondDoseDateIp = findViewById(R.id.SecondDoseDateEdit);
        eCheckAvailability2BTN = findViewById(R.id.CheckAvailabilityForSecondDoseBTN);

        UserDetailsBackEndDBDatabase userDetailsBackEndDBDatabase = UserDetailsBackEndDBDatabase.getUserDetailsBackEndDBDatabase(getApplicationContext());
        final UserDetailsBackEndDBDao userDetailsBackEndDBDao = userDetailsBackEndDBDatabase.userDetailsBackEndDBDao();

        eCheckAvailability2BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        UserDetailsBackEndDB userDetailsBackEndDB = userDetailsBackEndDBDao.findName(phone_number,password_temp);
                        String eTempDate = eSecondDoseDateIp.getText().toString();
                        String eTempPin = ePinCode.getText().toString();
                        userDetailsBackEndDB.setSecond_Dose_Date(eTempDate);
                        userDetailsBackEndDB.setPinCode(eTempPin);
                        userDetailsBackEndDBDao.update(userDetailsBackEndDB);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(SecondDosePage.this,"Updated in database!",Toast.LENGTH_SHORT).show();
                                // Call intent here
                            }
                        });

                    }
                }).start();
            }
        });
    }
}

// Directly use the pin code with a variable and call the API