package com.example.footballsimulator.backend;

// a ta klasa trzyma wszystkie te ligi w jednym miejscu, współgra z LeagueDefault

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class LeagueDefaultList {
    public ArrayList<LeagueDefault> leagues = new ArrayList<>();

    public void load_leagues(){
        String path = "jdbc:sqlite:C:/Users/kuba/IdeaProjects/footballsimulator/"+MainBackend.saveManager.used_save.getSave_index()+ File.separator+MainBackend.saveManager.used_save.getSave_index()+".db";
        String query = "SELECT * FROM leagues";
        try (Connection connection = DriverManager.getConnection(path);
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)){
            while(rs.next()){
                leagues.add(new LeagueDefault(rs.getInt("id"),rs.getString("name"),rs.getInt("teams")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
