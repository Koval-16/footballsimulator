package com.example.footballsimulator.backend;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TeamList {
    ArrayList<Team> teams = new ArrayList<>();
    public void load_teams(){
        String path = "jdbc:sqlite:C:/Users/kuba/IdeaProjects/footballsimulator/"+MainBackend.saveManager.used_save.getSave_index()+ File.separator+MainBackend.saveManager.used_save.getSave_index()+".db";
        String query = "SELECT * FROM clubs";
        try (Connection connection = DriverManager.getConnection(path);
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)){
            while(rs.next()){
                teams.add(new Team(rs.getInt("id"),rs.getString("name"),rs.getInt("elo")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void printing(){
        for(Team team: teams){
            System.out.println(team.getId()+" "+team.getName()+" "+team.getElo());
        }
    }
}
