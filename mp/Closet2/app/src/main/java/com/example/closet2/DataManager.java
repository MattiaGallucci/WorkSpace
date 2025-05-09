package com.example.closet2;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DataManager {
    private static final String PREF_NAME = "ContatorAppPrefs";
    private static final String CARDS_KEY = "cards";
    private static final String NOTIFICATIONS_ENABLED_KEY = "notifications_enabled";
    private static final String NOTIFICATION_THRESHOLD_KEY = "notification_threshold";

    private static DataManager instance;
    private SharedPreferences sharedPreferences;
    private List<CardItem> cardItems;
    private Gson gson;

    private DataManager(Context context) {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        gson = new Gson();
        loadCards();
    }

    public static synchronized DataManager getInstance(Context context) {
        if (instance == null) {
            instance = new DataManager(context.getApplicationContext());
        }
        return instance;
    }

    private void loadCards() {
        String cardsJson = sharedPreferences.getString(CARDS_KEY, null);
        if (cardsJson != null) {
            Type type = new TypeToken<ArrayList<CardItem>>() {}.getType();
            cardItems = gson.fromJson(cardsJson, type);
        } else {
            cardItems = new ArrayList<>();
        }
    }

    public void saveCards() {
        String cardsJson = gson.toJson(cardItems);
        sharedPreferences.edit().putString(CARDS_KEY, cardsJson).apply();
    }

    public List<CardItem> getCardItems() {
        return cardItems;
    }

    public CardItem addCard(Uri imageUri) {
        // If it's a file URI, make sure it's accessible
        String uriString = imageUri.toString();
        if (uriString.startsWith("file:")) {
            // For file URIs, we need to ensure the file is accessible
            try {
                File file = new File(imageUri.getPath());
                if (file.exists()) {
                    // File exists, we can use it
                    imageUri = Uri.fromFile(file);
                }
            } catch (Exception e) {
                Log.e("DataManager", "Error with file URI", e);
            }
        }

        // Create a new card with the image URI
        CardItem newCard = new CardItem(UUID.randomUUID().toString(), imageUri);
        cardItems.add(newCard);
        saveCards();
        return newCard;
    }

    public void updateCardCounter(String cardId, int newCount) {
        for (CardItem card : cardItems) {
            if (card.getId().equals(cardId)) {
                card.setCounter(newCount);
                break;
            }
        }
        saveCards();
    }

    public boolean isNotificationsEnabled() {
        return sharedPreferences.getBoolean(NOTIFICATIONS_ENABLED_KEY, false);
    }

    public void setNotificationsEnabled(boolean enabled) {
        sharedPreferences.edit().putBoolean(NOTIFICATIONS_ENABLED_KEY, enabled).apply();
    }

    public int getNotificationThreshold() {
        return sharedPreferences.getInt(NOTIFICATION_THRESHOLD_KEY, 10);
    }

    public void setNotificationThreshold(int threshold) {
        sharedPreferences.edit().putInt(NOTIFICATION_THRESHOLD_KEY, threshold).apply();
    }

    public CardItem getCardById(String id) {
        for (CardItem item : cardItems) {
            if (item.getId().equals(id)) {
                return item;
            }
        }
        return null;
    }

    public void deleteCard(String id) {
        CardItem itemToRemove = null;
        for (CardItem item : cardItems) {
            if (item.getId().equals(id)) {
                itemToRemove = item;
                break;
            }
        }

        if (itemToRemove != null) {
            cardItems.remove(itemToRemove);
            saveCards();
        }
    }
}