package com.example.project_a;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator;

public class Starting_Screen_Main extends AppCompatActivity {
    FragmentPagerAdapter adapterViewPager;
    ViewPager pager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.starting_screen_main);

        pager = findViewById(R.id.pager);
        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(adapterViewPager);
        CircleIndicator indicator = findViewById(R.id.indicator);
        indicator.setViewPager(pager);


        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());

        Starting_Screen_Fragment1 fragment1 = new Starting_Screen_Fragment1();
        Starting_Screen_Fragment2 fragment2 = new Starting_Screen_Fragment2();
        Starting_Screen_Fragment3 fragment3 = new Starting_Screen_Fragment3();
        Starting_Screen_Fragment4 fragment4 = new Starting_Screen_Fragment4();


        adapter.addItem(fragment1);
        adapter.addItem(fragment2);
        adapter.addItem(fragment3);
        adapter.addItem(fragment4);


        pager.setAdapter(adapter);
    }

    public static class MyPagerAdapter extends FragmentPagerAdapter{
        private static  int NUM_ITEMS = 4;
        public MyPagerAdapter(FragmentManager fragmentManager){
            super(fragmentManager);
        }
        ArrayList<Fragment> items = new ArrayList<>();



        public void addItem(Fragment item){
            items.add(item);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return items.get(position);
        }

        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return "○" + (position + 1);
        }
    }
}
