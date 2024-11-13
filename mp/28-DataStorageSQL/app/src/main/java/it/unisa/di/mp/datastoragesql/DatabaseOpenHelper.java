package it.unisa.di.mp.datastoragesql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseOpenHelper extends SQLiteOpenHelper {
	
	final static String[] columns = {
			SchemaDB.Tavola._ID,
			SchemaDB.Tavola.COLUMN_NAME,
			SchemaDB.Tavola.COLUMN_VOTO
	};

	final private static String CREATE_CMD =
			"CREATE TABLE "+SchemaDB.Tavola.TABLE_NAME+" ("
			+ SchemaDB.Tavola._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
			+ SchemaDB.Tavola.COLUMN_NAME + " TEXT NOT NULL, "
			+ SchemaDB.Tavola.COLUMN_VOTO + " INTEGER); ";

	final private static Integer VERSION = 1;
	final private Context context;

	public DatabaseOpenHelper(Context context) {
		super(context, SchemaDB.Tavola.TABLE_NAME, null, VERSION);
		this.context = context;
		Log.d("DEBUG", "DatatabaseOpenHelper - constructor");
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_CMD);
		Log.d("DEBUG", "DatatabaseOpenHelper - onCreate");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// non serve in questo esempio, ma deve esserci
	}

	//Questo metodo serve per cancellare il database
	//Non viene usato in questo esempio
	void deleteDatabase() {
		Log.d("DEBUG","Deleting database "+ SchemaDB.Tavola.TABLE_NAME);
		context.deleteDatabase(SchemaDB.Tavola.TABLE_NAME);
	}
}
