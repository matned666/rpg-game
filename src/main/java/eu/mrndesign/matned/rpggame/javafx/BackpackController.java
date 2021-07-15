package eu.mrndesign.matned.rpggame.javafx;

import eu.mrndesign.matned.rpggame.core.data.items.IInventory;
import eu.mrndesign.matned.rpggame.javafx.service.IPointService;
import eu.mrndesign.matned.rpggame.javafx.service.PointService;
import eu.mrndesign.matned.rpggame.javafx.utils.Background;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class BackpackController implements Initializable, IController {


    @FXML
    private VBox backpackLog;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        IPointService service = PointService.getInstance();
        backpackLog.getChildren();
        service.getHero().getInventoryInBackpack().forEach(item -> {
            try {
                loadPanel(item);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }

    @FXML
    public void onResumeButtonClicked(ActionEvent event){
        Node source = (Node)  event.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
    }

    public void loadPanel (IInventory item) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/backpackitem.fxml")));
        AnchorPane backpackItem = fxmlLoader.load();
        BackpackElementController controller = fxmlLoader.getController();
        controller.setItem(item);
        backpackLog.getChildren().add(backpackItem);
    }






}
