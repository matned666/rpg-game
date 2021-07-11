package eu.mrndesign.matned.rpggame.core.data.map;

import javafx.scene.paint.Color;

public class Hill extends MapFragment{

    public static final int APPEAR_CHANCE = 80;

    private static final String WATER_MAP = "hill";


    public Hill(IMapFragment eastNode, IMapFragment westNode, IMapFragment northNode, IMapFragment southNode, Integer x, Integer y) {
        super(eastNode, westNode, northNode, southNode, x, y);
    }

    @Override
    public Color getColor() {
        return Color.GREEN;
    }


    @Override
    public boolean isInstanceOf(MapFragment mapFragment) {
        return mapFragment instanceof Hill;
    }
}
