package com.example.myapplication.Mammals;

public class Mammals {
    private String OrdoID;
    private String OrdoName;
    private String ImageOrdo;
    private String ClassID;
    private String DescriptionOrdo;

    public Mammals(String ordoID, String ordoName, String imageOrdo, String classID, String descriptionOrdo) {
        OrdoID = ordoID;
        OrdoName = ordoName;
        ImageOrdo = imageOrdo;
        ClassID = classID;
        DescriptionOrdo = descriptionOrdo;
    }

    public String getOrdoID() {
        return OrdoID;
    }

    public void setOrdoID(String ordoID) {
        OrdoID = ordoID;
    }

    public String getOrdoName() {
        return OrdoName;
    }

    public void setOrdoName(String ordoName) {
        OrdoName = ordoName;
    }

    public String getImageOrdo() {
        return ImageOrdo;
    }

    public void setImageOrdo(String imageOrdo) {
        ImageOrdo = imageOrdo;
    }

    public String getClassID() {
        return ClassID;
    }

    public void setClassID(String classID) {
        ClassID = classID;
    }

    public String getDescriptionOrdo() {
        return DescriptionOrdo;
    }

    public void setDescriptionOrdo(String descriptionOrdo) {
        DescriptionOrdo = descriptionOrdo;
    }
}
