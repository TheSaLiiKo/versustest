package com.example.versustest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.versustest.model.ImageResource;

import java.util.ArrayList;

public class NewAdapter extends RecyclerView.Adapter<NewAdapter.NewViewHolder> {
    private ArrayList<ImageResource> nlist;
    private Context context;

    public NewAdapter(Context context, ArrayList<ImageResource> nlist){
        this.context = context;
        this.nlist = nlist;
    }

    @NonNull
    @Override
    public NewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.activity_new,parent,false);
        return new NewViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NewViewHolder holder, int position) {

        Glide.with(context).load(nlist.get(position).getImageUrl()).into(holder.image);

        ImageResource imageResource = nlist.get(position);
        holder.text.setText(imageResource.getText());


    }

    @Override
    public int getItemCount() { return nlist.size(); }

    public static class NewViewHolder extends RecyclerView.ViewHolder{

        TextView text;
        ImageView image;

        public NewViewHolder(@NonNull View itemView) {
            super(itemView);

            text = itemView.findViewById(R.id.text_name_new);
            image = itemView.findViewById(R.id.act_new_img);

        }
    }
}
