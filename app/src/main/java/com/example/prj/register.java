package com.example.prj;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class register extends AppCompatActivity {
    Button signupBtn;
    String username;
    String password;
    TextView loginBtn;


    String conP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        loginBtn = (TextView) findViewById(R.id.loginBTN);
        signupBtn = (Button) findViewById(R.id.signupBtn);
        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username = ((EditText) findViewById(R.id.registerUsernameTF)).getText().toString();
                password = ((EditText) findViewById(R.id.registerPasswordTF)).getText().toString();
                conP = ((EditText) findViewById(R.id.registerConPasswordTF)).getText().toString();
                Toast toast;
                if (!conP.equals(password)) {
                    toast = Toast.makeText(register.this, "Password is not the same", Toast.LENGTH_LONG);
                    toast.show();
                    return;
                }

                Account e = new Account(username, password);
                login_page.r.addAcc(e);
                toast = Toast.makeText(register.this, "Account Registered", Toast.LENGTH_LONG);
                toast.show();
            }
        });

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(register.this, login_page.class));
            }
        });
    }
}