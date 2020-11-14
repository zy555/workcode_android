package com.example.text_1;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TaoMainActivity extends AppCompatActivity {
    private List<Tao> taoList=new ArrayList<>();
    private String[] data={"nz1", "nz2", "nz3", "nz4", "nz5", "nz6", "nz7", "nz8", "nz9", "nz10", "nz11"};
    @Override
protected void onCreate(Bundle savesInstanceState) {
        super.onCreate(savesInstanceState);
        setContentView(R.layout.tao_main);
        initTao();
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recycler_view);
        StaggeredGridLayoutManager layoutManager=new
                StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        TaoAdapter adapter=new TaoAdapter(taoList);
        recyclerView.setAdapter(adapter);
        Button button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void initTao(){
        for (int i = 0; i < 2; i++) {
           Tao nz1=new Tao(
                    getRandomLengthName("百丽屋 2020秋季新款复古高腰纯色中长款不规则针织鱼尾半身裙女"),R.drawable.nz1);
           taoList.add(nz1);
            Tao nz2=new Tao(
                    getRandomLengthName("百丽屋 2020秋季新款百搭修身黑色小西装外套女薄款职业女装西服"),R.drawable.nz2);
            taoList.add(nz2);
            Tao nz3=new Tao(
                    getRandomLengthName("百丽屋 2020秋季新款英伦风小个子宽松收腰系带双排扣风衣外套女"),R.drawable.nz3);
            taoList.add(nz3);
            Tao nz4=new Tao(
                    getRandomLengthName("秋冬新款纯羊绒衫女V领套头抽条插肩毛衣韩版打底衫羊毛纯色针织"),R.drawable.nz4);
            taoList.add(nz4);
            Tao nz5=new Tao(
                    getRandomLengthName("百丽屋2020秋季新款日系甜美百搭黑白拼色双排扣娃娃领长袖衬衫女"),R.drawable.nz5);
            taoList.add(nz5);
            Tao nz6=new Tao(
                    getRandomLengthName("牛仔裤女2020年新款秋季宽松直筒高腰显瘦锥形小脚弹力哈伦裤子潮"),R.drawable.nz6);
            taoList.add(nz6);
            Tao nz7=new Tao(
                    getRandomLengthName("百丽屋2020秋季新款韩版百搭修身显瘦收腰系带无袖外搭风衣马甲女"),R.drawable.nz7);
            taoList.add(nz7);
            Tao nz8=new Tao(
                    getRandomLengthName("百丽屋 2020秋季新款英伦风小个子宽松收腰系带双排扣风衣外套女"),R.drawable.nz8);
            taoList.add(nz8);
            Tao nz9=new Tao(
                    getRandomLengthName("百丽屋 2020秋季新款百搭高腰钩花镂空网纱中长款a字蕾丝半身裙女"),R.drawable.nz9);
            taoList.add(nz9);
            Tao nz10=new Tao(
                    getRandomLengthName("百丽屋 百搭修身白色打底衫2020秋季新款黑色长袖v领内搭针织衫女"),R.drawable.nz10);
            taoList.add(nz10);
            Tao nz11=new Tao(
                    getRandomLengthName("百丽屋 小个子休闲短款风衣2020秋季新款英伦风格子西装外套女"),R.drawable.nz11);
            taoList.add(nz11);

        }
    }

    private String getRandomLengthName(String name) {
        Random random=new Random();
        int length=random.nextInt(1)+1;
        StringBuilder builder=new StringBuilder();
        for (int i=0;i<length;i++){
            builder.append(name);
        }
        return builder.toString();
    }
}



