package it.unisa.di.mp.sendbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    BroadcastReceiver bcr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setBCastReceiver();
    }

    public void sendBroadcast(View v) {
        Intent i = new Intent("it.unisa.di.mp.sendbroadcast.MYBCAST");
        String permission = "it.unisa.di.mp.sendbroadcast.ALLOW_MYBCAST";
        sendBroadcast(i);
    }

    private void setBCastReceiver() {
        IntentFilter filter = new IntentFilter();
        filter.addAction("it.unisa.di.mp.sendbroadcast.MYBCAST");
        filter.addAction(Intent.ACTION_TIME_TICK);

        bcr = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if (intent == null ) {
                    Log.d("MYDEBUG","Intent is null");
                }
                else {
                    String action= intent.getAction();
                    Log.d("MYDEBUG","intent = "+action);
                    Toast.makeText(context,
                            "Received broadcast action: "+action,
                            Toast.LENGTH_SHORT).show();
                }
            }
        };
        registerReceiver(bcr,filter);
    }
}