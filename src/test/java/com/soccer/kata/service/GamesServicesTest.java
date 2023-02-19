package com.soccer.kata.service;

import com.soccer.kata.service.impl.GamesServicesImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GamesServicesTest {

    GamesServices gamesServices;

    @BeforeEach
    public void setup() {
        gamesServices = new GamesServicesImpl();
    }

    @Test
    public void testGamesServiceSingleInput(){
        String input = "Lions 3, Snakes 3\n" +
                "Tarantulas 1, FC Awesome 0\n" +
                "Lions 1, FC Awesome 1\n" +
                "Tarantulas 3, Snakes 1\n" +
                "Lions 4, Grouches 0\n";
        String actual = gamesServices.rank(input);

        String expected = "1. Tarantulas, 6 pts\n" +
                "2. Lions, 5 pts\n" +
                "3. FC Awesome, 1 pt\n" +
                "3. Snakes, 1 pt\n" +
                "5. Grouches, 0 pts";
        Assertions.assertEquals(expected,actual);

    }
}
