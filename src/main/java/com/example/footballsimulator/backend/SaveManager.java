package com.example.footballsimulator.backend;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class SaveManager {

    public ArrayList<Save> saves = new ArrayList<>();
    public Save used_save;

    public void new_save(){
        used_save = new Save(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HHmmssddMMyyyy")),
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("ddMMyyyy")),2023,1,1,true);
        used_save.setSave_index(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HHmmssddMMyyyy")));
        File directory = new File(used_save.getSave_index());
        if (!directory.exists()) directory.mkdir();
        create_database();
        save_to_database();
    }

    public void load_save(Save chosen){
        used_save = chosen;
    }

    private void save_to_database(){
        String path = "jdbc:sqlite:C:/Users/kuba/IdeaProjects/footballsimulator/databases/info.db";
        String query1 = "UPDATE saves SET MostRecent = 0";
        String query2 = "INSERT INTO saves (ID, LastModified, MostRecent, InGameYear, InGameMonth, InGameDay) "+
                "VALUES (?, datetime('now'), 1, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(path);
             PreparedStatement updateStmt = connection.prepareStatement(query1);
             PreparedStatement insertStmt = connection.prepareStatement(query2)) {
            updateStmt.executeUpdate();
            insertStmt.setString(1, used_save.getSave_index());
            insertStmt.setInt(2, used_save.in_game_date.year);
            insertStmt.setInt(3, used_save.in_game_date.month);
            insertStmt.setInt(4, used_save.in_game_date.gameday);
            insertStmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void create_database(){
        File source = new File("C:/Users/kuba/IdeaProjects/footballsimulator/databases/default.db");
        File dest = new File("C:/Users/kuba/IdeaProjects/footballsimulator/"+used_save.getSave_index()+File.separator+used_save.getSave_index()+".db");
        try{
            Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public void existing_saves(){
        String path = "jdbc:sqlite:C:/Users/kuba/IdeaProjects/footballsimulator/databases/info.db";
        String query = "SELECT * FROM saves";
        try (Connection connection = DriverManager.getConnection(path);
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)){
            while(rs.next()){
                saves.add(new Save(rs.getString("ID"),rs.getString("LastModified"),
                        rs.getInt("InGameYear"),rs.getInt("InGameMonth"),
                        rs.getInt("InGameDay"),rs.getInt("MostRecent")==1));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
