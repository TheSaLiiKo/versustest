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
    ResourceCallback callback;

    public ResourceAdapter(List<ImageResource> mdata , ResourceCallback callback) {
        this.mdata = mdata;
        this.callback = callback ;
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
                .into(holder.base); // путь назначения


    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    public class resourceviewholder extends RecyclerView.ViewHolder {

        ImageView container,base, newImage;
        TextView textView,textNewView;


        public resourceviewholder(@NonNull View itemView) {
            super(itemView);

            container = itemView.findViewById(R.id.container);
            newImage = itemView.findViewById(R.id.act_new_img);
            textNewView = itemView.findViewById(R.id.text_name_new);
            base = itemView.findViewById(R.id.item_1_img);
            textView = itemView.findViewById(R.id.textName);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    callback.onResourceItemClick(getAdapterPosition(),
                            newImage,
                            textNewView);
                }
            });

        }
    }
}
