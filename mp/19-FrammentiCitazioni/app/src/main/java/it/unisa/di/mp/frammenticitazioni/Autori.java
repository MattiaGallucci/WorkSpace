package it.unisa.di.mp.frammenticitazioni;


import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class Autori extends ListFragment {

    AuthorSelectionListener listener = null;
    int current_selection = -1;
    String[] authors;

    public interface AuthorSelectionListener {
        public void onAuthorSelection(int index);
    }

    private void log(String str) {
        Log.d("MYDEBUG", "AUTORI: " + str);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        log("onAttach");
        try {
            listener = (AuthorSelectionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement AuthorSelectionListener");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        log("onCreate");
        authors = getResources().getStringArray(R.array.Authors);
        //setHasOptionsMenu(true);
        //setRetainInstance(true);
    }

    @Override
    public void onActivityCreated(Bundle savedState) {
        super.onActivityCreated(savedState);
        log("onActivityCreated");

        setListAdapter(new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, authors));
        if (current_selection != -1) {
            setSelection(current_selection);
            log("calling setSelection");
        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int pos, long id) {
        current_selection = pos;
        getListView().setItemChecked(pos, true);
        listener.onAuthorSelection(pos);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        log("onDetach");
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
}
