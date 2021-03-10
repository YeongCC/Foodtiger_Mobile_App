package com.codeseasy.footdiger.model;

public class Allmenu {
    private String name,imageUrl, rating,description,id,cart_id, price;

    public Allmenu (String name,String imageUrl,String rating,String description,String id,String cart_id,String price){
        this.name = name;
        this.imageUrl = imageUrl;
        this.rating = rating;
        this.description = description;
        this.id = id;
        this.cart_id = cart_id;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCart_id() {
        return cart_id;
    }

    public void setCart_id(String cart_id) {
        this.cart_id = cart_id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
