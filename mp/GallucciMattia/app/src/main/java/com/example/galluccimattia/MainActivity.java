package com.example.galluccimattia;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView tvPunteggio;
    private int punteggio=0;
    private TextView[] tvNumeri = new TextView[12];
    private int[] numeri = new int[4];
    private Random r;
    int click=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvPunteggio = findViewById(R.id.punteggio);

        for(int i = 0; i < 12; i++) {
            tvNumeri[i] = findViewById(getResources().getIdentifier("tv" + i, "id", getPackageName()));
        }
    }

    //GIOCO SENZA SCORRIMENTO NUMERI
    /*public void gioca(View view) {
        if(click!=0)
            return;
        click=1;
        r = new Random();
        for(int i = 0; i < 4; i++) {
            numeri[i] = r.nextInt(10);
        }

        for(int i = 0; i < 4; i++) {
            int numero = (numeri[i]) % 10;
            tvNumeri[i+4].setText("" + numeri[i]);
        }

        for(int i = 4; i < 8; i++) {
            int numero = (numeri[i-4] - 1 + 10) % 10;
            tvNumeri[i-4].setText("" + numero);
        }

        for(int i = 8; i < 12; i++) {
            int numero = (numeri[i-8]+1) % 10;
            tvNumeri[i].setText("" + numero);
        }
        test();
    }*/

    //GIOCO CON SCORRIMENTO NUEMERI
    public void gioca(View view) {
        if(click!=0)
            return;
        click=1;
        r = new Random();

        for (int i = 0; i < 4; i++) {
            numeri[i] = r.nextInt(10);
        }

        Handler handler = new Handler();
        final int[] step = {0};

        Runnable updateNumbers = new Runnable() {
            @Override
            public void run() {
                if (step[0] < 4) {
                    for (int i = 0; i < 4; i++) {
                        int sopra = (numeri[i] - 1 + 10) % 10;
                        int centro = numeri[i];
                        int sotto = (numeri[i] + 1) % 10;

                        tvNumeri[i].setText("" + sopra);
                        tvNumeri[i + 4].setText("" + centro);
                        tvNumeri[i + 8].setText("" + sotto);
                    }

                    for (int i = 0; i < 4; i++) {
                        numeri[i] = (numeri[i] - 1 + 10) % 10;
                    }

                    step[0]++;
                    handler.postDelayed(this, 500);
                } else {
                    test();
                }
            }
        };

        handler.post(updateNumbers); // Avvia il processo di scorrimento

    }


    public void reset(View view) {
        if(click==1) {
            Toast.makeText(this, "Aspetta che finisca il gioco", Toast.LENGTH_SHORT).show();
            return;
        }
        tvPunteggio.setText("0");
        punteggio=0;
        for(int i = 0; i < 12; i++) {
            tvNumeri[i].setText("X");
        }
    }

    public void test(){
        Map<Integer, Integer> conteggio = new HashMap<>();

        for (int num : numeri) {
            conteggio.put(num, conteggio.getOrDefault(num, 0) + 1);
        }

        int punti = 0;
        for (int count : conteggio.values()) {
            if (count == 2) {
                punti += 10;
            } else if (count == 3) {
                punti += 25;
            } else if (count == 4) {
                punti += 50;
            }
        }

        punteggio += punti;

        tvPunteggio.setText("" + punteggio);

        if (punti > 0) {
            lampeggiaSfondo();
        }
        click=0;
    }

    private void lampeggiaSfondo() {
        final RelativeLayout layout = findViewById(R.id.main);
        final Handler handler = new Handler();
        final int[] count = {0};

        Runnable flash = new Runnable() {
            @Override
            public void run() {
                if (count[0] < 6) {
                    if (count[0] % 2 == 0) {
                        layout.setBackgroundColor(Color.GREEN);
                    } else {
                        layout.setBackgroundColor(Color.WHITE);}
                    count[0]++;
                    handler.postDelayed(this, 300);
                }
            }
        };

        handler.post(flash);
    }

}