package com.soccer.kata.service;

import com.soccer.kata.models.RawData;
import com.soccer.kata.service.impl.ExtractRawDataServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ExtractRawDataServiceTest {

    ExtractRawDataService extractRawDataService;

    @BeforeEach
    public void setup(){
        extractRawDataService = new ExtractRawDataServiceImpl();
    }

    @Test
    public void setNullInputTest(){
        RawData actual = extractRawDataService.extract(null);
        Assertions.assertTrue(actual.getHashMap().isEmpty());
    }

    @Test
    public void emptyInputTest(){
        String input = "";
        RawData actual = extractRawDataService.extract(input);
        Assertions.assertTrue(actual.getHashMap().isEmpty());
    }

    @Test
    public void singleLineInputTest(){
        String input = "Lions 3, Snakes 1";
        RawData actual = extractRawDataService.extract(input);
        String expected = "{Lions=[{goalsFor=3, goalsAgainst=1}], Snakes=[{goalsFor=1, goalsAgainst=3}]}";
        Assertions.assertEquals(expected,actual.toString());
    }

    @Test
    public void multipleLineInputTest(){
        String input = "Lions 3, Snakes 3\n" +
                "Tarantulas 1, FC Awesome 0\n" +
                "Lions 1, FC Awesome 1\n" +
                "Tarantulas 3, Snakes 1\n" +
                "Lions 4, Grouches 0";
        RawData actual =  extractRawDataService.extract(input);
        String expected = "{Tarantulas=[{goalsFor=1, goalsAgainst=0}, {goalsFor=3, goalsAgainst=1}], Lions=[{goalsFor=3, goalsAgainst=3}, {goalsFor=1, goalsAgainst=1}, {goalsFor=4, goalsAgainst=0}], Grouches=[{goalsFor=0, goalsAgainst=4}], Snakes=[{goalsFor=3, goalsAgainst=3}, {goalsFor=1, goalsAgainst=3}], FC Awesome=[{goalsFor=0, goalsAgainst=1}, {goalsFor=1, goalsAgainst=1}]}";
        Assertions.assertEquals(expected,actual.toString());
    }
}
