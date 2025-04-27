package com.example.closet2;

import android.content.Context;
import android.net.Uri;
import android.util.Log;

import java.io.File;
import java.io.InputStream;

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
        try {
            return Uri.parse(imageUriString);
        } catch (Exception e) {
            Log.e("CardItem", "Error parsing URI: " + imageUriString, e);
            return null;
        }
    }

    // Add this method to check if the image file exists
    public boolean imageExists(Context context) {
        try {
            Uri uri = getImageUri();
            if (uri.getScheme().equals("file")) {
                File file = new File(uri.getPath());
                return file.exists();
            } else {
                // For content URIs, try to open a stream
                InputStream stream = context.getContentResolver().openInputStream(uri);
                if (stream != null) {
                    stream.close();
                    return true;
                }
                return false;
            }
        } catch (Exception e) {
            Log.e("CardItem", "Error checking if image exists", e);
            return false;
        }
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