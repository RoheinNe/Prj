package com.example.prj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Payment_option extends AppCompatActivity {
    CardView gcash, physical;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_option);

        gcash = (CardView) findViewById(R.id.Gcash);
        physical = (CardView) findViewById(R.id.Physical);

        gcash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), payment.class));
            }
        });
    }
}