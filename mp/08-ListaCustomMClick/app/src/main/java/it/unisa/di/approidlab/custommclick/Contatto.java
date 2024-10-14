package it.unisa.di.approidlab.custommclick;

import android.graphics.drawable.Drawable;

public class Contatto {
    private String name;
    private String tel;
    private Drawable picture;

    public Contatto(String n, String t, Drawable f) {
        this.name = n;
        this.tel = t;
        this.picture = f;
    }

    public String getName() {
        return name;
    }

    public String getTel() {
        return tel;
    }

    public Drawable getPicture() {
        return picture;
    }
}
