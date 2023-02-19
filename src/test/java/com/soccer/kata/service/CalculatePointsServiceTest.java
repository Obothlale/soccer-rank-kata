package com.soccer.kata.service;

import com.soccer.kata.models.Round;
import com.soccer.kata.service.impl.CalculatePointsServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CalculatePointsServiceTest {

    private CalculatePointsService calculatePointsService;

    @BeforeEach
    public void setup() {
        calculatePointsService = new CalculatePointsServiceImpl();
    }

    @Test
    public void calculatePointsDrawTest() {
        List<Round> rounds = new ArrayList<>();
        rounds.add(new Round(1, 1));
        rounds.add(new Round(2, 2));
        rounds.add(new Round(3, 3));

        Integer expected = 3;
        Integer actual = calculatePointsService.calculate(rounds);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void calculatePointsLossTest() {
        List<Round> rounds = new ArrayList<>();
        rounds.add(new Round(0, 1));
        rounds.add(new Round(1, 2));
        rounds.add(new Round(2, 3));

        Integer expected = 0;
        Integer actual = calculatePointsService.calculate(rounds);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void calculatePointsWinTest() {
        List<Round> rounds = new ArrayList<>();
        rounds.add(new Round(3, 2));
        rounds.add(new Round(2, 1));
        rounds.add(new Round(1, 0));

        Integer expected = 9;
        Integer actual = calculatePointsService.calculate(rounds);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void calculatePointsDrawWinAndLossTest() {
        List<Round> rounds = new ArrayList<>();
        rounds.add(new Round(3, 3));
        rounds.add(new Round(2, 1));
        rounds.add(new Round(1, 3));

        Integer expected = 4;
        Integer actual = calculatePointsService.calculate(rounds);
        Assertions.assertEquals(expected, actual);
    }

}
