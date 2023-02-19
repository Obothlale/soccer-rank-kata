package com.soccer.kata.service;

import com.soccer.kata.models.Round;

import java.util.List;

public interface CalculatePointsService {

    Integer calculate(List<Round> round);
}
