package com.example.esempio1;

import android.app.ActionBar;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView[] tv = new TextView[9];
    TextView counter;
    int count = 0;
    RelativeLayout layout;
    TextView[] tvNomi = new TextView[3];
    String[] recordmen = new String[3];
    int[] highScores = new int[3];

    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = findViewById(R.id.main);

        tv[0] = findViewById(R.id.tv11);
        tv[1] = findViewById(R.id.tv12);
        tv[2] = findViewById(R.id.tv13);

        tv[3] = findViewById(R.id.tv21);
        tv[4] = findViewById(R.id.tv22);
        tv[5] = findViewById(R.id.tv23);

        tv[6] = findViewById(R.id.tv31);
        tv[7] = findViewById(R.id.tv32);
        tv[8] = findViewById(R.id.tv33);

        counter = findViewById(R.id.counter);
        counter.setText(""+count);

        tv[0].setText(""+1);
        tv[1].setText(""+2);
        tv[2].setText(""+9);
        tv[3].setText(""+4);
        tv[4].setText(""+5);
        tv[5].setText(""+3);
        tv[6].setText(""+7);
        tv[7].setText(""+8);
        tv[8].setText(""+6);

        prefs = getSharedPreferences("File",MODE_PRIVATE);

        tvNomi[0] = findViewById(R.id.tvPrimo);
        tvNomi[1] = findViewById(R.id.tvSecondo);
        tvNomi[2] = findViewById(R.id.tvTerzo);
    }

    @Override
    protected void onResume() {
        super.onResume();
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
        count = prefs.getInt("SCORE",0);
        counter.setText(""+count);
    }

    public boolean test(){
        for(int i=0; i<tv.length; i++){
            if(!(tv[i].getText().toString().equals(""+(i+1))))
                return false;
        }
        return true;
    }

    public void sposta(View v){
        Button b = (Button) v;
        String s = null;

        if(b.getId() == R.id.button01){
            s = tv[0].getText().toString();
            tv[0].setText(tv[3].getText().toString());
            tv[3].setText(tv[6].getText().toString());
            tv[6].setText(s);
            count++;
            counter.setText(""+count);
            if(test())
                vittoria();
        }
        else if(b.getId() == R.id.button02){
            s = tv[1].getText().toString();
            tv[1].setText(tv[4].getText().toString());
            tv[4].setText(tv[7].getText().toString());
            tv[7].setText(s);
            count++;
            counter.setText(""+count);
        }
        else if(b.getId() == R.id.button03){
            s = tv[2].getText().toString();
            tv[2].setText(tv[5].getText().toString());
            tv[5].setText(tv[8].getText().toString());
            tv[8].setText(s);
            count++;
            counter.setText(""+count);
        }
        else if(b.getId() == R.id.button10){
            s = tv[0].getText().toString();
            tv[0].setText(tv[1].getText().toString());
            tv[1].setText(tv[2].getText().toString());
            tv[2].setText(s);
            count++;
            counter.setText(""+count);
        }
        else if(b.getId() == R.id.button20){
            s = tv[3].getText().toString();
            tv[3].setText(tv[4].getText().toString());
            tv[4].setText(tv[5].getText().toString());
            tv[5].setText(s);
            count++;
            counter.setText(""+count);
        }
        else if(b.getId() == R.id.button30){
            s = tv[6].getText().toString();
            tv[6].setText(tv[7].getText().toString());
            tv[7].setText(tv[8].getText().toString());
            tv[8].setText(s);
            count++;
            counter.setText(""+count);
        }
        else if(b.getId() == R.id.button14){
            s = tv[2].getText().toString();
            tv[2].setText(tv[1].getText().toString());
            tv[1].setText(tv[0].getText().toString());
            tv[0].setText(s);
            count++;
            counter.setText(""+count);
        }
        else if(b.getId() == R.id.button24){
            s = tv[5].getText().toString();
            tv[5].setText(tv[4].getText().toString());
            tv[4].setText(tv[3].getText().toString());
            tv[3].setText(s);
            count++;
            counter.setText(""+count);
        }
        else if(b.getId() == R.id.button34){
            s = tv[8].getText().toString();
            tv[8].setText(tv[7].getText().toString());
            tv[7].setText(tv[6].getText().toString());
            tv[6].setText(s);
            count++;
            counter.setText(""+count);
        }
        else if(b.getId() == R.id.button41){
            s = tv[6].getText().toString();
            tv[6].setText(tv[3].getText().toString());
            tv[3].setText(tv[0].getText().toString());
            tv[0].setText(s);
            count++;
            counter.setText(""+count);
        }
        else if(b.getId() == R.id.button42){
            s = tv[7].getText().toString();
            tv[7].setText(tv[4].getText().toString());
            tv[4].setText(tv[1].getText().toString());
            tv[1].setText(s);
            count++;
            counter.setText(""+count);
        }
        else if(b.getId() == R.id.button43){
            s = tv[8].getText().toString();
            tv[8].setText(tv[5].getText().toString());
            tv[5].setText(tv[2].getText().toString());
            tv[2].setText(s);
            count++;
            counter.setText(""+count);
        }
        if(test())
            vittoria();
    }

    public void vittoria(){
        TextView tvVittoria = new TextView(this);

        tvVittoria.setText("Completato in " + count + " mosse!");
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
        tvVittoria.setLayoutParams(params);

        tvVittoria.setTextSize(40);
        tvVittoria.setBackgroundColor(Color.rgb(255, 0, 0));

        layout.addView(tvVittoria);

        Intent i = new Intent();
        i.setClass(getApplicationContext(),HighScore.class);
        i.putExtra("PUNTEGGIO",count);
        startActivity(i);
    }

    public void reset(View v){
        Intent intent = new Intent(this, MainActivity.class); // Sostituisci MainActivity con il nome della tua Activity
        startActivity(intent);
        finish(); // Chiude l'Activity corrente
    }
}