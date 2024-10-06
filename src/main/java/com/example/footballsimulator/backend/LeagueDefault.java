package com.example.footballsimulator.backend;


// w tej klasie chodzi o to, żeby tylko trzymać te ligi w pamięci, żeby nie musieć cały czas ich pobierać z bazy
// danych, czyli ta klasa trzyma ogólne info o lidze, np mamy lige angielską: id=1, nazwa=PremierLeague
// teams=20, i potem jest to element konkretnego sezonu
public class LeagueDefault {
    private int id;
    private String name;
    private int teams;

    public LeagueDefault(int id, String name, int teams){
        this.id = id;
        this.name = name;
        this.teams = teams;
    }

    public String getName(){
        return name;
    }
}
