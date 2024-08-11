package com.example.footballsimulator.backend;

public class Date {
    public int year = 2023;
    public int month = 1;
    public int gameday = 1;

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

}
