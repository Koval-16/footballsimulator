package com.example.footballsimulator.backend;

public class Date {
    private int year;
    //private int month;
    private int gameday;

    public Date(int year, int gameday){
        this.year = year;
        this.gameday = gameday;
    }

    public void progress_date(){
        if(gameday<38) gameday++;
        else{
            gameday = 1;
            year++;
        }
    }

    public int getYear(){
        return year;
    }
    public int getGameday(){
        return gameday;
    }

    /*public Date(int year, int month, int gameday){
        this.year = year;
        this.month = month;
        this.gameday = gameday;
    }

    public void progress_date(){
        if(gameday!=7) gameday++;
        else{
            if(month!=12){
                month++;
                gameday = 1;
            }
            else{
                year++;
                month = 1;
                gameday = 1;
            }
        }
    }

    public int getYear(){
        return year;
    }
    public int getMonth(){
        return month;
    }
    public int getGameday(){
        return gameday;
    }*/



}
