package com.example.footballsimulator.backend;

// Ta klasa trzyma faktyczny sezon ligowy, np. Premier League 2025

import java.util.ArrayList;

public class League {
    private LeagueDefault league;
    private int season_year;
    public ArrayList<Team> teams = new ArrayList<>();

    public League(LeagueDefault league, int season_year){
        this.league = league;
        this.season_year = season_year;
    }



    public LeagueDefault getLeague(){
        return league;
    }
}
