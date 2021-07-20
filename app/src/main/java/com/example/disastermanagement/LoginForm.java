package com.example.disastermanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginForm extends AppCompatActivity {

    private Button login;
    private Button register;

    private EditText email;
    private EditText password;

    FirebaseAuth fauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_form);

        getSupportActionBar().setTitle("Log in");

        login = (Button) findViewById(R.id.Login);
        register = (Button) findViewById(R.id.Register);

        email = (EditText)findViewById(R.id.first_name_Login);
        password = (EditText)findViewById(R.id.password_Login);

        fauth = FirebaseAuth.getInstance();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email = email.getText().toString().trim();
                String Password = password.getText().toString().trim();


                if(TextUtils.isEmpty(Email)) {
                    email.setError("This Email feild cannot be empty");
                    return;
                }


                if(TextUtils.isEmpty(Password)) {
                    password.setError("This password feild cannot be empty");
                    return;
                }
                else if(Password.length() < 6)
                {
                    password.setError("Length of the password should be minimum 6 character");
                    return;
                }

                fauth.signInWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(LoginForm.this, "Logged Sucessfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), Home.class));
                        }
                                else
                        {

                            Toast.makeText(LoginForm.this,"Some Error has occured Please Try Again " + task.getException().getMessage(),Toast.LENGTH_SHORT).show();

                        }
                    }
                });

            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Signup.class));
            }
        });
    }
}
