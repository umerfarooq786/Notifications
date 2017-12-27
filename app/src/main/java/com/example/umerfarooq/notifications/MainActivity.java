package com.example.umerfarooq.notifications;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    NotificationCompat.Builder notification;
    private static final int uniqueID = 45612;
    Button btn ;
    EditText edMsg ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=(Button) findViewById(R.id.btnNotify);
        notification = new NotificationCompat.Builder(this);
        notification.setAutoCancel(true);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edMsg= (EditText) findViewById(R.id.edMessage);








                notification.setSmallIcon(R.drawable.ic_stat_name);
                notification.setTicker("This is the ticker");
                notification.setWhen(System.currentTimeMillis());
                notification.setContentTitle("Message");
                notification.setContentText(""+edMsg.getText().toString());

                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                notification.setContentIntent(pendingIntent);

                //Builds notification and issues it
                NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                nm.notify(uniqueID, notification.build());


            }
        });
    }
}
