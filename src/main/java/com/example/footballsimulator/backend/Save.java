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
import java.util.ArrayList;


public class Save {

    private String save_index;
    private String last_modified;
    private Date in_game_date;
    private boolean most_recent;

    public Save(String save_index, String last_modified, int year, int day, boolean most_recent){
        this.save_index = save_index;
        this.last_modified = last_modified;
        in_game_date = new Date(year,day);
        this.most_recent = most_recent;
    }


    public String getSave_index(){
        return save_index;
    }

    public void setSave_index(String save_index){
        this.save_index = save_index;
    }
    public Date getDate() {
        return in_game_date;
    }
    public boolean isMost_recent(){
        return most_recent;
    }
}
