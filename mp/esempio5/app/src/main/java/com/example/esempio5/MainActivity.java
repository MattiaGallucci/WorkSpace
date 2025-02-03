package com.example.esempio5;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    String[] array = {"Pasquale", "Maria", "Michele", "Antonella", "Vincenzo",
            "Teresa", "Roberto", "Rossella", "Antonio", "Luca", "Liliana", "Stefania",
            "Francesca", "Andrea", "Marco", "Elisa", "Anna", "Lorenzo"};

    ListView lv1;
    ListView lv2;
    Switch sw;
    ArrayAdapter<String> aa1, aa2;
    boolean mode = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv1 = (ListView) findViewById(R.id.lv1);
        lv2 = (ListView) findViewById(R.id.lv2);
        sw = (Switch) findViewById(R.id.sw);

        aa1 = new ArrayAdapter<>(getApplicationContext(), R.layout.list_element, R.id.lvElement, new ArrayList<>());
        aa2 = new ArrayAdapter<>(getApplicationContext(), R.layout.list_element, R.id.lvElement, new ArrayList<>());
        lv1.setAdapter(aa1);
        lv2.setAdapter(aa2);

        sw = (Switch) findViewById(R.id.sw);
        sw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!sw.isChecked()) {
                    lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            aa1.remove(aa1.getItem(i)); // Rimuovi l'elemento cliccato da lv1
                            aa1.notifyDataSetChanged();
                        }
                    });
                    lv2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            aa2.remove(aa2.getItem(i)); // Rimuovi l'elemento cliccato da lv1
                            aa2.notifyDataSetChanged();
                        }
                    });
                } else {
                    lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            aa2.add(aa1.getItem(i)); // Rimuovi l'elemento cliccato da lv1
                            aa2.notifyDataSetChanged();
                            aa1.remove(aa1.getItem(i)); // Rimuovi l'elemento cliccato da lv1
                            aa1.notifyDataSetChanged();
                        }
                    });
                    lv2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            aa1.add(aa2.getItem(i)); // Rimuovi l'elemento cliccato da lv1
                            aa1.notifyDataSetChanged();
                            aa2.remove(aa2.getItem(i)); // Rimuovi l'elemento cliccato da lv1
                            aa2.notifyDataSetChanged();
                        }
                    });
                }
            }
        });
    }

    public void inserisci1(View v) {
        Random r = new Random();
        aa1.add(array[r.nextInt(array.length)]);
        aa1.notifyDataSetChanged();
    }

    public void inserisci2(View v) {
        Random r = new Random();
        aa2.add(array[r.nextInt(array.length)]);
        aa2.notifyDataSetChanged();
    }
}