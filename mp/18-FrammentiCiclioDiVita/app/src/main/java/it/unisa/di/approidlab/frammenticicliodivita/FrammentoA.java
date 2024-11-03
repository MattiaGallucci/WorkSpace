package it.unisa.di.approidlab.frammenticicliodivita;


import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class FrammentoA extends Fragment {

    private void log(String str) {
        Log.d("MYDEBUG","FrammentoA: "+str);
    }


    public FrammentoA() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Activity a) {
        super.onAttach(a);
        log("onAttach");
    }


    @Override
    public void onCreate(Bundle s) {
        super.onCreate(s);
        log("onCreate");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        log("onCreateView");
        View v = inflater.inflate(R.layout.frammento_a, container, false);
        return v;
    }

    @Override
    public void onActivityCreated(Bundle s) {
        super.onActivityCreated(s);
        log("onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        log("onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        log("onResume");
    }

    @Override
    public void onStop() {
        super.onStop();
        log("onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        log("onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        log("onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        log("onDetach");
    }
}
