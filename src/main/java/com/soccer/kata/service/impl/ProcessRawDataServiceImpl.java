package com.soccer.kata.service.impl;

import com.soccer.kata.models.RawData;
import com.soccer.kata.models.Round;
import com.soccer.kata.models.Team;
import com.soccer.kata.service.CalculatePointsService;
import com.soccer.kata.service.ProcessRawDataService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProcessRawDataServiceImpl implements ProcessRawDataService {

    CalculatePointsService calculatePointsService;

    public ProcessRawDataServiceImpl() {
        this.calculatePointsService = new CalculatePointsServiceImpl();
    }
    @Override
    public List<Team> process(RawData rawData) {
        ArrayList<Team> teams = new ArrayList<>();
        if (rawData != null && !rawData.getHashMap().isEmpty()) {
            for (Map.Entry<String, List<Round>> next : rawData.getHashMap().entrySet()) {
                String name = next.getKey();
                List<Round> rounds = next.getValue();
                teams.add(new Team(name, rounds,calculatePointsService.calculate(rounds)));
            }
        }
        return teams;
    }
}
