package com.example.amnhac.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.amnhac.Adapter.MainViewPagerAdapter;
import com.example.amnhac.Fragment.Fragment_Tim_Kiem;
import com.example.amnhac.Fragment.Fragment_Trang_Chu;
import com.example.amnhac.R;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        init();
    }

    private void init() {
        MainViewPagerAdapter mainViewPagerAdapter = new MainViewPagerAdapter(getSupportFragmentManager());
        mainViewPagerAdapter.addFragment(new Fragment_Trang_Chu(),"trang chu");
        mainViewPagerAdapter.addFragment(new Fragment_Tim_Kiem(),"tim kiem");
        viewPager.setAdapter(mainViewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.icontrangchu);
        tabLayout.getTabAt(1).setIcon(R.drawable.icontimkiem);
    }

    private void anhxa(){
        tabLayout =findViewById(R.id.myTapLayout);
        viewPager = findViewById(R.id.myViewPage);
    }
}