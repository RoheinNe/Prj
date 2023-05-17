package com.example.prj;

import static android.widget.Toast.LENGTH_SHORT;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login_page extends AppCompatActivity {
    private String username = "calunod";
    private String password = "calunod";
    private String uLoginText;
    private String pLoginText;

    private EditText uLogin;
    private EditText pLogin;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        pLogin = (EditText) findViewById(R.id.password);

        uLogin = (EditText) findViewById(R.id.username);
        btnSubmit = (Button) findViewById(R.id.button2);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uLoginText = uLogin.getText().toString();
                pLoginText = pLogin.getText().toString();
                if (uLoginText.equals(username)) {
                    if (pLoginText.equals(password)) {
                        Toast toast = Toast.makeText(login_page.this, "Login Successful", Toast.LENGTH_SHORT);
                        toast.show();
                    } else {
                        Toast toast = Toast.makeText(login_page.this, "Wrong password", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                } else {
                    Toast toast = Toast.makeText(login_page.this, "Username not found", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }
}