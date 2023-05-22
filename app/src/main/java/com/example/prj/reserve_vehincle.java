package com.example.prj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class reserve_vehincle extends AppCompatActivity {
    Button reserveBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserve_vehincle);

        reserveBtn = (Button) findViewById(R.id.reserveBtn);

        reserveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Payment_option.class));
            }
        });
    }
}