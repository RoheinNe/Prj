package com.example.prj;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class Wallet extends AppCompatActivity {
    static final ArrayList<WalletModel> walletModels = new ArrayList<WalletModel>();
    RecyclerView recyclerView;
    wallet_recycler adapter;
    public static final String EXTRA_MONEY = "com.example.prj.EXTRA_MONEY";
    public static final String EXTRA_CURRDATE = "com.example.prj.EXTRA_CURRDATE";
    BottomNavigationView bottomNavigationView;
    Button wallet;
    String money, date, amount;
    TextView walletMoney;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigator);
        bottomNavigationView.setSelectedItemId(R.id.ic_balance);
        wallet = (Button) findViewById(R.id.walletBtn);
        walletMoney = (TextView) findViewById(R.id.wallet_money);



        Intent intent = getIntent();
        amount = intent.getStringExtra(add_money.EXTRA_MONEY);
        date = intent.getStringExtra(add_money.EXTRA_CURRDATE);
        wallet_recycler adapter = new wallet_recycler(this, walletModels);
        RecyclerView recyclerView = findViewById(R.id.walletRecyclerView);
        if (!amount.equals("") && !date.equals("")) {
            Toast toast;
            toast = Toast.makeText(Wallet.this, amount + " " + date, Toast.LENGTH_SHORT);
            toast.show();
            walletMoney.setText(amount);
            walletModels.add(new WalletModel(amount, date));
            adapter.notifyDataSetChanged();

            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
        }
        wallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), add_money.class);
                money = ((TextView) findViewById(R.id.wallet_money)).getText().toString();
                intent.putExtra(EXTRA_MONEY, money);
                startActivity(intent);

            }
        });
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.ic_book:
                        startActivity(new Intent(Wallet.this, search_vehicle.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.ic_home:
                        startActivity(new Intent(Wallet.this, My_Bookings.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.ic_balance:
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