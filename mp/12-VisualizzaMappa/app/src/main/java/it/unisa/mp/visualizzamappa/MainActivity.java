package it.unisa.mp.visualizzamappa;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
    EditText indirizzo;
    final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        indirizzo = (EditText) findViewById(R.id.indirizzo);
    }

    public void cercaIndirizzoClicked(View v) {
        try {
            Log.d("DEBUG", ContactsContract.Contacts.CONTENT_URI.toString());
            Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
            startActivityForResult(intent, REQUEST_CODE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void visualizzaMappaClicked(View v) {
        String address = indirizzo.getText().toString();
        if (null != address) {
            address = address.replace(' ', '+');
            Intent geoIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + address));
            startActivity(geoIntent);
        }
    }

    public void visualizzaRistorantiClicked(View v) {
        Uri gmmIntentUri = Uri.parse("geo:37.7749,-122.4194?z=10&q=restaurants");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);

        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
        /*
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }
        else {
            Log.d("DEBUG","No activity found");
        }
        */
    }


    @Override
    protected void onActivityResult(int request, int result, Intent data) {
        if (request == REQUEST_CODE && result == Activity.RESULT_OK) {

            Log.d("VMTAG","onActivityResult, result="+result);

            ContentResolver cr = getContentResolver();
            Cursor cursor = cr.query(data.getData(), null, null, null, null);

            if (null != cursor && cursor.moveToFirst()) {
                String id = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
                String where = ContactsContract.Data.CONTACT_ID
                        + " = ? AND "
                        + ContactsContract.Data.MIMETYPE
                        + " = ?";
                String[] whereParameters = new String[]{id,
                        ContactsContract.CommonDataKinds.StructuredPostal.CONTENT_ITEM_TYPE};
                Cursor addrCur = cr.query(ContactsContract.Data.CONTENT_URI, null, where,
                        whereParameters, null);

                Log.d("VMTAG","where="+where);

                if (null != addrCur && addrCur.moveToFirst()) {
                    String formattedAddress = addrCur
                            .getString(addrCur
                                    .getColumnIndex(ContactsContract.CommonDataKinds.StructuredPostal.FORMATTED_ADDRESS));

                    indirizzo.setText(formattedAddress);
                }
                if (null != addrCur)
                    addrCur.close();
            }
            if (null != cursor)
                cursor.close();
        }
    }
}
