package com.example.myapplication.GymnophionaFamilies.Ichthyophiidae;

public class Ichthyophiidae {
    private String id;
    private String textData;
    private String image_path;
    private String description;
    private String AnimalVideo;
    private String iFact;
    private String info;

    public Ichthyophiidae() {
    }

    public Ichthyophiidae(String id, String textData, String image_path, String description, String AnimalVideo, String iFact, String info) {
        this.id = id;
        this.textData = textData;
        this.image_path = image_path;
        this.description = description;
        this.AnimalVideo = AnimalVideo;
        this.iFact = iFact;
        this.info = info;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTextData() {
        return textData;
    }

    public void setTextData(String textData) {
        this.textData = textData;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAnimalVideo() {
        return AnimalVideo;
    }

    public void setAnimalVideo(String AnimalVideo) {
        this.AnimalVideo = AnimalVideo;
    }

    public String getiFact() {
        return iFact;
    }

    public void setiFact(String iFact) {
        this.iFact = iFact;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }
}
