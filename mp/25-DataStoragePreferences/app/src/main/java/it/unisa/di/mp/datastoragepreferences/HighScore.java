package it.unisa.di.mp.datastoragepreferences;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HighScore extends Activity {
    TextView[] tvNomi = new TextView[3];
    String[] recordmen = new String[3];
    int[] highScores = new int[3];
    EditText etNome;
    int screenw_px;
    int punteggio;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);

        punteggio = getIntent().getIntExtra("PUNTEGGIO", -1);

        Log.d("DEBUG", "onCreate HighScore Activity - punteggio ="+punteggio);

        tvNomi[0] = findViewById(R.id.textview_highscore1_name);
        tvNomi[1] = findViewById(R.id.textview_highscore2_name);
        tvNomi[2] = findViewById(R.id.textview_highscore3_name);
        etNome = findViewById(R.id.edittext_nameplayer);

        //Size
        Point size = new Point();
        getWindowManager().getDefaultDisplay().getSize(size);
        screenw_px = size.x;
        //Densità
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        float screen_density = metrics.density;

        if (screenw_px > 0) {
            tvNomi[0].setTextSize(screenw_px/30);
            tvNomi[1].setTextSize(screenw_px/30);
            tvNomi[2].setTextSize(screenw_px/30);
        }

        //getPreferences per NON condividere
        //prefs = getPreferences(MODE_PRIVATE);

        //getSharedPreferences per condividere con altre activity della stessa app
        // si può specificare il nome di un file per avere diversi "database"
        prefs = getSharedPreferences("File",MODE_PRIVATE);

        //getSharedPreferences per condividere con altre activity della stessa app, file di default
        //prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        highScores[0] = prefs.getInt("HIGHSCORE1", 0);
        highScores[1] = prefs.getInt("HIGHSCORE2", 0);
        highScores[2] = prefs.getInt("HIGHSCORE3", 0);

        recordmen[0] = prefs.getString("RECORDMAN1", "");
        recordmen[1] = prefs.getString("RECORDMAN2", "");
        recordmen[2] = prefs.getString("RECORDMAN3", "");

        tvNomi[0].setText(recordmen[0] + ":" + highScores[0]);
        tvNomi[1].setText(recordmen[1] + ":" + highScores[1]);
        tvNomi[2].setText(recordmen[2] + ":" + highScores[2]);
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
