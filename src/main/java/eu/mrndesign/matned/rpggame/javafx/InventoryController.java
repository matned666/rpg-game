package eu.mrndesign.matned.rpggame.javafx;

import eu.mrndesign.matned.rpggame.core.data.items.IInventory;
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

public class InventoryController implements Initializable {

    @FXML
    private VBox helmetVBox;

    @FXML
    private VBox amuletVBox;

    @FXML
    private VBox armorVBox;

    @FXML
    private VBox glovesVBox;

    @FXML
    private VBox beltVBox;

    @FXML
    private VBox bootsVBox;

    @FXML
    private VBox primaryMeleeVBox;

    @FXML
    private VBox secondaryMeleeVBox;

    @FXML
    private VBox rangedVBox;

    private IHero hero;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        IPointService pointService = PointService.getInstance();
        hero = pointService.getHero();
        getItem(hero.getHelmet(), helmetVBox);
        getItem(hero.getAmulet(), amuletVBox);
        getItem(hero.getArmor(), armorVBox);
        getItem(hero.getGloves(), glovesVBox);
        getItem(hero.getBelt(), beltVBox);
        getItem(hero.getShoes(), bootsVBox);
        getItem(hero.getPrimaryMeleeWeapon(), primaryMeleeVBox);
        getItem(hero.getSecondaryMeleeWeapon(), secondaryMeleeVBox);
        getItem(hero.getRangedWeapon(), rangedVBox);
    }

    private void getItem(IInventory item, VBox vBox) {
        if(item != null){
            vBox.getChildren().clear();
            vBox.getChildren().add(new Label("Name: " + item.getName()));
            vBox.getChildren().add(new Label("Inventory type: " + item.getInventoryType().name()));
            vBox.getChildren().add(new Label(""));
            vBox.getChildren().add(new Label("HP: " + item.getHP()));
            vBox.getChildren().add(new Label("PV: " + item.getPV()));
            vBox.getChildren().add(new Label("DV: " + item.getDV()));
            vBox.getChildren().add(new Label("Melee hit chance: " + item.getMeleeHitChance()));
            vBox.getChildren().add(new Label("Melee hit points: " + item.getMeleeHitPoints()));
            vBox.getChildren().add(new Label("Ranged hit chance: " + item.getRangedHitChance()));
            vBox.getChildren().add(new Label("Ranged hit points: " + item.getRangedHitChance()));
            vBox.getChildren().add(new Label("Weight: " + item.getWeight() + "kg"));
        }else {
            vBox.getChildren().clear();
            vBox.getChildren().add(new Label("Empty"));
        }
    }


    @FXML
    public void onResumeButtonClicked(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void onHelmetPutButtonClick() {

    }

    @FXML
    public void onHelmetTakeOffButtonClick() {
        hero.removeHelmet();
        getItem(hero.getHelmet(), helmetVBox);
    }

    @FXML
    public void onArmorPutButtonClick() {

    }

    @FXML
    public void onArmorTakeOffButtonClick() {
        hero.removeArmor();
        getItem(hero.getArmor(), armorVBox);
    }

    @FXML
    public void onBeltPutButtonClick() {

    }

    @FXML
    public void onBeltTakeOffButtonClick() {
        hero.removeBelt();
        getItem(hero.getBelt(), beltVBox);
    }

    @FXML
    public void onGlovesPutButtonClick() {

    }

    @FXML
    public void onGlovesTakeOffButtonClick() {
        hero.removeGloves();
        getItem(hero.getGloves(), glovesVBox);
    }

    @FXML
    public void onBootsPutButtonClick() {

    }

    @FXML
    public void onBootsTakeOffButtonClick() {
        hero.removeShoes();
        getItem(hero.getShoes(), bootsVBox);
    }

    @FXML
    public void onPrimaryMeleePutButtonClick() {

    }

    @FXML
    public void onPrimaryMeleeTakeOffButtonClick() {
        hero.removePrimaryMeleeWeapon();
        getItem(hero.getPrimaryMeleeWeapon(), primaryMeleeVBox);
    }

    @FXML
    public void onSecondaryMeleePutButtonClick() {

    }

    @FXML
    public void onSecondaryMeleeTakeOffButtonClick() {
        hero.removeSecondaryMeleeWeapon();
        getItem(hero.getSecondaryMeleeWeapon(), secondaryMeleeVBox);
    }

    @FXML
    public void onRangedPutButtonClick() {

    }

    @FXML
    public void onRangedTakeOffButtonClick() {
        hero.removeRangedWeapon();
        getItem(hero.getRangedWeapon(), rangedVBox);
    }

    @FXML
    public void onAmuletPutButtonClick() {

    }

    @FXML
    public void onAmuletTakeOffButtonClick() {
        hero.removeAmulet();
        getItem(hero.getAmulet(), amuletVBox);
    }

    @FXML
    public void onBackpackButtonClick() {

    }


}
