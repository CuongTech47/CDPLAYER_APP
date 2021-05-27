package com.example.btl_music4b.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.btl_music4b.Activity.DanhsachbaihatActivity;
import com.example.btl_music4b.Model.Playlist;
import com.example.btl_music4b.Model.ThinhHanh;
import com.example.btl_music4b.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ThinhHanhAdapter extends RecyclerView.Adapter<ThinhHanhAdapter.ViewHolder> {

    Context context;
    ArrayList<ThinhHanh> mangthinhhanh;
    View view;

    public ThinhHanhAdapter(Context context, ArrayList<ThinhHanh> mangthinhhanh) {
        this.context = context;
        this.mangthinhhanh = mangthinhhanh;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.dong_thinhhanh,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        ThinhHanh thinhHanh = mangthinhhanh.get(position);
        holder.txttenthinhhanh.setText(thinhHanh.getTenThinhHanh());
        Picasso.with(context).load(thinhHanh.getHinhThinhHanh()).into(holder.imgpthinhhanh);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DanhsachbaihatActivity.class);
                intent.putExtra("intentthinhhanh", mangthinhhanh.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mangthinhhanh.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgpthinhhanh;
        TextView txttenthinhhanh;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgpthinhhanh = itemView.findViewById(R.id.imageviewthinhhanh);
            txttenthinhhanh = itemView.findViewById(R.id.textviewthinhhanh);
        }
    }
}
