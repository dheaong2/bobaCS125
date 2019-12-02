package com.example.boba;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

import android.os.Bundle;
import android.widget.TextView;

public class KFTActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kft);
        TextView drinkDisplay = findViewById(R.id.drinkDisplay);

        String[] yogurtDrinks = {"Yogurt Green Tea", "Yogurt Grapefruit Tea", "Yogurt Orange Tea"};
        String[] classicDrinks = {"Winter Melon Green Tea", "Honey Black Tea",
        "Honey Green Tea", "Honey Oolong Tea", "Longan Jujube Tea", "KungFu Black Tea",
        "KungFu Green Tea", "KungFu Oolong Tea", "KungFu Honey Tea", "Winter Melon Tea"};

        int length = 0;
        int drinkGroup = getRandomNumberInRange(0, 2);
        if (drinkGroup == 0) {
            length = yogurtDrinks.length;
        } else if (drinkGroup == 1) {
            length = classicDrinks.length;
        }
        String selected = yogurtDrinks[getRandomNumberInRange(0,length)];
        drinkDisplay.setText(selected);
    }

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
