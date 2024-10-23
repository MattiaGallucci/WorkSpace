package it.unisa.di.approidlab.threadsi;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends Activity {
    private ImageView imageView;
    private Bitmap bmap;
    private TextView counterTextView;
    private int index = 1;
    private int counter = 0;
    ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        imageView = (ImageView) findViewById(R.id.imageView);
        counterTextView = (TextView) findViewById(R.id.counterTextView);
        pb = findViewById(R.id.progressBar_cyclic);

    }


    public void loadButtonPressed(View v) {
        pb.setVisibility(ProgressBar.VISIBLE);
        new Thread(new Runnable() {
            @Override
            public void run() {
                /* Ritardo di 8 secondi */
                try {
                    Thread.sleep(8000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                /* procediamo */
                bmap = null;
                switch (index) {
                    case 1:
                        bmap = BitmapFactory.decodeResource(getResources(), R.drawable.image1);
                        index = 2;
                        break;
                    case 2:
                        bmap = BitmapFactory.decodeResource(getResources(), R.drawable.image2);
                        index = 3;
                        break;
                    case 3:
                        bmap = BitmapFactory.decodeResource(getResources(), R.drawable.image3);
                        index = 1;
                        break;
                }

                /* Non possiamo interagire con l'interfaccia grafica nel thread
                 * la seguente istruzione causa un errore
                 */
                //imageView.setImageBitmap(bmap);

                /*Visualizziamo l'immagine nel main thread usando il metodo post*/


                imageView.post(new Runnable() {
                    @Override
                    public void run() {
                        pb.setVisibility(ProgressBar.INVISIBLE);
                        imageView.setImageBitmap(bmap);
                        counter++;
                        counterTextView.setText("" + counter);
                    }

                });

                /* In alternativa si può usare runOnUiThread*/

				/*
				MainActivity.this.runOnUiThread(new Runnable() {
					@Override
					public void run() {
						pb.setVisibility(ProgressBar.INVISIBLE);
						imageView.setImageBitmap(bmap);
					}
				});
				*/


            }
        }).start();
    }

    public void counterButtonPressed(View v) {
        counter++;
        counterTextView.setText("" + counter);
    }
}
