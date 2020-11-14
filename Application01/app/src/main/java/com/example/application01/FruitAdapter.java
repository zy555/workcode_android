package com.example.application01;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class FruitAdapter extends ArrayAdapter<Fruit> {
    private  int resID;

    public FruitAdapter(Context context, int res, List<Fruit>object){
        super(context,res,object);
        resID = res;
    }
    @Override
public View getView(int position, View convertView, ViewGroup parent){
    Fruit fruit=getItem(position);
    View view;
    if (convertView==null){
        view=LayoutInflater.from(getContext()).inflate(resID,parent,false);
    }
    else{
        view=convertView;
    }
        ImageView imageView= view.findViewById(R.id.fruit_image);
        TextView textView= view.findViewById(R.id.fruit_name);
        imageView.setImageResource(fruit.getImageID());
        textView.setText(fruit.getName());
        return view;
    }
}