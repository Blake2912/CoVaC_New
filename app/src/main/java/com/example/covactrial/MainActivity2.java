package com.example.covactrial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerAdapterFirstHospitalSchedule recyclerAdapterFirstHospitalSchedule;
    private List<String> HospitalList;
    private List<String> vaccine_Type;
    private List<String> Slots;
    String pin_code_temp2;
    String date_temp2;
    private String phone_number;
    private String password;
    private Button eDisplayAvailableHospitalsBTN,eScheduleAppointmentBTN;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        eDisplayAvailableHospitalsBTN = findViewById(R.id.SecondDoseHospitalDisplayButton);
        eScheduleAppointmentBTN = findViewById(R.id.SecondDoseHospitalScheduleButton);



        HospitalList = new ArrayList<>();
        vaccine_Type = new ArrayList<>();
        Slots = new ArrayList<>();

        phone_number = getIntent().getStringExtra("PhoneNumber5");
        password = getIntent().getStringExtra("Password5");

        // Recycler View items
        recyclerView = findViewById(R.id.RecyclerViewSecond);
        recyclerAdapterFirstHospitalSchedule = new RecyclerAdapterFirstHospitalSchedule(HospitalList,vaccine_Type,Slots,phone_number,password);

        eDisplayAvailableHospitalsBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerView.setAdapter(recyclerAdapterFirstHospitalSchedule);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for(int i=0;i<20;i++){
                            HospitalList.add("HospitalTest");
                            vaccine_Type.add("VaccineTypeTest");
                            Slots.add("123");
                        }
                    }
                }).start();
            }
        });
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);

        eScheduleAppointmentBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity2.this,"Appointment Scheduled successfully",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity2.this,UserDetails.class)
                        .putExtra("phone_number",phone_number)
                        .putExtra("password",password));
            }
        });

    }
}
