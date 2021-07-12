package eu.mrndesign.matned.rpggame.core.data.map;

import javafx.scene.paint.Color;

public class City extends MapFragment{

    public static final int APPEAR_CHANCE = 2;

    private static final String WATER_MAP = "city";


    public City(IMapFragment eastNode, IMapFragment westNode, IMapFragment northNode, IMapFragment southNode, Integer x, Integer y) {
        super(eastNode, westNode, northNode, southNode, x, y);
        name = getRandomCityName();
        this.imageName = WATER_MAP;
    }

    @Override
    public Color getColor() {
        return Color.HOTPINK;
    }

    @Override
    public boolean isInstanceOf(MapFragment mapFragment) {
        return mapFragment instanceof City;
    }

    private String getRandomCityName() {
        int max = 6;
        int min = 1;
        int range = max - min + 1;
        int randomInt =  (int)(Math.random() * range) + min;
        switch (randomInt){
            case 1: return "Avalon";
            case 2: return "Bolboth";
            case 3: return "Vermotnis";
            case 4: return "Chatr";
            default: return "Unnamed city";
        }
    }
}
