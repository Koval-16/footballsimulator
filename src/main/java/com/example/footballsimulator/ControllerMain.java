package com.example.footballsimulator;

import com.example.footballsimulator.backend.MainBackend;
import com.example.footballsimulator.backend.Save;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.Parent;

import java.io.IOException;

public class ControllerMain {
    private Stage stage;
    private Scene scene;


    @FXML
    private void new_clicked(ActionEvent event) throws IOException {
        MainBackend.saveManager.new_save();
        MainBackend.teamList.load_teams();
        MainBackend.teamList.printing();
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
    private void load_clicked(ActionEvent evente) throws IOException{
        MainBackend.saveManager.existing_saves();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("load_save.fxml"));
        Parent root = loader.load();
        ControllerLoad controllerLoad = loader.getController();
        stage = (Stage)((Node)evente.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.setFullScreen(true);
        for (Save save : MainBackend.saveManager.saves){
            Button button = new Button("Save: "+ save.getSave_index());
            button.setOnAction(event -> {
                MainBackend.saveManager.load_save(save);
                MainBackend.teamList.load_teams();
                MainBackend.teamList.printing();
            });
            controllerLoad.container.getChildren().add(button);
        }
        stage.show();
    }

    @FXML
    private void edit_clicked(){
    }

    @FXML
    private void exit_clicked(){
        Platform.exit();
    }
}