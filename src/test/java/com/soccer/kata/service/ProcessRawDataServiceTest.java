package com.soccer.kata.service;

import com.soccer.kata.models.RawData;
import com.soccer.kata.models.Round;
import com.soccer.kata.models.Team;
import com.soccer.kata.service.impl.ExtractRawDataServiceImpl;
import com.soccer.kata.service.impl.ProcessRawDataServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ProcessRawDataServiceTest {

    private ProcessRawDataService processRawDataService;

    @BeforeEach
    public void setup() {
        processRawDataService = new ProcessRawDataServiceImpl();
    }

    @Test
    public void processRawDataNullInputTest() {
        List<Team> teams = processRawDataService.process(null);
        Assertions.assertTrue(teams.isEmpty());
    }

    @Test
    public void processEmptyRawDataTest() {
        RawData rawData = new RawData();
        List<Team> teams = processRawDataService.process(rawData);
        Assertions.assertTrue(teams.isEmpty());
    }

    @Test
    public void processRawDataSingleLineInputTest() {
        ArrayList<Round> team1Rounds = new ArrayList<>();
        team1Rounds.add(new Round(1, 3));

        ArrayList<Round> team2Rounds = new ArrayList<>();
        team2Rounds.add(new Round(3, 1));

        RawData rawData = new RawData();
        rawData.getHashMap().put("team1", team1Rounds);
        rawData.getHashMap().put("team2", team2Rounds);

        List<Team> actual = processRawDataService.process(rawData);
        int expected = 2;
        Assertions.assertEquals(expected, actual.size());
    }

    @Test
    public void processRawDataMultipleLinesInputTest() {
        String strInput = "Lions 3, Snakes 3\n" +
                "Tarantulas 1, FC Awesome 0\n" +
                "Lions 1, FC Awesome 1\n" +
                "Tarantulas 3, Snakes 1\n" +
                "Lions 4, Grouches 0";
        ExtractRawDataService extractRawDataService = new ExtractRawDataServiceImpl();
        RawData rawData = extractRawDataService.extract(strInput);
        List<Team> actual = processRawDataService.process(rawData);
        int expected = 5;
        Assertions.assertEquals(expected, actual.size());
    }
}
