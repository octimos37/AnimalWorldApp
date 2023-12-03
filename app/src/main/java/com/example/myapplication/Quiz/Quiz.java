package com.example.myapplication.Quiz;

public class Quiz {
    String id;
    String image;
    String QA;
    String QB;
    String QC;
    String QD;
    String Ans;

    public Quiz(String id, String image, String QA, String QB, String QC, String QD, String ans) {
        this.id = id;
        this.image = image;
        this.QA = QA;
        this.QB = QB;
        this.QC = QC;
        this.QD = QD;
        this.Ans = ans;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getQA() {
        return QA;
    }

    public void setQA(String QA) {
        this.QA = QA;
    }

    public String getQB() {
        return QB;
    }

    public void setQB(String QB) {
        this.QB = QB;
    }

    public String getQC() {
        return QC;
    }

    public void setQC(String QC) {
        this.QC = QC;
    }

    public String getQD() {
        return QD;
    }

    public void setQD(String QD) {
        this.QD = QD;
    }

    public String getAns() {
        return Ans;
    }

    public void setAns(String ans) {
        this.Ans = ans;
    }
}
