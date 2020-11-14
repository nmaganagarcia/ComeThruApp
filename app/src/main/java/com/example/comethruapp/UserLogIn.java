package com.example.comethruapp;

import androidx.appcompat.app.AppCompatActivity;
        import androidx.appcompat.widget.Toolbar;

        import android.app.DatePickerDialog;
import android.content.SharedPreferences;
import android.graphics.Color;
        import android.graphics.drawable.ColorDrawable;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.CheckBox;

        import java.util.Calendar;

public class UserLogIn extends AppCompatActivity {

    String username, password;

    EditText username_;
    EditText password_;

    Button logInButton;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_login);

        username_ = (EditText) findViewById(R.id.username_);
        password_ = (EditText) findViewById(R.id.password_);

        logInButton = (Button) findViewById(R.id.signUpButton);

        logInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username = username_.getText().toString();
                password = password_.getText().toString();
            }
        });


    }

}
