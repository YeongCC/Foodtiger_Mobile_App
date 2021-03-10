package com.codeseasy.footdiger;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;


public class fooddetail extends AppCompatActivity {
    ImageView imageView;
    TextView itemName, itemPrice, itemRating,description;;
    RatingBar ratingBar;

    String name, price, rating, imageUrl,des;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fooddetail);

        Intent intent = getIntent();

        name = intent.getStringExtra("name");
        price = intent.getStringExtra("price");
        rating = intent.getStringExtra("rate");
        imageUrl = intent.getStringExtra("imageUrl");
        des = intent.getStringExtra("description");

        imageView = findViewById(R.id.imageView5);
        itemName = findViewById(R.id.name);
        itemPrice = findViewById(R.id.price);
        itemRating = findViewById(R.id.rating);
        ratingBar = findViewById(R.id.ratingBar);
        description = findViewById(R.id.textView8);

        Glide.with(getApplicationContext()).load(imageUrl).into(imageView);
        itemName.setText(name);
        itemPrice.setText("RM "+price);
        itemRating.setText(rating);
        ratingBar.setRating(Float.parseFloat(rating));
        description.setText(des);
    }
}