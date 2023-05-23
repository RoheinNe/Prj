package com.example.prj;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class reserve_vehincle extends AppCompatActivity {
    public static final String EXTRA_BUS = "com.example.prj.EXTRA_BUS";
    public static final String EXTRA_DATE = "com.example.prj.EXTRA_DATE";
    Button reserveBtn, rBtn1, rBtn2 , rBtn3, rBtn4, rBtn5, rBtn6, rBtn7, rBtn8, rBtn9, rBtn10, rBtn11, rBtn12, rBtn13, rBtn14, rBtn15, rBtn16;
    String busName, busDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserve_vehincle);

        reserveBtn = (Button) findViewById(R.id.reserveBtn);
        rBtn1 = (Button) findViewById(R.id.rBtn1);
        rBtn2 = (Button) findViewById(R.id.rBtn2);
        rBtn3 = (Button) findViewById(R.id.rBtn3);
        rBtn4 = (Button) findViewById(R.id.rBtn4);
        rBtn5 = (Button) findViewById(R.id.rBtn5);
        rBtn6 = (Button) findViewById(R.id.rBtn6);
        rBtn7 = (Button) findViewById(R.id.rBtn7);
        rBtn8 = (Button) findViewById(R.id.rBtn8);
        rBtn9 = (Button) findViewById(R.id.rBtn9);
        rBtn10 = (Button) findViewById(R.id.rBtn10);
        rBtn11 = (Button) findViewById(R.id.rBtn11);
        rBtn12 = (Button) findViewById(R.id.rBtn12);
        rBtn13 = (Button) findViewById(R.id.rBtn13);
        rBtn14 = (Button) findViewById(R.id.rBtn14);
        rBtn15 = (Button) findViewById(R.id.rBtn15);
        rBtn16 = (Button) findViewById(R.id.rBtn16);

        Intent intent = getIntent();
        busName = intent.getStringExtra(search_results.EXTRA_BUS);
        busDate = intent.getStringExtra(search_results.EXTRA_DATE);

        Toast toast = Toast.makeText(reserve_vehincle.this, busName + " " + busDate, Toast.LENGTH_SHORT);
        toast.show();

        reserveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Payment_option.class);
                intent.putExtra(EXTRA_BUS, busName);
                intent.putExtra(EXTRA_DATE, busDate);
                startActivity(intent);
//                startActivity(new Intent(getApplicationContext(), Payment_option.class));
            }
        });

        View.OnClickListener buttonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.rBtn1:
                        // Handle rBtn1 click
                        changeColor(rBtn1);
                        break;
                    case R.id.rBtn2:
                        // Handle rBtn2 click
                        changeColor(rBtn2);
                        break;
                    case R.id.rBtn3:
                        // Handle rBtn3 click
                        changeColor(rBtn3);
                        break;
                    case R.id.rBtn4:
                        // Handle rBtn4 click
                        changeColor(rBtn4);
                        break;
                    case R.id.rBtn5:
                        // Handle rBtn5 click
                        changeColor(rBtn5);
                        break;
                    case R.id.rBtn6:
                        // Handle rBtn6 click
                        changeColor(rBtn6);
                        break;
                    case R.id.rBtn7:
                        // Handle rBtn7 click
                        changeColor(rBtn7);
                        break;
                    case R.id.rBtn8:
                        // Handle rBtn8 click
                        changeColor(rBtn8);
                        break;
                    case R.id.rBtn9:
                        // Handle rBtn9 click
                        changeColor(rBtn9);
                        break;
                    case R.id.rBtn10:
                        // Handle rBtn10 click
                        changeColor(rBtn10);
                        break;
                    case R.id.rBtn11:
                        // Handle rBtn11 click
                        changeColor(rBtn11);
                        break;
                    case R.id.rBtn12:
                        // Handle rBtn12 click
                        changeColor(rBtn12);
                        break;
                    case R.id.rBtn13:
                        // Handle rBtn13 click
                        changeColor(rBtn13);
                        break;
                    case R.id.rBtn14:
                        // Handle rBtn14 click
                        changeColor(rBtn14);
                        break;
                    case R.id.rBtn15:
                        // Handle rBtn15 click
                        changeColor(rBtn15);
                        break;
                    case R.id.rBtn16:
                        // Handle rBtn16 click
                        changeColor(rBtn16);
                        break;
                    default:
                        // Handle default case if needed
                        break;
                }
            }
        };

        rBtn1.setOnClickListener(buttonClickListener);
        rBtn2.setOnClickListener(buttonClickListener);
        rBtn3.setOnClickListener(buttonClickListener);
        rBtn4.setOnClickListener(buttonClickListener);
        rBtn5.setOnClickListener(buttonClickListener);
        rBtn6.setOnClickListener(buttonClickListener);
        rBtn7.setOnClickListener(buttonClickListener);
        rBtn8.setOnClickListener(buttonClickListener);
        rBtn9.setOnClickListener(buttonClickListener);
        rBtn10.setOnClickListener(buttonClickListener);
        rBtn11.setOnClickListener(buttonClickListener);
        rBtn12.setOnClickListener(buttonClickListener);
        rBtn13.setOnClickListener(buttonClickListener);
        rBtn14.setOnClickListener(buttonClickListener);
        rBtn15.setOnClickListener(buttonClickListener);
        rBtn16.setOnClickListener(buttonClickListener);
    }
    public static void changeColor(Button btn) {
        int desiredColor = Color.GREEN;
        ColorStateList colorStateList = ColorStateList.valueOf(desiredColor);
        btn.setBackgroundTintList(colorStateList);
    }

}