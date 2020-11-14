package com.example.application01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.List;

public class DataStoreActivity extends AppCompatActivity {
    private Button save;
    private Button read;
    private TextView data;
    private Button create;
    private Button ss;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_store);
        save=findViewById(R.id.save_bt);
        read=findViewById(R.id.read_bt);
        data=findViewById(R.id.data_store_tv);
        create=findViewById(R.id.create_bt);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp=getSharedPreferences("mydata",MODE_PRIVATE);
                SharedPreferences.Editor editor=sp.edit();
                editor.putString("name","张三");
                editor.putInt("age",21);
                editor.apply();
            }
        });
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp=getSharedPreferences("mydata",MODE_PRIVATE);
                String name=sp.getString("name","");
                int age=sp.getInt("age",0);
                data.setText("读取的信息为:姓名"+name+"年龄:"+age);
            }
        });
        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Connector.getWritableDatabase();

            }
        });
        ss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<book> bookList= DataSupport.where("price(?","40)").find()
                        for(book book:bookList){
                            Log.d("datatest",book.getName());
                        }
            }
        });
    }
}