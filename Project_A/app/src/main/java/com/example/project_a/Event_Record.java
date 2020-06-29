package com.example.project_a;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class Event_Record extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_record);

        recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        EventRecordAdapter adapter= new EventRecordAdapter();
        adapter.addItem(new EventDTO("택배옴","010-4444-4444","2022-06-23",R.drawable.aa));
        adapter.addItem(new EventDTO("택배옴","010-4445-4444","2022-06-23",R.drawable.aa));
        adapter.addItem(new EventDTO("택배옴","010-4447-4444","2022-06-23",R.drawable.aa));
        adapter.addItem(new EventDTO("택배옴","010-4440-4444","2022-06-23",R.drawable.aa));
        adapter.addItem(new EventDTO("택배옴","010-4449-4444","2022-06-23",R.drawable.aa));

        recyclerView.setAdapter(adapter);
    }
}
