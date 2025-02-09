package com.example.esempio9;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Gioco extends AppCompatActivity {

    int grandezza, mine;
    GridLayout gl;
    RelativeLayout rl;
    int[] array;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);

        Intent i = getIntent();
        grandezza = i.getIntExtra("grandezza", 4);
        mine = grandezza;

        array = new int[grandezza * grandezza];

        generaCampo(array, grandezza);

        creaGriglia();
    }

    private void creaGriglia() {
        // Trova il layout principale
        rl = findViewById(R.id.gioco);

        // Crea un nuovo GridLayout
        gl = new GridLayout(this);
        gl.setColumnCount(grandezza); // Imposta il numero di colonne
        gl.setRowCount(grandezza);    // Imposta il numero di righe

        // Aggiungi i pulsanti alla griglia
        for (int row = 0; row < grandezza; row++) {
            for (int col = 0; col < grandezza; col++) {
                Button button = new Button(this);
                button.setLayoutParams(new GridLayout.LayoutParams(
                        GridLayout.spec(row),
                        GridLayout.spec(col)
                ));

                // Imposta le dimensioni del pulsante
                button.setWidth(50); // Larghezza fissa
                button.setHeight(50); // Altezza fissa
                button.setId(row * grandezza + col);

                // Aggiungi un listener per gestire il click
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        scopri(v);
                    }
                });

                gl.addView(button);
            }
        }
        rl.addView(gl);
    }

    public void scopri(View v){
        Button b = (Button) v;
        int posizione = b.getId();

        if(array[posizione] == 1){
            b.setText("X");
        } else{
            b.setText(""+calcolaMine(posizione));
        }
    }

    public static void generaCampo(int[] array, int grandezza) {
        Random random = new Random();
        int posizioniDaRiempire = grandezza;

        while (posizioniDaRiempire > 0) {
            int posizione = random.nextInt(grandezza * grandezza);
            if (array[posizione] == 0) {
                array[posizione] = 1;
                posizioniDaRiempire--;
            }
        }
    }

    public int calcolaMine(int posizione){
        int mine = 0;

        try {
            if (array[posizione - grandezza - 1] == 1)
                mine++;
            if (array[posizione - grandezza] == 1)
                mine++;
            if (array[posizione - grandezza + 1] == 1)
                mine++;
            if (array[posizione - 1] == 1)
                mine++;
            if (array[posizione + 1] == 1)
                mine++;
            if (array[posizione + grandezza - 1] == 1)
                mine++;
            if (array[posizione + grandezza] == 1)
                mine++;
            if (array[posizione + grandezza + 1] == 1)
                mine++;
        }catch (IndexOutOfBoundsException e){
            ;
        }
        return mine;
    }
}