package com.testrigor;

public class BestMatch {
    private int score;
    private String name;
    private String aliases;

    public BestMatch() {
        this.score = 0;
        this.name = "";
        this.aliases = "";
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAliases() {
        return aliases;
    }

    public void setAliases(String aliases) {
        this.aliases = aliases;
    }

    @Override
    public String toString() {
        return "BestMath {" +
                "score=" + score +
                ", match='" + name + '\'' +
                '}';
    }
}
