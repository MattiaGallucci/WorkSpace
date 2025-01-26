package com.example.graficagestureflip;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class MainActivity extends Activity {
    private ViewFlipper view_flipper;
    private TextView text_view_1, text_view_2;
    private int counter, current_view;
    private GestureDetector gesture_detector;
    private enum Direction {DECREASE, INCREASE};
    private Animation in_from_left, in_from_right, out_to_left, out_to_right;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        view_flipper = (ViewFlipper) findViewById(R.id.view_flipper);
        text_view_1 = (TextView) findViewById(R.id.textView1);
        text_view_2 = (TextView) findViewById(R.id.textView2);

        in_from_right = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.in_from_right);
        out_to_left   = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.out_to_left);
        in_from_left = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.in_from_left);
        out_to_right   = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.out_to_right);

        counter = 0;
        text_view_1.setText(String.valueOf(counter));
        current_view = 1;

        gesture_detector = new GestureDetector(this,
                new GestureDetector.SimpleOnGestureListener() {
                    @Override
                    public boolean onFling(MotionEvent e1, MotionEvent e2, float velx, float vely) {
                        if (velx < -30) {
                            switchFlipperViews(Direction.INCREASE);
                        }
                        if (velx > 30) {
                            switchFlipperViews(Direction.DECREASE);
                        }
                        return true;
                    }
                });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gesture_detector.onTouchEvent(event);
    }

    public void switchFlipperViews(Direction d) {

        switch(d) {
            case INCREASE: counter++;
                view_flipper.setInAnimation(in_from_right);
                view_flipper.setOutAnimation(out_to_left);
                break;
            case DECREASE: counter--;
                view_flipper.setInAnimation(in_from_left);
                view_flipper.setOutAnimation(out_to_right);
                break;
        }

        switch(current_view) {
            case 1:	text_view_2.setText(String.valueOf(counter));
                current_view = 2;
                break;
            case 2:	text_view_1.setText(String.valueOf(counter));
                current_view = 1;
                break;
        }

        Log.d("DEBUG","TextView1: "+text_view_1.getText());
        Log.d("DEBUG","TextView2: "+text_view_2.getText());
        Log.d("DEBUG","current_view = "+current_view);
        view_flipper.showNext();
    }
}