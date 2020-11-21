package com.example.application01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.application01.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    private Button bt1;
    private EditText op1;
    private EditText op2;
    private EditText et1;
  //  private String[] data={"apple","banana","pear","orange","cherry","watermelon"};
    private ListView myList;
    private List<Fruit>fruitList=new ArrayList<Fruit>();

    @Override

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt1= findViewById(R.id.bt1);
        et1= findViewById(R.id.et1);
        op1=findViewById(R.id.op1);
        op2=findViewById(R.id.op2);
        progressBar= findViewById(R.id.pb1);
        myList=findViewById(R.id.my_list);
        IntFruit();
        FruitAdapter adapter=new FruitAdapter(MainActivity.this,R.layout.item_layout,fruitList);
        myList.setAdapter(adapter);
        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,fruitList.get(position).getName(),Toast.LENGTH_LONG).show();
            }
        });

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double data1=Double.parseDouble(op1.getText().toString());
                Double data2=Double.parseDouble(op2.getText().toString());
                Intent intent=new Intent(MainActivity.this,TextActivity.class);
                intent.putExtra("mydata1",data1);
                intent.putExtra("mydata2",data2);
                startActivity(intent);
                //int p=progressBar.getProgress();
               // p=p+10;
               // progressBar.setProgress(p);
            }
        });

    }
    public void IntFruit(){
        Fruit fruit=new Fruit("apple",R.drawable.apple_pic);
        fruitList.add(fruit);
        Fruit fruit1=new Fruit("banana",R.drawable.banana_pic);
        fruitList.add(fruit1);
        Fruit fruit2=new Fruit("pear",R.drawable.pear_pic);
        fruitList.add(fruit2);
        Fruit fruit3=new Fruit("orange",R.drawable.orange_pic);
        fruitList.add(fruit3);
        Fruit fruit4=new Fruit("cherry",R.drawable.cherry_pic);
        fruitList.add(fruit4);
        Fruit fruit5=new Fruit("watermelon",R.drawable.watermelon_pic);
        fruitList.add(fruit5);

    }

}


