package com.tashi.patient_record_management;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.tashi.patient_record_management.Sensor.ShakeDetector;

public class Activity_register extends AppCompatActivity {
    private TextView txtsignin, txttas;
    private TextView username, email, password, con_password, btnsignup;

    private ShakeDetector mShakeDetector;
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;

    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        firebaseAuth = FirebaseAuth.getInstance();
        username = findViewById(R.id.user);
        email = findViewById(R.id.mail);
        password = findViewById(R.id.pswd);
        con_password = findViewById(R.id.mobphone);
        btnsignup = findViewById(R.id.tv_res);

        mSensorManager=(SensorManager)getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer= mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mShakeDetector= new ShakeDetector(new ShakeDetector.OnShakeListener() {
            @Override
            public void onShake() {
                username.setText("");
                email.setText("");
                password.setText("");
                con_password.setText("");
            }
        });


        btnsignup.setOnClickListener(new View.OnClickListener(){
            public void onClick (View view){
                String mail = email.getText().toString();
                String pswd = password.getText().toString();
                String mobphone = con_password.getText().toString();
                String user = username.getText().toString();

                if (mail.isEmpty()) {
                    email.setError("Check your email");
                    email.requestFocus();
                } else if (pswd.isEmpty()) {
                    password.setError("Set your password");
                    password.requestFocus();
                } else if (mobphone.isEmpty()) {
                    con_password.setError("Set the mobile number");
                    con_password.requestFocus();
                } else if (user.isEmpty()) {
                    username.setError("Set a username");
                    username.requestFocus();
                } else if (emailID.isEmpty() && paswd.isEmpty() && user_name.isEmpty() && conpaswd.isEmpty()) {
                    Toast.makeText(Activity_register.this, "Please fill everything!", Toast.LENGTH_SHORT).show();
                } else if (!(emailID.isEmpty() && paswd.isEmpty() && user_name.isEmpty() && conpaswd.isEmpty())) {
                    firebaseAuth.createUserWithEmailAndPassword(emailID, paswd).addOnCompleteListener(Activity_register.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(Activity_register.this.getApplicationContext(), "Signup unsuccesfull:" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            } else {
                                startActivity(new Intent(Activity_register.this, Activity_login.class));
                            }
                        }
                    });
                } else {
                    Toast.makeText(Activity_register.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }


        });

        txtsignin = findViewById(R.id.back);
        txtsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Activity_register.this, Activity_login.class);
                startActivity(i);
            }
        });

    }

    @Override
    protected void onResume(){
        super.onResume();
        mSensorManager.registerListener((mShakeDetector, mAccelerometer, SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    protected void onPause(){
        mSensorManager.unregisterListener(mShakeDetector);
        super.onPause();

        }
    }