package com.example.closet2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import java.util.List;

public class NotificationReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        // Check if any items have a counter >= 4
        DataManager dataManager = DataManager.getInstance(context);
        List<CardItem> items = dataManager.getCardItems();

        boolean hasHighCounters = false;
        int highCountItems = 0;

        for (CardItem item : items) {
            if (item.getCounter() >= 4) {
                hasHighCounters = true;
                highCountItems++;
            }
        }

        // Show notification if there are items with high counters
        if (hasHighCounters) {
            String message = "Hai " + highCountItems + " elementi con contatore 4 o superiore.";
            NotificationHelper.showNotification(context, "Promemoria MyCloset", message);
        }

        // Reschedule for tomorrow
        NotificationHelper.scheduleDailyNotificationCheck(context);
    }
}