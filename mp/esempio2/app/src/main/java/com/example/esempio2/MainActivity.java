package com.example.esempio2;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText etNome, etCognome, etTelefono;
    String nome=null, cognome=null, telefono=null;

    ListView lv;
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNome = findViewById(R.id.nome);
        etCognome = findViewById(R.id.cognome);
        etTelefono = findViewById(R.id.telefono);

        adapter = new CustomAdapter(this, R.layout.list_element, new ArrayList<>());

        lv = findViewById(R.id.lv);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Persona p = adapter.getItem(position);

                adapter.remove(p);
                adapter.notifyDataSetChanged();
            }
        });
    }

    public void inserisci(View v) {
        if (etNome.getText() == null || etCognome.getText() == null || etTelefono.getText() == null)
            return;

        nome = etNome.getText().toString();
        cognome = etCognome.getText().toString();
        telefono = etTelefono.getText().toString();

        Persona p = new Persona(nome, cognome, telefono);
        adapter.add(p);
        etNome.setText("");
        etCognome.setText("");
        etTelefono.setText("");

        adapter.notifyDataSetChanged();
    }
}