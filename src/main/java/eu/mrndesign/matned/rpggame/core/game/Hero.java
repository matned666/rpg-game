package eu.mrndesign.matned.rpggame.core.game;

import eu.mrndesign.matned.rpggame.core.IObserver;
import eu.mrndesign.matned.rpggame.core.data.items.*;
import eu.mrndesign.matned.rpggame.core.data.items.utils.Direction;
import eu.mrndesign.matned.rpggame.javafx.utils.Variables;
import javafx.scene.paint.Color;

import java.util.LinkedList;
import java.util.List;

public class Hero implements IHero {

    public static final double SPEED = 1D;
    public static final String MOVE_EAST = "MOVE_EAST";
    public static final String MOVE_WEST = "MOVE_WEST";
    public static final String MOVE_SOUTH = "MOVE_SOUTH";
    public static final String MOVE_NORTH = "MOVE_NORTH";

    private final List<IObserver> observerList;
    private final ICreature hero;

    private int x;
    private int y;
    private int prevX;
    private int prevY;

    public Hero() {
        hero = createCreature();
        createEquipment();
        observerList = new LinkedList<>();
    }


    @Override
    public void addObserver(IObserver observer) {
        observerList.add(observer);
    }

    @Override
    public ICreature get() {
        return hero;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public int getPrevX() {
        return prevX;
    }

    @Override
    public int getPrevY() {
        return prevY;
    }

    @Override
    public void setX(int val) {
        this.x = val;
    }

    @Override
    public void setY(int val) {
        this.y = val;
    }

    @Override
    public void setPrevX(int val) {
        this.prevX = val;
    }

    @Override
    public void setPrevY(int val) {
        this.prevY = val;
    }

    @Override
    public List<IInventory> getInventoryInBackpack() {
        return hero.getInventoryInBackpack();
    }

    @Override
    public void attackAction(ICreature creature) {
//TODO
    }

    @Override
    public void moveEast() {
        move(Direction.EAST, MOVE_EAST);
    }

    @Override
    public void moveWest() {
        move(Direction.WEST, MOVE_WEST);

    }

    @Override
    public void moveNorth() {
        move(Direction.NORTH, MOVE_NORTH);

    }

    @Override
    public void moveSouth() {
        move(Direction.SOUTH, MOVE_SOUTH);

    }

    @Override
    public void talk(ICreature creature) {
//TODO
    }

    @Override
    public void runAway() {
        switch (getRandom(1, 4)) {
            case 1: {
                moveWest();
                break;
            }
            case 2: {
                moveEast();
                break;
            }
            case 3: {
                moveNorth();
                break;
            }
            default:
                moveSouth();
        }
    }

    @Override
    public void pickUpItems(List<IInventory> items) {
        hero.getInventory().getInventoryInBackpack().addAll(items);
    }

    @Override
    public void barter() {
//TODO
    }

    @Override
    public void putHelmet(IInventory inventory) {
        hero.putHelmet(inventory);
    }

    @Override
    public void removeHelmet() {
        hero.removeHelmet();
    }

    @Override
    public IInventory getHelmet() {
        return hero.getHelmet();
    }

    @Override
    public void putArmor(IInventory inventory) {
        hero.putArmor(inventory);
    }

    @Override
    public void removeArmor() {
        hero.removeArmor();
    }

    @Override
    public IInventory getArmor() {
        return hero.getArmor();
    }

    @Override
    public void putShoes(IInventory inventory) {
        hero.putShoes(inventory);
    }

    @Override
    public void removeShoes() {
        hero.removeShoes();
    }

    @Override
    public IInventory getShoes() {
        return hero.getShoes();
    }

    @Override
    public void putGloves(IInventory inventory) {
        hero.putGloves(inventory);
    }

    @Override
    public void removeGloves() {
        hero.removeShoes();
    }

    @Override
    public IInventory getGloves() {
        return hero.getGloves();
    }

    @Override
    public void putBelt(IInventory inventory) {
        hero.putBelt(inventory);
    }

    @Override
    public void removeBelt() {
        hero.removeBelt();
    }

    @Override
    public IInventory getBelt() {
        return hero.getBelt();
    }

    @Override
    public void putPrimaryMeleeWeapon(IInventory inventory) {
        hero.putPrimaryMeleeWeapon(inventory);
    }

    @Override
    public void removePrimaryMeleeWeapon() {
        hero.removePrimaryMeleeWeapon();
    }

    @Override
    public IInventory getPrimaryMeleeWeapon() {
        return hero.getPrimaryMeleeWeapon();
    }

    @Override
    public void putSecondaryMeleeWeapon(IInventory inventory) {
        hero.putSecondaryMeleeWeapon(inventory);
    }

    @Override
    public void removeSecondaryMeleeWeapon() {
        hero.removeSecondaryMeleeWeapon();
    }

    @Override
    public IInventory getSecondaryMeleeWeapon() {
        return hero.getSecondaryMeleeWeapon();
    }

    @Override
    public void putRangedWeapon(IInventory inventory) {
        hero.putRangedWeapon(inventory);
    }

    @Override
    public void removeRangedWeapon() {
        hero.removeRangedWeapon();
    }

    @Override
    public IInventory getRangedWeapon() {
        return hero.getRangedWeapon();
    }

    @Override
    public void putAmulet(IInventory inventory) {
        hero.putAmulet(inventory);
    }

    @Override
    public void removeAmulet() {
        hero.removeAmulet();
    }

    @Override
    public IInventory getAmulet() {
        return hero.getAmulet();
    }

    private void notifyObservers(String action) {
        observerList.forEach(observer -> observer.heroUpdated(action));
    }

    private void move(Direction direction, String notification){
        if(checkDirectionPossibility(direction)) {
            switchPreviousLocationAsCurrent();
            hero.move(direction, SPEED);
            refreshCurrentLocation();
            notifyObservers(notification);
        }
    }

    private boolean checkDirectionPossibility(Direction d) {
        switch (d){
            case SOUTH: return y < Variables.MAP_Y_FIELDS - SPEED;
            case NORTH: return y >= 0 + SPEED;
            case WEST: return x >= 0 + SPEED;
            case EAST: return x < Variables.MAP_X_FIELDS - SPEED;
        }
        return false;
    }

    private void refreshCurrentLocation() {
        this.x = hero.getX().intValue();
        this.y = hero.getY().intValue();
    }

    private void switchPreviousLocationAsCurrent() {
        prevY = y;
        prevX = x;
    }

    private ICreature createCreature() {
        this.x = getRandom(0, Variables.MAP_X_FIELDS-1);
        this.y = getRandom(0, Variables.MAP_Y_FIELDS-1);
        this.prevX = x;
        this.prevY = y;
        return new Creature.CreatureDTOBuilder(new Symbol('@', Color.RED))
                .id(1L)
                .x((double) x)
                .y((double) y)
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

    private void createEquipment() {
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
        hero.putPrimaryMeleeWeapon(new Inventory.InventoryDTOBuilder(IInventory.InventoryType.MELEE_WEAPON)
                .name("Short sword")
                .image("short_sword")
                .dV(getRandom(5, 20))
                .pV(getRandom(2, 10))
                .mHC(getRandom(10, 15))
                .mHV(getRandom(5, 20))
                .rHC(getRandom(2, 5))
                .rHV(getRandom(1, 10))
                .weight((double) getRandom(1, 4))
                .build());
        ;
    }

    private int getRandom(int min, int max) {
        int range = max - min + 1;
        return (int) (Math.random() * range) + min;
    }
}
