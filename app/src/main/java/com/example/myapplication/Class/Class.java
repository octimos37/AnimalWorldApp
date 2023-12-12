package com.example.myapplication.Class;

public class Class {
    private String id;
    private String textData;
    private String image_path;
    private String descriptionClass;
    private String nameE;
    private String nameTV;

    public Class(String id, String image_path, String descriptionClass, String nameE, String nameTV) {
        this.id = id;
        this.image_path = image_path;
        this.descriptionClass = descriptionClass;
        this.nameE = nameE;
        this.nameTV = nameTV;
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

    public String getDescriptionClass() {
        return descriptionClass;
    }

    public void setDescriptionClass(String descriptionClass) {
        this.descriptionClass = descriptionClass;
    }

    public String getNameE() {
        return nameE;
    }

    public void setNameE(String nameE) {
        this.nameE = nameE;
    }

    public String getNameTV() {
        return nameTV;
    }

    public void setNameTV(String nameTV) {
        this.nameTV = nameTV;
    }
}
