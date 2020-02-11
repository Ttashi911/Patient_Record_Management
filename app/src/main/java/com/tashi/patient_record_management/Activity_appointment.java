package com.tashi.patient_record_management;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Activity_appointment extends AppCompatActivity {

    private EditText Name, Address, Treatment, Blood_type, Number, Date;
    private Button appoint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointment);

        Name = findViewById(R.id.Name);
        Address = findViewById(R.id.Address);
        Treatment = findViewById(R.id.Treatment);
        Blood_type = findViewById(R.id.Blood_type);
        Number = findViewById(R.id.Number);
        Date = findViewById(R.id.Date);
        appoint = findViewById(R.id.appoint);

        appoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String, Object> map = new HashMap<>();
                map.put("Name", Name.getText().toString());
                map.put("Address", Address.getText().toString());
                map.put("Treatment", Treatment.getText().toString());
                map.put("Blood_type", Blood_type.getText().toString());
                map.put("Number", Number.getText().toString());
                map.put("Date", Date.getText().toString());
                FirebaseDatabase.getInstance().getReference().child("Appointment").push()
                        .setValue(map)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                Log.i("Made Appointment", "onComplete: ");
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.i("Fail!", "onFailure: " + e.toString());
                    }
                }).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.i("Appoint made!", "onSuccess: ");
                    }
                });
            }
        });
    }
}
