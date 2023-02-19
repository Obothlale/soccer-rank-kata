package com.soccer.kata.service.impl;

import com.soccer.kata.models.Round;
import com.soccer.kata.service.CalculatePointsService;

import java.util.List;

public class CalculatePointsServiceImpl implements CalculatePointsService {
    @Override
    public Integer calculate(List<Round> rounds) {
        int points = 0;
        for (Round round : rounds) {
            if (isWin(round.getGoalsFor(), round.getGoalsAgainst())) {
                points += 3;
            }
            if (isDraw(round.getGoalsFor(), round.getGoalsAgainst())) {
                points += 1;
            }
        }
        return points;
    }

    private boolean isDraw(Integer goalsFor, Integer goalsAgainst) {
        return goalsFor.equals(goalsAgainst);
    }

    private boolean isWin(Integer goalsFor, Integer goalsAgainst) {
        return goalsFor.compareTo(goalsAgainst) > 0;
    }

}
