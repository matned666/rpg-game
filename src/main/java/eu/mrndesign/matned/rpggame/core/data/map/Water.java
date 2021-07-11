package eu.mrndesign.matned.rpggame.core.data.map;

import javafx.scene.paint.Color;

public class Water extends MapFragment{

    public static final int APPEAR_CHANCE = 20;

    private static final String WATER_MAP = "water";

    public Water(IMapFragment eastNode,
                 IMapFragment westNode,
                 IMapFragment northNode,
                 IMapFragment southNode,
                 Integer x, Integer y) {
        super(eastNode, westNode, northNode, southNode, x, y);
        this.imageName = WATER_MAP;
    }


    @Override
    public Color getColor() {
        return Color.AQUA;
    }

    @Override
    public boolean isInstanceOf(MapFragment mapFragment) {
        return mapFragment instanceof Water;
    }
}
