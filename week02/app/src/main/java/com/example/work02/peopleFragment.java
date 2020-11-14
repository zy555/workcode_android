package com.example.work02;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class peopleFragment extends Fragment {
    private ListView pList;
    ArrayList<people> listData = new ArrayList<people>();



    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_people, container, false);
        pList = view.findViewById(R.id.people_lv);
        pAdapter adapter = new pAdapter(getActivity(), R.layout.people_layout, listData);
        demo();
        pList.setAdapter(adapter);
        return view;
    }


    private void demo() {
        listData.add(new people(">特别关心"));
        listData.add(new people(">小学同学"));
        listData.add(new people(">高中同学"));
        listData.add(new people(">大学同学"));
        listData.add(new people(">家人"));
    }
}