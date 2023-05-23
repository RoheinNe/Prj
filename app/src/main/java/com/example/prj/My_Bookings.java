package com.example.prj;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class My_Bookings extends AppCompatActivity {
    public static final String EXTRA_MONEY = "com.example.prj.EXTRA_MONEY";
    public static final String EXTRA_CURRDATE = "com.example.prj.EXTRA_CURRDATE";
    static final ArrayList<BusModel> busModels = new ArrayList<>();
    String busName;
    String busDate;
    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_bookings);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigator);
        bottomNavigationView.setSelectedItemId(R.id.ic_home);

        Intent intent = getIntent();
        busName = intent.getStringExtra(search_vehicle.EXTRA_BUS);
        busDate = intent.getStringExtra(search_vehicle.EXTRA_DATE);

        RecyclerView recyclerView = findViewById(R.id.actRecyclerView);
        if (!busName.equals("") && !busDate.equals("")) {
            busModels.add(new BusModel(busName, busDate));
            BM_REC_VIEW_AD adapter = new BM_REC_VIEW_AD(this, busModels);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        }
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.ic_book:
                        startActivity(new Intent(My_Bookings.this, search_vehicle.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.ic_home:
                        return true;
                    case R.id.ic_balance:
                        Intent intent = new Intent(getApplicationContext(), Wallet.class);
                        String amount = "";
                        String currentDateAndTime = "";
                        intent.putExtra(EXTRA_MONEY, amount);
                        intent.putExtra(EXTRA_CURRDATE, currentDateAndTime);
                        startActivity(intent);
//                        startActivity(new Intent(getApplicationContext(), Wallet.class));
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

    }


}