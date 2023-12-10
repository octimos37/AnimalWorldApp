package com.example.myapplication.Pet.PetTopic;

public class CatTopic {
    String id;
    String title;
    String image;
    String description;
    String petId;

    public CatTopic(String id, String title, String image, String description, String petId) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.description = description;
        this.petId = petId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPetId() {
        return petId;
    }

    public void setPetId(String petId) {
        this.petId = petId;
    }
}
