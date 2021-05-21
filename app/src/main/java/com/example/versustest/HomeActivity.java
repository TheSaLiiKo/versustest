package com.example.versustest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.versustest.model.ImageResource;
import com.example.versustest.recycleview.ResourceAdapter;
import com.example.versustest.recycleview.ResourceCallback;

import java.util.ArrayList;
import java.util.List;

//убедитеся, что импортирую тот же самый класс
import androidx.core.util.Pair;

public class HomeActivity extends AppCompatActivity implements ResourceCallback {

    private RecyclerView rvDescription;
    private ResourceAdapter ResourceAdapter;
    private List<ImageResource> mdata;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initViews();
        initmdataResource();
        setupResourceAdapter();

    }

    private void setupResourceAdapter() {

        ResourceAdapter = new ResourceAdapter(mdata,this);
        rvDescription.setAdapter(ResourceAdapter);

    }

    private void initmdataResource() {

        // для проверки я создаю случайный набор новостей
        // я могу получить свои данные из веб-службы или базы данных firebase

        mdata = new ArrayList<>();
        mdata.add(new ImageResource(R.drawable.termopast));
        mdata.add(new ImageResource(R.drawable.termopast));
        mdata.add(new ImageResource(R.drawable.termopast));
        mdata.add(new ImageResource(R.drawable.termopast));
        mdata.add(new ImageResource(R.drawable.termopast));
        mdata.add(new ImageResource(R.drawable.termopast));

    }

    private void initViews() {

        rvDescription = findViewById(R.id.rv_home);
        rvDescription.setLayoutManager(new LinearLayoutManager(this));
        rvDescription.setHasFixedSize(true);

    }

    @Override
    public void onResourceItemClick(int pos,
                                    ImageView newImage,
                                    TextView textNewView) {

        // создать намерение и отправить объект руководства в действие Details

        Intent intent = new Intent(this,NewActivity.class);
        intent.putExtra("ResourceObject",mdata.get(pos));

        // общая настройка анимации
        //импортируем класс Pair

        Pair<View,String> p1 = Pair.create((View)newImage,"newImgTN");// второй аргумент - имя строки tansition.
        Pair<View,String> p2 = Pair.create((View)textNewView,"textNameTN");

       /* ActivityOptionsCompat optionsCompat =
                ActivityOptionsCompat.makeSceneTransitionAnimation(this,p1,p2);*/

        // начать действие с перехода сцены

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN){
            startActivity(intent);
        }
        else
            startActivity(intent);

    }
}