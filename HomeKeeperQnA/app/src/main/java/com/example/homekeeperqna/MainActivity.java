package com.example.homekeeperqna;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button button1;
    ListView listView;

    homekeeperQnAAdapter adapter;
    ArrayList<HomeKeeperQnA> dtos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 디바이스 사이즈 구하기
        Point size = getDeviceSize();

        dtos = new ArrayList<>();

        button1 = findViewById(R.id.button1);
        listView = findViewById(R.id.listView);

        // 어댑터에 디바이스 사이즈까지 보낸다
        adapter = new homekeeperQnAAdapter(MainActivity.this, dtos, size);
        adapter.addDto(new HomeKeeperQnA("이방ㅂ이방저방내방??",
                "010ssss123", "2020-05-06","25", R.drawable.ss));
        adapter.addDto(new HomeKeeperQnA("이방ㅂ이방저방내방??",
                "010ssss123", "2020-05-06","25", R.drawable.ss));
        adapter.addDto(new HomeKeeperQnA("이방ㅂ이방저방내방??",
                "010ssss123", "2020-05-06","25", R.drawable.ss));
        adapter.addDto(new HomeKeeperQnA("이방ㅂ이방저방내방??",
                "010ssss123", "2020-05-06","25", R.drawable.ss));
        adapter.addDto(new HomeKeeperQnA("이방ㅂ이방저방내방??",
                "010ssss123", "2020-05-06","25", R.drawable.ss));
        adapter.addDto(new HomeKeeperQnA("이방ㅂ이방저방내방??",
                "010ssss123", "2020-05-06","25", R.drawable.ss));


        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                HomeKeeperQnA dto = (HomeKeeperQnA) adapter.getItem(position);
                Toast.makeText(MainActivity.this, "선택 : " + position
                                + "\n제목 : " + dto.getSubject() + "\n아이디 : " + dto.getId()
                                + "\n날짜 : " + dto.getDate() + "\n이미지 : " + dto.getResId(),
                        Toast.LENGTH_SHORT).show();
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String subject = "글제목글제목글제목글제목글제목글제목";
                String Id = "0112345";
                String date = "2020-06-08";
                String readCount= "33";
                int resId = R.drawable.ss;

                HomeKeeperQnA dto = new HomeKeeperQnA(subject,Id,date,readCount,resId);
                adapter.addDto(dto);
                adapter.notifyDataSetChanged();
            }
        });
    }

    // 디바이스 가로 세로 사이즈 구하기
    // getRealSize()는 status bar 등 system instets을
    // 포함한 스크린 사이즈를 가져오는 방법이고,
    // getSize()는 status bar 등 insets를
    // 제외한 부분에 대한 사이즈만 가져오는 함수입니다.
    // 단위는 픽셀

    public Point getDeviceSize(){
        Display display = getWindowManager().getDefaultDisplay();  // in Activity
        /* getActivity().getWindowManager().getDefaultDisplay() */ // in Fragment
        Point size = new Point();
        display.getRealSize(size); // or getSize(size)
        int width = size.x;
        int height = size.y;

        return size;
    }
}
