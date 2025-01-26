package it.unisa.di.mp.receivebroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    String custom_permission = "it.unisa.di.mp.sendbroadcast.ALLOW_MYBCAST";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (hasCustomPermission(this, custom_permission)) {
            Log.d("MYDEBUG","Custom permission OK");
        } else {
            Log.d("MYDEBUG","Custom permission NOT GRANTED. Requesting it...");
            ActivityCompat.requestPermissions(this, new String[]{custom_permission}, 12345);
        }

        setBCastReceiver();

    }

    private boolean hasCustomPermission(Context context, String permission) {
        return ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED;
    }

    // Handle the permission request result
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 12345) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                onPermissionGranted();
            } else {
                onPermissionDenied();
            }
        }
    }

    // Custom actions if the permission is granted
    private void onPermissionGranted() {
        Log.d("MYDEBUG","Custom permission granted!");
        if (hasCustomPermission(this, custom_permission)) {
            Log.d("MYDEBUG","Custom permission OK");
        } else {
            Log.d("MYDEBUG","Custom permission STILL NOT GRANTED");
        }
    }

    // Custom actions if the permission is denied
    private void onPermissionDenied() {
        Log.d("DEBUG","Custom permission denied!");
    }

    private void setBCastReceiver() {
        IntentFilter filter = new IntentFilter();
        filter.addAction("it.unisa.di.mp.sendbroadcast.MYBCAST");
        filter.addAction(Intent.ACTION_TIME_TICK);

        BroadcastReceiver bcr = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if (intent == null ) {
                    Log.d("MYDEBUG","ReceiveBcast: Intent is null");
                }
                else {
                    String action= intent.getAction();
                    Log.d("MYDEBUG","ReceiveBcast: action = "+action);
                    Toast.makeText(context,
                            "ReceiveBcast: "+action,
                            Toast.LENGTH_SHORT).show();
                }
            }
        };
        registerReceiver(bcr,filter);
    }
}