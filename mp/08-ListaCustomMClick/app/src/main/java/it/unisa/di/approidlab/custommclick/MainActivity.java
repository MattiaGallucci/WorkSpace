package it.unisa.di.approidlab.custommclick;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity {
	public ListView listView;
	CustomAdapter customAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		String[] nomi = {"Pasquale","Maria","Michele","Antonella", "Vincenzo",
				"Teresa", "Roberto", "Rossella", "Antonio", "Luca", "Liliana", "Stefania",
				"Francesca", "Andrea", "Marco", "Elisa", "Anna", "Lorenzo"};
	
        
		listView = (ListView)findViewById(R.id.mylistview);
		
		customAdapter = new CustomAdapter(this, R.layout.list_element, new ArrayList<Contatto>());

        listView.setAdapter(customAdapter);


        for (int i=0; i<nomi.length; i++) {
        	Contatto c = new Contatto(
        			nomi[i],
        			"111-2222-333",
        			getResources().getDrawable(R.drawable.faceplaceholder));
        	customAdapter.add(c);
        }


/*		listView.setOnItemClickListener(new OnItemClickListener() {
			 
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              String  str  = listView.getItemAtPosition(position).toString();
              // Show Toast 
              Toast.makeText(getApplicationContext(),
                "Click su posizione n."+position+": " +str, Toast.LENGTH_LONG)
                .show();
            }
       }); 
*/

	}

	public void onPictureClick(View v) {
		Log.d("DEBUG","Picture has been clicked: position="+v.getTag());
		int position = Integer.parseInt(v.getTag().toString());
		Contatto c = customAdapter.getItem(position);
	    Toast.makeText(getApplicationContext(),
	                "Click su Foto - posizione n."+position+": " +c.getName(), Toast.LENGTH_LONG)
	                .show();
	}

	public void onNameClick(View v) {
		Log.d("DEBUG","Name has been clicked position="+v.getTag());
		int position = Integer.parseInt(v.getTag().toString());
		Contatto c = customAdapter.getItem(position);
	    Toast.makeText(getApplicationContext(),
	                "Click su Nome - posizione n."+position+": " +c.getName(), Toast.LENGTH_LONG)
	                .show();
	}

	public void onTelClick(View v) {
		Log.d("DEBUG","Tel has been clicked position="+v.getTag());
		int position = Integer.parseInt(v.getTag().toString());
		Contatto c = customAdapter.getItem(position);
	    Toast.makeText(getApplicationContext(),
	                "Click su Tel - posizione n."+position+": " +c.getName(), Toast.LENGTH_LONG)
	                .show();	}

}
