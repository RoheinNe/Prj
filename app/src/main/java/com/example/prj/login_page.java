package com.example.prj;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class login_page extends AppCompatActivity {
    private String username;
    private String password;
    private String uLoginText;
    private String pLoginText;
    private TextView createNewAcc;
    private EditText uLogin;
    private EditText pLogin;
    String busName;
    String busDate;
    private Button btnSubmit;
    public static Registery r = new Registery();
    public static final String EXTRA_BUS = "com.example.prj.EXTRA_BUS";
    public static final String EXTRA_DATE = "com.example.prj.EXTRA_DATE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        pLogin = (EditText) findViewById(R.id.password);
        createNewAcc = (TextView) findViewById(R.id.createNewAccountBTN);
        uLogin = (EditText) findViewById(R.id.username);
        btnSubmit = (Button) findViewById(R.id.button2);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                uLoginText = uLogin.getText().toString();
                pLoginText = pLogin.getText().toString();
                int count = 0;
                for (Account a : r.acc) {
                    username = a.getUsername();
                    password = a.getPassword();
                    if (username.equals(uLoginText)) break;
                }

                if (uLoginText.equals(username)) {
                    Toast toast;
                    if (pLoginText.equals(password)) {
                        Intent intent = new Intent(getApplicationContext(), My_Bookings.class);
                        busName = "";
                        busDate = "";
                        intent.putExtra(EXTRA_BUS, busName);
                        intent.putExtra(EXTRA_DATE, busDate);
                        startActivity(intent);
//                        startActivity(new Intent(getApplicationContext(), My_Bookings.class));
                    } else {
                        toast = Toast.makeText(login_page.this, "Wrong password", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                } else {
                    Toast toast = Toast.makeText(login_page.this, "Username not found", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

        createNewAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(login_page.this, register.class));
            }
        });
    }
}