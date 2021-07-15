package eu.mrndesign.matned.rpggame.javafx;

import eu.mrndesign.matned.rpggame.core.game.IHero;
import eu.mrndesign.matned.rpggame.javafx.service.IPointService;
import eu.mrndesign.matned.rpggame.javafx.service.PointService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class CharacterInfoController implements Initializable, IController {

    @FXML
    private VBox charInfoVBox;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        init();
    }

    @FXML
    public void onResumeButtonClicked(ActionEvent event){
        Node source = (Node)  event.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
    }

    private void init() {
        IPointService pointService = PointService.getInstance();
        IHero hero = pointService.getHero();
        add("Name: " + hero.get().getName());
        add("");
        add("HP: " + hero.get().getHP());
        add("PV: " + hero.get().getPV());
        add("DV: " + hero.get().getDV());
        add("Weight: " + hero.get().getWeight());
        add("");
        add("Attributes:");
        add("strength: " + hero.get().getAttributes().getStrength());
        add("learning: " + hero.get().getAttributes().getLearning());
        add("willpower: " + hero.get().getAttributes().getWillpower());
        add("dexterity: " + hero.get().getAttributes().getDexterity());
        add("toughness: " + hero.get().getAttributes().getToughness());
        add("charisma: " + hero.get().getAttributes().getCharisma());
        add("appearance: " + hero.get().getAttributes().getAppearance());
        add("mana: " + hero.get().getAttributes().getMana());
        add("perception: " + hero.get().getAttributes().getPerception());
        add("luck: " + hero.get().getAttributes().getLuck());
        add("");
        add("Mental state:");
        add("Scare level: " + hero.get().getStateOfMind().getScared());
        add("Clear level: " + hero.get().getStateOfMind().getClear());
        add("Anger level: " + hero.get().getStateOfMind().getAnger());
        add("Is conscious: " + hero.get().getStateOfMind().isConscious());
        add("");
        add("Is fireproof: " + hero.get().isFireproof());
        add("Is waterproof: " + hero.get().isWaterproof());
        add("Is alive: " + hero.get().isAlive());
        add("Is visible: " + hero.get().isVisible());


    }

    private void add(String s) {
        charInfoVBox.getChildren().add(new Label(s));
    }
}
