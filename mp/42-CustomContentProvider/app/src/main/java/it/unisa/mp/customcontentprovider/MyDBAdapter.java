package it.unisa.mp.customcontentprovider;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MyDBAdapter {

    public static final String NAME="custom.db";
    public static final int VERSION=1;
    public static final String TABLE_NAME = "studenti";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "nome";
    public static final String COLUMN_VOTO = "voto";

    final static String[] columns = {COLUMN_ID, COLUMN_NAME, COLUMN_VOTO };

    final private static String CREATE_CMD =
            "CREATE TABLE "+TABLE_NAME+" ("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COLUMN_NAME + " TEXT NOT NULL, "
                    + COLUMN_VOTO + " INTEGER); ";

    private Context context;
    private SQLiteDatabase  sqlLiteDatabase;
    private static MyDBAdapter myDBAdapterInstance;

    private MyDBAdapter(Context context){
        this.context=context;
        sqlLiteDatabase=new MyDBHelper(this.context,NAME,null,VERSION).getWritableDatabase();
    }

    public  static MyDBAdapter getCustomDBAdapterInstance(Context context){
        if(myDBAdapterInstance ==null){
            myDBAdapterInstance =new MyDBAdapter(context);
        }
        return myDBAdapterInstance;
    }

    //insert, delete
    public long insert(ContentValues contentValues){
        return sqlLiteDatabase.insert(TABLE_NAME,null,contentValues);
    }

    public boolean insert(String nome, String voto){
        ContentValues contentValues=new ContentValues();
        contentValues.put(COLUMN_NAME,nome);
        contentValues.put(COLUMN_VOTO,voto);
        return sqlLiteDatabase.insert(TABLE_NAME,null,contentValues)>0;
    }

    public boolean delete(int id){
        return sqlLiteDatabase.delete(TABLE_NAME, COLUMN_ID+" = "+id,null)>0;
    }

    public int delete(String whereClause, String [] whereValues){
        return sqlLiteDatabase.delete(TABLE_NAME,whereClause,whereValues);
    }


    //SELECT * FROM TABLE
    public Cursor getAll(){
        Cursor cursor=sqlLiteDatabase.query(TABLE_NAME,columns,null,null,null,null,null,null);
        return cursor;
    }

    public Cursor getSelectAll(){
        Cursor cursor=sqlLiteDatabase.query(TABLE_NAME,columns,null,null,null,null,null,null);
        return cursor;
    }

    //SELECT ID, NAME FROM TABLE WHERE VOTO = ?
    public Cursor getSelectedVote(int voto){
        Cursor cursor=sqlLiteDatabase.query(TABLE_NAME,new String[]{COLUMN_ID,COLUMN_NAME},COLUMN_VOTO +" = "+voto+"",null,null,null,null,null);
        return cursor;
    }

    public Cursor getCount(){
        Cursor cursor=sqlLiteDatabase.rawQuery("SELECT COUNT(*) FROM "+TABLE_NAME,null);
        return cursor;
    }


    private static class MyDBHelper extends SQLiteOpenHelper{

        public MyDBHelper(Context context, String databaseName, SQLiteDatabase.CursorFactory factory, int dbVersion){
            super(context,databaseName,factory,dbVersion);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL(CREATE_CMD);
            Log.d("DEBUG","myDBHelper onCreate");

        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        }
    }

}