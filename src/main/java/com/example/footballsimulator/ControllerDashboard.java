package com.example.footballsimulator;

import com.example.footballsimulator.backend.Date;
import com.example.footballsimulator.backend.MainBackend;
import com.example.footballsimulator.backend.SaveManager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ControllerDashboard {
    @FXML
    private Label Yolabel;

    @FXML
    private void click(){
        Yolabel.setText("Day: "+ MainBackend.saveManager.used_save.getDate().getGameday()+" Year: "+MainBackend.saveManager.used_save.getDate().getYear());
        MainBackend.saveManager.used_save.getDate().progress_date();
    }

    @FXML
    private void exit(){
        MainBackend.saveManager.editing();
        System.exit(0);
    }
}
