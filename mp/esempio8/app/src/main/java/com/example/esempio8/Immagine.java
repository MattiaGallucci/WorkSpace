package com.example.esempio8;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Immagine  extends AppCompatActivity {

    private ImageView imageView;
    private Bitmap bmap;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.immagine);

        imageView = (ImageView)findViewById(R.id.imageView);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);

        Intent i = getIntent();
        int pos = i.getIntExtra("posizione", 0);
        int[] imageResources = {
                R.drawable.img01, R.drawable.img02, R.drawable.img03, R.drawable.img05,
                R.drawable.img05, R.drawable.img06, R.drawable.img07, R.drawable.img08,
                R.drawable.img09, R.drawable.img10, R.drawable.img11, R.drawable.img12,
                R.drawable.img13, R.drawable.img14, R.drawable.img15
        };

        int imageResource = imageResources[pos];

        new LoadImageTask().execute(imageResource);
    }

    class LoadImageTask extends AsyncTask<Integer, Integer, Bitmap> {

        @Override
        protected void onPreExecute() {
            progressBar.setVisibility(ProgressBar.VISIBLE);
        }

        @Override
        protected Bitmap doInBackground(Integer... img_ids) {
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