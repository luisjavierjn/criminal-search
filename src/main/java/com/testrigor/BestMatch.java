package com.testrigor;

public class BestMatch {
    private int score;
    private String match;

    public BestMatch() {
        this.score = 0;
        this.match = "";
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getMatch() {
        return match;
    }

    public void setMatch(String match) {
        this.match = match;
    }

    @Override
    public String toString() {
        return "BestMath {" +
                "score=" + score +
                ", match='" + match + '\'' +
                '}';
    }
}
