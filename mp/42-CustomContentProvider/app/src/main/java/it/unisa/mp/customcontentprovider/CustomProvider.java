package it.unisa.mp.customcontentprovider;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomProvider extends ContentProvider {

    public static final String AUTHORITY="it.unisa.mp.customcontentprovider";

    public static final String PATH ="ALL_STUDENTS";
    public static final String PATH2 ="ANOTHER_TABLE_OR_VIEW"; //Non usato in questo esempio

    public static final Uri CUSTOM_URI1=Uri.parse("content://"+AUTHORITY+"/"+ PATH);
    public static final Uri CUSTOM_URI2=Uri.parse("content://"+AUTHORITY+"/"+ PATH2);

    public static final int ALL_STUDENTS = 1 ;
    public static final int ANOTHER_TABLE_OR_VIEW = 2;

    private static final UriMatcher MATCHER=new UriMatcher(UriMatcher.NO_MATCH);

    static {
        MATCHER.addURI(AUTHORITY, PATH, ALL_STUDENTS);
        MATCHER.addURI(AUTHORITY, PATH2, ANOTHER_TABLE_OR_VIEW);
    }

    public static final String MIME_TYPE_1 = ContentResolver.CURSOR_DIR_BASE_TYPE+"/"+ "all_students";
    public static final String MIME_TYPE_2 = ContentResolver.CURSOR_DIR_BASE_TYPE+"/"+ "another_table_or_view";

    private MyDBAdapter myDBAdapter;

    @Override
    public String getType(@NonNull Uri uri) {
        //Necessario fare l'ovverride di questo metodo
        switch (MATCHER.match(uri)){
            case ALL_STUDENTS: return MIME_TYPE_1;
            case ANOTHER_TABLE_OR_VIEW: return MIME_TYPE_2;
        }
        return null;
    }


    @Override
    public boolean onCreate() {
        myDBAdapter = MyDBAdapter.getCustomDBAdapterInstance(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] strings, @Nullable String s, @Nullable String[] strings1, @Nullable String s1) {
        Cursor cursor=null;
        // Build cursor depending on specific URI
        switch (MATCHER.match(uri)){
            case ALL_STUDENTS: cursor = myDBAdapter.getAll();
                break;
            case ANOTHER_TABLE_OR_VIEW:
                break;
        }
        return cursor;
    }

    //@Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) { //throws UnsupportedOperationException{
        Uri returnUri = null;
        //Should implement insert here
        return returnUri ;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) { //throws UnsupportedOperationException{
        int rc = 0;
        //Should implement update here
        return rc;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String where, @Nullable String[] strings) { // throws UnsupportedOperationException{
        int rc = 0;
        //Should implement delete here
        return rc;
    }
}