package com.example.myapplication.Birds;

public class Birds {
    private String OrdoID;
    private String OrdoName;
    private String ImageOrdo;
    private String ClassID;

    public Birds(String ordoID, String ordoName, String imageOrdo, String classID) {
        OrdoID = ordoID;
        OrdoName = ordoName;
        ImageOrdo = imageOrdo;
        ClassID = classID;
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
}
