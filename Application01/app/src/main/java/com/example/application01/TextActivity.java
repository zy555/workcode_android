package com.example.application01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class TextActivity extends AppCompatActivity {
    private TextView myText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
        Intent intent=getIntent();
        Double data1=intent.getDoubleExtra("mydata1",0.0);
        Double data2=intent.getDoubleExtra("mydata2",0.0);
        myText=findViewById(R.id.myText);
        myText.setText((data1+data2)+"");
    }
}