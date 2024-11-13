package it.unisa.di.mp.graficacustomwidget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.Log;
import android.view.View;

public class CustomWidget extends View {
	int view_width;
	int view_height;
	int color = 0;
	int UID;
	
	public CustomWidget(Context c, int w, int h, int color, int uid) {
		super(c);
		setMinimumWidth(w);
		setMinimumHeight(h);
		view_width = w;
		view_height = h;
		this.color = color;
		this.UID = uid;
		Log.d("DEBUG","["+UID+"] creating CustomWidgetView w="+w+"   h="+h);
	}
	
	public void setColor(int color) {
		this.color = color;
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		int widthMode = MeasureSpec.getMode(widthMeasureSpec);
	    int width = MeasureSpec.getSize(widthMeasureSpec);
	    int heightMode = MeasureSpec.getMode(heightMeasureSpec);
	    int height = MeasureSpec.getSize(heightMeasureSpec);
		Log.d("DEBUG","["+UID+"] onMeasure w="+width+"  h="+height);
		
		if (widthMode == MeasureSpec.EXACTLY) {
			Log.d("DEBUG","        width mode EXACTLY");
		} else if (widthMode == MeasureSpec.AT_MOST) {
			Log.d("DEBUG","        width mode AT MOST");
		} else {
		    Log.d("DEBUG","        width mode ... A PIACERE!!");
		}	

		if (heightMode == MeasureSpec.EXACTLY) {
			Log.d("DEBUG","        height mode EXACTLY");
		} else if (heightMode == MeasureSpec.AT_MOST) {
			Log.d("DEBUG","        height mode AT MOST");
		} else {
		    Log.d("DEBUG","        height mode ... A PIACERE!!");
		}	

		setMeasuredDimension(getSuggestedMinimumWidth(),getSuggestedMinimumHeight());
	}

	@Override
	protected void onLayout(boolean b, int x1, int y1, int x2, int y2) {
		Log.d("DEBUG","["+UID+"] onLayout coordinate b="+b+"  x1="+x1+" y1="+y1+"  x2="+x2+"  y2="+y2);
		int smw = getSuggestedMinimumWidth();
		int smh = getSuggestedMinimumHeight();
		Log.d("DEBUG","onLayout smw="+smw+"   smh="+smh);
		setMeasuredDimension(smw,smh);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		Log.d("DEBUG","onDraw, canvas.h="+canvas.getHeight()+"  w="+canvas.getWidth());
		canvas.drawColor(color);
	}
}
