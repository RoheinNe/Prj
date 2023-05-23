package com.example.prj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Payment_option extends AppCompatActivity {
    public static final String EXTRA_BUS = "com.example.prj.EXTRA_BUS";
    public static final String EXTRA_DATE = "com.example.prj.EXTRA_DATE";
    String busName, busDate;
    CardView gcash, physical;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_option);

        gcash = (CardView) findViewById(R.id.Gcash);
        physical = (CardView) findViewById(R.id.Physical);

        Intent intent = getIntent();
        busName = intent.getStringExtra(search_results.EXTRA_BUS);
        busDate = intent.getStringExtra(search_results.EXTRA_DATE);

        Toast toast = Toast.makeText(Payment_option.this, busName + " " + busDate, Toast.LENGTH_SHORT);
        toast.show();

        gcash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), payment.class);
                intent.putExtra(EXTRA_BUS, busName);
                intent.putExtra(EXTRA_DATE, busDate);
                startActivity(intent);
//                startActivity(new Intent(getApplicationContext(), payment.class));
            }
        });
    }
}