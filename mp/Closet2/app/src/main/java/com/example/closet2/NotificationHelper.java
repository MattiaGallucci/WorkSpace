package com.example.closet2;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import java.util.Calendar;

public class NotificationHelper {

    private static final String CHANNEL_ID = "closet_app_channel";
    private static final String CHANNEL_NAME = "MyCloset Notifications";
    private static final String CHANNEL_DESC = "Notifiche per l'app MyCloset";
    private static final int NOTIFICATION_ID = 1;

    public static void showNotification(Context context, String title, String message) {
        // Create notification channel for Android 8.0+
        createNotificationChannel(context);

        // Build notification
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_settings)
                .setContentTitle(title)
                .setContentText(message)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setAutoCancel(true);

        // Show notification
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);

        try {
            notificationManager.notify(NOTIFICATION_ID, builder.build());
        } catch (SecurityException e) {
            // Handle case where notification permissions are not granted
            e.printStackTrace();
        }
    }

    public static void scheduleDailyNotificationCheck(Context context) {
        Intent intent = new Intent(context, NotificationReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                context,
                0,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE
        );

        // Set alarm to trigger at a specific time each day (e.g., 9:00 AM)
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, 9);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);

        // If time has already passed today, schedule for tomorrow
        if (calendar.getTimeInMillis() <= System.currentTimeMillis()) {
            calendar.add(Calendar.DAY_OF_YEAR, 1);
        }

        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        if (alarmManager != null) {
            // Use different methods based on Android version
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                // For Android 12+, check if we can schedule exact alarms
                if (alarmManager.canScheduleExactAlarms()) {
                    alarmManager.setExactAndAllowWhileIdle(
                            AlarmManager.RTC_WAKEUP,
                            calendar.getTimeInMillis(),
                            pendingIntent
                    );
                } else {
                    // Fall back to inexact alarm
                    alarmManager.setInexactRepeating(
                            AlarmManager.RTC_WAKEUP,
                            calendar.getTimeInMillis(),
                            AlarmManager.INTERVAL_DAY,
                            pendingIntent
                    );
                }
            } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                // For Android 6.0-11
                alarmManager.setExactAndAllowWhileIdle(
                        AlarmManager.RTC_WAKEUP,
                        calendar.getTimeInMillis(),
                        pendingIntent
                );
            } else {
                // For older versions
                alarmManager.setExact(
                        AlarmManager.RTC_WAKEUP,
                        calendar.getTimeInMillis(),
                        pendingIntent
                );
            }
        }
    }

    private static void createNotificationChannel(Context context) {
        // Create notification channel only for Android 8.0+
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                    CHANNEL_ID,
                    CHANNEL_NAME,
                    NotificationManager.IMPORTANCE_DEFAULT
            );
            channel.setDescription(CHANNEL_DESC);

            // Register channel with the system
            NotificationManager notificationManager = context.getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}