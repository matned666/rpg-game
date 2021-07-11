package eu.mrndesign.matned.rpggame.javafx;

import eu.mrndesign.matned.rpggame.core.data.happening.Happening;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class HappeningController {

    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    private Label title;

    @FXML
    private Label description;

    @FXML
    public void onResumeButtonClicked(ActionEvent event){
        Node source = (Node)  event.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void onConfirmButtonClicked(ActionEvent event){
        Node source = (Node)  event.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
//        TODO temporary action
    }

    public void applyHappening(Happening happening) {
        happening.getActions().forEach(action -> choiceBox.getItems().add(action.getTitle()));
        description.setText(happening.getDescription());
        title.setText(happening.getTitle());
    }
}
