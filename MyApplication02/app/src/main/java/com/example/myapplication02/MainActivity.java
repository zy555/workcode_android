package com.example.myapplication02;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button bt;
    private TextView tv;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(@NonNull Message message){
                tv.setText(message.what+"");
            }
     };
    //在线程中不能更改UI界面

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt=findViewById(R.id.thread_bt);
        tv=findViewById(R.id.thread_tv);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        int count = 0;
                        while (count<=10){
                            Message message=new Message();
                            message.what=count;
                            handler.sendMessage(message);

                            count+=1;
                            try {
                                Thread.sleep(1000);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                    }
                }).start();
            }
        });
    }

//    @Override
//    public void onClick(View v) {
//        switch (v.getId()){
//            case R.id.thread_tv:
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        Message message =new Message();
//                        message.what=UPDATE_TEXT;
//                        handler.sendMessage(message);
//                    }
//                }).start();
//                break;
//            default:
//                break;
//        }
//    }
}