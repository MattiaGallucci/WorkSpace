package it.unisa.mp.customcontentprovider;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private EditText eTVname, eTVvoto, eTVid;
    private MyDBAdapter myDBAdapter;

    public ListView lvSelectResult;
    ArrayList<String> strArrayList  = new ArrayList<>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("DEBUG","BASE DIR="+ContentResolver.CURSOR_DIR_BASE_TYPE);

        myDBAdapter = MyDBAdapter.getCustomDBAdapterInstance(getApplicationContext());

        eTVname = findViewById(R.id.eTVname);
        eTVvoto = findViewById(R.id.eTVvoto);
        eTVid = findViewById(R.id.eTVid);

        lvSelectResult =findViewById(R.id.lvSelectResult);

        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, strArrayList);

        lvSelectResult.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateListView();
    }

    private void updateListView(){
        Cursor cursor = myDBAdapter.getSelectAll();
        strArrayList.clear();
        if(cursor!=null && cursor.getCount()>0){
            while(cursor.moveToNext()){
                String str = cursor.getLong(0)+", "+cursor.getString(1)+", "+cursor.getString(2);
                strArrayList.add(str);
            }
        }
        if (cursor!=null) cursor.close();
        for (String str:strArrayList) { Log.d("DEBUG","str="+str); }
        adapter.notifyDataSetChanged();
    }

    public void insertClicked(View v){
        myDBAdapter.insert(eTVname.getText().toString(), eTVvoto.getText().toString());
        updateListView();
    }

    public void removeClicked(View v){
        myDBAdapter.delete(Integer.parseInt(eTVid.getText().toString()));
        updateListView();
    }

}
