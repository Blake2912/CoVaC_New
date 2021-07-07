package com.example.covactrial;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapterFirstHospitalSchedule extends RecyclerView.Adapter<RecyclerAdapterFirstHospitalSchedule.ViewHolderFirstDoseHospital>{
    int count = 0;

    private static final String TAG = "RecyclerAdapterFirstHos";
    @NonNull
    @Override
    public ViewHolderFirstDoseHospital onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.i(TAG, "onCreateViewHolder: "+ count++);

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_item,parent,false);
        ViewHolderFirstDoseHospital viewHolderFirstDoseHospital = new ViewHolderFirstDoseHospital(view);
        return viewHolderFirstDoseHospital;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapterFirstHospitalSchedule.ViewHolderFirstDoseHospital holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 20;
    }

    class ViewHolderFirstDoseHospital extends RecyclerView.ViewHolder{

        TextView HospitalName,NoOfSlots,VaccineType;

        public ViewHolderFirstDoseHospital(@NonNull View itemView) {
            super(itemView);
            HospitalName = itemView.findViewById(R.id.HospitalNameTextView);
            NoOfSlots = itemView.findViewById(R.id.SlotsView);
            VaccineType = itemView.findViewById(R.id.VaccineTextView);
        }
    }
}
