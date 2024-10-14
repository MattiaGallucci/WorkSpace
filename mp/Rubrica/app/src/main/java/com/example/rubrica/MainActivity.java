package com.example.rubrica;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public ListView listView;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] nomi = {"Pasquale","Maria","Michele","Antonella", "Vincenzo",
                "Teresa", "Roberto", "Rossella", "Antonio", "Luca", "Liliana", "Stefania",
                "Francesca", "Andrea", "Marco", "Elisa", "Anna", "Lorenzo"};

        listView = (ListView) findViewById(R.id.myLV);
        customAdapter = new CustomAdapter(this, R.layout.list_element, new ArrayList<>());
        listView.setAdapter(customAdapter);

        for (int i=0; i<nomi.length; i++) {
            Contatto c = new Contatto(
                    nomi[i],
                    "111-2222-333",
                    getResources().getDrawable(R.drawable.faceplaceholder));
            customAdapter.add(c);
        }
    }

    public void onNomeClicked(View v){
        int position = Integer.parseInt(v.getTag().toString());
        Contatto c = customAdapter.getItem(position);
        Toast.makeText(this, c.getNome(), Toast.LENGTH_SHORT).show();
    }

    public void onTelClicked(View v) {
        int position = Integer.parseInt(v.getTag().toString());
        Contatto c = customAdapter.getItem(position);
        Toast.makeText(this, c.getNumero(), Toast.LENGTH_SHORT).show();
    }

    public void onFotoClicked(View v) {
        int position = Integer.parseInt(v.getTag().toString());
        Contatto c = customAdapter.getItem(position);
        // Assuming 'getFoto()' returns a Drawable:
        // You might want to display the image in a larger view or perform other actions
        // For now, we'll just show a Toast with a message
        Toast.makeText(this, "Foto clicked for: " + c.getNome(), Toast.LENGTH_SHORT).show();
    }


}