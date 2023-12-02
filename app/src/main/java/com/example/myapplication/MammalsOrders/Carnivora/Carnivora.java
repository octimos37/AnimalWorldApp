package com.example.myapplication.MammalsOrders.Carnivora;

public class Carnivora {
    private String FamilyID;
    private String FamilyNameE;
    private String imagesFamyli;
    private String DescriptionFamily;
    private String OrdoID;

    public Carnivora(String familyID, String familyNameE, String imagesFamyli, String descriptionFamily, String ordoID) {
        FamilyID = familyID;
        FamilyNameE = familyNameE;
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
