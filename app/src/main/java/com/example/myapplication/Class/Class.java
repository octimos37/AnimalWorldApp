package com.example.myapplication.Class;

public class Class {
    private String id;
    private String textData;
    private String image_path;
    private String descriptionClass;

    public Class(String id, String image_path, String descriptionClass) {
        this.id = id;
        this.image_path = image_path;
        this.descriptionClass = descriptionClass;
    }
    public Class() {
    }


    public String getDescriptionClass() {
        return descriptionClass;
    }

    public void setDescriptionClass(String description) {
        this.descriptionClass = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }
}
