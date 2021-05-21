package com.example.versustest.recycleview;

import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public interface ResourceCallback {

    void onResourceItemClick(int pos,
                             ImageView newImage,
                             TextView textNewView);
}
