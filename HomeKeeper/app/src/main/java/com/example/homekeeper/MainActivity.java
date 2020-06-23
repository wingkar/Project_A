package com.example.homekeeper;

import androidx.appcompat.app.AppCompatActivity;
<<<<<<< HEAD
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
=======
>>>>>>> 4f2699afecf294cecdf61310a4e6c02151fc446d

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

<<<<<<< HEAD
    RecyclerView recyclerView;

=======
>>>>>>> 4f2699afecf294cecdf61310a4e6c02151fc446d
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
<<<<<<< HEAD

        recyclerView = findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        EventAdapter adapter= new EventAdapter();
        adapter.addItem(new Event("택배옴","010-4444-4444","2022-06-23",R.drawable.aa));
        adapter.addItem(new Event("택배옴","010-4445-4444","2022-06-23",R.drawable.aa));
        adapter.addItem(new Event("택배옴","010-4447-4444","2022-06-23",R.drawable.aa));
        adapter.addItem(new Event("택배옴","010-4440-4444","2022-06-23",R.drawable.aa));
        adapter.addItem(new Event("택배옴","010-4449-4444","2022-06-23",R.drawable.aa));

        recyclerView.setAdapter(adapter);


=======
>>>>>>> 4f2699afecf294cecdf61310a4e6c02151fc446d
    }
}
