package eu.mrndesign.matned.rpggame.core.data.items;

import eu.mrndesign.matned.rpggame.core.data.items.utils.Direction;

public abstract class BaseMovingObject extends BaseObject implements IMovingObject {

    @Override
    public void move(Direction direction, Double speed) {
        switch (direction){
            case NORTH:{
                direction(0, -1 * speed);
                break;
            }case NORTH_WEST:{
                direction(-1 * speed /2, -1 * speed/2);
                break;
            }case NORTH_EAST:{
                direction(speed /2, -1 * speed/2);
                break;
            }case WEST:{
                direction(-1 * speed , 0);
                break;
            }case EAST:{
                direction(speed, 0);
                break;
            }case SOUTH:{
                direction(0, speed);
                break;
            }case SOUTH_EAST:{
                direction(speed /2, speed/2);
                break;
            }case SOUTH_WEST:{
                direction(-1 * speed /2, speed/2);
                break;
            } default: direction (0,0);
        }
    }

    private void direction(double xModifier, double yModifier){
        x += xModifier;
        y += yModifier;
    }
}
