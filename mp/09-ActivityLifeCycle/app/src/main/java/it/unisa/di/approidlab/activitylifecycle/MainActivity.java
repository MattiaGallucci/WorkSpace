package it.unisa.di.approidlab.activitylifecycle;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity {
	ListView listView;
	TextView counterTextView;
	EditText et;
	String str;
	ArrayList<String> array = new ArrayList<String>();
	ArrayAdapter<String> arrayAdapter;
	int counter = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);		
		Log.d("LIFECYCLE","onCreate()");
		setContentView(R.layout.activity_main);

		if (savedInstanceState != null) {
			Log.d("LIFECYCLE","-- Retrieving saved instance state");
			array = savedInstanceState.getStringArrayList("LISTA_CHIAMATE");
			counter = savedInstanceState.getInt("COUNTER");
			counter++;
			str = savedInstanceState.getString("EDIT_TEXT");
		}

		
		listView = (ListView)findViewById(R.id.lits_of_calls);
		counterTextView = (TextView)findViewById(R.id.counter_text_view);
		et = findViewById(R.id.et);
		et.setText(str);

		arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1,  array);
		listView.setAdapter(arrayAdapter);
		
		addString("ciao eseguo onCreate() - text in edit text:"+et.getText());

		}
	
	private void addString(String str) {
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
		counterTextView.setText("Counter: "+counter);
		arrayAdapter.notifyDataSetChanged();
	}
	


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
	    savedInstanceState.putStringArrayList("LISTA_CHIAMATE", array);
	    savedInstanceState.putInt("COUNTER", counter);
	    //str = et. getText().toString();
	    //savedInstanceState.putString("EDIT_TEXT",str);
		Log.d("LIFECYCLE","-- onSaveInstanceState()");
	    // Always call the superclass so it can save the view hierarchy state
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

	/*
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);

		addString("onConfigurationChanged()");
		// Checks the orientation of the screen
		if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
			Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();
		} else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
			Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show();
		}
	}
	*/

}
