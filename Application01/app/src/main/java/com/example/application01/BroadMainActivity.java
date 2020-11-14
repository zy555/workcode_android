package com.example.application01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class BroadMainActivity extends AppCompatActivity {
    private IntentFilter intentFilter;
    private Button button;
    private MyBroadCastReceiver myBroadCastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.broadcast_activity_main);
        button=findViewById(R.id.bt);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent("com.example.myapplication.MyBroadCast");
                sendBroadcast(intent);
            }
        });
        myBroadCastReceiver=new BroadMainActivity.MyBroadCastReceiver();
        IntentFilter intentFilter=new IntentFilter();
        intentFilter.addAction("com.example.myapplication.MyBroadCast");
        registerReceiver(myBroadCastReceiver,intentFilter);

    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        unregisterReceiver(myBroadCastReceiver);
    }
    class MyBroadCastReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent){
            ConnectivityManager connectivityManager =(ConnectivityManager)
                    getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo =connectivityManager.getActiveNetworkInfo();
            if(networkInfo !=null && networkInfo.isAvailable()){
                Toast.makeText(BroadMainActivity.this,"已发送",
                        Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(BroadMainActivity.this,"未发送",
                        Toast.LENGTH_SHORT).show();
            }

        }
    }

}