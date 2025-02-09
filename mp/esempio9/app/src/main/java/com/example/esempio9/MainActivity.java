package com.example.esempio9;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText et;
    int grandezza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = findViewById(R.id.et);

    }

    public void gioca(View view) {
        grandezza = Integer.parseInt(et.getText().toString());
        Intent i = new Intent(this, Gioco.class);
        i.putExtra("grandezza", grandezza);
        startActivity(i);
    }
}