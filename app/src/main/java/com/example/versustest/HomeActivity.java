package com.example.versustest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.ColorSpace;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.versustest.model.ImageResource;
import com.example.versustest.recycleview.ResourceAdapter;
import com.example.versustest.recycleview.ResourceCallback;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

//убедитеся, что импортирую тот же самый класс
import androidx.core.util.Pair;

public class HomeActivity extends AppCompatActivity implements ResourceAdapter.OnResourceListener {



    private List<ImageResource> mdata;

    DatabaseReference database;
    ResourceAdapter resourceAdapter; //image
    ArrayList<ImageResource> list; //image
    RecyclerView recyclerView; //text,image


    private FirebaseDatabase db = FirebaseDatabase.getInstance();          //text



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        recyclerView = findViewById(R.id.rv_home);
        database = FirebaseDatabase.getInstance().getReference("Users");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //---------------------------------image-------------------------------------------------------------------------------------\/

        list = new ArrayList<>();
        resourceAdapter = new ResourceAdapter(this,list,this);

        recyclerView.setAdapter(resourceAdapter);
        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                Log.e("DataBase", String.valueOf(snapshot.getChildren()));

                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Log.e("DataBase Child", String.valueOf(dataSnapshot.getChildren()));
                    Log.e("DataBase Value", String.valueOf(dataSnapshot.getValue()));
                    Log.e("DataBase Key ", String.valueOf(dataSnapshot.getKey()));

                    ImageResource imageResource = dataSnapshot.getValue(ImageResource.class);
                    Log.e("imageResource text", imageResource.getText());
                    Log.e("imageResource image ",imageResource.getImage());

                    list.add(imageResource);

                }

                resourceAdapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }






//    @Override
//    public void onResourceItemClick(int pos,
//                                    ImageView newImage,
//                                    TextView textNewView) {
//
//        // создать намерение и отправить объект руководства в действие Details
//            Log.e("Clicl ", "click");
//        Intent intent = new Intent(this,NewActivity.class);
//        intent.putExtra("ResourceObject",mdata.get(pos));
//
//        // общая настройка анимации
//        //импортируем класс Pair
//
//        Pair<View,String> p1 = Pair.create((View)newImage,"newImgTN");// второй аргумент - имя строки tansition.
//        Pair<View,String> p2 = Pair.create((View)textNewView,"textNameTN");
//
//        ActivityOptionsCompat optionsCompat =
//                ActivityOptionsCompat.makeSceneTransitionAnimation(this,p1,p2);
//
//        // начать действие с перехода сцены
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN){
//            startActivity(intent);
//        }
//        else
//            startActivity(intent);
//
//    }

    @Override
    public void onResourceClick(int position) {
        Log.e("Clicl ", "click");
        Log.e("Click TEXT ", list.get(position).getText());
        Log.e("Clicl ", list.get(position).getImage() + " ");
        Intent intent = new Intent(this, NewActivity.class);
        intent.putExtra("Text", list.get(position).getText().toString());
        intent.putExtra("ResourceObject", list.get(position));

        // общая настройка анимации
        //импортируем класс Pair
//
//        Pair<View,String> p1 = Pair.create((View)newImage,"newImgTN");// второй аргумент - имя строки tansition.
//        Pair<View,String> p2 = Pair.create((View)textNewView,"textNameTN");
//
//        ActivityOptionsCompat optionsCompat =
//                ActivityOptionsCompat.makeSceneTransitionAnimation(this,p1,p2);

        // начать действие с перехода сцены

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            startActivity(intent);
        } else {
            startActivity(intent);
    }
}
    }
