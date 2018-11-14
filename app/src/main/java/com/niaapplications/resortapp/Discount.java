package com.niaapplications.resortapp;

import android.graphics.drawable.Drawable;
import java.io.InputStream;

import java.net.URL;

public class Discount {
    private  String description;
    private  String name;
    private  String city;
    private  String location;
    private  String webURL;
    private  String pictureURL;




    public Discount(){

        this.name=name;
        this.description=description;
        this.city=city;
        this.location = location;
        this.webURL=webURL;
        this.pictureURL=pictureURL;

    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getWebURL() {
        return webURL;
    }

    public void setWebURL(String webURL) {
        this.webURL = webURL;
    }

    public String getPictureURL(){ return pictureURL;}

    public void setPictureURL(String pictureURL){this.pictureURL = pictureURL;}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
