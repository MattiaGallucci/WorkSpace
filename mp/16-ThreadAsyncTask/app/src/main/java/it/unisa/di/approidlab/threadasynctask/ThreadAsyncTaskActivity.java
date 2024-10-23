package it.unisa.di.approidlab.threadasynctask;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class ThreadAsyncTaskActivity extends Activity {
	private ImageView imageView;
	private Bitmap bmap;
	private ProgressBar progressBar;
	private TextView counterTextView;
	private int index = 1;
	private int counter = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_layout);
		
		imageView = (ImageView)findViewById(R.id.imageView);
		counterTextView = (TextView)findViewById(R.id.counterTextView);
		progressBar = (ProgressBar)findViewById(R.id.progressBar);

	}
	
	public void counterButtonPressed(View v) {
		counter++;
		counterTextView.setText(""+counter);
		
	}
	
	public void loadButtonPressed(View v) {
		Integer img_id = 0;
		switch(index) {
		case 1:
			img_id = R.drawable.image1;
			index = 2;
			break;
		case 2:
			img_id = R.drawable.image2;
			index = 3;
			break;
		case 3:
			img_id = R.drawable.image3;
			index = 1;
			break;
		}
		Log.d("DEBUG","increasing index:"+index);
		new LoadImageTask().execute(img_id);
	}
	

	class LoadImageTask extends AsyncTask<Integer, Integer, Bitmap> {

		@Override
		protected void onPreExecute() {
			progressBar.setVisibility(ProgressBar.VISIBLE);
		}

		@Override
		protected Bitmap doInBackground(Integer... img_ids) {
			// Load bitmap
			Log.d("DEBUG","index="+img_ids[0]);
			Bitmap tmp = BitmapFactory.decodeResource(getResources(), img_ids[0]);

			/* Simuliamo il ritardo */
			for (int i = 1; i < 11; i++) {
				sleep();
				publishProgress(i * 10);
			}
		
			return tmp;
		}

		@Override
		protected void onProgressUpdate(Integer... values) {
			progressBar.setProgress(values[0]);
			if (values[0]>75) {
				Toast.makeText(getApplicationContext(),"Stiamo per terminare", Toast.LENGTH_SHORT).show();
			}
		}

		@Override
		protected void onPostExecute(Bitmap result) {
			progressBar.setVisibility(ProgressBar.INVISIBLE);
			progressBar.setProgress(0);
			imageView.setImageBitmap(result);
		}

		private void sleep() {
			/* Ritardo di 0,5 secondi */
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
