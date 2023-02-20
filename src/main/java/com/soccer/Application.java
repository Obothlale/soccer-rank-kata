package com.soccer;

import com.soccer.kata.service.GamesServices;
import com.soccer.kata.service.impl.GamesServicesImpl;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GamesServices gamesServices = new GamesServicesImpl();
        printOptions();
        scanner.useDelimiter("\\Z");
        while (scanner.hasNext()) {
            try {
                String input = scanner.nextLine();
                if (input.equals("exit")) {
                    break;
                }
                System.out.println("\n===New Rank===");
                System.out.println(gamesServices.rank(input));
            } catch (Exception exception) {
                System.err.println("Acceptable input examples as follows.\nExample single line:\nLions 3, Snakes 3" +
                        "\nExample copy paste multiple lines:" +
                        "\nLions 3, Snakes 3\nTarantulas 1, FC Awesome 0\n");
                printOptions();
            }
        }
    }


    private static void printOptions() {
        System.out.println("\n\n\n===Options===");
        System.out.println("1. Type exit + enter to exit program");
        System.out.println("2. Type or copy and paste (a) match(s) to rank in the format separated by new lines: <team1 name> <score>, <team2 name> <score>.\nExample:\nLions 3, Snakes 3\n" +
                "Tarantulas 1, FC Awesome 0\n");
    }
}
