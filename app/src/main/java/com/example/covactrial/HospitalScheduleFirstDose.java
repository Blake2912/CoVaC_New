package com.example.covactrial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class HospitalScheduleFirstDose extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerAdapterFirstHospitalSchedule recyclerAdapterFirstHospitalSchedule;
    private List<String> HospitalList;
    private List<String> vaccine_Type;
    private List<String> Slots;
    private Button ViewHospitalListButton,ScheduleAppointmentButton;
    private RequestQueue requestQueue;
    String pin_code_temp;
    String date_temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_schedule_first_dose);
        String phone_number = getIntent().getStringExtra("Phone_number2");
        String password_temp = getIntent().getStringExtra("Password2");
        pin_code_temp = getIntent().getStringExtra("Pin_code1");
        date_temp = getIntent().getStringExtra("DateFirst");
        ViewHospitalListButton = findViewById(R.id.DisplayHospitalBTN);
        ScheduleAppointmentButton = findViewById(R.id.ScheduleAppointmentBTN);
        requestQueue = Volley.newRequestQueue(this);
        HospitalList = new ArrayList<>();
        vaccine_Type = new ArrayList<>();
        Slots = new ArrayList<>();

        recyclerView = findViewById(R.id.RecyclerViewFirst);
        recyclerAdapterFirstHospitalSchedule = new RecyclerAdapterFirstHospitalSchedule(HospitalList,vaccine_Type,Slots,phone_number,password_temp);

        ViewHospitalListButton.setOnClickListener(new View.OnClickListener() {
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
//                        jsonParse();
                    }
                }).start();
            }
        });
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);

        ScheduleAppointmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HospitalScheduleFirstDose.this,"Appointment Scheduled successfully",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(HospitalScheduleFirstDose.this,UserDetails.class)
                        .putExtra("phone_number",phone_number)
                        .putExtra("password",password_temp));
            }
        });
    }
    // Here we need to create an method which will add hospital list from the api.
    private void jsonParse(){
        String url = String.format("https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/findByPin?pincode=%1$s&date=%2$s",pin_code_temp,date_temp);
//        String url = "https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/findByPin?pincode=560037&date=12.07.2021";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("sessions");
                            for(int i=0;i<jsonArray.length();i++){
                                JSONObject session = jsonArray.getJSONObject(i);
                                String HospitalName = session.getString("name");
                                String vaccine_type_json = session.getString("vaccine");
                                int dose_available_first_dose = session.getInt("available_capacity_dose1");
                                String firstDose = Integer.toString(dose_available_first_dose);
                                HospitalList.add(HospitalName);
                                vaccine_Type.add(vaccine_type_json);
                                Slots.add(firstDose);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        requestQueue.add(request);
    }
}