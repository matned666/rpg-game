package eu.mrndesign.matned.rpggame.javafx;

import eu.mrndesign.matned.rpggame.javafx.service.IPointService;
import eu.mrndesign.matned.rpggame.javafx.service.PointService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class Controller implements Initializable {

    @FXML
    private VBox logsVBox;

    @FXML
    private GridPane mapGrid;

    @FXML
    private ScrollPane scrollPane;

    IPointService pointService;
    boolean isPlaying;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        isPlaying = false;
        scrollPane.vvalueProperty().bind(logsVBox.heightProperty());
        pointService = PointService.getInstance();
        pointService.initiate(logsVBox, mapGrid);
        pointService.addNewLog("");
        pointService.addNewLog("Game started");
    }


    @FXML
    public void onOpenMenuDialog(){
        Dialog.openDialog("Menu", "menu");
    }

    @FXML
    void onCharacterButtonClicked(){
        Dialog.openDialog("Character", "characterInfo");
    }

    @FXML
    void onQuestLogButtonClicked(){
        Dialog.openDialog("Quest log", "questlog");
    }

    @FXML
    void onInventoryButtonClicked(){
        Dialog.openDialog("Inventory", "inventory");
    }

    @FXML
    void onPlayPauseButtonClicked(){
        Dialog.openDialog("Action", "actionDialog");
    }

    @FXML
    void west(){
        pointService.moveWest();
    }

    @FXML
    void north(){
        pointService.moveNorth();
    }

    @FXML
    void south(){
        pointService.moveSouth();
    }

    @FXML
    void east(){
        pointService.moveEast();
    }




}
