package eu.mrndesign.matned.rpggame.core.data.items;

import eu.mrndesign.matned.rpggame.core.data.items.utils.Direction;

public interface IGameObject {

    Long getId();

    String getName();
    void setName(String newName);

    Symbol getSymbol();

    void hit(int hP);

    int getHP();
    Double getX();
    Double getY();
    void setX(double x);
    void setY(double y);

    double getWeight();

    boolean collide(Direction direction, IGameObject collider);

    boolean isVisible();
    void setVisibility();

    boolean isWaterproof();
    void setWaterproof();

    void setFireproof();

    Integer getDV();

    Integer getPV();

    boolean isFireproof();


    enum ActionType {

        ATTACK,
        TALK,
        BARTER,
        MOVE

    }


}