package com.mashang.chater01.q01;

public class Student {
    // student number
    private String number;

    // student name
    private String name;

    // chinese score
    private Score cScore;

    // math score
    private Score mScore;

    // physics score
    private Score pScore;

    public Student(String number, String name) {
        this.number = number;
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCScore(double u, double e) {
        cScore = new Score();

        cScore.setUScore(u);
        cScore.setEScore(e);
    }

    public void setMScore(double u, double e) {
        mScore = new Score();

        mScore.setUScore(u);
        mScore.setEScore(e);
    }

    public void setPScore(double u, double e) {
        pScore = new Score();

        pScore.setUScore(u);
        pScore.setEScore(e);
    }

    public int calcTotalScore() {
        return (cScore.calcTotalScore() + mScore.calcTotalScore() + pScore.calcTotalScore());
    }

    public double calcAverageScore() {
        return (cScore.calcTotalScore() + mScore.calcTotalScore() + pScore.calcTotalScore()) / 3.00;
    }
}
