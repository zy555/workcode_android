package com.example.myapplication02;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class NotificationTestActivity extends AppCompatActivity {
    private Button bt;
    NotificationManager manager=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_test);
        bt=findViewById(R.id.notification_bt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent =new Intent(NotificationTestActivity.this,MainActivity.class);
                PendingIntent pendingIntent =PendingIntent.getActivity(NotificationTestActivity.this,0,intent,0);

                if(Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O){
                    //只在Android O之上需要渠道，这里的第一个参数要和下面的channelId一样
                    NotificationChannel notificationChannel = new NotificationChannel("1","name",NotificationManager.IMPORTANCE_HIGH);
                    //如果这里用IMPORTANCE_NOENE就需要在系统的设置里面开启渠道，通知才能正常弹出
                    manager.createNotificationChannel(notificationChannel);
                }
//这里的第二个参数要和上面的第一个参数一样
                Notification notification=new NotificationCompat.Builder(NotificationTestActivity.this,"1")
                        .setContentTitle("这是标题")
                        .setContentText("这是文本")
                        .setWhen(System.currentTimeMillis())
                        .setSmallIcon(R.drawable.ic_launcher_background)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher_background))
                        .setContentIntent(pendingIntent)
                        .setAutoCancel(true)
                        .build();
                manager.notify(1,notification);

            }
        });
    }
}