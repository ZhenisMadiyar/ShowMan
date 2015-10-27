package com.example.madiyarzhenis.showman.artist.tab_my_zayavka;

/**
 * Created by madiyarzhenis on 27.10.15.
 */
public class ElementComment {
    String name;
    String data;
    String content;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ElementComment(String name, String data, String content) {

        this.name = name;
        this.data = data;
        this.content = content;
    }
}
