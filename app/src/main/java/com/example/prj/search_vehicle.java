package com.example.prj;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class search_vehicle extends AppCompatActivity {
    public static final String EXTRA_BUS = "com.example.prj.EXTRA_BUS";
    public static final String EXTRA_DATE = "com.example.prj.EXTRA_DATE";
    BottomNavigationView bottomNavigationView;
    String from, to, date;
    Button searchBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_vehicle);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigator);
        bottomNavigationView.setSelectedItemId(R.id.ic_book);
        searchBtn = (Button) findViewById(R.id.searchBtn);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.ic_home:
                        startActivity(new Intent(getApplicationContext(), My_Bookings.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.ic_book:
                        return true;
                    case R.id.ic_balance:
                        startActivity(new Intent(getApplicationContext(), Wallet.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.ic_settings:
                        startActivity(new Intent(getApplicationContext(), Profile.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return true;
            }
        });

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                from = ((EditText) findViewById(R.id.fromTF)).getText().toString();
                to = ((EditText) findViewById(R.id.toTF)).getText().toString();
                date = ((EditText) findViewById(R.id.dateTF)).getText().toString();

                Intent intent = new Intent(getApplicationContext(), search_results.class);
                intent.putExtra(EXTRA_BUS, to);
                intent.putExtra(EXTRA_DATE, date);
                startActivity(intent);
            }
        });
    }
}