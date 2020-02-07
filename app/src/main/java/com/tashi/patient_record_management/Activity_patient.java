package com.tashi.patient_record_management;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.tashi.patient_record_management.Adapter.PatientAdapter;
import com.tashi.patient_record_management.model.Patient;

public class Activity_patient extends AppCompatActivity {
    private RecyclerView recyclerView;
    private PatientAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_patient);

        recyclerView = findViewById(R.id.precycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        FirebaseRecyclerOptions<Patient> options =
                new FirebaseRecyclerOptions.Builder<Patient>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("PATIENT"), Patient.class)
                        .build();
        adapter = new PatientAdapter(options);
        recyclerView.setAdapter(adapter);


    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}
