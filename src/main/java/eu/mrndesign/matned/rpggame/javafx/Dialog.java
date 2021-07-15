package eu.mrndesign.matned.rpggame.javafx;

import eu.mrndesign.matned.rpggame.javafx.service.IPointService;
import eu.mrndesign.matned.rpggame.javafx.service.PointService;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Dialog {

    private static final IPointService pointService = PointService.getInstance();

    public static void openDialog(String title, String fileName){
        pointService.addNewLog(title + " dialog has been initiated");
        AnchorPane parent = (AnchorPane) setParent(fileName);
        nextStage(title+" screen", parent);
    }

    private static Node setParent(String file) {
        FXMLLoader fxmlLoader = new FXMLLoader(Dialog.class
                .getResource("/"+file+".fxml"));
        AnchorPane parent;
        try {
            parent = fxmlLoader.load();
            return parent;
        } catch (IOException e) {
            e.printStackTrace();
            pointService.addNewLog("Exception happened!!!");
            return null;
        }
    }

    private static void nextStage(String title, AnchorPane parent) {
        Scene scene = new Scene(parent);
        scene.getStylesheets().add(Objects.requireNonNull(Dialog.class.getResource("/styles.css")).toString());
        Stage stage = new Stage();
        stage.setTitle(title);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        pointService.addNewLog("Stage >"+ title +"< has been set");
    }
}
