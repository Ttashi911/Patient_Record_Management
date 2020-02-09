package com.tashi.patient_record_management;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class Dashboard extends AppCompatActivity {
    ImageView lout;
    LinearLayout doc;
    LinearLayout pro;
    LinearLayout emg;
    LinearLayout feedback;
    LinearLayout location;


    FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        doc =findViewById(R.id.doc);
        doc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent I = new Intent( Dashboard.this, Activity_doctor.class);
                startActivity(I);

            }
        });


        location= findViewById(R.id.location);
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent I = new Intent(Dashboard.this, MapsActivity.class);
                startActivity(I);
            }
        });


        feedback = findViewById(R.id.feedback);
        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent I = new Intent(Dashboard.this, Activity_feedback.class);
                startActivity(I);
            }
        });


        emg = findViewById(R.id.emg);
        emg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent I = new Intent(Dashboard.this, Activity_emergency.class);
                startActivity(I);
            }
        });


        pro = findViewById(R.id.pro);
        pro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent I = new Intent(Dashboard.this, Activity_patient.class);
                startActivity(I);
            }
        });



        lout =findViewById(R.id.lout);
        lout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent I = new Intent( Dashboard.this, Activity_login.class);
                startActivity(I);

            }
        });
    }




}
