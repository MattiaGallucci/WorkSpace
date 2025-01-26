package com.example.graficamultitouch;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends Activity {
    public static final String TAG = "DEBUG";
    private Map<Integer, CircleTouch> hashMap = new HashMap<Integer, CircleTouch>();

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        final FrameLayout main_window = (FrameLayout) findViewById(R.id.container);

/*
		CircleTouch ct = new CircleTouch(getApplicationContext(), 7);
		main_window.addView(ct);
		ct.setNewCoordinates(480,580);
		ct.setSize(250);
		ct.invalidate();

		ct = new CircleTouch(getApplicationContext(), 1);
		main_window.addView(ct);
		ct.setNewCoordinates(200,250);
		ct.setSize(50);
		ct.invalidate();

		ct = new CircleTouch(getApplicationContext(), 2);
		main_window.addView(ct);
		ct.setNewCoordinates(60,300);
		ct.setSize(50);
		ct.invalidate();

		ct = new CircleTouch(getApplicationContext(), 3);
		main_window.addView(ct);
		ct.setNewCoordinates(250,80);
		ct.setSize(50);
		ct.invalidate();
		*/

//        /*
        main_window.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int pointer_index;
                int pointer_id;
                CircleTouch ct;

                switch (event.getActionMasked()) {
                    case MotionEvent.ACTION_DOWN:
                    case MotionEvent.ACTION_POINTER_DOWN:
                        pointer_index = event.getActionIndex();
                        pointer_id = event.getPointerId(pointer_index);
                        Log.d(TAG,"Action down: index="+pointer_index+"  ID="+pointer_id);
                        if (hashMap.containsKey(pointer_id)) {
                            //In realtà questo caso non si verifica mai, in quanto gli oggetti CircleTouch vengono
                            //cancellati dall'hashMap con gli eventi ACTION_UP/ACTION_POINTER_UP
                            //quindi potrebbe anche essere omesso
                            //Lo lascio per una eventuale soluzione alternativa che non cancelli gli oggetti
                            //CircleTouch dalla hashMap
                            ct = hashMap.get(pointer_id);
                            Log.d(TAG,"AAAAA Ct ("+pointer_id+") already in hashMap");
                            Log.d(TAG,"Found ct ID="+pointer_id);
                        }
                        else {
                            ct = new CircleTouch(getApplicationContext(), pointer_id);
                            hashMap.put(pointer_id, ct);
                            Log.d(TAG,"AAAAA Creating new ct ("+pointer_id+") and inserting it into hashMap");
                            main_window.addView(ct);
                        }
                        Log.d(TAG,"ct="+ct.toString());
                        ct.setNewCoordinates(event.getX(pointer_index),event.getY(pointer_index));
                        ct.setSize(50);
                        ct.invalidate();
                        break;


                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_POINTER_UP:
                        pointer_index = event.getActionIndex();
                        pointer_id = event.getPointerId(pointer_index);
                        Log.d(TAG,"Action up: index="+pointer_index+"  ID="+pointer_id);
                        if (hashMap.containsKey(pointer_id)) {
                            ct = hashMap.get(pointer_id);
                            Log.d(TAG,"Found ct ID="+pointer_id);
                            ct.setSize(0);
                            ct.invalidate();
                            main_window.removeView(ct);
                            Log.d(TAG,"AAAAA Removing ct ("+pointer_id+") from hashMap");
                            hashMap.remove(pointer_id);
                        }
                        break;

                    case MotionEvent.ACTION_MOVE: {
                        Log.d(TAG,"Action Move");
                        for (int i = 0; i < event.getPointerCount(); i++) {
                            pointer_id = event.getPointerId(i);
                            Log.d(TAG,"  index="+i+"  ID="+pointer_id);
                            ct = hashMap.get(pointer_id);
                            if (null != ct) {
                                ct.setNewCoordinates(event.getX(i),event.getY(i));
                                ct.invalidate();
                            }
                        }
                    }

                    break;
                }
                return true;
            }
        });
//		*/
    }

}