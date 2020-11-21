package com.example.application01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivityFragment extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void  onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_test);
        Button button= findViewById(R.id.Button);
        button.setOnClickListener(this);
        replaceFragment(new RightTestFragment());
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManger=getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManger.beginTransaction();
        transaction.replace(R.id.layout_content,fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.Button:
                replaceFragment(new AnotherRightFragment());
                break;
            default:
                break;
        }
    }
}
