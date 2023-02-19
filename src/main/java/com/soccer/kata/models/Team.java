package com.soccer.kata.models;

import java.util.List;

public class Team {
    String name;
    List<Round> rounds;
    Integer points;
    Integer rankValue;
    public Team(String name, List<Round> rounds, Integer points) {
        this.rankValue = 0;
        this.name = name;
        this.rounds = rounds;
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public Integer getPoints() {
        return points;
    }

    public String toString(){
        String ptsText = points == 1? "pt":"pts";
        return rankValue +". "+name+", "+points+" "+ ptsText;
    }

    public Integer getRankValue() {
        return rankValue;
    }

    public void setRankValue(Integer rankValue) {
        this.rankValue = rankValue;
    }
}
