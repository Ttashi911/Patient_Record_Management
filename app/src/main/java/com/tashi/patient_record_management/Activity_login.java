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
import com.google.firebase.auth.FirebaseUser;

public class Activity_login extends AppCompatActivity {
    private  TextView txtsignup, btnsignin, login_username , login_password,button_signin;
    FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        firebaseAuth = FirebaseAuth.getInstance();
        login_password = findViewById(R.id.pswd);
        login_username = findViewById(R.id.user);
        button_signin = findViewById(R.id.lin);
        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    Toast.makeText(Activity_login.this, "Login successful", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Activity_login.this, Dashboard.class);
                    startActivity(i);
                } else {
                    Toast.makeText(Activity_login.this, "Login to continue", Toast.LENGTH_SHORT).show();
                }
            }
        };

        txtsignup = findViewById(R.id.tv_register);
        txtsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Activity_login.this, Activity_register.class);
                startActivity(i);
            }
        });
        button_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userEmail = login_username.getText().toString();
                String userPaswd = login_password.getText().toString();
                if (userEmail.isEmpty()) {
                    login_username.setError("Check your Email!");
                    login_username.requestFocus();
                } else if (userPaswd.isEmpty()) {
                    login_password.setError("Enter Password!");
                    login_password.requestFocus();
                } else if (userEmail.isEmpty() && userPaswd.isEmpty()) {
                    Toast.makeText(Activity_login.this, "Fields Empty!", Toast.LENGTH_SHORT).show();
                } else if (!(userEmail.isEmpty() && userPaswd.isEmpty())) {
                    firebaseAuth.signInWithEmailAndPassword(userEmail, userPaswd).addOnCompleteListener(Activity_login.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(Activity_login.this, "Not successful", Toast.LENGTH_SHORT).show();
                            } else {
                                startActivity(new Intent(Activity_login.this, Dashboard.class));
                            }
                        }
                    });
                } else {
                    Toast.makeText(Activity_login.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    @Override
    protected void onStart(){
        super.onStart();
        firebaseAuth.addAuthStateListener(authStateListener);
    }
}
