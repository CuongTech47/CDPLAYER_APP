package com.example.btl_music4b.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.Handler;

import com.example.btl_music4b.Adapter.MainViewPagerAdapter;
import com.example.btl_music4b.Fragment.Fragment_Profile;
import com.example.btl_music4b.Fragment.Fragment_Thu_Vien;
import com.example.btl_music4b.Fragment.Fragment_Tim_Kiem;
import com.example.btl_music4b.Fragment.Fragment_Trang_Chu;
import com.example.btl_music4b.Fragment.LoadingDialog;
import com.example.btl_music4b.R;
import com.google.android.material.tabs.TabLayout;

public class HomeActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        final LoadingDialog loadingDialog = new LoadingDialog(HomeActivity.this);
        AnhXa();
        loadingDialog.StartLoadingDialog();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                loadingDialog.dismissDialog();
            }
        }, 7500);
        init();
        overridePendingTransition(R.anim.anim_intent_in_home, R.anim.anim_intent_out);
    }

    private void init() {
        MainViewPagerAdapter mainViewPagerAdapter = new MainViewPagerAdapter(getSupportFragmentManager());
        mainViewPagerAdapter.addFragment(new Fragment_Trang_Chu(), "");
        mainViewPagerAdapter.addFragment(new Fragment_Tim_Kiem(), "");
        mainViewPagerAdapter.addFragment(new Fragment_Thu_Vien(), "");
        mainViewPagerAdapter.addFragment(new Fragment_Profile(), "");
        viewPager.setAdapter(mainViewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.icontrangchu);
        tabLayout.getTabAt(1).setIcon(R.drawable.icontimkiem);
        tabLayout.getTabAt(2).setIcon(R.drawable.iconthuvien);
        tabLayout.getTabAt(3).setIcon(R.drawable.iconlogo);
    }

    private void AnhXa() {
        tabLayout = findViewById(R.id.myTabLayout);
        viewPager = findViewById(R.id.myViewPager);
    }

}