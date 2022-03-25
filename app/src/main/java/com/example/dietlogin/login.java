package com.example.dietlogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class login extends AppCompatActivity {

    Button signupbutton, loginbutton;
    TextInputLayout username_var, password_var;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.login);

        signupbutton = findViewById(R.id.signup_button);
        loginbutton = findViewById(R.id.login_button);
        username_var = findViewById(R.id.username_text_field_design);
        password_var = findViewById(R.id.password_input_field);


        loginbutton.setOnClickListener(v -> {
            String username = Objects.requireNonNull(username_var.getEditText()).getText().toString();
            String password = Objects.requireNonNull(password_var.getEditText()).getText().toString();

            if (!username.isEmpty()) {
                username_var.setError(null);
                username_var.setErrorEnabled(false);
                if (!password.isEmpty()) {
                    password_var.setError(null);
                    password_var.setErrorEnabled(false);
                    final String username_data = username_var.getEditText().getText().toString();
                    final String password_data = password_var.getEditText().getText().toString();

                    FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                    DatabaseReference databaseReference = firebaseDatabase.getReference().child("datauser");
                    Query check_username = databaseReference.orderByChild("username").equalTo(username_data);
                    check_username.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if (dataSnapshot.exists()) {
                                username_var.setError(null);
                                username_var.setErrorEnabled(false);
                                String check_password = dataSnapshot.child(username_data).child("password").getValue(String.class);

                                if (Objects.equals(check_password, password_data)){
                                    password_var.setError(null);
                                    password_var.setErrorEnabled(false);
                                    Toast.makeText(getApplicationContext(),"Login Successfully",Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(),dashboard.class);
                                    startActivity(intent);
                                    finish();
                                }else {
                                    password_var.setError("Invalid Password");
                                }
                            }else {
                                username_var.setError("User Does not Exist");
                            }
                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });

                }
                else {
                    password_var.setError("Please Enter Password");
                }
            }
            else {
                username_var.setError("Please Enter the Username");
            }
        });


        signupbutton.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(),SignUp.class);
            startActivity(intent);
        });
    }
}