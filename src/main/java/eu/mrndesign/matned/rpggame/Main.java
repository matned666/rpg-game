package eu.mrndesign.matned.rpggame;

import eu.mrndesign.matned.rpggame.javafx.Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass()
                .getResource("/rpg.fxml"));
        AnchorPane anchorPane = loader.load();
        Controller controller = loader.getController();
        primaryStage.setTitle("RPG Game");
        Scene scene = new Scene(anchorPane);
        scene.getStylesheets().add(getClass().getResource("/styles.css").toString());

        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
