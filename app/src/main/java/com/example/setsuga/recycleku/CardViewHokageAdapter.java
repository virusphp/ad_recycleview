package com.example.setsuga.recycleku;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CardViewHokageAdapter extends RecyclerView.Adapter<CardViewHokageAdapter.CardViewViewHolder>{
    private ArrayList<Hokage> listHokage;
    private Context context;

    public CardViewHokageAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<Hokage> getListHokage() {
        return listHokage;
    }

    public void setListHokage(ArrayList<Hokage> listHokage) {
        this.listHokage = listHokage;
    }
    @Override
    public CardViewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_hokage, parent, false);
        CardViewViewHolder viewHolder = new CardViewViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CardViewViewHolder holder, int position) {

        Hokage p = getListHokage().get(position);

        Glide.with(context)
                .load(p.getFoto())
                .override(350, 550)
                .into(holder.imgPhoto);

        holder.tvName.setText(p.getNama());
        holder.tvRemarks.setText(p.getRemarks());

        holder.btnFavorite.setOnClickListener(new CustomOnItemClickListener(position, new CustomOnItemClickListener.OnItemClickCallback() {

            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context, "Favorite "+getListHokage().get(position).getNama(), Toast.LENGTH_SHORT).show();
            }
        }));

        holder.btnShare.setOnClickListener(new CustomOnItemClickListener(position, new CustomOnItemClickListener.OnItemClickCallback() {

            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context, "Share " + getListHokage().get(position).getNama(), Toast.LENGTH_SHORT).show();
            }
        }));
    }

    @Override
    public int getItemCount() {
        return getListHokage().size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder{
        ImageView imgPhoto;
        TextView tvName, tvRemarks;
        Button btnFavorite, btnShare;
        public CardViewViewHolder(View itemView) {
            super(itemView);
            imgPhoto = (ImageView)itemView.findViewById(R.id.img_item_photo);
            tvName = (TextView)itemView.findViewById(R.id.tv_item_name);
            tvRemarks = (TextView)itemView.findViewById(R.id.tv_item_remarks);
            btnFavorite = (Button)itemView.findViewById(R.id.btn_set_favorite);
            btnShare = (Button)itemView.findViewById(R.id.btn_set_share);
        }
    }
}