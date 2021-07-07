package com.example.covactrial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class HospitalScheduleFirstDose extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerAdapterFirstHospitalSchedule recyclerAdapterFirstHospitalSchedule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_schedule_first_dose);
        recyclerView = findViewById(R.id.RecyclerViewFirst);
        recyclerAdapterFirstHospitalSchedule = new RecyclerAdapterFirstHospitalSchedule();
        recyclerView.setAdapter(recyclerAdapterFirstHospitalSchedule);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
    }
}