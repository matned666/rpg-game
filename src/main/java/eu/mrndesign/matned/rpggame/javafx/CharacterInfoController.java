package eu.mrndesign.matned.rpggame.javafx;

import eu.mrndesign.matned.rpggame.core.data.items.ICreature;
import eu.mrndesign.matned.rpggame.javafx.service.IPointService;
import eu.mrndesign.matned.rpggame.javafx.service.PointService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CharacterInfoController {

    @FXML
    private VBox charInfoVBox;

    private IPointService pointService;
    private ICreature hero;


    public void init() {
        pointService = PointService.getInstance();
        hero = pointService.getHero();
        add("Name: " + hero.getName());
        add("");
        add("HP: " + hero.getHP());
        add("PV: " + hero.getPV());
        add("DV: " + hero.getDV());
        add("Weight: " + hero.getWeight());
        add("");
        add("Attributes:");
        add("strength: " + hero.getAttributes().getStrength());
        add("learning: " + hero.getAttributes().getLearning());
        add("willpower: " + hero.getAttributes().getWillpower());
        add("dexterity: " + hero.getAttributes().getDexterity());
        add("toughness: " + hero.getAttributes().getToughness());
        add("charisma: " + hero.getAttributes().getCharisma());
        add("appearance: " + hero.getAttributes().getAppearance());
        add("mana: " + hero.getAttributes().getMana());
        add("perception: " + hero.getAttributes().getPerception());
        add("luck: " + hero.getAttributes().getLuck());
        add("");
        add("Mental state:");
        add("Scare level: " + hero.getStateOfMind().getScared());
        add("Clear level: " + hero.getStateOfMind().getClear());
        add("Anger level: " + hero.getStateOfMind().getAnger());
        add("Is conscious: " + hero.getStateOfMind().isConscious());
        add("");
        add("Is fireproof: " + hero.isFireproof());
        add("Is waterproof: " + hero.isWaterproof());
        add("Is alive: " + hero.isAlive());
        add("Is visible: " + hero.isVisible());


    }

    private void add(String s) {
        charInfoVBox.getChildren().add(new Label(s));
    }

    @FXML
    public void onResumeButtonClicked(ActionEvent event){
        Node source = (Node)  event.getSource();
        Stage stage  = (Stage) source.getScene().getWindow();
        stage.close();
    }

}
