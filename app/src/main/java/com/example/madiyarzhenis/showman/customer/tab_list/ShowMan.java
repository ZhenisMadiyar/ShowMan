package com.example.madiyarzhenis.showman.customer.tab_list;

/**
 * Created by madiyarzhenis on 19.10.15.
 */
public class ShowMan {
    String name;
    String username;
    String imageUrl;
    String rating;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public ShowMan(String name, String username, String imageUrl, String rating) {

        this.name = name;
        this.username = username;
        this.imageUrl = imageUrl;
        this.rating = rating;
    }
}
