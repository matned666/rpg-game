package eu.mrndesign.matned.rpggame.core.game;

import eu.mrndesign.matned.rpggame.core.IObserver;
import eu.mrndesign.matned.rpggame.core.data.items.ICreature;
import eu.mrndesign.matned.rpggame.core.data.items.IInventory;

import java.util.List;

public interface IHero {

    List<IInventory> getInventoryInBackpack();

    ICreature get();

    int getX();
    int getY();
    int getPrevX();
    int getPrevY();

    void setX(int val);
    void setY(int val);
    void setPrevX(int val);
    void setPrevY(int val);


    void attackAction(ICreature creature);
    void moveEast();
    void moveWest();
    void moveNorth();
    void moveSouth();
    void talk(ICreature creature);
    void runAway();
    void pickUpItems(List<IInventory> items);
    void barter();

    void putHelmet(IInventory inventory);
    void removeHelmet();
    IInventory getHelmet();

    void putArmor(IInventory inventory);
    void removeArmor();
    IInventory getArmor();

    void putShoes(IInventory inventory);
    void removeShoes();
    IInventory getShoes();

    void putGloves(IInventory inventory);
    void removeGloves();
    IInventory getGloves();

    void putBelt(IInventory inventory);
    void removeBelt();
    IInventory getBelt();

    void putPrimaryMeleeWeapon(IInventory inventory);
    void removePrimaryMeleeWeapon();
    IInventory getPrimaryMeleeWeapon();

    void putSecondaryMeleeWeapon(IInventory inventory);
    void removeSecondaryMeleeWeapon();
    IInventory getSecondaryMeleeWeapon();

    void putRangedWeapon(IInventory inventory);
    void removeRangedWeapon();
    IInventory getRangedWeapon();

    void putAmulet(IInventory inventory);
    void removeAmulet();
    IInventory getAmulet();

    void putItemOnSlot1(IInventory item);

    void putItemOnSlot2(IInventory item);

    void useItem(IInventory item);

    void dropItem(IInventory item);
}
