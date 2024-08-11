package com.example.footballsimulator.backend;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DatabaseMetaData;


public class Save {

    private String save_index;

    public void new_save(){
        save_index = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HHmmssddMMyyyy"));
        File directory = new File(save_index);
        if (!directory.exists()) directory.mkdir();
        create_database();
    }

    private void create_database(){
        /*try (Connection connection = DriverManager.getConnection("jdbc:sqlite:"+save_index+File.separator+save_index+".db")){
            if(connection != null){
                DatabaseMetaData meta = connection.getMetaData();
            }
        } catch (SQLException e) {
            int z = 1;
        }*/
        File source = new File("C:/Users/kuba/IdeaProjects/footballsimulator/databases/default.db");
        File dest = new File("C:/Users/kuba/IdeaProjects/footballsimulator/"+save_index+File.separator+save_index+".db");
        try{
            Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void load_save(){
    }

}
