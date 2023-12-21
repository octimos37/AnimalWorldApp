package com.example.myapplication.ReptileOrders.Rhynchocephalia;

public class Rhynchocephalia {
    private String FamilyID;
    private String FamilyNameE;
    private String FamilyNameTV;
    private String imagesFamyli;
    private String DescriptionFamily;
    private String OrdoID;

    public Rhynchocephalia(String familyID, String familyNameE, String familyNameTV, String imagesFamyli, String descriptionFamily, String ordoID) {
        FamilyID = familyID;
        FamilyNameE = familyNameE;
        FamilyNameTV = familyNameTV;
        this.imagesFamyli = imagesFamyli;
        DescriptionFamily = descriptionFamily;
        OrdoID = ordoID;
    }

    public String getFamilyID() {
        return FamilyID;
    }

    public void setFamilyID(String familyID) {
        FamilyID = familyID;
    }

    public String getFamilyNameE() {
        return FamilyNameE;
    }

    public void setFamilyNameE(String familyNameE) {
        FamilyNameE = familyNameE;
    }

    public String getFamilyNameTV() {
        return FamilyNameTV;
    }

    public void setFamilyNameTV(String familyNameTV) {
        FamilyNameTV = familyNameTV;
    }

    public String getImagesFamyli() {
        return imagesFamyli;
    }

    public void setImagesFamyli(String imagesFamyli) {
        this.imagesFamyli = imagesFamyli;
    }

    public String getDescriptionFamily() {
        return DescriptionFamily;
    }

    public void setDescriptionFamily(String descriptionFamily) {
        DescriptionFamily = descriptionFamily;
    }

    public String getOrdoID() {
        return OrdoID;
    }

    public void setOrdoID(String ordoID) {
        OrdoID = ordoID;
    }
}
