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
                    UserDetailsBackEndDBDatabase userDetailsBackEndDBDatabase = UserDetailsBackEndDBDatabase.getUserDetailsBackEndDBDatabase(getApplicationContext());
                    final UserDetailsBackEndDBDao userDetailsBackEndDBDao = userDetailsBackEndDBDatabase.userDetailsBackEndDBDao();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            UserDetailsBackEndDB userDetailsBackEndDB = userDetailsBackEndDBDao.login(inputPhone,inputPassword);
                            if(userDetailsBackEndDB == null){
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(MainActivity.this,"Incorrect Credentials,try again!",Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                            else{
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        String phone1 = userDetailsBackEndDB.PhoneNumber;
                                        String password1 = userDetailsBackEndDB.Password;
                                        Toast.makeText(MainActivity.this,"Login Success",Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(MainActivity.this,UserDetails.class)
                                                .putExtra("phone_number",phone1)
                                                .putExtra("password",password1));
                                    }
                                });
                            }
                        }
                    }).start();
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
}