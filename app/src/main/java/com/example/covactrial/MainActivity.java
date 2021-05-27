package com.example.covactrial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText ePhoneNumberInput;
    private EditText ePasswordInput;
    private Button eLoginButton;

    boolean isValid = false;
    int counter = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ePhoneNumberInput = findViewById(R.id.PhoneNoInput);
        ePasswordInput = findViewById(R.id.PasswordInput);
        Button eRegisterButton = findViewById(R.id.RegisterButton);
        eLoginButton = findViewById(R.id.LoginButton);

        eLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputPhone = ePhoneNumberInput.getText().toString();
                String inputPassword = ePasswordInput.getText().toString();

                if(inputPassword.isEmpty() || inputPhone.isEmpty()){
                    Toast.makeText(MainActivity.this,"Please enter the details properly",Toast.LENGTH_SHORT).show();
                }
                else{
                    isValid = Validate(inputPhone,inputPassword);
                    if(!isValid){
                        counter--;
                        Toast.makeText(MainActivity.this,"Incorrect Credentials,try again! You have these many tries "+ counter,Toast.LENGTH_SHORT).show();
                        if(counter == 0){
                            eLoginButton.setEnabled(false);
                        }
                    }
                    else{
                        // Code to go to the user page
                        Toast.makeText(MainActivity.this,"Login Successful",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this,UserDetails.class));
                    }
                }
            }
        });

        eRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Write the code to go to Registration Page.
                Intent GoToRegistration = new Intent(MainActivity.this,RegistrationPage.class);
                startActivity(GoToRegistration);
            }
        });
    }

    boolean Validate(String Phone_input, String Password_input){
        if(Phone_input.equals("123456789") && Password_input.equals("Password")){
            return true;
        }
        return false;
    }
}