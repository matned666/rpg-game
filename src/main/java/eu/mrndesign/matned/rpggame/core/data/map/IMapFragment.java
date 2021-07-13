package eu.mrndesign.matned.rpggame.core.data.map;

import javafx.scene.paint.Color;

public interface IMapFragment {

    String getName();

    Color getColor();

    String getImage();

    boolean isInstanceOf(MapFragment mapFragment);

    Integer getX();
    Integer getY();

    void setX(Integer x);
    void setY(Integer y);

    boolean isVisible();
    void setVisible();


}
