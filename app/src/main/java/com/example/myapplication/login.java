package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
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

public class login extends AppCompatActivity {
    Button loginBtn;
    public static String PREFS_NAME = "MyPrefsFile";
    EditText loginEmail,otpLogin;
    ProgressDialog progressDialog;
    String  emailpattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";


    FirebaseAuth mAuth;
    FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginEmail = findViewById(R.id.loginEmail);
        otpLogin = findViewById(R.id.otpLogin);
        loginBtn = findViewById(R.id.loginBtn);
        progressDialog = new ProgressDialog(this);
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences(login.PREFS_NAME,0);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putBoolean("hasLoggedIn",true);
                editor.apply();
                startActivity(new Intent(login.this,location_hotels.class));
                finish();
                perfLogin();


            }
        });



    }

    private void perfLogin() {
        String email = loginEmail.getText().toString();
        String password = otpLogin.getText().toString();

        if(!email.matches(emailpattern)){
            loginEmail.setError("enter the correct email");
        }
        else if(password.isEmpty() || password.length()<8){
            otpLogin.setError("Please enter the password with atleast 8 characters");
        }

        else {
            progressDialog.setMessage("Please wait until login!");
            progressDialog.setTitle("Login...");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        progressDialog.dismiss();
                        sendUserToNextActivity();
                        Toast.makeText(login.this, "Login successful..", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        progressDialog.dismiss();
                        Toast.makeText(login.this, ""+task.getException(), Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }
    }

    private void sendUserToNextActivity() {

        Intent intent = new Intent(this,location_hotels.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

    }


    public void registration(View view){
        Intent intent = new Intent(this,registration.class);
        startActivity(intent);
        Animatoo.INSTANCE.animateSwipeLeft(this);

    }

    public void locations(View view){
        Intent intent = new Intent(this,location_hotels.class);
        startActivity(intent);
    }
}