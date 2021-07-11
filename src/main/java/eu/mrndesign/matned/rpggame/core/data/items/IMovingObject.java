package eu.mrndesign.matned.rpggame.core.data.items;

import eu.mrndesign.matned.rpggame.core.data.items.utils.Direction;

public interface IMovingObject extends IGameObject {

    void move(Direction direction, Double speed);


}
