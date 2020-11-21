package com.example.myapplication02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class AsncActivity extends AppCompatActivity {
    private TextView textView;
    private Button bt;
    private ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asnc);
        textView=findViewById(R.id.asy_tv);
        bt=findViewById(R.id.asy_bt);
        pb=findViewById(R.id.asy_pb);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MyDownloadTask().execute();
            }
        });
    }
    class MyDownloadTask extends AsyncTask<Void,Integer,Boolean>{
        @Override
        protected Boolean doInBackground(Void... voids) {
            int count = 0;
            try {
                while (count<100){
                    count+=10;
                    publishProgress(count);
                    Thread.sleep(1000);
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        }

        @Override
        protected void onPreExecute() {
            textView.setText("开始下载");
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            if (aBoolean){
                textView.setText("下载完毕！");
            }
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
           textView.setText("下载进度"+values[0]);
           pb.setProgress(values[0]);
        }


    }
}