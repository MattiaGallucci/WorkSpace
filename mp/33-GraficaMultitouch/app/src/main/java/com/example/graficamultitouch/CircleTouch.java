package com.example.graficamultitouch;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.view.View;

public class CircleTouch extends View {
	    private int id;
	    private float x, y;
	    private int size;
	    
	    private final int STROKE_SIZE = 10;
	
		private Paint fill;
		private Paint stroke;
		private Paint text;

		public CircleTouch(Context c, int id) {
			super(c);
			this.id = id;
			this.x = 0;
			this.y = 0;
			this.size = 0;
			stroke = new Paint();
			stroke.setStyle(Style.STROKE);
			stroke.setARGB(128, 255, 0, 0);
			stroke.setStrokeWidth(STROKE_SIZE);
			fill = new Paint();
			fill.setStyle(Style.FILL);
			fill.setARGB(128, 0, 255, 0);
			text = new Paint();
			text.setColor(Color.BLACK);
			text.setTextSize(64);
			
		}
		
		public void setNewCoordinates(float x, float y) {
			this.x = x;
			this.y = y;
		}
		
		public void setSize(int size) {
			this.size = size;
		}
		
		@Override
		protected void onDraw(Canvas canvas) {
			canvas.drawCircle(x, y, size, fill);
			canvas.drawCircle(x, y, size, stroke);
			canvas.drawText(""+id, x-20, y+20, text);
		}
}
