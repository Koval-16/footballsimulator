package com.example.footballsimulator.backend;

public class Team {
    private int id;
    private String name;
    private String shortname;
    private int confederation;
    private int fifa_ranking;
    private int elo_ranking;
    private boolean is_arab;

    public Team(int id, String name, String shortname, int confederation, int fifa_ranking, int elo_ranking, boolean is_arab){
        this.id = id;
        this.name = name;
        this.shortname = shortname;
        this.confederation = confederation;
        this.fifa_ranking = fifa_ranking;
        this.elo_ranking = elo_ranking;
        this.is_arab = is_arab;
    }

    public int getId(){return id;}
    public String getName(){return name;}
    public String getShortname(){return shortname;}
    public int getConfederation(){return confederation;}
    public int getFifa_ranking(){return fifa_ranking;}
    public int getElo_ranking() {return elo_ranking;}
    public boolean getIs_Arab(){return is_arab;}

    public void setId(int id){this.id=id;}
    public void setName(String name){this.name=name;}
    public void setShortname(String shortname){this.shortname=shortname;}
    public void setConfederation(int confederation){this.confederation=confederation;}
    public void setFifa_ranking(int fifa_ranking){this.fifa_ranking=fifa_ranking;}
    public void setElo_ranking(int elo_ranking){this.elo_ranking=elo_ranking;}
    public void setIs_arab(boolean is_arab){this.is_arab=is_arab;}
}
