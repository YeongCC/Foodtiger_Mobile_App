package com.codeseasy.footdiger.model;

public class Category {

    private String name,imageUrl,description,  c_id;

    public Category (String name,String imageUrl,String description,String c_id){
        this.name = name;
        this.imageUrl = imageUrl;
        this.description = description;
        this.c_id = c_id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getC_id() {
        return c_id;
    }

    public void setC_id(String c_id) {
        this.c_id = c_id;
    }


}
