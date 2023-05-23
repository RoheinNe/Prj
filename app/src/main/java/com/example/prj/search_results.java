package com.example.prj;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class search_results extends AppCompatActivity implements RecyclerViewInterface {
    public static final String EXTRA_BUS = "com.example.prj.EXTRA_BUS";
    public static final String EXTRA_DATE = "com.example.prj.EXTRA_DATE";
    ArrayList<BusModel> busModels = new ArrayList<>();
    String busName;
    String busDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);

        Intent intent = getIntent();
        busName = intent.getStringExtra(search_vehicle.EXTRA_BUS);
        busDate = intent.getStringExtra(search_vehicle.EXTRA_DATE);

        RecyclerView recyclerView = findViewById(R.id.mRecyclerView);
        setBusModels();

        BM_RecyclerViewAdapter adapter = new BM_RecyclerViewAdapter(this, busModels, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setBusModels() {
        for (int i = 0; i < 10; i++) {
            busModels.add(new BusModel(busName, busDate));
        }
    }

    @Override
    public void onItemClick(int position) {
        CardView cv = findViewById(R.id.cardView);
        cv.setVisibility(View.VISIBLE);
        Intent intent = new Intent(getApplicationContext(), reserve_vehincle.class);
        intent.putExtra(EXTRA_BUS, busName);
        intent.putExtra(EXTRA_DATE, busDate);
        startActivity(intent);
    }
}