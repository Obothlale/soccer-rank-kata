package com.soccer.kata.service.impl;

import com.soccer.kata.models.RawData;
import com.soccer.kata.models.Round;
import com.soccer.kata.service.ExtractRawDataService;

import java.util.ArrayList;
import java.util.List;

public class ExtractRawDataServiceImpl implements ExtractRawDataService {

    private RawData rawData;

    public ExtractRawDataServiceImpl() {
        this.rawData = new RawData();
    }

    public RawData extract(String input) {
        if (input != null && input.length() > 0) {
            input = this.removeSpaceAfterComma(input);
            for (String line : input.split("\n")) {
                this.processMatchPlayed(line.split(","));
            }
        }
        return this.rawData;
    }

    private String removeSpaceAfterComma(String input) {
        return input.replace(", ", ",");
    }

    private void processMatchPlayed(String[] stringList) {
        List<String> teamNames = new ArrayList<>();
        List<Integer> matchScores = new ArrayList<>();
        for (String value : stringList) {
            teamNames.add(value.substring(0, value.lastIndexOf(" ")));
            matchScores.add(Integer.parseInt(value.substring(value.lastIndexOf(" ") + 1)));
        }
        setGoalsForAndAgainst(teamNames.get(0), matchScores.get(0), matchScores.get(1));
        setGoalsForAndAgainst(teamNames.get(1), matchScores.get(1), matchScores.get(0));
    }

    private void setGoalsForAndAgainst(String teamName, Integer goalFor, Integer goalAgainst) {
        if (!this.rawData.getHashMap().containsKey(teamName)) {
            this.rawData.getHashMap().put(teamName, new ArrayList<>());
        }
        this.rawData.getHashMap().get(teamName).add(new Round(goalFor, goalAgainst));
    }

}
