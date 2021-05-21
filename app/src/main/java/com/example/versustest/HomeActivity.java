package com.example.versustest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.versustest.model.ImageResource;
import com.example.versustest.recycleview.ResourceAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView rvDescription;
    private ResourceAdapter ResourceAdapter;
    private List<ImageResource> mdata;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        rvDescription = findViewById(R.id.rv_home);
        rvDescription.setLayoutManager(new LinearLayoutManager(this));
        rvDescription.setHasFixedSize(true);
        initmdataResource();
        setupResourceAdapter();

    }

    private void setupResourceAdapter() {

        ResourceAdapter = new ResourceAdapter(mdata);
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



    }
}