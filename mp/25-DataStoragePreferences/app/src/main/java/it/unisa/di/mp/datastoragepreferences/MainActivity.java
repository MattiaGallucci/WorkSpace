package it.unisa.di.mp.datastoragepreferences;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    TextView textViewCounter;
    TextView[] tvNomi = new TextView[3];
    Button increaseButton;
    Button decreaseButton;
    String[] recordmen = new String[3];
    int[] highScores = new int[3];

    int counter;
    int screenw_px;

    SharedPreferences prefs;

    @SuppressLint("WrongViewCast")
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        //getPreferences per NON condividere
        //prefs = getPreferences(MODE_PRIVATE);

        //getSharedPreferences per condividere con altre activity della stessa app
        // si può specificare il nome di un file per avere diversi "database"
        prefs = getSharedPreferences("File",MODE_PRIVATE);

        //getSharedPreferences per condividere con altre activity della stessa app, file di default
        //prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        //Size
        Point size = new Point();
        getWindowManager().getDefaultDisplay().getSize(size);
        screenw_px = size.x;
        //Densità
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        float screen_density = metrics.density;

        textViewCounter = (TextView) findViewById(R.id.textview_counter);
        increaseButton = (Button) findViewById(R.id.button_increase);
        decreaseButton = (Button) findViewById(R.id.button_decrease);

        tvNomi[0] = findViewById(R.id.tvPrimo);
        tvNomi[1] = findViewById(R.id.tvSecondo);
        tvNomi[2] = findViewById(R.id.tvTerzo);

        textViewCounter.setTextSize(screenw_px / (5*screen_density));
        increaseButton.setTextSize(screenw_px / (5*screen_density));
        decreaseButton.setTextSize(screenw_px / (5 * screen_density));
        tvNomi[0].setTextSize(screenw_px / (10 * screen_density));
        tvNomi[1].setTextSize(screenw_px / (10 * screen_density));
        tvNomi[2].setTextSize(screenw_px / (10 * screen_density));

        //Conviene chiamare updateNames in onResume e non in onCreate
        //updateNames();
    }

    public void buttonIncrease(View v) {
        counter++;
        textViewCounter.setText(""+counter);
        return;
    }

    public void buttonDecrease(View v) {
        counter--;
        textViewCounter.setText(""+counter);
        if (counter <0) counter=0;
        return;
    }

    public void resetGame(View v) {
        counter=0;
        textViewCounter.setText(""+counter);
        return;
    }

    public void endGame(View v) {
        Log.d("DEBUG","End game");
        if (counter > highScores[2]) {
            Log.d("DEBUG","updating highscores");
            Intent i = new Intent();
            i.setClass(getApplicationContext(),HighScore.class);
            i.putExtra("PUNTEGGIO",counter);
            startActivity(i);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("DEBUG", "onResume");
        //Conviene chiamare updateNames in onResume e non in onCreate
        updateNames();
    }

    private void updateNames() {
        highScores[0] = prefs.getInt("HIGHSCORE1", 0);
        highScores[1] = prefs.getInt("HIGHSCORE2", 0);
        highScores[2] = prefs.getInt("HIGHSCORE3", 0);

        recordmen[0] = prefs.getString("RECORDMAN1", "");
        recordmen[1] = prefs.getString("RECORDMAN2", "");
        recordmen[2] = prefs.getString("RECORDMAN3", "");

        tvNomi[0].setText(recordmen[0] + ":" + highScores[0]);
        tvNomi[1].setText(recordmen[1] + ":" + highScores[1]);
        tvNomi[2].setText(recordmen[2] + ":" + highScores[2]);

        //Update del punteggio nel caso sia stato salvato
        //Se abbiamo salvato il punteggio lo recuperiamo
        counter = prefs.getInt("SCORE",0);
        textViewCounter.setText(""+counter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("DEBUG", "onStop");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        Log.d("DEBUG","onSaveInstanceState writing "+counter);
        //Qui possiamo salvare lo stato del gioco
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("SCORE", counter);
        editor.commit();

        // call superclass to save any view hierarchy
        super.onSaveInstanceState(outState);
    }

    public void resetHighscores(View v) {
        for (int i=0; i<3; i++) {
            highScores[i]=0;
            recordmen[i]="";
        }
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("HIGHSCORE1",highScores[0]);
        editor.putInt("HIGHSCORE2",highScores[1]);
        editor.putInt("HIGHSCORE3",highScores[2]);
        editor.putString("RECORDMAN1",recordmen[0]);
        editor.putString("RECORDMAN2",recordmen[1]);
        editor.putString("RECORDMAN3",recordmen[2]);
        editor.commit();
        tvNomi[0].setText(recordmen[0] + ":" + highScores[0]);
        tvNomi[1].setText(recordmen[1] + ":" + highScores[1]);
        tvNomi[2].setText(recordmen[2] + ":" + highScores[2]);
    }

    public void exitApp(View v) {
        finish();
    }
}