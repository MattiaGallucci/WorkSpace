package it.unisa.di.mp.notifiche;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

    }

    public void showToast(View v) {
        Toast.makeText(getApplicationContext(), "Toast!", Toast.LENGTH_LONG).show();
    }

    public void showCustomToast(View v) {
        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(getLayoutInflater().inflate(R.layout.custom_toast, null));
        toast.show();
    }

    public void showDialog(View v) {
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case DialogInterface.BUTTON_POSITIVE:
                        Toast.makeText(getApplicationContext(), "Ok!", Toast.LENGTH_LONG).show();
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        Toast.makeText(getApplicationContext(), "Azione annullata", Toast.LENGTH_LONG).show();
                        break;
                }
            }
        };

        /*
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Stai per ripartire da capo. Sei sicuro?")
                .setPositiveButton("Si", dialogClickListener)
                .setNegativeButton("No", dialogClickListener).show();
         */

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Stai per ripartire da capo. Sei sicuro?");
        builder.setPositiveButton("Si", dialogClickListener);
        builder.setNegativeButton("No", dialogClickListener);
        builder.show();

        return;
    }

    @RequiresApi(Build.VERSION_CODES.O) //Api 26
    public void showNotification(View v) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
            Toast.makeText(this, "API " + Build.VERSION.SDK_INT + " <" + Build.VERSION_CODES.O, Toast.LENGTH_LONG).show();
            return;
        }

        //Da API 33 (Ansdroid 13) occorre richiedere il permesso a runtime!
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) { // Android 13+
            if (ContextCompat.checkSelfPermission(this, "android.permission.POST_NOTIFICATIONS")
                    != PackageManager.PERMISSION_GRANTED) {
                // Request the notification permission at runtime
                ActivityCompat.requestPermissions(this,
                        new String[]{"android.permission.POST_NOTIFICATIONS"},
                        12345); // Request code for POST_NOTIFICATIONS
                return;
            }
        }

        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        String NOTIFICATION_CHANNEL_ID = "channel01";
        NotificationChannel notificationChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, "Canale n.1", NotificationManager.IMPORTANCE_HIGH);
        notificationChannel.setDescription("This is a description of the channel 1");
        notificationChannel.enableLights(true);
        notificationChannel.setLightColor(Color.GREEN);
        notificationChannel.setVibrationPattern(new long[]{0, 600, 300, 600});
        notificationChannel.enableVibration(true);
        notificationManager.createNotificationChannel(notificationChannel);


        // Create an explicit intent for an Activity in your app
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        //Il flag per il pendingIntent è obbligatorio da sdk 31 (FLAG_MUTABLE o FLAG_IMMUTABLE)
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_MUTABLE);

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID);

        notificationBuilder.setAutoCancel(true) //Cancella automaticamente la notifica quando l'utente la tocca.
                .setDefaults(Notification.DEFAULT_ALL)
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.drawable.baseline_5g_24) //For Api > 28 the small icon has to be one color over transparent
                .setPriority(Notification.PRIORITY_MAX)
                .setContentTitle("Questo è il titolo della mia notifica 1 ")
                .setContentText("Qui ci sono altre informazioni della notifica 1")
                .setContentIntent(pendingIntent);

        notificationManager.notify(1, notificationBuilder.build());
    }

    public void showNotification2(View v) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
            Toast.makeText(this, "API " + Build.VERSION.SDK_INT + " <" + Build.VERSION_CODES.O, Toast.LENGTH_LONG).show();
            return;
        }
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        // Create second channel
        String NOTIFICATION_CHANNEL_ID_TWO = "channel02";
        NotificationChannel notificationChannelTwo = new NotificationChannel(
                NOTIFICATION_CHANNEL_ID_TWO, "Canale n.2", NotificationManager.IMPORTANCE_HIGH);
        notificationChannelTwo.setDescription("This is a description of the channel 2");
        notificationChannelTwo.enableLights(true);
        notificationChannelTwo.setLightColor(Color.GREEN);
        notificationChannelTwo.setVibrationPattern(new long[]{0, 600, 300, 600});
        notificationChannelTwo.enableVibration(true);
        notificationManager.createNotificationChannel(notificationChannelTwo);

        // Create an explicit intent for an Activity in your app
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        //Il flag per il pendingIntent è obbligatorio da sdk 31 (FLAG_MUTABLE o FLAG_IMMUTABLE)
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_MUTABLE);

        NotificationCompat.Builder notificationBuilderTwo = new NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID_TWO);

        notificationBuilderTwo.setAutoCancel(true) //Cancella automaticamente la notifica quando l'utente la tocca.
                .setDefaults(Notification.DEFAULT_ALL)
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.drawable.telefono_old) //For Api > 28 the small icon has to be one color over transparent
                .setPriority(Notification.PRIORITY_MAX)
                .setContentTitle("Questo è il titolo della mia notifica 2")
                .setContentText("Qui ci sono altre informazioni della notifica 2")
                .setContentIntent(pendingIntent);

        notificationManager.notify(2, notificationBuilderTwo.build());
    }

    public void cancelNotification(View v) {
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.cancel(1);
        mNotificationManager.cancel(2);
    }

    @Override
    public void onBackPressed() {
        //Toast.makeText(this,"onBack",Toast.LENGTH_SHORT).show();
        esciDialog(null);
    }

    public void esciDialog(View v) {
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case DialogInterface.BUTTON_POSITIVE:
                        finish();
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        Toast.makeText(getApplicationContext(), "Azione annullata", Toast.LENGTH_LONG).show();
                        break;
                }
            }
        };

        /*
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Stai per ripartire da capo. Sei sicuro?")
                .setPositiveButton("Si", dialogClickListener)
                .setNegativeButton("No", dialogClickListener).show();
         */

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Vuoi uscire dall'app?");
        builder.setPositiveButton("Si", dialogClickListener);
        builder.setNegativeButton("No", dialogClickListener);
        builder.show();

        return;
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 12345) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permesso notifica accordato", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Permesso notifica negato", Toast.LENGTH_SHORT).show();
            }
        }
    }

}
