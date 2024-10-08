package it.unisa.di.approidlab.semplice;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
    public ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String [] array = {"Pasquale","Maria","Michele","Antonella", "Vincenzo",
                "Teresa", "Roberto", "Rossella", "Antonio", "Luca", "Liliana", "Stefania",
                "Francesca", "Andrea", "Marco", "Elisa", "Anna", "Lorenzo"};

        listView = findViewById(R.id.mylistview);

        Log.d("DEBUG","ListView create: listView="+listView);

        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this, R.layout.list_element, R.id.textViewList,  array);

        Log.d("DEBUG","ArrayAdapter create: arrayAdapter="+arrayAdapter);

        listView.setAdapter(arrayAdapter);

        Log.d("DEBUG","Done!");

        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String  str  = listView.getItemAtPosition(position).toString();
                // Show Toast
                Toast.makeText(getApplicationContext(),
                        "Click su posizione n."+position+": " +str, Toast.LENGTH_LONG)
                        .show();
            }
        });
    }

}