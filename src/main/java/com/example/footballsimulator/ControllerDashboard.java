package com.example.footballsimulator;

import com.example.footballsimulator.backend.Date;
import com.example.footballsimulator.backend.MainBackend;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ControllerDashboard {
    @FXML
    private Label Yolabel;

    @FXML
    private void click(){
        Yolabel.setText("Day: "+ MainBackend.saveManager.used_save.in_game_date.gameday+" Month: "+MainBackend.saveManager.used_save.in_game_date.month+" Year: "+MainBackend.saveManager.used_save.in_game_date.year);
        MainBackend.saveManager.used_save.in_game_date.progress_date();
    }
}
