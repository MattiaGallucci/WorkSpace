package it.unisa.di.approidlab.graficacanvas;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
	Pentagramma pentagramma;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		FrameLayout container = (FrameLayout) findViewById(R.id.container);
		
	    //Controlla la dimensione del display
		Display display = getWindowManager().getDefaultDisplay();
		DisplayMetrics metrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metrics);	
		Point size = new Point();
		display.getSize(size);
		int screen_w = size.x;
		int screen_h = size.y;
		int dp_w = (int)(screen_w/metrics.density);
		int dp_h = (int)(screen_h/metrics.density);
		Log.d("DEBUG","Display size");
		Log.d("DEBUG","   Physical w="+screen_w+", h="+screen_h);
		Log.d("DEBUG","   Density ind. w="+dp_w+", h="+dp_h);
		
		pentagramma = new Pentagramma(getApplicationContext(), screen_w, screen_h);
		container.addView(pentagramma);
		
		final TextView coordinate = (TextView) findViewById(R.id.coordinate);
		pentagramma.setOnTouchListener(new View.OnTouchListener() {
	        @Override
	        public boolean onTouch(View v, MotionEvent event) {
	            if (event.getAction() == MotionEvent.ACTION_DOWN){
	                coordinate.setText("coordinate del click x=" +
	                        String.valueOf(event.getX()) + " y=" + String.valueOf(event.getY()));
	                int hor=(int) event.getX();
	                int ver=(int) event.getY();
	                pentagramma.aggiungiNota(hor,ver);
	                pentagramma.invalidate();

	            }
	            return true;
	        }
	    });
	}


	
	

}
