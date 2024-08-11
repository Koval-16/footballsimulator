package com.example.footballsimulator;

import com.example.footballsimulator.backend.Date;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ControllerDashboard {
    @FXML
    private Label Yolabel;
    Date date = new Date();

    @FXML
    private void click(){
        Yolabel.setText("Day: "+date.gameday+" Month: "+date.month+" Year: "+date.year);
        date.progress_date();
    }
}
