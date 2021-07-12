package eu.mrndesign.matned.rpggame.core.data.items;


import java.util.List;

public interface IInventorySlots {



    List<IInventory> getInventoryInBackpack();

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


}
