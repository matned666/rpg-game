package eu.mrndesign.matned.rpggame.core.data.items.utils;

public enum Direction {

    NORTH,
    NORTH_EAST,
    EAST,
    SOUTH_EAST,
    SOUTH,
    SOUTH_WEST,
    WEST,
    NORTH_WEST,
    STAY;

    public static double changeX(Direction direction){
        switch (direction){
            case SOUTH_EAST:
            case EAST: return -1;
            case NORTH_WEST:
            case WEST: return 1;
            default: return changeXYInner(direction);
        }
    }

    public static double changeY(Direction direction){
        switch (direction){
            case NORTH_WEST:
            case NORTH: return -1;
            case SOUTH_EAST:
            case SOUTH: return 1;
            default: return changeXYInner(direction);
        }
    }

    private static double changeXYInner(Direction direction){
        switch (direction){
            case NORTH_EAST: return -1;
            case SOUTH_WEST: return 1;
            default: return 0;
        }
    }
}
