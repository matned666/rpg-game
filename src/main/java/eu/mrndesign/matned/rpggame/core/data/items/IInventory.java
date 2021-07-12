package eu.mrndesign.matned.rpggame.core.data.items;

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



    Integer fireResistance();
    void setFireResistance(Integer fireResistanceModifier);

    Integer waterResistance();
    void setWaterResistance(Integer waterResistanceModifier);


    enum InventoryType{

        HELMET,
        ARMOR,
        SHOES,
        GLOVES,
        BELT,
        MELEE_WEAPON,
        RANGED_WEAPON,
        AMULET,
        FOOD,
        BOOK,
        OTHER

    }


}
