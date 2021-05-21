package com.example.versustest.recycleview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.Resource;
import com.example.versustest.MainActivity;
import com.example.versustest.R;
import com.example.versustest.model.ImageResource;

import java.util.List;

public class ResourceAdapter extends RecyclerView.Adapter<ResourceAdapter.resourceviewholder> {

    List<ImageResource> mdata;

    public ResourceAdapter(List<ImageResource> mdata) {
        this.mdata = mdata;
    }



    @NonNull
    @Override
    public resourceviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_resource, parent, false);

        return new resourceviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull resourceviewholder holder, int position) {

        //привязать сюда данные об элементе Описания
        //Я просто скомбинирую изображение..

        //загрузить изображение с помощью Glide

        Glide.with(holder.itemView.getContext())
                .load(mdata.get(position).getDrawableResource()) //установить URL-адрес описания img
                .centerCrop()
                .into(holder.imgResource); // путь назначения


    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    public class resourceviewholder extends RecyclerView.ViewHolder {

        ImageView imgResource,base;
        TextView description;

        public resourceviewholder(@NonNull View itemView) {
            super(itemView);

            description = itemView.findViewById(R.id.item_text_description);
            base = itemView.findViewById(R.id.item_base_image);
            imgResource = itemView.findViewById(R.id.item_resource_img);


        }
    }
}
