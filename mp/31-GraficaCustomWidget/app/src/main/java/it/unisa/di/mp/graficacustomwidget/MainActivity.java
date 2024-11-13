package it.unisa.di.mp.graficacustomwidget;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		LinearLayout container = (LinearLayout) findViewById(R.id.container);
		
		CustomWidget cw1, cw2, cw3, cw4;
		cw1 = new CustomWidget(getApplicationContext(),100,100, Color.RED,111);
		cw2 = new CustomWidget(getApplicationContext(),200,200, Color.GREEN,222);
		cw3 = new CustomWidget(getApplicationContext(),300,200, Color.MAGENTA, 333);
		cw4 = new CustomWidget(getApplicationContext(),300,400, Color.LTGRAY, 333);

		container.addView(cw1);
	    container.addView(cw2);
		container.addView(cw3);
		container.addView(cw4);
	}
}
