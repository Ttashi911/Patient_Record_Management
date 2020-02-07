package com.tashi.patient_record_management.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.tashi.patient_record_management.R;
import com.tashi.patient_record_management.model.Patient;

public class PatientAdapter extends FirebaseRecyclerAdapter<Patient, PatientAdapter.PostViewHolder> {

    public PatientAdapter(@NonNull FirebaseRecyclerOptions<Patient> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull PostViewHolder holder, int position, @NonNull Patient patient) {

asdjahsgdjhasd
        holder.Name.setText(patient.getName());
        holder.Address.setText(patient.getAddress());
        holder.Treatment.setText(patient.getTreatment());
        holder.Medication.setText(patient.getMedication());
        holder.Number.setText(patient.getNumber());
        holder.Blood_type.setText(patient.getBlood_type());
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.patientcard, parent, false);

        return new PostViewHolder(view);
    }

    class PostViewHolder extends RecyclerView.ViewHolder{

        TextView Name,Address,Treatment,Medication,Number,Blood_type;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            Name = itemView.findViewById(R.id.Name);
            Address = itemView.findViewById(R.id.Address);
            Treatment = itemView.findViewById(R.id.Treatment);
            Medication = itemView.findViewById(R.id.Medication);
            Number = itemView.findViewById(R.id.Number);
            Blood_type = itemView.findViewById(R.id.Blood_type);

asdgjasdj
        }
    }

}
