package com.mashang.chater01.q01;

public class Score {
    // usually
    private double uScore;

    // end of term
    private double eScore;

    public double getUScore() {
        return uScore;
    }

    public void setUScore(double uScore) {
        this.uScore = uScore;
    }

    public double getEScore() {
        return eScore;
    }

    public void setEScore(double eScore) {
        this.eScore = eScore;
    }

    public int calcTotalScore() {
        return (int) (uScore * 0.4 + eScore * 0.6);
    }
}
