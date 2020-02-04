package com.tashi.patient_record_management;

import android.content.Intent;
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

public class Activity_register extends AppCompatActivity {
    private TextView txtsignin, txttas;
    private TextView username, email, password, con_password, btnsignup;

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
        btnsignup.setOnClickListener(new View.OnClickListener(){
            public void onClick (View view){
                String emailID = email.getText().toString();
                String paswd = password.getText().toString();
                String conpaswd = con_password.getText().toString();
                String user_name = username.getText().toString();

                if (emailID.isEmpty()) {
                    email.setError("Check your email");
                    email.requestFocus();
                } else if (paswd.isEmpty()) {
                    password.setError("Set your password");
                    password.requestFocus();
                } else if (conpaswd.isEmpty()) {
                    con_password.setError("Set the mobile number");
                    con_password.requestFocus();
                } else if (user_name.isEmpty()) {
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
}
