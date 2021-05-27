package com.example.btl_music4b.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.btl_music4b.Adapter.MainViewPagerAdapter;
import com.example.btl_music4b.Adapter.ViewPagerThuVien;
import com.example.btl_music4b.R;
import com.google.android.material.tabs.TabLayout;

public class Fragment_Thu_Vien extends Fragment {
    TabLayout tabLayout;
    ViewPager viewPager;
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_thu_vien, container, false);
        AnhXa();
        init();
        return  view;
    }
    private void init() {
        ViewPagerThuVien viewPagerThuVien = new ViewPagerThuVien(getChildFragmentManager());
        viewPagerThuVien.addFragment(new Fragment_ThuVien_Playlist(), "Playlist");
        viewPagerThuVien.addFragment(new Fragment_ThuVien_NgheSi(), "Nghệ sĩ");
        viewPagerThuVien.addFragment(new Fragment_ThuVien_Album(), "Album");
        viewPager.setAdapter(viewPagerThuVien);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void AnhXa() {
        tabLayout = view.findViewById(R.id.tabLayouttv);
        viewPager = view.findViewById(R.id.viewPagertv);
    }

}
