package com.example.boba;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
        String selected = "";
        int drinkGroup = getRandomNumberInRange(0, 1);
        if (drinkGroup == 0) {
            length = yogurtDrinks.length;
            selected = yogurtDrinks[getRandomNumberInRange(0, length)];
        } else if (drinkGroup == 1) {
            length = classicDrinks.length;
            selected = classicDrinks[getRandomNumberInRange(0, length)];
        }

        drinkDisplay.setText(selected);

        Button geneButton = findViewById(R.id.geneButton);

        final Intent kftIntent = new Intent(this, KFTActivity.class);
        geneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                startActivity(kftIntent);
            }
        });
    }

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
