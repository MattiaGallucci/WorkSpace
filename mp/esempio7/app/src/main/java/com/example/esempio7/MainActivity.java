package com.example.esempio7;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    boolean[] girato = new boolean[16];
    int tocchi = 0;
    ImageButton[] immagini = new ImageButton[16];
    String[] disegni = new String[16];

    int id1=-1, id2=-2;
    ImageButton b1=null, b2=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        disegni[0] = "anguria";
        disegni[1] = "anguria";
        disegni[2] = "ciambella";
        disegni[3] = "ciambella";
        disegni[4] = "conchiglia";
        disegni[5] = "conchiglia";
        disegni[6] = "gelato";
        disegni[7] = "gelato";
        disegni[8] = "occhiali";
        disegni[9] = "occhiali";
        disegni[10] = "ombrellone";
        disegni[11] = "ombrellone";
        disegni[12] = "pallone";
        disegni[13] = "pallone";
        disegni[14] = "uccello";
        disegni[15] = "uccello";

        shuffle(disegni);

        for (int i = 0; i < 16; i++) {
            immagini[i] = findViewById(getResources().getIdentifier("button" + i, "id", getPackageName()));
            immagini[i].setTag(disegni[i]);
            immagini[i].setOnClickListener(this::scopri);
            girato[i] = false;
        }

    }

    public void scopri(View view) {
        tocchi++;
        ImageButton b = (ImageButton) view;
        if (tocchi == 1) {
            b1 = b;
            String id = b.getTag().toString();
            id1 = getResources().getIdentifier(id, "drawable", getPackageName());
            b.setImageDrawable(getResources().getDrawable(id1));
        }
        else if(tocchi == 2){
            b2 = b;
            String id = b.getTag().toString();
            id2 = getResources().getIdentifier(id, "drawable", getPackageName());
            b.setImageDrawable(getResources().getDrawable(id2));

            if(id1 == id2){
                tocchi=0;
            }
        } else if(tocchi > 2){
            b1.setImageDrawable(getResources().getDrawable(R.drawable.back));
            b2.setImageDrawable(getResources().getDrawable(R.drawable.back));
            tocchi=0;
        }
    }

    void shuffle(String[] array) {
        Random random = new Random();
        int count = array.length;
        for (int i = count; i > 1; i--) {
            swap(array, i - 1, random.nextInt(i));
        }
    }

    void swap(String[] array, int i, int j) {
        String temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}