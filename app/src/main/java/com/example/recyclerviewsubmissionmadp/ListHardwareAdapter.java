package com.example.recyclerviewsubmissionmadp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ListHardwareAdapter extends RecyclerView.Adapter<ListHardwareAdapter.CategoryViewHolder> {
    private Context context;
    private ArrayList<Hardware> listHardware;

    public ArrayList<Hardware> getListHardware() {
        return listHardware;
    }

    public void setListHardware(ArrayList<Hardware> listHardware) {
        this.listHardware = listHardware;
    }

    public ListHardwareAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_hardware,viewGroup, false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, int i) {
        categoryViewHolder.tVName.setText(getListHardware().get(i).getName());
        categoryViewHolder.tVDescription.setText(getListHardware().get(i).getDescription());

        Glide.with(context).load(getImageFromDrawableByName(getListHardware().get(i).getPhoto())).
                into(categoryViewHolder.imgPhoto);

    }

    @Override
    public int getItemCount() {
        if (listHardware==null) return 0;
        return listHardware.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView tVName, tVDescription;
        ImageView imgPhoto;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tVName = itemView.findViewById(R.id.tv_item_name);
            tVDescription = itemView.findViewById(R.id.tv_item_description);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
        }
    }

    public int getImageFromDrawableByName(String imageName){
        int drawableResId = context.getResources().getIdentifier(imageName, "drawable", context.getPackageName());
        return drawableResId;
    }
}
