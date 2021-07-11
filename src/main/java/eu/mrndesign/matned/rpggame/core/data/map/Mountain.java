package eu.mrndesign.matned.rpggame.core.data.map;

import javafx.scene.paint.Color;

public class Mountain extends MapFragment{

    public static final int APPEAR_CHANCE = 76;

    private static final String WATER_MAP = "mountain";



    public Mountain(IMapFragment eastNode, IMapFragment westNode, IMapFragment northNode, IMapFragment southNode, Integer x, Integer y) {
        super(eastNode, westNode, northNode, southNode, x, y);
    }

    @Override
    public Color getColor() {
        return Color.BROWN;
    }


    @Override
    public boolean isInstanceOf(MapFragment mapFragment) {
        return mapFragment instanceof Mountain;
    }
}
