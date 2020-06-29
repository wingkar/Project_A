package com.example.project_a;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class QnA_Main extends AppCompatActivity {
    Button button1,button9;
    ListView listView;

    QnAListAdapter adapter;
    ArrayList<QnAListDTO> dtos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Inflater inflater = new Inflater();
        checkDangerousPermissions();

        button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QnA_Main.this,QnA_Write.class);
                startActivity(intent);
            }
        });

        button9 = findViewById(R.id.button9);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),QnA_Notice.class);
                startActivity(intent);
            }
        });

        // 디바이스 사이즈 구하기
        Point size = getDeviceSize();

        dtos = new ArrayList<>();


        listView = findViewById(R.id.listView2);

        // 어댑터에 디바이스 사이즈까지 보낸다
        adapter = new QnAListAdapter(QnA_Main.this, dtos, size);
        adapter.addDto(new QnAListDTO("이방ㅂ이방저방내방??",
                "010ssss123", "2020-05-06","25", R.drawable.ss));
        adapter.addDto(new QnAListDTO("이방ㅂ이방저방내방??",
                "010ssss123", "2020-05-06","25", R.drawable.ss));
        adapter.addDto(new QnAListDTO("이방ㅂ이방저방내방??",
                "010ssss123", "2020-05-06","25", R.drawable.ss));
        adapter.addDto(new QnAListDTO("이방ㅂ이방저방내방??",
                "010ssss123", "2020-05-06","25", R.drawable.ss));
        adapter.addDto(new QnAListDTO("이방ㅂ이방저방내방??",
                "010ssss123", "2020-05-06","25", R.drawable.ss));
        adapter.addDto(new QnAListDTO("이방ㅂ이방저방내방??",
                "010ssss123", "2020-05-06","25", R.drawable.ss));


        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                QnAListDTO dto = (QnAListDTO) adapter.getItem(position);
                Toast.makeText(QnA_Main.this, "선택 : " + position
                                + "\n제목 : " + dto.getSubject() + "\n아이디 : " + dto.getId()
                                + "\n날짜 : " + dto.getDate() + "\n이미지 : " + dto.getResId(),
                        Toast.LENGTH_SHORT).show();
            }
        });

        /*button1.setOnClickListener(new View.OnClickListener() {
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
        });*/
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
        display.getSize(size); // or getSize(size)
        int width = size.x;
        int height = size.y;

        return size;
    }

    private void checkDangerousPermissions() {
        String[] permissions = {
                Manifest.permission.INTERNET,
                Manifest.permission.ACCESS_NETWORK_STATE,
                Manifest.permission.ACCESS_WIFI_STATE,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.CAMERA
        };

        int permissionCheck = PackageManager.PERMISSION_GRANTED;
        for (int i = 0; i < permissions.length; i++) {
            permissionCheck = ContextCompat.checkSelfPermission(this, permissions[i]);
            if (permissionCheck == PackageManager.PERMISSION_DENIED) {
                break;
            }
        }

        if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "권한 있음", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "권한 없음", Toast.LENGTH_LONG).show();

            if (ActivityCompat.shouldShowRequestPermissionRationale(this, permissions[0])) {
                Toast.makeText(this, "권한 설명 필요함.", Toast.LENGTH_LONG).show();
            } else {
                ActivityCompat.requestPermissions(this, permissions, 1);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == 1) {
            for (int i = 0; i < permissions.length; i++) {
                if (grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, permissions[i] + " 권한이 승인됨.", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, permissions[i] + " 권한이 승인되지 않음.", Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}
