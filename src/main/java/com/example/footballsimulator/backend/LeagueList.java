package com.example.footballsimulator.backend;

import java.util.ArrayList;

public class LeagueList {
    ArrayList<League> leagues = new ArrayList<>();

    public void create_leagues(){
        for(LeagueDefault def : MainBackend.leagueDefaultList.leagues){
            leagues.add(new League(def, MainBackend.saveManager.used_save.getDate().getYear()));
            System.out.println(leagues.get(0).getLeague().getName());
        }
    }
}
