package com.example.work02;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;


import java.util.ArrayList;
import java.util.List;

public class xiaoxiFragment extends Fragment {
    private ListView myList;
    private List<picture>pictureList=new ArrayList<picture>();

    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.xiaoxi_fragment,container,false);
        myList=view.findViewById(R.id.list_view);
        xAdapter adapter=new xAdapter(getActivity(),R.layout.xiaoxi_layout,pictureList);
        Initpicture();
        myList.setAdapter(adapter);
        return view;
    }


    public void Initpicture(){
        picture picture=new picture("今天天气真好",R.drawable.a1);
        pictureList.add(picture);
        picture picture1=new picture("早上好",R.drawable.a2);
        pictureList.add(picture1);
        picture picture2=new picture("中午好",R.drawable.a3);
        pictureList.add(picture2);
        picture picture3=new picture("晚上好",R.drawable.a4);
        pictureList.add(picture3);
        picture picture4=new picture("吃饭了吗",R.drawable.a5);
        pictureList.add(picture4);
        picture picture5=new picture("出去玩",R.drawable.a6);
        pictureList.add(picture5);

    }
}