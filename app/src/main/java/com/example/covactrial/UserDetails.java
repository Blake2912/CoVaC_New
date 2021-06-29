package com.example.covactrial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UserDetails extends AppCompatActivity {
    private Button eNoButton;
    private Button eYesButton;
    private TextView eDisplayName,eDisplayPhoneNo,eDisplayGovtId,eDisplayFirstDose,eDisplaySecondDose,eDisplayVaccineType;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);
        eNoButton = findViewById(R.id.NoBtn);
        eYesButton = findViewById(R.id.YesBtn);
        eDisplayName = findViewById(R.id.DisplayName);
        eDisplayPhoneNo = findViewById(R.id.DisplayPhoneNumber);
        eDisplayGovtId = findViewById(R.id.DisplayGovtID);
        eDisplayFirstDose = findViewById(R.id.DisplayFirstDose);
        eDisplaySecondDose = findViewById(R.id.DisplaySecondDose);
        eDisplayVaccineType = findViewById(R.id.DisplayVaccineType);

        String phone_number = getIntent().getStringExtra("phone_number");
        String password_temp = getIntent().getStringExtra("password");

        UserDetailsBackEndDBDatabase userDetailsBackEndDBDatabase = UserDetailsBackEndDBDatabase.getUserDetailsBackEndDBDatabase(getApplicationContext());
        final UserDetailsBackEndDBDao userDetailsBackEndDBDao = userDetailsBackEndDBDatabase.userDetailsBackEndDBDao();
        new Thread(new Runnable() {
            @Override
            public void run() {
                UserDetailsBackEndDB userDetailsBackEndDB = userDetailsBackEndDBDao.findName(phone_number,password_temp);
                String tempName = userDetailsBackEndDB.getName();
                String first_dose_date = userDetailsBackEndDB.getFirst_Dose_Date();
                String second_dose_date = userDetailsBackEndDB.getSecond_Dose_Date();
                String vaccine_type_temp = userDetailsBackEndDB.getVaccineType();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        eDisplayName.setText(tempName);
                        eDisplayPhoneNo.setText(phone_number);
                        eDisplayGovtId.setText(userDetailsBackEndDB.getGovt_ID());
                        eDisplayFirstDose.setText(first_dose_date);
                        eDisplaySecondDose.setText(second_dose_date);
                        eDisplayVaccineType.setText(vaccine_type_temp);
                    }
                });
            }
        }).start();

        eNoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        UserDetailsBackEndDB userDetailsBackEndDB = userDetailsBackEndDBDao.findName(phone_number,password_temp);
                        String tempPhone = userDetailsBackEndDB.getPhoneNumber();
                        String tempPassword = userDetailsBackEndDB.getPassword();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                startActivity(new Intent(UserDetails.this,FirstDoseVaccineSchedule.class)
                                        .putExtra("Phone_number1",tempPhone)
                                        .putExtra("Password1",tempPassword));
                            }
                        });
                    }
                }).start();
            }
        });

        eYesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        UserDetailsBackEndDB userDetailsBackEndDB = userDetailsBackEndDBDao.findName(phone_number,password_temp);
                        String tempPhone = userDetailsBackEndDB.getPhoneNumber();
                        String tempPassword = userDetailsBackEndDB.getPassword();
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                startActivity(new Intent(UserDetails.this,SecondDosePage.class)
                                .putExtra("Phone_number1",tempPhone)
                                .putExtra("Password1",tempPassword));
                            }
                        });
                    }
                }).start();
            }
        });

    }
}