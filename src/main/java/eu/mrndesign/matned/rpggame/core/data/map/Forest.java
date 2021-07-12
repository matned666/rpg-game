package eu.mrndesign.matned.rpggame.core.data.map;

import javafx.scene.paint.Color;

public class Forest extends MapFragment{

    public static final int APPEAR_CHANCE = 300;

    private static final String WATER_MAP = "forest";


    public Forest(IMapFragment eastNode, IMapFragment westNode, IMapFragment northNode, IMapFragment southNode, Integer x, Integer y) {
        super(eastNode, westNode, northNode, southNode, x, y);
        this.imageName = WATER_MAP;
    }

    @Override
    public Color getColor() {
        return Color.DARKGREEN;
    }


    @Override
    public boolean isInstanceOf(MapFragment mapFragment) {
        return mapFragment instanceof Forest;
    }
}
