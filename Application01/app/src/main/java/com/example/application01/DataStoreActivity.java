package com.example.application01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import org.litepal.crud.LitePalSupport;
import android.content.SharedPreferences;
import android.widget.TextView;
import org.litepal.LitePal;



public class DataStoreActivity extends AppCompatActivity {
    private Button save;
    private Button read;
    private Button create;
    private Button add;
    private Button search;
    private TextView data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_store);
        LitePal.initialize(this);
        create=findViewById(R.id.create_bt);
        data=findViewById(R.id.data_store_tv);
        save=findViewById(R.id.save_bt);
        read=findViewById(R.id.read_bt);
        add=findViewById(R.id.add_bt);
//        search.findViewById(R.id.search_bt);
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sp=getSharedPreferences("mydata",MODE_PRIVATE);
                String name=sp.getString("nem","");
                int age=sp.getInt("age",0);
                data.setText("读取的信息为：姓名"+name+"年龄"+age);

            }
        });

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

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LitePal.getDatabase();
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book =new Book();
                book.setAuthor("jinx");
                book.setName("android");
                book.setPages(500);
                book.setPrice(55.6);
                book.save();
            }
        });
//         search.setOnClickListener(new View.OnClickListener() {
//             @Override
//             public void onClick(View v) {
//                 List<Book> bookList= DataSupport.where("price<?","40").find(Book.class);
//                 for(Book)
//             }
//         });
    }

}