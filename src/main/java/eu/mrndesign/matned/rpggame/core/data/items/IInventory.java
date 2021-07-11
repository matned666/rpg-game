package eu.mrndesign.matned.rpggame.core.data.items;

public interface IInventory extends IMovingObject {


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




}
