package com.example.closet2;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class NotificationHelper {

    private static final String CHANNEL_ID = "contator_app_channel";
    private static final String CHANNEL_NAME = "Contator App Notifications";
    private static final String CHANNEL_DESC = "Notifiche per l'app Contator";

    public static void showNotification(Context context, String title, String message) {
        // Crea il canale di notifica per Android 8.0+
        createNotificationChannel(context);

        // Costruisci la notifica
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_settings)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setAutoCancel(true);

        // Mostra la notifica
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);

        try {
            notificationManager.notify(1, builder.build());
        } catch (SecurityException e) {
            // Gestisce il caso in cui i permessi di notifica non sono stati concessi
            e.printStackTrace();
        }
    }

    private static void createNotificationChannel(Context context) {
        // Crea il canale di notifica solo per Android 8.0+
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID,
                    CHANNEL_NAME,
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            channel.setDescription(CHANNEL_DESC);

            // Registra il canale con il sistema
            NotificationManager notificationManager = context.getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}