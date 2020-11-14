package com.example.work02;

import android.content.Context;
import android.graphics.Picture;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class xAdapter extends ArrayAdapter<picture> {
    private  int resourceID;

    public xAdapter(Context context, int ID, List<picture>object){
        super(context,ID,object);
        resourceID = ID;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        picture picture=getItem(position);
        View view= LayoutInflater.from(getContext()).inflate(resourceID,parent,false);
        ImageView imageView= view.findViewById(R.id.picture_image);
        TextView textView= view.findViewById(R.id.picture_name);
        imageView.setImageResource(picture.getImageId());
        textView.setText(picture.getName());
        return view;
    }
}