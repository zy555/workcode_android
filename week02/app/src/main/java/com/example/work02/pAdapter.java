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


public class pAdapter extends ArrayAdapter<people> {
    private  int resourceID;

    public pAdapter(Context context, int ID, List<people>object){
        super(context,ID,object);
        resourceID = ID;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        people people=getItem(position);
        View view= LayoutInflater.from(getContext()).inflate(resourceID,parent,false);
        TextView textView= view.findViewById(R.id.people_tv);
        textView.setText(people.getContent());
        return view;
    }
}