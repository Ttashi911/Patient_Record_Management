package com.tashi.patient_record_management.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.tashi.patient_record_management.R;
import com.tashi.patient_record_management.model.Doctor;
import com.squareup.picasso.Picasso;


public class DoctorAdapter extends FirebaseRecyclerAdapter<Doctor, DoctorAdapter.PostViewHolder> {

    public DoctorAdapter(@NonNull FirebaseRecyclerOptions<Doctor> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull PostViewHolder holder, int position, @NonNull Doctor doctor) {


        holder.Name.setText(doctor.getName());
        holder.Graduate.setText(doctor.getGraduate());
        holder.Specialist.setText(doctor.getSpecialist());
        holder.Address.setText(doctor.getAddress());
        holder.Number.setText(doctor.getNumber());
       Picasso.get().load(doctor.getImage()).into(holder.image);
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.doctorcard, parent, false);

        return new PostViewHolder(view);
    }

    class PostViewHolder extends RecyclerView.ViewHolder{

        TextView Name,Graduate,Specialist,Address,Number;
        ImageView image;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            Name = itemView.findViewById(R.id.Name);
            Graduate = itemView.findViewById(R.id.Graduate);
            Specialist = itemView.findViewById(R.id.Specialist);
            Address = itemView.findViewById(R.id.Address);
            Number = itemView.findViewById(R.id.Number);
            image = itemView.findViewById(R.id.image);


        }
    }

}
