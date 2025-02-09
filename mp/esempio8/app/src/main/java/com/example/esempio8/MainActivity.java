package com.example.esempio8;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    String[] nomi = new String[15];
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.lv);

        for (int i = 0; i < nomi.length; i++) {
            int x=i;
            x++;

            if(i<9)
                nomi[i] = "img0" + x;
            else
                nomi[i] = "img" + x;
        }

        adapter = new ArrayAdapter<>(this, R.layout.list_element, R.id.tv, nomi);

        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getApplicationContext(), Immagine.class);
                i.putExtra("posizione", position);
                startActivity(i);
            }
        });
    }
}