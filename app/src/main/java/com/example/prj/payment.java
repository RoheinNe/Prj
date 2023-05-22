package com.example.prj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationChannelCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class payment extends AppCompatActivity {
    Button proceed;
    CardView cv;

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


            }
        });

    }
}