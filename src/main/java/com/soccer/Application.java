package com.soccer;

import com.soccer.kata.service.GamesServices;
import com.soccer.kata.service.impl.GamesServicesImpl;

import java.io.FileReader;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        if (args == null || args.length == 0) {
            System.err.println("Application requires single '/path/file' containing match data as arguments or -it to run in interactive mode.");
            return;
        }
        if(args[0].equals("-it")){
            runInInteractiveMode();
            return;
        }
        passInFileAsArguments(args[0]);
    }

    private static void passInFileAsArguments(String arg) {
        try {
            FileReader fileReader = new FileReader(arg);
            Scanner scanner = new Scanner(fileReader);
            String input = getInput(scanner);
            GamesServices gamesServices = new GamesServicesImpl();
            System.out.println("\n"+gamesServices.rank(input));
            fileReader.close();
        } catch (Exception exception) {
            throw new RuntimeException("Unable to read file: " + arg, exception);
        }
    }

    private static void runInInteractiveMode() {
        Scanner scanner = new Scanner(System.in);
        GamesServices gamesServices = new GamesServicesImpl();
        printOptions();
        while(scanner.hasNext()){
            try {
                String input = scanner.nextLine();
                if (input.equals("exit")) {
                    break;
                }
                System.out.println("\n===New Rank===");
                System.out.println(gamesServices.rank(input));
            } catch (Exception exception) {
                System.err.println("Acceptable input examples as follows.\nExample single line:\nLions 3, Snakes 3\n");
            }
        }
    }

    private static void printOptions() {
        System.out.println("\n\n\n===Options===");
        System.out.println("1. Type exit + enter to exit program");
        System.out.println("2. Type a match to enter a new rank in the format: <team1 name> <score>, <team2 name> <score>.\nExample:\nLions 3, Snakes 3\n" +
                "Tarantulas 1, FC Awesome 0\n");
    }
    private static String getInput(Scanner scanner) {
        StringBuilder input = new StringBuilder();
        while (scanner.hasNextLine()) {
            input.append(scanner.nextLine()).append("\n");
        }
        return input.toString();
    }
}
