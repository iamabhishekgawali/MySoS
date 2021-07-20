package com.example.disastermanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Signup extends AppCompatActivity {

    EditText email;
    EditText password;
    EditText number,emergency_number1,emergency_number2,emergency_number3;
    FirebaseFirestore fstore;
    FirebaseAuth fAuth;
    Button register;
    String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        getSupportActionBar().setTitle("Signup form");


        register = (Button) findViewById(R.id.button_register);
        email = (EditText) findViewById(R.id.email_register);
        password = (EditText) findViewById(R.id.password_register);
        number = (EditText) findViewById(R.id.Phone_Number_register);

        emergency_number1 = (EditText)findViewById(R.id.emergency_number1);
        emergency_number2 = (EditText)findViewById(R.id.emergency_number2);
        emergency_number3 = (EditText)findViewById(R.id.emergency_number3);

        fAuth = FirebaseAuth.getInstance();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Email = email.getText().toString().trim();
                String Password = password.getText().toString().trim();
                final String phone = number.getText().toString().trim();
                fstore = FirebaseFirestore.getInstance();
                final String number1 = emergency_number1.getText().toString().trim();
                final String number2 = emergency_number2.getText().toString().trim();
                final String number3 = emergency_number3.getText().toString().trim();


                if(TextUtils.isEmpty(Email) ) {
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


                fAuth.createUserWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()) {
                                    Toast.makeText(Signup.this, "Sucessfully Registered", Toast.LENGTH_SHORT).show();
                                    userID = fAuth.getCurrentUser().getUid();
                                    DocumentReference documentReference = fstore.collection("users").document(userID);
                                    Map<String,Object> user = new HashMap<String,Object>();
                                    user.put("phone",phone);
                                    user.put("phone1",number1);
                                    user.put("phone2",number2);
                                    user.put("phone3",number3);
                                    documentReference.set(user);
                                    startActivity(new Intent(getApplicationContext(), Home.class));
                                }
                                else
                                {
                                    Toast.makeText(Signup.this,"Some Error has occured Please Try Again " + task.getException().getMessage(),Toast.LENGTH_SHORT).show();

                                }
                    }
                });



            }
        });

    }

}
