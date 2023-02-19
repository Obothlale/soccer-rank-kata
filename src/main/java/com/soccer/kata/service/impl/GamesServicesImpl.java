package com.soccer.kata.service.impl;

import com.soccer.kata.models.RawData;
import com.soccer.kata.models.Team;
import com.soccer.kata.service.ExtractRawDataService;
import com.soccer.kata.service.GamesServices;
import com.soccer.kata.service.ProcessRawDataService;

import java.util.Comparator;
import java.util.List;

public class GamesServicesImpl implements GamesServices, Comparator<Team> {

    ExtractRawDataService extractRawDataService;
    ProcessRawDataService processRawDataService;

    public GamesServicesImpl() {
        this.extractRawDataService = new ExtractRawDataServiceImpl();
        this.processRawDataService = new ProcessRawDataServiceImpl();
    }

    @Override
    public String rank(String input) {
        RawData rawData = this.extractRawDataService.extract(input);
        List<Team> teams = processRawDataService.process(rawData);
        teams.sort(this);
        for (int index = 0; index < teams.size(); index++) {
            if (index - 1 >= 0) {
                Team previous = teams.get(index - 1);
                if (teams.get(index).getPoints().equals(previous.getPoints())) {
                    teams.get(index).setRankValue(previous.getRankValue());
                    continue;
                }
                teams.get(index).setRankValue(index + 1);
                continue;
            }
            teams.get(index).setRankValue(index + 1);
        }
        return this.print(teams);
    }

    private String print(List<Team> teams) {
        StringBuilder output = new StringBuilder();
        int counter = 1;
        String newLine = "";
        for (Team team : teams) {
            newLine = counter < teams.size() ? "\n" : "";
            output.append(team).append(newLine);
            counter++;
        }
        return output.toString();
    }

    @Override
    public int compare(Team o1, Team o2) {
        int descendingOrder = o2.getPoints() - o1.getPoints();
        if (descendingOrder != 0) {
            return descendingOrder;
        }
        return o1.getName().compareTo(o2.getName());
    }
}
