package com.example.setsuga.recycleku;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ListHokageAdapter extends RecyclerView.Adapter<ListHokageAdapter.CategoryViewHolder>{
    private Context context;

    public ArrayList<Hokage> getListHokage() {
        return listHokage;
    }

    public void setListHokage(ArrayList<Hokage> listHokage)
    {
        this.listHokage = listHokage;
    }

    private ArrayList<Hokage> listHokage;

    public ListHokageAdapter(Context context)
    {
        this.context = context;
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_hokage, parent, false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {
        holder.tvName.setText(getListHokage().get(position).getNama());
        holder.tvRemarks.setText(getListHokage().get(position).getRemarks());

        Glide.with(context)
                .load(getListHokage().get(position).getFoto())
                .override(55, 55)
                .crossFade()
                .into(holder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return getListHokage().size();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvRemarks;
        ImageView imgPhoto;

        public CategoryViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView)itemView.findViewById(R.id.tv_item_name);
            tvRemarks = (TextView)itemView.findViewById(R.id.tv_item_remarks);
            imgPhoto = (ImageView)itemView.findViewById(R.id.img_item_photo);
        }
    }
}
