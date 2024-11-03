package it.unisa.di.mp.frammenticitazioni;


import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;


public class Citazione extends Fragment implements View.OnClickListener {

    private TextView quoteView = null;
    private TextView authorView = null;
    private int current_index = -1;
    private int quoteArrLen = 0;
    String[] authors;
    String[] quotes;
    Button myBackButton;
    Activity hostingActivity;

    public Citazione() {
        //Required empty public constructor
    }

    private void log(String str) {
        Log.d("MYDEBUG", "QUOTE: " + str);
    }

    public int getShownIndex() {
        return current_index;
    }

    public void showIndex(int newIndex, int mode) {
        if (myBackButton != null && mode ==2) myBackButton.setVisibility(View.INVISIBLE);
        if (newIndex < 0 || newIndex >= quoteArrLen)
            return;
        current_index = newIndex;
        authorView.setText(authors[current_index]);
        quoteView.setText(quotes[current_index]);
    }

    @Override
    public void onAttach(Activity a) {
        super.onAttach(a);
        log("onAttach");
        current_index = -1;
        hostingActivity = a;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        log("onCreateView");
        View myView =  inflater.inflate(R.layout.quote_layout, container, false);
        myBackButton = myView.findViewById(R.id.myBackButton);
        myBackButton.setOnClickListener(this);
        return myView;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        log("onCreate");
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
    public void onDestroy() {
        super.onDestroy();
        log("onDestroy");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        log("onDestroyView");
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        log("onActivityCreated");
        quoteView = (TextView) getActivity().findViewById(R.id.quoteView);
        authorView = (TextView) getActivity().findViewById(R.id.authorName);
        authors = getResources().getStringArray(R.array.Authors);
        quotes = getResources().getStringArray(R.array.Quotes);
        quoteArrLen = quotes.length;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        log("onDetach");
        current_index = -1;
    }

    @Override
    public void onClick(View v) {
        log("CLICK!!! in frammento");
        hostingActivity.onBackPressed();
    }
}
