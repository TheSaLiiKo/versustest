package com.example.versustest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.versustest.model.ImageResource;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class NewActivity extends AppCompatActivity {
    private android.widget.ImageButton imageButton;
    ImageView toolbarImageButton, newImage;
    TextView textNewView;
    //------------------------firebase------------------------------------
    DatabaseReference database;
    NewAdapter newAdapter;
    ArrayList<ImageResource> nlist;
    RecyclerView recyclerView;
    ArrayList<ImageResource> list;
    String text;
    private FirebaseDatabase db = FirebaseDatabase.getInstance();          //text
    private DatabaseReference root = db.getReference().child("Users");     //text
    private NewAdapter adapter;                                            //text


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
       Intent intent = new Intent();
        text = intent.getStringExtra("Text");
        //ini view
        newImage = findViewById(R.id.act_new_img);
        textNewView = findViewById(R.id.text_name_new);
        textNewView.setText(text);
        database = FirebaseDatabase.getInstance().getReference("Users");


        // нам нужно получить объект предмета

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

        // привяжите сюда данные обьекта, пока я буду загружать только изображение

        Glide.with(this).load(item.getDrawableResource()).into(newImage);

        //----text---------------------------------------------------firebase------------------------------------------------------------------------------------------------

        nlist = new ArrayList<>();
        adapter = new NewAdapter(this, nlist);

        root.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    ImageResource imageResource = dataSnapshot.getValue(ImageResource.class);
                    nlist.add(imageResource);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        //----image-------------------------------------------------firebase------------------------------------------------------------------------------------------------

        list = new ArrayList<>();
        newAdapter = new NewAdapter(this,list);

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                Log.e("DataBase", String.valueOf(snapshot.getChildren()));

                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Log.e("DataBase", String.valueOf(snapshot.getChildren()));
                    Log.e("DataBase", String.valueOf(snapshot.getValue()));
                    Log.e("DataBase", String.valueOf(snapshot.getKey()));

                    /*HashMap<String,String> map = (HashMap<String, String>) dataSnapshot.getValue();
                    User user = new User();
                    user.setImage(map.get("image"));
                    user.setText(map.get("text"));*/

                    ImageResource imageResource = dataSnapshot.getValue(ImageResource.class);
                    list.add(imageResource);

                }

                newAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}