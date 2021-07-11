package eu.mrndesign.matned.rpggame.javafx.service;


import eu.mrndesign.matned.rpggame.core.data.items.ICreature;
import javafx.scene.Node;
import javafx.scene.layout.VBox;


public interface IPointService {


    void initiate(Node... nodes);

    void addNewLog(String text);

    void moveWest();

    void moveNorth();

    void moveSouth();

    void moveEast();

    ICreature getHero();

}