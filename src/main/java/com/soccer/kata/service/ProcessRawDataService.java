package com.soccer.kata.service;

import com.soccer.kata.models.RawData;
import com.soccer.kata.models.Team;

import java.util.List;

public interface ProcessRawDataService {

    List<Team> process(RawData rawData);
}
