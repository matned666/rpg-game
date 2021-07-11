package eu.mrndesign.matned.rpggame.core.data.items;


public interface ICreature extends IMovingObject {

    IAttributes getAttributes();
    IStateOfMind getStateOfMind();

    String getRace();



    boolean isAlive();
    void setAlive();




}
