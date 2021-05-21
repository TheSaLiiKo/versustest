package com.example.versustest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.Resource;
import com.example.versustest.model.ImageResource;

public class NewActivity extends AppCompatActivity {
    private android.widget.ImageButton imageButton;
    ImageView toolbarImageButton, newImage;
    TextView textNewView;
    private Object ImageButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        //ini view
        newImage = findViewById(R.id.act_new_img);
        textNewView = findViewById(R.id.text_name_new);

        // нам нужно получить объект предмета книги

        ImageResource item = (ImageResource) getIntent().getExtras().getSerializable("ResourceObject");

        loadResourceData(item);

        toolbarImageButton = findViewById(R.id.imageButton_toolbar);
        toolbarImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(NewActivity.this, "Рекомендации", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(NewActivity.this, HomeActivity.class);
                startActivity(intent);

            }
        });
    }

    private void loadResourceData(ImageResource item) {

        // привяжите сюда данные книги, пока я буду загружать только изображение обложки книги

        Glide.with(this).load(item.getDrawableResource()).into(newImage);

    }
}