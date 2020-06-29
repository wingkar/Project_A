package com.example.project_a;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Main_Fragment1 extends Fragment {
    public static final int REQUEST_CODE_MENU = 101;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.activity_main_fragment1, container, false);


        Button button1,button2,button3;
        button1 = rootView.findViewById(R.id.button1);
        button2 = rootView.findViewById(R.id.button2);
        //출입기록
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), Access_Record.class);
                startActivity(intent);
            }
        });
        //이벤트기록
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(), Event_Record.class);
                startActivity(intent);
            }
        });


        //도어락 등록화면으로 가기
        ImageView imageView2;
        imageView2 = rootView.findViewById(R.id.imageView2);

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(getActivity().getApplicationContext(), DoorLockResister.class); 도어락화면은 아직! 민영이로 연결함
                //startActivity(intent);

            }
        });
        return rootView;

    }
}