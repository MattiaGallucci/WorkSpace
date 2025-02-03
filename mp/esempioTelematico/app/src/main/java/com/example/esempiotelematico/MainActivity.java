package com.example.esempiotelematico;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    CustomAdapter ca;
    EditText et;
    Spinner sp;
    ArrayAdapter<String> oggetti;

    String[] nomi = {"Pasquale", "Maria", "Michele", "Antonella", "Vincenzo",
            "Teresa", "Roberto", "Rossella", "Antonio", "Luca", "Liliana", "Stefania",
            "Francesca", "Andrea", "Marco", "Elisa", "Anna", "Lorenzo"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.lv);
        ca = new CustomAdapter(this, R.layout.list_element, new ArrayList<>());
        lv.setAdapter(ca);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (which == DialogInterface.BUTTON_POSITIVE) {
                            // Remove the item at the clicked position
                            Oggetto o = ca.getItem(position);
                            ca.remove(o);
                            ca.notifyDataSetChanged();
                        } else if (which == DialogInterface.BUTTON_NEGATIVE) {
                            Toast.makeText(getApplicationContext(), "Azione annullata", Toast.LENGTH_LONG).show();
                        }
                    }
                };

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Vuoi cancellare?");
                builder.setPositiveButton("Si", dialogClickListener);
                builder.setNegativeButton("No", dialogClickListener);
                builder.show();
            }
        });

        sp = findViewById(R.id.oggetto);
        oggetti = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, nomi);
        sp.setAdapter(oggetti);

        et = findViewById(R.id.quantita);
    }

    public void inserisci(View v) {
        int quantita = Integer.parseInt(et.getText().toString());
        Oggetto o = new Oggetto(sp.getSelectedItem().toString(), quantita, getDrawable(R.drawable.faceplaceholder));

        ca.add(o);
        ca.notifyDataSetChanged();
    }
}