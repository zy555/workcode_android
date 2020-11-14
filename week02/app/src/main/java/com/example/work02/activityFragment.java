package com.example.work02;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link activityFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class activityFragment extends Fragment {
    private ListView aList;
    private List<activity> activityList=new ArrayList<activity>();

    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.fragment_activity,container,false);
        aList=view.findViewById(R.id.activity_lv);
        aAdapter adapter=new aAdapter(getActivity(),R.layout.activity_layout,activityList);
        Initactivity();
        aList.setAdapter(adapter);
        return view;
    }


    public void Initactivity(){
        activityList.add(new activity("小花",R.drawable.a1));

    }
}