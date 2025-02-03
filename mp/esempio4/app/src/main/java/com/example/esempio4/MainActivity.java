package com.example.esempio4;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView tentativi, parola;
    EditText et;

    int count = 0;

    String[] parole = {"AUTOSTRADA", "MATTIA", "CHICCA"};
    String str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tentativi = findViewById(R.id.tentativi);
        parola = findViewById(R.id.parola);
        et = findViewById(R.id.et);

        str = parole[(int)(Math.random() * parole.length)];

        parola.setText(scrivi(str, '_'));
    }

    public void prova(View view){
        char c = et.getText().charAt(0);
        count++;
        tentativi.setText("Tentativi: " + count);
        parola.setText(scrivi(str, c));
    }

    public String scrivi(String parola, char c){
        String str = " ";
        if(c == '_'){
            for(int i = 0; i < parola.length(); i++) {
                str += c;
                str += " ";
            }
        }
        else{
            for(int i = 0; i < parola.length(); i++) {
                if (parola.charAt(i) == c) {
                    str += c;
                    str += " ";
                }
                else{
                    str += "_";
                    str += " ";
                }
            }
        }
        return str;
    }
}