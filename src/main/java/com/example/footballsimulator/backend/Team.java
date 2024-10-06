package com.example.footballsimulator.backend;

public class Team {
    private int id;
    private String name;
    private int elo;

    public Team(int id, String name, int elo){
        this.id = id;
        this.name = name;
        this.elo = elo;
    }

    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public int getElo(){
        return elo;
    }
}
