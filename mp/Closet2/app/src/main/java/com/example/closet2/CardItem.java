package com.example.closet2;

import android.net.Uri;

public class CardItem {
    private String id;
    private Uri imageUri;
    private String imageUriString;
    private int counter;

    public CardItem(String id, Uri imageUri) {
        this.id = id;
        this.imageUriString = imageUri.toString();
        this.counter = 0;
    }

    public String getId() {
        return id;
    }

    public Uri getImageUri() {
        return Uri.parse(imageUriString);
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public void incrementCounter() {
        counter++;
    }

    public void decrementCounter() {
        if (counter > 0) {
            counter--;
        }
    }
}