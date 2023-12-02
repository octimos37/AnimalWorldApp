package com.example.myapplication.Class;

public class Class {
    private String id;
    private String textData;
    private String image_path;

    public Class() {
    }

    public Class(String id, String image_path) {
        this.id = id;
        //this.textData = textData;
        this.image_path = image_path;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

//    public String getTextData() {
//        return textData;
//    }
//
//    public void setTextData(String textData) {
//        this.textData = textData;
//    }

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }
}
