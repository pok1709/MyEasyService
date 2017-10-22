package app.cpt.sorapongph.myeasyservice.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import app.cpt.sorapongph.myeasyservice.R;

/**
 * Created by sorapong.ph on 10/21/2017.
 */

public class MainFragment extends Fragment {

    //    การสร้าง Method หลัก
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //Button Controller
        buttonController();


    }// Main Method

    private void buttonController() {
//        Initial View
        Button button = getView().findViewById(R.id.btnGotoSecond);

//        Get Event From Click
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Go to Second Fragment
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contentFrangmentMain, new SecondFragment())
                        .addToBackStack(null).commit();
                //addToBackStack(null) คือ ใส่หน้ากากใหม่แล้ว แล้วจะไปทับหน้ากาเก่า โดยที่หน้ากากเก่าจะยังอยู่ เมื่อกด Back ก็จะกลับมาหน้ากากแรก
            }// Onclick
        });
    }

    //    การสร้างหน้ากาก
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // New View from xml fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        return view;
    }

}   //Main Class
