package com.example.footballsimulator.backend;

public class Match {
    private Team team1;
    private Team team2;
    private Team host;
    private Date date;

    Team winner;
    private int result; // 0/1/2
    private int team1_goals;
    private int team2_goals;

    public Match(Team team1, Team team2, Team host, int year, int day){
        this.host = host;
        date = new Date(year,day);
    }

    public Team getTeam1() {
        return team1;
    }
    public Team getTeam2(){
        return team2;
    }
    public Team getHost() {
        return host;
    }
    public Date getDate() {
        return date;
    }
}
