package com.soccer.kata.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RawData {
    HashMap<String, List<Round>> hashMap;

    public RawData() {
        this.hashMap = new HashMap<>();
    }

    public HashMap<String, List<Round>> getHashMap() {
        return hashMap;
    }

    @Override
    public String toString() {
        return hashMap.toString();
    }
}
