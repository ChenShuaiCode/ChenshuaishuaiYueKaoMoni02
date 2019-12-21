package com.bawei.chenshuaishuaiyuekaomoni02.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.chenshuaishuaiyuekaomoni02.R;
import com.bawei.chenshuaishuaiyuekaomoni02.model.entity.GridEntity;
import com.bawei.chenshuaishuaiyuekaomoni02.view.SecendActivity;
import com.bumptech.glide.Glide;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private Context context;
    private List<GridEntity.ResultBean> list;

    public MyAdapter(Context context, List<GridEntity.ResultBean> list) {
        this.context = context;
        this.list = list;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(parent.getContext(), R.layout.layout_item, null);
        ViewHolder viewHolder=new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.tv1.setText(list.get(position).commodityName);
        holder.tv2.setText(list.get(position).price);
        Glide.with(context)
                .load(list.get(position).masterPic)
                .into(holder.iv);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, list.get(position).commodityName, Toast.LENGTH_SHORT).show();
                context.startActivity(new Intent(context, SecendActivity.class));
            }
        });
    }
    @Override
    public int getItemCount() {
        return list.size();
    }
    protected class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView iv;
        public TextView tv1,tv2;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            tv1 = itemView.findViewById(R.id.tv1);
            tv2 = itemView.findViewById(R.id.tv2);
        }
    }
}