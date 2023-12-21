package com.example.myapplication.Pet;

public class Pet {
    String id;
    String name;
    String nameE;
    String image;

    public Pet(String id, String name, String nameE, String image) {
        this.id = id;
        this.name = name;
        this.nameE = nameE;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameE() {
        return nameE;
    }

    public void setNameE(String nameE) {
        this.nameE = nameE;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
