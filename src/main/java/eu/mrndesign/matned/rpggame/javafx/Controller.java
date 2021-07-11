package eu.mrndesign.matned.rpggame.javafx;

import eu.mrndesign.matned.rpggame.javafx.service.IPointService;
import eu.mrndesign.matned.rpggame.javafx.service.PointService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
    public void onOpenMenuDialog(ActionEvent event){
        pointService.addNewLog("Menu dialog has been initiated");
        List<Object> list = setStage("menu");
        FXMLLoader loader = (FXMLLoader) list.get(0);
        AnchorPane parent = (AnchorPane) list.get(1);
        MenuController controller = loader.getController();
        nextStage("Menu screen", parent);
    }

    @FXML
    void onCharacterButtonClicked(ActionEvent event){
        pointService.addNewLog("Character dialog has been initiated");
        List<Object> list = setStage("characterInfo");
        FXMLLoader loader = (FXMLLoader) list.get(0);
        AnchorPane parent = (AnchorPane) list.get(1);
        CharacterInfoController controller = loader.getController();
        controller.init();
        nextStage("Character information screen", parent);
    }

    @FXML
    void onQuestLogButtonClicked(ActionEvent event){
        pointService.addNewLog("Quest log dialog has been initiated");
        List<Object> list = setStage("questlog");
        FXMLLoader loader = (FXMLLoader) list.get(0);
        AnchorPane parent = (AnchorPane) list.get(1);
        QuestLogController controller = loader.getController();
        nextStage("Quest log screen", parent);
    }

    @FXML
    void onInventoryButtonClicked(ActionEvent event){
        pointService.addNewLog("Inventory dialog has been initiated");
        List<Object> list = setStage("inventory");
        InventoryController controller = ((FXMLLoader)list.get(0)).getController();
        nextStage("Inventory screen", ((AnchorPane) list.get(1)));
    }

    @FXML
    void onPlayPauseButtonClicked(ActionEvent event){
        pointService.addNewLog("Action dialog has been initiated");
        List<Object> list = setStage("actionDialog");
        FXMLLoader loader = (FXMLLoader) list.get(0);
        AnchorPane parent = (AnchorPane) list.get(1);
        ActionController controller = loader.getController();
        nextStage("Action screen", parent);
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



    private List<Object> setStage(String file) {
        List<Object> list = new LinkedList<>();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass()
                .getResource("/"+file+".fxml"));
        AnchorPane parent = null;
        try {
            parent = fxmlLoader.load();
            list.add(fxmlLoader);
            list.add(parent);
            return list;
        } catch (IOException e) {
            e.printStackTrace();
            pointService.addNewLog("Exception happened:");
            pointService.addNewLog(e.getMessage());
            return null;
        }
    }

    private void nextStage(String title, AnchorPane parent) {
        Scene scene = new Scene(parent);
        scene.getStylesheets().add(getClass().getResource("/styles.css").toString());
        Stage stage = new Stage();
        stage.setTitle(title);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        pointService.addNewLog("Stage >"+ title +"< has been set");
    }
}
