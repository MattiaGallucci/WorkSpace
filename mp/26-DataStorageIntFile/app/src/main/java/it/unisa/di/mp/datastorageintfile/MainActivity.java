package it.unisa.di.mp.datastorageintfile;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends Activity {
	EditText filename;
	EditText sourcetext;
	TextView path;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		//Size
		Point size = new Point();
		getWindowManager().getDefaultDisplay().getSize(size);
		int screenw_px = size.x;
		//Densità
		DisplayMetrics metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);
		float density = metrics.density;

		int textSize = (int)(screenw_px/(10*density));


		filename = (EditText) findViewById(R.id.textFileName);
		sourcetext = (EditText) findViewById(R.id.textEditor);
		path = (TextView) findViewById(R.id.textFilePath);
		
		filename.setTextSize(textSize);
		sourcetext.setTextSize(textSize);
		path.setTextSize(textSize);
		
		path.setText("Path: "+getApplicationContext().getFilesDir().toString());
	}
	
	
	public void buttonReset(View v) {
		sourcetext.setText("");
	}
	
	public void buttonSave(View v) {
		String str = filename.getText().toString();
		FileOutputStream fos = null;
		try {
			fos = openFileOutput(str, Context.MODE_PRIVATE);
			fos.write(sourcetext.getText().toString().getBytes());
			fos.close();
			Toast.makeText(getApplicationContext(),
					"File "+str+" saved!", Toast.LENGTH_SHORT).show();
		}
		catch (FileNotFoundException e) {
			Toast.makeText(getApplicationContext(),
					"File not found!", Toast.LENGTH_SHORT).show();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void buttonLoad(View v) {
		String str = filename.getText().toString();
		FileInputStream fis = null;
		try {
			fis = openFileInput(str);
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			String line;
			String data = "";
			while (null != (line = br.readLine())) {
				data += line+"\n";
			}
			br.close();
			sourcetext.setText(data);
		}
		catch (FileNotFoundException e) {
			Toast.makeText(getApplicationContext(),
					"File "+str+" not found!", Toast.LENGTH_SHORT).show();
		}
		catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
}
