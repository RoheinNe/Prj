package com.example.prj;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class add_money extends AppCompatActivity {
    public static final String EXTRA_MONEY = "com.example.prj.EXTRA_MONEY";
    public static final String EXTRA_CURRDATE = "com.example.prj.EXTRA_CURRDATE";

    Button addMoneybtn;
    CardView cv;
    int amount, amountTF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_money);


        Intent intent = getIntent();
        amount = Integer.parseInt(intent.getStringExtra(Wallet.EXTRA_MONEY));
        cv = (CardView) findViewById(R.id.addMoneyCV);


        addMoneybtn = (Button) findViewById(R.id.addMoneyBtn);

        addMoneybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                amountTF = Integer.parseInt(((EditText) findViewById(R.id.addMoneyTF)).getText().toString());


                cv.setVisibility(View.VISIBLE);
                addMoneybtn.setVisibility(View.INVISIBLE);
            }
        });

        cv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                nextPage();
            }
        });
    }

    public void nextPage() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentDateAndTime = sdf.format(new Date());
        Intent intent = new Intent(getApplicationContext(), Wallet.class);
        amount += amountTF;
        String a = Integer.toString(amount);
        intent.putExtra(EXTRA_MONEY, a);
        intent.putExtra(EXTRA_CURRDATE, currentDateAndTime);
        startActivity(intent);
    }
}