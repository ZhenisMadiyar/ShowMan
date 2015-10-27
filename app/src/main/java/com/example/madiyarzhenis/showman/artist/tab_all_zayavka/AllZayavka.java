package com.example.madiyarzhenis.showman.artist.tab_all_zayavka;

/**
 * Created by madiyarzhenis on 23.10.15.
 */
public class AllZayavka {
    String title;
    boolean newZayavka;

    public AllZayavka(String title, boolean newZayavka) {
        this.title = title;
        this.newZayavka = newZayavka;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isNewZayavka() {
        return newZayavka;
    }

    public void setNewZayavka(boolean newZayavka) {
        this.newZayavka = newZayavka;
    }
}
