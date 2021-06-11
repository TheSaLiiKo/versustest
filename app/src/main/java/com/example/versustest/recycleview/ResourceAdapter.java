package com.example.versustest.recycleview;

import android.content.Context;
import android.util.Log;
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

import java.util.ArrayList;
import java.util.List;

public class ResourceAdapter extends RecyclerView.Adapter<ResourceAdapter.resourceviewholder> {

    private ArrayList<ImageResource> hlist;   //image
    private Context context;                  //image

    public ResourceAdapter(Context context, ArrayList<ImageResource> hlist, OnResourceListener mOnResourceListener) {
        this.context = context;
        this.hlist = hlist;
        this.mOnResourceListener = mOnResourceListener;
    }

    private OnResourceListener mOnResourceListener;

    List<ImageResource> mdata;

    public ResourceAdapter(Context context, ArrayList<ImageResource> mlist) {
        this.context = context;
        this.hlist = mlist;
    }


    @NonNull
    @Override
    public resourceviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_resource,parent,false);
        return new resourceviewholder(view, mOnResourceListener);
    }

    @Override
    public void onBindViewHolder(@NonNull resourceviewholder holder, int position) {

        //загрузить изображение с помощью Glide
        Log.e("nlist get Image " ,hlist.get(position).getImage()+" ");
        Log.e("nlist get Image URL " , hlist.get(position).getImageUrl()+" ");

        Glide.with(context).load(hlist.get(position).getImage()).into(holder.base);

        ImageResource imageResource = hlist.get(position);
        holder.textView.setText(imageResource.getText());


    }

    @Override
    public int getItemCount() {
        return hlist.size();
    }

    public class resourceviewholder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView base;
        TextView textView;
        OnResourceListener onResourceListener;

        public resourceviewholder(@NonNull View itemView, OnResourceListener onResourceListener) {
            super(itemView);

            base = itemView.findViewById(R.id.item_1_img);
            textView = itemView.findViewById(R.id.textName);
            this.onResourceListener = onResourceListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
onResourceListener.onResourceClick(getAdapterPosition());


        }
    }
public interface OnResourceListener{
        void onResourceClick(int position);
}
}
