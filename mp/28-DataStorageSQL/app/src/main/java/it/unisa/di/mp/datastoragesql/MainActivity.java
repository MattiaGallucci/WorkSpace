package it.unisa.di.mp.datastoragesql;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class MainActivity extends Activity {
    private ListView lw;
    private ListView lw_filtered;

    private SQLiteDatabase db = null;
    private DatabaseOpenHelper dbHelper;
    private SimpleCursorAdapter adapter;
    private SimpleCursorAdapter adapterSelected;

    private EditText et_nome;
    private EditText et_voto;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("DEBUG", "DataStorageSQL - onCreate");
        setContentView(R.layout.main);

        // Create a new DatabaseHelper
        Log.d("DEBUG", "DataStorageSQL - new DBOpenHelper");
        dbHelper = new DatabaseOpenHelper(this);

        // Get the underlying database for writing
        Log.d("DEBUG", "DataStorageSQL - getting writable db");
        db = dbHelper.getWritableDatabase();

        //Cursor cursorAll = readAllEntries();
        Cursor cursorAll = db.rawQuery("SELECT * from studenti",null);
        Cursor cursorSelected = readSelectedEntries();
        //Cursor cursorSelected = db.rawQuery("SELECT * FROM studenti WHERE nome = ? and voto > ?",
        //        new String[]{"car%","25"});
        //Cursor cursorSelected = db.rawQuery("SELECT * FROM studenti WHERE nome = Car% and voto > 25",null);

        adapter = new SimpleCursorAdapter(
                getApplicationContext(),    //context
                R.layout.list_layout,       //Layout della lista
                cursorAll,                  //Il cursore con i dati del database
                DatabaseOpenHelper.columns, // String[] con i nomi  delle colonne database
                new int[]{R.id._id, R.id.name, R.id.voto}, //id dei campi nel layout
                0 //flags
        );


        adapterSelected = new SimpleCursorAdapter(
                getApplicationContext(),    //context
                R.layout.list_layout,       //Layout della lista
                cursorSelected,             //Il cursore con i dati del database
                DatabaseOpenHelper.columns, // String[] con i nomi  delle colonne database
                new int[]{R.id._id, R.id.name, R.id.voto}, //id dei campi nel layout
                0 //flags
        );

        et_nome = (EditText) findViewById(R.id.et_nome);
        et_voto = (EditText) findViewById(R.id.et_voto);

        //lw = (ListView) findViewById(android.R.id.list);
        lw = (ListView) findViewById(R.id.list_all);
        lw_filtered = (ListView) findViewById(R.id.list_filtered);

        lw.setAdapter(adapter);
        lw_filtered.setAdapter(adapterSelected);
        //setListAdapter(adapter);

        lw.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SQLiteCursor cursor = (SQLiteCursor) lw.getItemAtPosition(position);

                //Dati dell'elemento cliccato
                int db_id = cursor.getInt(0);
                String nome = cursor.getString(1);
                int voto = cursor.getInt(2);

                // Show Toast
                Toast.makeText(getApplicationContext(),
                        "Position= "+position+"\nCancello il record " + db_id + "\nNome: " + nome + " - Voto = " + voto,
                        Toast.LENGTH_LONG).show();

                // delete from database
                db.delete(SchemaDB.Tavola.TABLE_NAME,
                          SchemaDB.Tavola._ID + "=?",
                           new String[]{"" + db_id});

                // Redisplay data
                updateLists();
            }

        });
    }

    private Cursor readAllEntries() {
        String[] projection = null;
        String sortOrder = null;
        String selection = null;
        String[] selectionArgs = null;

        Cursor cursor = db.query(
                SchemaDB.Tavola.TABLE_NAME,  // The table to query
                projection,                  // The columns to return
                selection,                   // The columns for the WHERE clause
                selectionArgs,               // The values for the WHERE clause
                null,                // don't group the rows
                null,                 // don't filter by row groups
                sortOrder                    // The sort order
        );

        return cursor;
    }

    private Cursor readSelectedEntries() {
        // Specifichiamo le colonne che ci interessano

        String[] projection = {
                SchemaDB.Tavola._ID,
                SchemaDB.Tavola.COLUMN_NAME,
                SchemaDB.Tavola.COLUMN_VOTO
        };
        //String[] projection = null;

        // Specifichiamo come le vogliamo ordinare le righe
        String sortOrder = SchemaDB.Tavola.COLUMN_VOTO + " ASC";

        // Definiamo la parte 'where' della query.
        String selection;
        selection = SchemaDB.Tavola.COLUMN_NAME + " LIKE ? "
                + " and "
                + SchemaDB.Tavola.COLUMN_VOTO + " >? ";
        //es. selection="NOME LIKE ? AND VOTO >?"

        // Specifchiamo gli argomento per i segnaposto (i ? nella stringa selection).
        String[] selectionArgs = {"Car%", "25"};

        // Eseguiamo la query: es. SELECT <nomi colonne> FROM <nome tavola> WHERE ...
        Cursor cursor = db.query(
                SchemaDB.Tavola.TABLE_NAME,  // The table to query
                projection,                  // The columns to return
                selection,                   // The columns for the WHERE clause
                selectionArgs,               // The values for the WHERE clause
                null,                // don't group the rows
                null,                 // don't filter by row groups
                sortOrder                   // The sort order
        );

        return cursor;
    }

    // Modify the contents of the database
    public void inserisciRecord(View v) {

        String nome = et_nome.getText().toString();
        String voto = et_voto.getText().toString();

        Log.d("DEBUG", "Devo inserire " + nome + " con voto " + voto);

        if (nome.length() > 0 && voto.length() > 0) {
            ContentValues values = new ContentValues();
            values.put(SchemaDB.Tavola.COLUMN_NAME, nome);
            values.put(SchemaDB.Tavola.COLUMN_VOTO, Integer.parseInt(voto));
            Log.d("DEBUG", "Inserisco in " + SchemaDB.Tavola.TABLE_NAME + " values: " + values.toString());
            db.insert(SchemaDB.Tavola.TABLE_NAME, null, values);
        } else {
            Toast.makeText(getApplicationContext(),
                    "Dati non validi!", Toast.LENGTH_LONG).show();
        }

        // Redisplay data
        updateLists();
    }

    private void updateLists() {
        adapter.getCursor().requery();
        //requery è obsoleto, serve a fare il refresh dei dati
        //la documentazione dice di ripetere la query al posto di requery
        //ma non funziona
        //Cursor cursorAll = readAllEntries();
        adapter.notifyDataSetChanged();
        //Cursor cursorSelected = readSelectedEntries();
        adapterSelected.getCursor().requery();
        adapterSelected.notifyDataSetChanged();
    }

    // Delete all records
    private void clearAll() {
        db.delete(SchemaDB.Tavola.TABLE_NAME, null, null);
    }

    // Close database
    @Override
    protected void onDestroy() {
        Log.d("DEBUG", "DataStorageSQL - onDestroy");
        db.close();
        super.onDestroy();
    }
}