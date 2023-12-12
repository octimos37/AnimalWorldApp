package com.example.myapplication.Reptilia;

public class Reptilia {
    private String OrdoID;
    private String OrdoNameE;
    private String OrdoNameTV;
    private String ImageOrdo;
    private String ClassID;

    public Reptilia(String ordoID, String ordoNameE, String ordoNameTV, String imageOrdo, String classID) {
        OrdoID = ordoID;
        OrdoNameE = ordoNameE;
        OrdoNameTV = ordoNameTV;
        ImageOrdo = imageOrdo;
        ClassID = classID;
    }

    public String getOrdoID() {
        return OrdoID;
    }

    public void setOrdoID(String ordoID) {
        OrdoID = ordoID;
    }

    public String getOrdoNameE() {
        return OrdoNameE;
    }

    public void setOrdoNameE(String ordoNameE) {
        OrdoNameE = ordoNameE;
    }

    public String getOrdoNameTV() {
        return OrdoNameTV;
    }

    public void setOrdoNameTV(String ordoNameTV) {
        OrdoNameTV = ordoNameTV;
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
