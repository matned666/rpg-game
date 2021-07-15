package eu.mrndesign.matned.rpggame.core.data.items;

import eu.mrndesign.matned.rpggame.core.IObservable;
import eu.mrndesign.matned.rpggame.core.IObserver;

import java.util.LinkedList;
import java.util.List;

public class InventorySlots implements IInventorySlots, IObservable {


    private final List<IObserver> observers;
    private final List<IInventory> inventoryInBackpack;
    private IInventory helmet;
    private IInventory armor;
    private IInventory shoes;
    private IInventory gloves;
    private IInventory belt;
    private IInventory primaryMeleeWeapon;
    private IInventory secondaryMeleeWeapon;
    private IInventory rangedWeapon;
    private IInventory amulet;

    public InventorySlots() {
        observers = new LinkedList<>();
        inventoryInBackpack = new LinkedList<>();
    }

    @Override
    public List<IInventory> getInventoryInBackpack() {
        return this.inventoryInBackpack;
    }

    @Override
    public void putHelmet(IInventory inventory) {
        if (inventory != null)
            if (inventory.getInventoryType() == IInventory.InventoryType.HELMET)
            {
                inventoryInBackpack.remove(inventory);
                removeHelmet();
                this.helmet = inventory;
            }
    }

    @Override
    public void removeHelmet() {
        if (this.helmet != null)
            inventoryInBackpack.add(this.helmet);
        this.helmet = null;
    }

    @Override
    public IInventory getHelmet() {
        return this.helmet;
    }

    @Override
    public void putArmor(IInventory inventory) {
        if (inventory != null)
            if (inventory.getInventoryType() == IInventory.InventoryType.ARMOR)
            {
                inventoryInBackpack.remove(inventory);
                removeArmor();
                this.armor = inventory;
            }
    }

    @Override
    public void removeArmor() {
        if (this.armor != null)
            inventoryInBackpack.add(this.armor);
        this.armor = null;
    }

    @Override
    public IInventory getArmor() {
        return this.armor;
    }

    @Override
    public void putShoes(IInventory inventory) {
        if (inventory != null)
            if (inventory.getInventoryType() == IInventory.InventoryType.SHOES)
            {
                inventoryInBackpack.remove(inventory);
                removeShoes();
                this.shoes = inventory;
            }
    }

    @Override
    public void removeShoes() {
        if (this.shoes != null)
            inventoryInBackpack.add(this.shoes);
        this.shoes = null;
    }

    @Override
    public IInventory getShoes() {
        return this.shoes;
    }

    @Override
    public void putGloves(IInventory inventory) {
        if (inventory != null)
            if (inventory.getInventoryType() == IInventory.InventoryType.GLOVES)
            {
                inventoryInBackpack.remove(inventory);
                removeGloves();
                this.gloves = inventory;
            }
    }

    @Override
    public void removeGloves() {
        if (this.gloves != null)
            inventoryInBackpack.add(this.gloves);
        this.gloves = null;
    }

    @Override
    public IInventory getGloves() {
        return this.gloves;
    }

    @Override
    public void putBelt(IInventory inventory) {
        if (inventory != null)
            if (inventory.getInventoryType() == IInventory.InventoryType.BELT)
            {
                inventoryInBackpack.remove(inventory);
                removeBelt();
                this.belt = inventory;
            }
    }

    @Override
    public void removeBelt() {
        if (this.belt != null)
            inventoryInBackpack.add(this.belt);
        this.belt = null;
    }

    @Override
    public IInventory getBelt() {
        return this.belt;
    }

    @Override
    public void putPrimaryMeleeWeapon(IInventory inventory) {
        if (inventory != null)
            if (inventory.getInventoryType() == IInventory.InventoryType.MELEE)
            {
                inventoryInBackpack.remove(inventory);
                removePrimaryMeleeWeapon();
                this.primaryMeleeWeapon = inventory;
            }
    }

    @Override
    public void removePrimaryMeleeWeapon() {
        if (this.primaryMeleeWeapon != null)
            inventoryInBackpack.add(this.primaryMeleeWeapon);
        this.primaryMeleeWeapon = null;
    }

    @Override
    public IInventory getPrimaryMeleeWeapon() {
        return this.primaryMeleeWeapon;
    }

    @Override
    public void putSecondaryMeleeWeapon(IInventory inventory) {
        if (inventory != null)
            if (inventory.getInventoryType() == IInventory.InventoryType.MELEE)
            {
                inventoryInBackpack.remove(inventory);
                removeSecondaryMeleeWeapon();
                this.secondaryMeleeWeapon = inventory;
            }
    }

    @Override
    public void removeSecondaryMeleeWeapon() {
        if (this.secondaryMeleeWeapon != null)
            inventoryInBackpack.add(this.secondaryMeleeWeapon);
        this.secondaryMeleeWeapon = null;
    }

    @Override
    public IInventory getSecondaryMeleeWeapon() {
        return this.secondaryMeleeWeapon;
    }

    @Override
    public void putRangedWeapon(IInventory inventory) {
        if (inventory != null)
            if (inventory.getInventoryType() == IInventory.InventoryType.RANGED) {
                inventoryInBackpack.remove(inventory);
                removeRangedWeapon();
                this.rangedWeapon = inventory;
            }
    }

    @Override
    public void removeRangedWeapon() {
        if (this.rangedWeapon != null)
            inventoryInBackpack.add(this.rangedWeapon);
        this.rangedWeapon = null;
    }

    @Override
    public IInventory getRangedWeapon() {
        return this.rangedWeapon;
    }

    @Override
    public void putAmulet(IInventory inventory) {
        if (inventory != null)
            if (inventory.getInventoryType() == IInventory.InventoryType.AMULET)
            {
                inventoryInBackpack.remove(inventory);
                removeAmulet();
                this.amulet = inventory;
            }
    }

    @Override
    public void removeAmulet() {
        if (this.amulet != null)
            inventoryInBackpack.add(this.amulet);
        notifyObservers("");
        this.amulet = null;
    }

    @Override
    public IInventory getAmulet() {
        return this.amulet;
    }

    @Override
    public void addObserver(IObserver observer) {
        if (observer != null) observers.add(observer);
    }

    @Override
    public void notifyObservers(String action) {
        observers.forEach(observer -> observer.update(action));
    }
}
