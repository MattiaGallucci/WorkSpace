package it.unisa.di.mp.frammenticitazioni;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Point;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;


public class MainActivity extends Activity implements Autori.AuthorSelectionListener {

    private FragmentManager fm;

    private final Autori authorsFragment = new Autori();
    private final Citazione quoteFragment = new Citazione();

    private int MODE = 0;

    private void log(String str) {
        Log.d("MYDEBUG", "MAIN: " + str);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        log("onCreate");

        Display display = getWindowManager().getDefaultDisplay();
        //Dimensione display, in pixel reali
        Point size = new Point();
        display.getSize(size);
        int screenw_px = size.x;
        int screenh_px = size.y;
        //Densità
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        float screen_density = metrics.density;
        //Dimensioni in dip
        int screenw_dp = (int) (screenw_px / screen_density);
        int screenh_dp = (int) (screenh_px / screen_density);
        //Dimensioni in cm
        float screenw_cm = 2.54f * screenw_dp / 160;
        float screenh_cm = 2.54f * screenh_dp / 160;

        log("Display size --- w=" + screenw_px + "px   h=" + screenh_px);
        log("Display size --- w=" + screenw_cm + "cm   h=" + screenh_cm);


        if (screenw_px < screenh_px) {
            MODE = 1; //portrait
            setContentView(R.layout.main1);
        } else {
            MODE = 2; //landscape
            setContentView(R.layout.main2);
            FrameLayout fla = (FrameLayout) findViewById(R.id.author_fragment_container);
            fla.getLayoutParams().width = (int)(screenw_px*0.30);
            FrameLayout flq = (FrameLayout) findViewById(R.id.quote_fragment_container);
            flq.getLayoutParams().width = (int)(screenw_px*0.70);
        }
        log("MODE=" + MODE);


        fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        switch (MODE) {
            case 1:
                ft.replace(R.id.fragment_container, authorsFragment);
                log("INIT MODE 1 - Adding authors fragment");
                break;
            case 2:
                ft.replace(R.id.author_fragment_container, authorsFragment);
                ft.replace(R.id.quote_fragment_container, quoteFragment);
                log("INIT MODE 2 - Adding authors and quote fragments");
        }
        //non mettiamo la transazione nel backstack perchè sostituisce lo screen iniziale
        //e quindi vogliamo uscire dall'app se si preme il pulsante di back
        //ft.addToBackStack(null);
        ft.commit();
        fm.executePendingTransactions();
    }


    @Override
    protected void onStart() {
        super.onStart();
        log("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        log("onResume");
        quoteFragment.showIndex(-1,MODE);
    }

    @Override
    protected void onPause() {
        super.onPause();
        log("onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        log("onStop");
    }

    @Override
    public void onAuthorSelection(int index) {
        log("onListSelection index=" + index);

        switch (MODE) {
            case 1:
                FragmentTransaction ft = fm.beginTransaction();
                ft.remove(authorsFragment);
                ft.add(R.id.fragment_container, quoteFragment);
                //addToBackStack per entrambi i cambiamenti che vengono
                //così considerati come una sola transizione. Il pulsante back
                //ripristinerà lo stato precedente i due cambiamenti
                //ft.addToBackStack(null);
                ft.commit();
                //Per essere sicuri che il frammento sia effettivamente
                //presente per la chiamata showIndex
                fm.executePendingTransactions();
                break;
            case 2:
        }
        quoteFragment.showIndex(index,MODE);
    }
}