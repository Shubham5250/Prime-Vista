package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class registration extends AppCompatActivity {

    EditText inputEmail,inputPassword,confirmPassword;
    Button register;
    String  emailpattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressDialog progressDialog;

    FirebaseAuth mAuth;
    FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        inputEmail = findViewById(R.id.loginEmail);
        inputPassword = findViewById(R.id.otpLogin);
        confirmPassword = findViewById(R.id.confirmPassword);
        register = findViewById(R.id.register);
        progressDialog = new ProgressDialog(this);
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PerfAuth();
            }
        });

    }

    private void PerfAuth() {
        String email = inputEmail.getText().toString();
        String password = inputPassword.getText().toString();
        String confpassword = confirmPassword.getText().toString();

        if(!email.matches(emailpattern)){
            inputEmail.setError("enter the correct email");
        }
        else if(password.isEmpty() || password.length()<8){
            inputPassword.setError("Please enter the password with atleast 8 characters");
        }
        else if(!password.equals(confpassword)){
            confirmPassword.setError("Password didn't match");
        }
        else{
            progressDialog.setMessage("Please while we register you!");
            progressDialog.setTitle("Registration...");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        progressDialog.dismiss();
                        sendUserToNextActivity();
                        Toast.makeText(registration.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        progressDialog.dismiss();
                        Toast.makeText(registration.this, ""+task.getException(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void sendUserToNextActivity() {
        Intent intent = new Intent(registration.this,goa_room_booking.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

    }

    public void login(View view){
        Intent intent = new Intent(this,login.class);
        startActivity(intent);
        Animatoo.INSTANCE.animateSwipeRight(this);

    }




}