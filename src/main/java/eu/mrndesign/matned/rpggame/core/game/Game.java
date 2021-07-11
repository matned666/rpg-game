package eu.mrndesign.matned.rpggame.core.game;


import eu.mrndesign.matned.rpggame.core.data.items.*;
import javafx.scene.paint.Color;

/**
 * Service singleton class
 * created to have the same instance for all classes
 */

public class Game {

    private static Game instance;

    public static Game getInstance() {
        if (instance == null) {
            synchronized (Game.class) {
                if (instance == null)
                    instance = new Game();
            }
        }
        return instance;
    }


    private ICreature hero;
    private Map map;


    private Game() {
        if (instance != null) {
            throw new IllegalStateException("Cannot create new instance, please use getInstance method instead.");
        } else {
            instance = this;
            initiate();
        }
    }


    public void initiate() {
        map = new Map();
        hero = new Creature.CreatureDTOBuilder(new Symbol('@', Color.RED))
                .id(1L)
                .name("Hero")
                .race("Human")
                .hP(getRandom(5, 30))
                .dV(getRandom(5, 30))
                .pV(getRandom(5, 30))
                .weight((double) getRandom(50, 100))
                .isAlive(true)
                .isFireproof(false)
                .isWaterproof(false)
                .isVisible(true)
                .attributes(new Attributes.AttributesBuilder()
                        .appearance(getRandom(5, 30))
                        .charisma(getRandom(5, 30))
                        .dexterity(getRandom(5, 30))
                        .learning(getRandom(5, 30))
                        .luck(getRandom(5, 30))
                        .mana(getRandom(5, 30))
                        .perception(getRandom(5, 30))
                        .strength(getRandom(5, 30))
                        .toughness(getRandom(5, 30))
                        .willpower(getRandom(5, 30))
                        .build())
                .stateOfMind(new StateOfMind.StateOfMindBuilder()
                        .anger(0)
                        .clear(0)
                        .isConscious(true)
                        .scared(0)
                        .build())
                .build();
    }

    public ICreature getHero() {
        return hero;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    private int getRandom(int min, int max) {
        int range = max - min + 1;
        return (int) (Math.random() * range) + min;
    }


}
