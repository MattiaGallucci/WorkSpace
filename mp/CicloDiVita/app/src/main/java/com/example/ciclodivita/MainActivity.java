package com.example.ciclodivita;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    ListView lv;
    ArrayList<String> array;
    ArrayAdapter<String> adapter;
    int counter=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState != null){
            array = savedInstanceState.getStringArrayList("LISTA_CHIAMATE");
            counter = savedInstanceState.getInt("COUNTER");
            counter++;
        }

        lv = (ListView) findViewById(R.id.myLV);
        tv = (TextView) findViewById(R.id.counter);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, array);
        lv.setAdapter(adapter);

        addString("eseguo onCreate()");
    }

    private void addString(String str){
        long time = SystemClock.elapsedRealtime();
        int secs = (int)time/1000;
        int ms = (int)(time - secs*1000);
        int mm = secs/60;
        secs = secs -(mm*60);
        int hh = (int)mm/60;
        mm = mm - hh*60;
        int gg = (int)hh/24;
        hh = hh - gg*24;
        array.add(gg+"gg:"+hh+"hh:"+mm+"mm:"+secs+"ss:"+ms+" - "+counter+": "+str);
        counter++;
        tv.setText("Counter: "+counter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putStringArrayList("LISTA_CHIAMATE", array);
        savedInstanceState.putInt("COUNTER", counter);
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LIFECYCLE","onStart()");
        addString("onStart()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("LIFECYCLE","onRestart()");
        addString("onRestart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LIFECYCLE","onResume()");
        addString("onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LIFECYCLE","onPause()");
        addString("onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LIFECYCLE","onStop()");
        addString("onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LIFECYCLE","onDestroy()");
        addString("onDestroy()");
    }

    public void onAzzeraButtonClick(View v) {
        Log.d("LIFECYCLE","-- Azzera Button clicked");
        array.clear();
        counter = 0;
        addString("onAzzeraButtonClick()");
    }

    public void onDestroyButtonClick(View v) {
        Log.d("LIFECYCLE","-- Destroy Button clicked");
        finish();
    }
}