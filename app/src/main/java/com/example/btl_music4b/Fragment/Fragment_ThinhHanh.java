package com.example.btl_music4b.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.btl_music4b.Adapter.PlaylistAdapter;
import com.example.btl_music4b.Adapter.ThinhHanhAdapter;
import com.example.btl_music4b.Model.Playlist;
import com.example.btl_music4b.Model.ThinhHanh;
import com.example.btl_music4b.R;
import com.example.btl_music4b.Service.APIService;
import com.example.btl_music4b.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_ThinhHanh extends Fragment {

    View view;
    ThinhHanhAdapter thinhHanhAdapter;
    RecyclerView recyclerViewthinhhanh;
    TextView tenThinhHanh;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_thinhhanh, container, false);
        recyclerViewthinhhanh = view.findViewById(R.id.recyclerviewthinhhanh);
        tenThinhHanh = view.findViewById(R.id.txtthinhhanh);
        GetData();
        return view;
    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<ThinhHanh>> callback = dataservice.GetThinhHanhCurrent();
        callback.enqueue(new Callback<List<ThinhHanh>>() {
            @Override
            public void onResponse(Call<List<ThinhHanh>> call, Response<List<ThinhHanh>> response) {
                ArrayList<ThinhHanh> mangthinhhanh = (ArrayList<ThinhHanh>) response.body();
                thinhHanhAdapter = new ThinhHanhAdapter(getActivity(), mangthinhhanh);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                recyclerViewthinhhanh.setLayoutManager(linearLayoutManager);
                recyclerViewthinhhanh.setAdapter(thinhHanhAdapter);
            }

            @Override
            public void onFailure(Call<List<ThinhHanh>> call, Throwable t) {

            }

        });
    }
}
