package it.unisa.di.approidlab.graficacanvas;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

public class Pentagramma extends View {
		int MARGIN_TOP= 50;
		int MARGIN_H= 40;
		int NOTEHEAD_SIZE = 12;
		int LINE_SPACING = (int)(NOTEHEAD_SIZE*1.8);
		int STEM_LENGTH = NOTEHEAD_SIZE*6;
		
		ArrayList<Nota> notesList = new ArrayList<Nota>(); 
				
		public Pentagramma(Context c, int screen_w, int screen_h) {
			super(c);
			setMinimumWidth(screen_w);
			setMinimumHeight(150);
			Nota nota = new Nota(100,78);
			notesList.add(nota);
		}

		public void aggiungiNota(int h, int v) {
			Nota nota = new Nota(h,v);
			notesList.add(nota);
		}
		
		@Override
		protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
			int widthMode = MeasureSpec.getMode(widthMeasureSpec);
		    int width = MeasureSpec.getSize(widthMeasureSpec);
		    int heightMode = MeasureSpec.getMode(heightMeasureSpec);
		    int height = MeasureSpec.getSize(heightMeasureSpec);
			Log.d("DEBUG","onMeasure w="+width+"  h="+height);
			
			if (widthMode == MeasureSpec.EXACTLY) {
				Log.d("DEBUG","        width mode EXACTLY");
			} else if (widthMode == MeasureSpec.AT_MOST) {
				Log.d("DEBUG","        width mode AT MOST");
			} else {
			    Log.d("DEBUG","        width mode ... A PIACERE!!");
			}	

			if (heightMode == MeasureSpec.EXACTLY) {
				Log.d("DEBUG","        width mode EXACTLY");
			} else if (heightMode == MeasureSpec.AT_MOST) {
				Log.d("DEBUG","        width mode AT MOST");
			} else {
			    Log.d("DEBUG","        width mode ... A PIACERE!!");
			}	

			setMeasuredDimension(getSuggestedMinimumWidth(),getSuggestedMinimumHeight());
		}

		@Override
		protected void onLayout(boolean b, int x1, int y1, int x2, int y2) {
			Log.d("DEBUG","onLayout coordinate x1="+x1+" y1="+y1+"  x2="+x2+"  y2="+y2);
			setMeasuredDimension(getSuggestedMinimumWidth(),getSuggestedMinimumHeight());
		}

		@Override
		protected void onDraw(Canvas canvas) {
			Log.d("DEBUG", "onDraw, canvas.h=" + canvas.getHeight() + "  w=" + canvas.getWidth());

			//Diesgna la nota

			Paint paint = new Paint();
			paint.setColor(Color.BLACK);
			int h = MARGIN_TOP;
			int x_start = MARGIN_H;
			int x_end = canvas.getWidth() - MARGIN_H;
			for (int i = 0; i < 5; i++) {
				canvas.drawLine(x_start, h, x_end, h, paint);
				h = h + LINE_SPACING;
			}


			for (int i = 0; i < notesList.size(); i++) {
				Nota n = notesList.get(i);
				int note_position_horizzontal = n.getH();
				int note_position_vertical = n.getV();
				canvas.drawCircle(note_position_horizzontal, note_position_vertical, NOTEHEAD_SIZE, paint);
				canvas.drawLine(note_position_horizzontal + NOTEHEAD_SIZE/2, note_position_vertical - STEM_LENGTH,
						note_position_horizzontal + NOTEHEAD_SIZE/2, note_position_vertical, paint);

			}
		}

		public class Nota {
			int h;
			int v;
			
			public Nota(int h, int v) {
				this.h = h;
				this.v = v;
			}
			
			public int getH() {
				return h;
			}
		
			public int getV() {
				return v;
			}
		}
}
