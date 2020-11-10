package com.example.comethruapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class UserSignUp extends AppCompatActivity {

    private Toolbar toolbar;


    private static final String TAG = "UserSignUp";
    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;

    String firstname, lastname, username, password, confirmpassword, email, phonenumber;

    EditText firstName;
    EditText lastName;
    EditText username_;
    EditText password_;
    EditText confirmPassword;
    EditText email_;
    EditText phoneNumber;

    Button signUpButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_sign_up);

        toolbar = findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);

        mDisplayDate = (TextView) findViewById(R.id.birthdatepicker);

        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        UserSignUp.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();

            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;

                String date = month + "/" + day + "/" + year;
                mDisplayDate.setText(date);
            }
        };

        firstName = (EditText) findViewById(R.id.firstName);
        lastName = (EditText) findViewById(R.id.lastName);
        username_ = (EditText) findViewById(R.id.username_);
        password_ = (EditText) findViewById(R.id.password_);
        confirmPassword = (EditText) findViewById(R.id.confirmPassword);
        email_ = (EditText) findViewById(R.id.email_);
        phoneNumber = (EditText) findViewById(R.id.phonenumber);

        signUpButton = (Button) findViewById(R.id.signUpButton);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               firstname = firstName.getText().toString();
               lastname = lastName.getText().toString();
               username = username_.getText().toString();
               password = password_.getText().toString();
               confirmpassword = confirmPassword.getText().toString();
               email = email_.getText().toString();
               phonenumber = phoneNumber.getText().toString();

               validateEmail(email_);

            }
        });
    }

    private boolean validateEmail(EditText email){
        String emailInput = email.getText().toString();

        if (!emailInput.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()){
            email.setError(null);
            return true;
        } else{
            email.setError("Invalid Email Address");
            return false;
    }
}
}