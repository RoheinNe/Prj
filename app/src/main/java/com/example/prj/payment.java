package com.example.prj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationChannelCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class payment extends AppCompatActivity {
    public static final String EXTRA_BUS = "com.example.prj.EXTRA_BUS";
    public static final String EXTRA_DATE = "com.example.prj.EXTRA_DATE";
    Button proceed;
    CardView cv;
    String busName, busDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("notification", "notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        proceed = (Button) findViewById(R.id.proceedBtn);
        cv = (CardView) findViewById(R.id.paymentCV);


        Intent intent = getIntent();
        busName = intent.getStringExtra(search_results.EXTRA_BUS);
        busDate = intent.getStringExtra(search_results.EXTRA_DATE);

        Toast toast = Toast.makeText(payment.this, busName + " " + busDate, Toast.LENGTH_SHORT);
        toast.show();
        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cv.setVisibility(View.VISIBLE);
                proceed.setVisibility(View.INVISIBLE);

            }
        });

        cv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(payment.this, "My Notification");
                builder.setContentTitle("Bus boarded");
                builder.setContentText("You have successfully booked a seat");
                builder.setSmallIcon(R.drawable.ic_noti);
                builder.setAutoCancel(true);

                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(payment.this);
                managerCompat.notify(1, builder.build());

                // Create a new Handler instance
                Handler handler = new Handler();

                int delayMillis = 2000; // 2 seconds
                nextPage();
            }
        });

    }

    public void nextPage() {
        Intent intent = new Intent(getApplicationContext(), My_Bookings.class);
        intent.putExtra(EXTRA_BUS, busName);
        intent.putExtra(EXTRA_DATE, busDate);
        startActivity(intent);
    }
}