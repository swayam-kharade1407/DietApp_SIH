package com.example.dietlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class SignUp extends AppCompatActivity {

    TextInputLayout fullname_var, username_var, email_var, phonenum_var, pass_var;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        fullname_var = findViewById(R.id.fullname_text_field_design);
        username_var = findViewById(R.id.username_text_field_design);
        email_var = findViewById(R.id.email_text_field_design);
        phonenum_var = findViewById(R.id.phone_text_field_design);
        pass_var = findViewById(R.id.pass_input_field);

    }

    public void loginbuttonclick(View view) {
        Intent intent = new Intent(getApplicationContext(), login.class);
        startActivity(intent);
        finish();
    }

    public void registerbuttonclick(View view) {
        String fullname = Objects.requireNonNull(fullname_var.getEditText()).getText().toString();
        String username = Objects.requireNonNull(username_var.getEditText()).getText().toString();
        String email = Objects.requireNonNull(email_var.getEditText()).getText().toString();
        String phonenumber = Objects.requireNonNull(phonenum_var.getEditText()).getText().toString();
        String password = Objects.requireNonNull(pass_var.getEditText()).getText().toString();

        if (!fullname.isEmpty()) {
            fullname_var.setError(null);
            fullname_var.setErrorEnabled(false);
            if (!username.isEmpty()) {
                username_var.setError(null);
                username_var.setErrorEnabled(false);
                if (!email.isEmpty()) {
                    email_var.setError(null);
                    email_var.setErrorEnabled(false);
                    if (!phonenumber.isEmpty()) {
                        phonenum_var.setError(null);
                        phonenum_var.setErrorEnabled(false);
                        if (!password.isEmpty()) {
                            pass_var.setError(null);
                            pass_var.setErrorEnabled(false);

                                FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                                DatabaseReference reference = firebaseDatabase.getReference("datauser");

                                String fullname_s = Objects.requireNonNull(fullname_var.getEditText()).getText().toString();
                                String username_s = Objects.requireNonNull(username_var.getEditText()).getText().toString();
                                String email_s = Objects.requireNonNull(email_var.getEditText()).getText().toString();
                                String phonenumber_s = Objects.requireNonNull(phonenum_var.getEditText()).getText().toString();
                                String password_s = Objects.requireNonNull(pass_var.getEditText()).getText().toString();

                                storingdata data = new storingdata(fullname_s,username_s,email_s,phonenumber_s,password_s);

                                reference.child(username_s).setValue(data);
                                Toast.makeText(getApplicationContext(), "Registered Successfully",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(),dashboard.class);
                                startActivity(intent);
                                finish();

                        } else {
                            pass_var.setError("Please Enter Password");
                        }
                    } else {
                        phonenum_var.setError("Please Enter Phone Number");
                    }

                } else {
                    email_var.setError("Please Enter Email Address");
                }

            } else {
                username_var.setError("Please Enter Username");
            }

        } else {
            fullname_var.setError("Please Enter Fullname");
        }

    }
}