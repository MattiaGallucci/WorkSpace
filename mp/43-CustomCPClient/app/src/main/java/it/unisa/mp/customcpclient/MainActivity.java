package it.unisa.mp.customcpclient;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends Activity implements View.OnClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    private EditText editTextVoto;
    private Button buttonGetAll, buttonGetSelected;
    private ContentResolver contentResolver;

    Uri CONTENT_URI = Uri.parse("content://it.unisa.mp.customcontentprovider/ALL_STUDENTS");

    public ListView lvSelectResult;
    ArrayList<String> strArrayList = new ArrayList<>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextVoto = (EditText) findViewById(R.id.editTextVoto);
        buttonGetAll = (Button) findViewById(R.id.buttonGetAll);
        buttonGetSelected = (Button) findViewById(R.id.buttonGetSelected);

        buttonGetAll.setOnClickListener(this);
        buttonGetSelected.setOnClickListener(this);

        contentResolver = getContentResolver();

        lvSelectResult = findViewById(R.id.lvSelectResult);

        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, strArrayList);

        lvSelectResult.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonGetAll:
                selectAllFromCP();
                break;
            case R.id.buttonGetSelected:
                break;
        }
    }

    private void selectAllFromCP() {
        Log.d("MYDEBUG", "Content resolver query");
        Cursor cursor = contentResolver.query(CONTENT_URI, null, null, null, null, null);
        Log.d("MYDEBUG", "got cursor=" + cursor);
        strArrayList.clear();
        if (cursor != null && cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                String str = cursor.getLong(0) + ", " + cursor.getString(1) + ", " + cursor.getString(2);
                strArrayList.add(str);
            }
        }
        if (cursor != null) cursor.close();
        for (String str : strArrayList) {
            Log.d("DEBUG", "str=" + str);
        }
        adapter.notifyDataSetChanged();
    }
}
