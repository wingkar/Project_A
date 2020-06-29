package com.example.project_a;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import android.widget.EditText;
import android.widget.TextView;


import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

//fgfgfg90090909090
public class Access_Record extends AppCompatActivity implements  TextWatcher{
    RecyclerView recyclerView;
    TextView accessTime;
    EditText editText;
    AccessRecordAdapter adapter;
    ArrayList<AccessDTO> items = new ArrayList<>();
    TabLayout tabs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_access_record);

        recyclerView = findViewById(R.id.recyclerView);
        editText = findViewById(R.id.edittext);
        accessTime = findViewById(R.id.accessTime);
        editText.addTextChangedListener(this);
        tabs = findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("출입기록"));
        tabs.addTab(tabs.newTab().setText("상시방문자"));
        tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });







        adapter = new AccessRecordAdapter(getApplicationContext(),items);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

//        adapter.addItem(new AccessDTO("open","택배",accessTime,R.drawable.singer1));
//        adapter.addItem(new AccessDTO("close","택배",accessTime,R.drawable.singer1));
//        adapter.addItem(new AccessDTO("open","배달",accessTime,R.drawable.singer1));

        items.add(new AccessDTO("open","택배",accessTime,R.drawable.singer1));
        items.add(new AccessDTO("close","택배",accessTime,R.drawable.singer1));
        items.add(new AccessDTO("open","배달",accessTime,R.drawable.singer1));
        items.add(new AccessDTO("close","배달",accessTime,R.drawable.singer1));


        recyclerView.setAdapter(adapter);
//        adapter.setOnItemClickListener(new OnAccessItemClickListener() {
//            @Override
//            public void onItemClick(AccessRecordAdapter.ViewHolder holderm, View view, int position) {
//                AccessDTO item = adapter.getItem(position);
//            }
//        });
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
        adapter.getFilter().filter(charSequence);
        //Toast.makeText(this, "눌렸다", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
