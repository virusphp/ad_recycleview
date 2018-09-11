package com.example.setsuga.recycleku;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class GridHokageAdapter extends RecyclerView.Adapter<GridHokageAdapter.GridViewHolder> {
    private Context context;
    private ArrayList<Hokage> listHokage;

    public ArrayList<Hokage> getListHokage() {
        return listHokage;
    }

    public void setListHokage(ArrayList<Hokage> listHokage) {
        this.listHokage = listHokage;
    }

    public GridHokageAdapter(Context context) {
        this.context = context;
    }

    @Override
    public GridViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_hokage, parent, false);
        GridViewHolder gridViewHolder = new GridViewHolder(view);
        return gridViewHolder;
    }

    @Override
    public void onBindViewHolder(GridViewHolder holder, int position) {
        Glide.with(context)
                .load(getListHokage().get(position).getFoto())
                .override(350, 550)
                .into(holder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return getListHokage().size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;

        public GridViewHolder(View itemView) {
            super(itemView);
            imgPhoto = (ImageView) itemView.findViewById(R.id.img_item_photo);
        }
    }

}