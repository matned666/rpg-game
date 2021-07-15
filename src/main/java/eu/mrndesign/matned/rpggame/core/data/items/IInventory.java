package eu.mrndesign.matned.rpggame.core.data.items;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public interface IInventory extends IMovingObject {

    InventoryType getInventoryType();

    Integer getPV();
    void setPV(Integer pVModifier);

    Integer getDV();
    void setDV(Integer dVModifier);

    Integer getMeleeHitChance();
    void setMeleeHitChance(Integer mHCModifier);

    Integer getMeleeHitPoints();
    void setMeleeHitPoints(Integer mHPModifier);

    Integer getRangedHitChance();
    void setRangeHitChance(Integer rHCModifier);

    Integer getRangeHitPoints();
    void setRangeHitPoints(Integer rHPModifier);

    IAttributes getAttributes();

    Integer fireResistance();
    void setFireResistance(Integer fireResistanceModifier);

    Integer waterResistance();
    void setWaterResistance(Integer waterResistanceModifier);

    static void addLabel(VBox vBox, IInventory item) {
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
        vBox.getChildren().add(new Label(""));
        vBox.getChildren().add(new Label("Attributes modifiers:"));
        getAtributeLabel(vBox, "Strength", item.getAttributes().getStrength());
        getAtributeLabel(vBox, "Learning", item.getAttributes().getLearning());
        getAtributeLabel(vBox, "Toughness", item.getAttributes().getToughness());
        getAtributeLabel(vBox, "Willpower", item.getAttributes().getWillpower());
        getAtributeLabel(vBox, "Perception", item.getAttributes().getPerception());
        getAtributeLabel(vBox, "Dexterity", item.getAttributes().getDexterity());
        getAtributeLabel(vBox, "Mana", item.getAttributes().getMana());
        getAtributeLabel(vBox, "Appearance", item.getAttributes().getAppearance());
        getAtributeLabel(vBox, "Charisma", item.getAttributes().getCharisma());
        getAtributeLabel(vBox, "Luck", item.getAttributes().getLuck());

    }

    private static void getAtributeLabel(VBox vBox, String txt, Integer value) {
        if (value != 0)
            vBox.getChildren().add(new Label(txt + ": " + value));
    }

    enum InventoryType{

        HELMET,
        ARMOR,
        SHOES,
        GLOVES,
        BELT,
        MELEE,
        RANGED,
        AMULET,
        FOOD,
        BOOK,
        OTHER;

        public String getImage(){
            if (this == FOOD || this == BOOK || this == OTHER) return "backpack";
            return this.name().toLowerCase();
        }

    }


}
