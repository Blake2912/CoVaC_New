package com.example.covactrial;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerAdapterFirstHospitalSchedule extends RecyclerView.Adapter<RecyclerAdapterFirstHospitalSchedule.ViewHolderFirstDoseHospital>{
    List<String> HospitalList;
    List<String> Vaccine_type;
    List<String> SlotsFirst;
    String phone_number;
    String password_temp;

    public RecyclerAdapterFirstHospitalSchedule(List<String> hospitalList, List<String> vaccine_type, List<String> slotsFirst, String phone_number, String password_temp) {
        HospitalList = hospitalList;
        Vaccine_type = vaccine_type;
        SlotsFirst = slotsFirst;
        this.phone_number = phone_number;
        this.password_temp = password_temp;
    }

    @NonNull
    @Override
    public ViewHolderFirstDoseHospital onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_item,parent,false);
        ViewHolderFirstDoseHospital viewHolderFirstDoseHospital = new ViewHolderFirstDoseHospital(view);
        return viewHolderFirstDoseHospital;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapterFirstHospitalSchedule.ViewHolderFirstDoseHospital holder, int position) {
        holder.HospitalName.setText(HospitalList.get(position));
        holder.VaccineType.setText(Vaccine_type.get(position));
        holder.NoOfSlots.setText(SlotsFirst.get(position));
    }

    @Override
    public int getItemCount() {
        return HospitalList.size();
    }

    class ViewHolderFirstDoseHospital extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView HospitalName,NoOfSlots,VaccineType;

        public ViewHolderFirstDoseHospital(@NonNull View itemView) {
            super(itemView);
            HospitalName = itemView.findViewById(R.id.HospitalNameTextView);
            NoOfSlots = itemView.findViewById(R.id.SlotsView);
            VaccineType = itemView.findViewById(R.id.VaccineTextView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            UserDetailsBackEndDBDatabase userDetailsBackEndDBDatabase = UserDetailsBackEndDBDatabase.getUserDetailsBackEndDBDatabase(v.getContext());
            final UserDetailsBackEndDBDao userDetailsBackEndDBDao = userDetailsBackEndDBDatabase.userDetailsBackEndDBDao();
            new Thread(() -> {
                UserDetailsBackEndDB userDetailsBackEndDB = userDetailsBackEndDBDao.findName(phone_number,password_temp);
                userDetailsBackEndDB.setHospital_Name(HospitalList.get(getAdapterPosition()));
                userDetailsBackEndDB.setVaccineType(Vaccine_type.get(getAdapterPosition()));
                userDetailsBackEndDBDao.update(userDetailsBackEndDB);
            }).start();
            Toast.makeText(v.getContext(),HospitalList.get(getAdapterPosition()),Toast.LENGTH_SHORT).show();
        }
    }
}
