package eu.mrndesign.matned.rpggame.core.game;


import eu.mrndesign.matned.rpggame.core.IObservable;
import eu.mrndesign.matned.rpggame.core.IObserver;

/**
 * Service singleton class
 * created to have the same instance for all classes
 */

public class Game implements IObserver {

    private IHero hero;
    private Map map;


    public void initiate(IObserver observer) {
        map = new Map();
        hero = new Hero();
        ((IObservable)hero).addObserver(this);
        ((IObservable)hero).addObserver(observer);
          }



    public IHero getHero() {
        return hero;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    @Override
    public void update(String action) {

    }
}
