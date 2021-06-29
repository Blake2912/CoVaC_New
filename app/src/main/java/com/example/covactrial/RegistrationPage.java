package com.example.covactrial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;


public class RegistrationPage extends AppCompatActivity {


    private EditText eName;
    private EditText eYearOfBirth;
    private EditText ePhone;
    private EditText eGovtId;
    private EditText ePassword;
    private EditText eConfirmPassword;
    private CheckBox eTermsNConditions;
    Button eRegisterBTN;
    boolean TermsConditionsAccepted = false;

    public String tempYear,Password,confirm_password;
    public int Year_DOB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_page);

        // Linking of all text boxes with the UI
        eName = findViewById(R.id.NameInputOfPatient);
        eYearOfBirth = findViewById(R.id.YearOfBirthInput);
        ePhone = findViewById(R.id.PhoneNumRegInput);
        eGovtId = findViewById(R.id.GovtIDInput);
        ePassword = findViewById(R.id.PasswordRegInput);
        eConfirmPassword = findViewById(R.id.PasswordConfirm);
        eRegisterBTN = findViewById(R.id.RegistrationBTN);
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
                UserDetailsBackEndDB userDetailsBackEndDB = new UserDetailsBackEndDB();
                userDetailsBackEndDB.setName(eName.getText().toString());
                tempYear = eYearOfBirth.getText().toString();
                if(!"".equals(tempYear)){
                    Year_DOB = Integer.parseInt(tempYear);
                }
                userDetailsBackEndDB.setYear_DOB(Year_DOB);
                userDetailsBackEndDB.setPhoneNumber(ePhone.getText().toString());
                userDetailsBackEndDB.setGovt_ID(eGovtId.getText().toString());
                Password = ePassword.getText().toString();
                confirm_password = eConfirmPassword.getText().toString();
                if(Password.equals(confirm_password)){
                    userDetailsBackEndDB.setPassword(Password);
                }
                else{
                    Toast.makeText(RegistrationPage.this,"Please enter the password properly!",Toast.LENGTH_SHORT).show();
                }

                if(TermsConditionsAccepted){
                    // Code to go back to login page after registration
                    if(ValidateInput(userDetailsBackEndDB)){
                        UserDetailsBackEndDBDatabase userDetailsBackEndDBDatabase = UserDetailsBackEndDBDatabase.getUserDetailsBackEndDBDatabase(getApplicationContext());
                        final UserDetailsBackEndDBDao userDetailsBackEndDBDao = userDetailsBackEndDBDatabase.userDetailsBackEndDBDao();
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                userDetailsBackEndDBDao.insert(userDetailsBackEndDB);
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(RegistrationPage.this,"Registration Successful!",Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(RegistrationPage.this,MainActivity.class));
                                    }
                                });
                            }
                        }).start();
                    }
                    else{
                        Toast.makeText(RegistrationPage.this,"Please enter all details properly!",Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(RegistrationPage.this,"Please Accept the Terms And Conditions",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    Boolean ValidateInput(UserDetailsBackEndDB userDetailsBackEndDB){
        if(userDetailsBackEndDB.getName().isEmpty() ||
                userDetailsBackEndDB.getYear_DOB() == 0||
                userDetailsBackEndDB.getPhoneNumber().isEmpty() ||
                userDetailsBackEndDB.getGovt_ID().isEmpty() || userDetailsBackEndDB.getPassword().isEmpty()){
            return false;
        }
        return true;
    }
}