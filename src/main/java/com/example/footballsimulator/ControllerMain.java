package com.example.footballsimulator;

import com.example.footballsimulator.backend.Save;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Parent;

import java.io.IOException;

public class ControllerMain {
    private Stage stage;
    private Scene scene;
    private VBox container;

    @FXML
    private void new_clicked(ActionEvent event) throws IOException {
        Save save = new Save();
        save.new_save();
        Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }

    @FXML
    private void continue_clicked(){
    }

    @FXML
    private void load_clicked(){
    }

    @FXML
    private void edit_clicked(){
    }

    @FXML
    private void exit_clicked(){
        Platform.exit();
    }
}