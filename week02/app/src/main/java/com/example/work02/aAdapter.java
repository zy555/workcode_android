package com.example.work02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class aAdapter extends ArrayAdapter<activity> {
    private  int resourceID;

    public aAdapter(Context context, int ID, List<activity>object){
        super(context,ID,object);
        resourceID = ID;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        activity activity=getItem(position);
        View view= LayoutInflater.from(getContext()).inflate(resourceID,parent,false);
        ImageView imageView= view.findViewById(R.id.activity_image);
        TextView textView= view.findViewById(R.id.activity_name);
        imageView.setImageResource(activity.getImageId());
        textView.setText(activity.getName());
        return view;
    }
}