package eu.mrndesign.matned.rpggame.core.game;

import eu.mrndesign.matned.rpggame.core.data.map.*;
import eu.mrndesign.matned.rpggame.javafx.utils.Variables;


public class Map {


    IMapFragment[][] mapFragments;

    public Map() {
        mapFragments = new IMapFragment[Variables.MAP_X_FIELDS][Variables.MAP_Y_FIELDS];
        generateMap();
    }

    public IMapFragment[][] getFrags(){
        return mapFragments;
    }

    private void generateMap() {

        for (int y = 0; y < mapFragments.length; y++) {
            for (int x = 0; x < mapFragments[y].length; x++) {
                IMapFragment east = x < mapFragments[y].length-1? mapFragments[y][x+1] : null;
                IMapFragment west = x > 0? mapFragments[y][x-1] : null;
                IMapFragment north = y > 0? mapFragments[y-1][x] : null;
                IMapFragment south = y < mapFragments.length-1? mapFragments[y+1][x] : null;
                mapFragments[y][x] = generateField(east, west, north, south, x, y);
            }
        }


    }

    private IMapFragment generateField(IMapFragment east , IMapFragment west, IMapFragment north, IMapFragment south, int x, int y) {
        int randomInt = (int) (Math.random()*(699));
        int actual = 0;
        if (randomInt >= 0 && randomInt <= City.APPEAR_CHANCE) return new City(east, west, north, south, x, y);
        else {
            actual += City.APPEAR_CHANCE;
        }
        if (randomInt >= actual && randomInt <= actual + Field.APPEAR_CHANCE) return new Field(east, west, north, south, x, y);
        else actual += Field.APPEAR_CHANCE;
        if (randomInt >= actual && randomInt <= actual + Forest.APPEAR_CHANCE) return new Forest(east, west, north, south, x, y);
        else actual += Forest.APPEAR_CHANCE;

        if (randomInt >= actual && randomInt <= actual + Hill.APPEAR_CHANCE) return new Hill(east, west, north, south, x, y);
        else actual += Hill.APPEAR_CHANCE;

        if (randomInt >= actual && randomInt <= actual + Mountain.APPEAR_CHANCE) return new Mountain(east, west, north, south, x, y);
        else actual += Mountain.APPEAR_CHANCE;

        if (randomInt >= actual && randomInt <= actual + Road.APPEAR_CHANCE) return new Road(east, west, north, south, x, y);
        else actual += Road.APPEAR_CHANCE;

        if (randomInt >= actual && randomInt <= actual + Swamp.APPEAR_CHANCE) return new Swamp(east, west, north, south, x, y);
        else actual += Swamp.APPEAR_CHANCE;

        if (randomInt >= actual && randomInt <= actual + Village.APPEAR_CHANCE) return new Village(east, west, north, south, x, y);
        else actual += Village.APPEAR_CHANCE;

        if (randomInt >= actual && randomInt <= actual + Water.APPEAR_CHANCE) return new Water(east, west, north, south, x, y);
        else actual += Water.APPEAR_CHANCE;
        return new Field(east, west, north, south, x, y);
    }
}
