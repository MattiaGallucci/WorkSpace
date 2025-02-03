package com.example.esempio1;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class HighScore extends Activity {
    EditText etNome;
    SharedPreferences prefs;
    int punteggio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);

        punteggio = getIntent().getIntExtra("PUNTEGGIO", -1);

        Log.d("DEBUG", "onCreate HighScore Activity - punteggio ="+punteggio);

        etNome = findViewById(R.id.edittext_nameplayer);

        prefs = getSharedPreferences("File",MODE_PRIVATE);
    }

    public void inserisciNome(View v) {
        String nome = etNome.getText().toString();
        Log.d("DEBUG","Inserisco "+nome+" con punteggio "+punteggio);
        if (punteggio > highScores[2]) {
            if (punteggio > highScores[1]) {
                if (punteggio > highScores[0]) {
                    //Primo, scala i primi due
                    Log.d("DEBUG","PRIMO!!!!");
                    recordmen[2] = recordmen[1];
                    recordmen[1] = recordmen[0];
                    recordmen[0] = nome;
                    highScores[2] = highScores[1];
                    highScores[1] = highScores[0];
                    highScores[0] = punteggio;
                }
                else {
                    //Secondo, scala il secondo
                    Log.d("DEBUG","Secondo");
                    recordmen[2] = recordmen[1];
                    recordmen[1] = nome;
                    highScores[2] = highScores[1];
                    highScores[1] = punteggio;
                }
            }
            else {
                //Terzo
                Log.d("DEBUG","Terzo");
                recordmen[2] = nome;
                highScores[2] = punteggio;
            }

            SharedPreferences.Editor editor = prefs.edit();
            editor.putInt("HIGHSCORE1",highScores[0]);
            editor.putInt("HIGHSCORE2",highScores[1]);
            editor.putInt("HIGHSCORE3",highScores[2]);
            editor.putString("RECORDMAN1",recordmen[0]);
            editor.putString("RECORDMAN2",recordmen[1]);
            editor.putString("RECORDMAN3",recordmen[2]);
            //Per azzerare il punteggio al ritorno:
            editor.putInt("SCORE",0);
            editor.commit();

            finish();
        }
    }
}
