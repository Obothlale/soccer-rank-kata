package com.soccer.kata.models;

public class Round {
    Integer goalsFor;
    Integer goalsAgainst;

    public Round(Integer goalsFor, Integer goalsAgainst) {
        this.goalsFor = goalsFor;
        this.goalsAgainst = goalsAgainst;
    }

    @Override
    public String toString() {
        return "{goalsFor=" + goalsFor + ", goalsAgainst=" + goalsAgainst+"}";
    }

    public Integer getGoalsFor() {
        return goalsFor;
    }

    public Integer getGoalsAgainst() {
        return goalsAgainst;
    }
}
