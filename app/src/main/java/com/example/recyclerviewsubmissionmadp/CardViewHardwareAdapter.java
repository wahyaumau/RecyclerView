package com.example.recyclerviewsubmissionmadp;

import android.content.Context;
import android.support.annotation.NonNull;
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

public class CardViewHardwareAdapter extends RecyclerView.Adapter<CardViewHardwareAdapter.CardViewViewHolder>{
    private Context context;
    private ArrayList<Hardware> listHardware;

    public ArrayList<Hardware> getListHardware() {
        return listHardware;
    }

    public void setListHardware(ArrayList<Hardware> listHardware) {
        this.listHardware = listHardware;
    }

    public CardViewHardwareAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_cardview_hardware, viewGroup, false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewViewHolder cardViewViewHolder, int i) {
        cardViewViewHolder.tVName.setText(getListHardware().get(i).getName());
        cardViewViewHolder.tVDescription.setText(getListHardware().get(i).getDescription());

        Glide.with(context).load(getImageFromDrawableByName(getListHardware().get(i).getPhoto())).
                into(cardViewViewHolder.imgPhoto);

        cardViewViewHolder.btnFavorite.setOnClickListener(new CustomOnItemClickListener(i, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context, "Liked "+getListHardware().get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        }));
        cardViewViewHolder.btnShare.setOnClickListener(new CustomOnItemClickListener(i, new CustomOnItemClickListener.OnItemClickCallback() {
            @Override
            public void onItemClicked(View view, int position) {
                Toast.makeText(context, "Share "+getListHardware().get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        }));
    }

    @Override
    public int getItemCount() {
        if (listHardware==null) return 0;
        return listHardware.size();
    }

    class CardViewViewHolder extends RecyclerView.ViewHolder{
        TextView tVName, tVDescription;
        ImageView imgPhoto;
        Button btnFavorite, btnShare;
        CardViewViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tVName = itemView.findViewById(R.id.tv_item_name);
            tVDescription = itemView.findViewById(R.id.tv_item_description);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            btnFavorite = itemView.findViewById(R.id.btn_set_favorite);
            btnShare = itemView.findViewById(R.id.btn_set_share);
        }
    }

    public int getImageFromDrawableByName(String imageName){
        int drawableResId = context.getResources().getIdentifier(imageName, "drawable", context.getPackageName());
        return drawableResId;
    }
}
