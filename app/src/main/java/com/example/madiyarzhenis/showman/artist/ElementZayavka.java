package com.example.madiyarzhenis.showman.artist;

import java.util.ArrayList;

/**
 * Created by madiyarzhenis on 27.10.15.
 */
public class ElementZayavka extends ArrayList<ElementZayavka> {
    String name;
    String region;
    String language;
    String data;
    String priceOt;
    String priceDo;
    String event;
    String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getPriceOt() {
        return priceOt;
    }

    public void setPriceOt(String priceOt) {
        this.priceOt = priceOt;
    }

    public String getPriceDo() {
        return priceDo;
    }

    public void setPriceDo(String priceDo) {
        this.priceDo = priceDo;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ElementZayavka(String name, String region, String language, String data, String priceOt, String priceDo, String event, String phone) {
        this.name = name;
        this.region = region;
        this.language = language;
        this.data = data;
        this.priceOt = priceOt;
        this.priceDo = priceDo;
        this.event = event;
        this.phone = phone;
    }
}
