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
        hero.putArmor(new Inventory.InventoryDTOBuilder(IInventory.InventoryType.ARMOR)
                .name("Leather armor")
                .image("leather_armor")
                .dV(getRandom(2, 10))
                .pV(getRandom(2, 10))
                .mHC(getRandom(1, 5))
                .mHV(getRandom(1, 5))
                .rHC(getRandom(1, 5))
                .rHV(getRandom(1, 5))
                .weight((double) getRandom(2, 10))
                .build());
        hero.putShoes(new Inventory.InventoryDTOBuilder(IInventory.InventoryType.SHOES)
                .name("Leather boots")
                .image("leather_boots")
                .dV(getRandom(1, 3))
                .pV(getRandom(1, 4))
                .mHC(getRandom(0, 2))
                .mHV(getRandom(0, 2))
                .rHC(getRandom(0, 2))
                .rHV(getRandom(0, 2))
                .weight((double) getRandom(1, 2))
                .build());
        hero.putPrimaryMeleeWeapon(new Inventory.InventoryDTOBuilder(IInventory.InventoryType.SHOES)
                .name("Short sword")
                .image("short_sword")
                .dV(getRandom(5, 20))
                .pV(getRandom(2, 10))
                .mHC(getRandom(10, 15))
                .mHV(getRandom(5, 20))
                .rHC(getRandom(2, 5))
                .rHV(getRandom(1, 10))
                .weight((double) getRandom(1, 4))
                .build());;

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
