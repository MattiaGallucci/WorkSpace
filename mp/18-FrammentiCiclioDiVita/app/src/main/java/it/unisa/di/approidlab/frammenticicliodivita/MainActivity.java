package it.unisa.di.approidlab.frammenticicliodivita;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends Activity {

    private void log(String str) {
        Log.d("MYDEBUG", "Main: " + str);
    }

    FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fm = getFragmentManager();
        log("onCreate");
    }

    public void pulsanteInserisciApremuto(View v) {
        FrammentoA f = new FrammentoA();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.contenitoreFrammenti,f,"tagFrammentoA");
        ft.commit();
    }

    public void pulsanteInserisciBpremuto(View v) {
        FrammentoB f = new FrammentoB();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.contenitoreFrammenti,f,"tagFrammentoB");
        ft.commit();
    }

    public void pulsanteRimuoviApremuto(View v) {
        Fragment f = fm.findFragmentByTag("tagFrammentoA");
        FragmentTransaction ft = fm.beginTransaction();
        if (f != null) {
            ft.remove(f);
        }
        ft.commit();
    }

    public void pulsanteRimuoviBpremuto(View v) {
        Fragment f = fm.findFragmentByTag("tagFrammentoB");
        FragmentTransaction ft = fm.beginTransaction();
        if (f != null) {
            ft.remove(f);
        }
        ft.commit();
    }

    public void pulsantedaAaBpremuto(View v) {
        FragmentTransaction ft = fm.beginTransaction();
        FrammentoB f = new FrammentoB();
        ft.replace(R.id.contenitoreFrammenti,f,"tagFrammentoB");
        ft.commit();
    }

    public void pulsantedaBaApremuto(View v) {
        FragmentTransaction ft = fm.beginTransaction();
        FrammentoA f = new FrammentoA();
        ft.replace(R.id.contenitoreFrammenti,f,"tagFrammentoA");
        ft.commit();
    }

    public void pulsanteAttachApremuto(View v) {
        Fragment f = fm.findFragmentByTag("tagFrammentoA");
        if (f != null) {
            FragmentTransaction ft = fm.beginTransaction();
            ft.attach(f);
            ft.commit();
        }
    }

    public void pulsanteDetachApremuto(View v) {
        Fragment f = fm.findFragmentByTag("tagFrammentoA");
        if (f != null) {
            FragmentTransaction ft = fm.beginTransaction();
            ft.detach(f);
            ft.commit();
        }
    }

}
