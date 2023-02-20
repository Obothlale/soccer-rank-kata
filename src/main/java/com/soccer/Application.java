package com.soccer;

import com.soccer.kata.service.GamesServices;
import com.soccer.kata.service.impl.GamesServicesImpl;

import java.io.FileReader;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        if (args == null || args.length == 0) {
            System.err.println("Application requires single '/path/file' containing match data as arguments");
            return;
        }
        try {
            FileReader fileReader = new FileReader(args[0]);
            Scanner scanner = new Scanner(fileReader);
            String input = getInput(scanner);
            GamesServices gamesServices = new GamesServicesImpl();
            String rank = gamesServices.rank(input);
            System.out.println(rank);
            fileReader.close();
        } catch (Exception fileNotFoundException) {
            System.err.println("Unable to read file:" + args[0] + "\n With Exception:\n" + fileNotFoundException.getCause());
        }
    }

    private static String getInput(Scanner scanner) {
        StringBuilder input = new StringBuilder();
        while (scanner.hasNextLine()) {
            input.append(scanner.nextLine()).append("\n");
        }
        return input.toString();
    }
}
