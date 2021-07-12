package eu.mrndesign.matned.rpggame.core.data.items;


import java.util.List;
import java.util.Objects;

public class Creature extends BaseMovingObject implements ICreature, IInventorySlots {


    private final IAttributes attributes;
    private final IStateOfMind stateOfMind;
    private final String race;
    private boolean isAlive;
    private final IInventorySlots inventory;


    private Creature(CreatureDTOBuilder builder) {

        this.id = builder.id;
        this.symbol = builder.symbol;
        this.x = builder.x;
        this.y = builder.y;
        this.pV = builder.pV;
        this.dV = builder.dV;
        this.weight = builder.weight;
        this.name = builder.name;
        this.image = builder.image;
        this.hP = builder.hP;
        this.attributes = builder.attributes;
        this.stateOfMind = builder.stateOfMind;
        this.race = builder.race;
        this.isVisible = builder.isVisible;
        this.isAlive = builder.isAlive;
        this.isFireproof = builder.isFireproof;
        this.isWaterproof = builder.isWaterproof;
        this.inventory = new InventorySlots();
    }


    @Override
    public IInventorySlots getInventory() {
        return this.inventory;
    }

    @Override
    public IAttributes getAttributes() {
        return attributes;
    }

    @Override
    public IStateOfMind getStateOfMind() {
        return stateOfMind;
    }

    @Override
    public String getRace() {
        return race;
    }


    @Override
    public boolean isAlive() {
        return isAlive;
    }

    @Override
    public void setAlive() {
        this.isAlive = !isAlive;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Creature that = (Creature) o;
        return isAlive == that.isAlive && Objects.equals(attributes, that.attributes) && Objects.equals(stateOfMind, that.stateOfMind) && Objects.equals(race, that.race);
    }

    @Override
    public int hashCode() {
        return Objects.hash(attributes, stateOfMind, race, isAlive);
    }

    @Override
    public String toString() {
        return "CreatureDTO{" +
                "symbol=" + symbol +
                ", x=" + x +
                ", y=" + y +
                ", weight=" + weight +
                ", name='" + name + '\'' +
                ", hP=" + hP +
                ", isVisible=" + isVisible +
                ", isFireproof=" + isFireproof +
                ", isWaterproof=" + isWaterproof +
                ", attributes=" + attributes +
                ", stateOfMind=" + stateOfMind +
                ", race='" + race + '\'' +
                ", isAlive=" + isAlive +
                '}';
    }

    @Override
    public List<IInventory> getInventoryInBackpack() {
        return inventory.getInventoryInBackpack();
    }

    @Override
    public void putHelmet(IInventory inventory) {
        this.inventory.putHelmet(inventory);
    }

    @Override
    public void removeHelmet() {
        inventory.removeHelmet();
    }

    @Override
    public IInventory getHelmet() {
        return inventory.getHelmet();
    }

    @Override
    public void putArmor(IInventory inventory) {
        this.inventory.putArmor(inventory);
    }

    @Override
    public void removeArmor() {
        inventory.removeArmor();
    }

    @Override
    public IInventory getArmor() {
        return inventory.getArmor();
    }

    @Override
    public void putShoes(IInventory inventory) {
        this.inventory.putShoes(inventory);
    }

    @Override
    public void removeShoes() {
        inventory.removeShoes();
    }

    @Override
    public IInventory getShoes() {
        return inventory.getShoes();
    }

    @Override
    public void putGloves(IInventory inventory) {
        this.inventory.putGloves(inventory);
    }

    @Override
    public void removeGloves() {
        inventory.removeGloves();
    }

    @Override
    public IInventory getGloves() {
        return inventory.getGloves();
    }

    @Override
    public void putBelt(IInventory inventory) {
        this.inventory.putBelt(inventory);
    }

    @Override
    public void removeBelt() {
        inventory.removeBelt();
    }

    @Override
    public IInventory getBelt() {
        return inventory.getBelt();
    }

    @Override
    public void putPrimaryMeleeWeapon(IInventory inventory) {
        this.inventory.putPrimaryMeleeWeapon(inventory);
    }

    @Override
    public void removePrimaryMeleeWeapon() {
        inventory.removePrimaryMeleeWeapon();
    }

    @Override
    public IInventory getPrimaryMeleeWeapon() {
        return inventory.getPrimaryMeleeWeapon();
    }

    @Override
    public void putSecondaryMeleeWeapon(IInventory inventory) {
        this.inventory.putSecondaryMeleeWeapon(inventory);
    }

    @Override
    public void removeSecondaryMeleeWeapon() {
        inventory.removeSecondaryMeleeWeapon();
    }

    @Override
    public IInventory getSecondaryMeleeWeapon() {
        return inventory.getSecondaryMeleeWeapon();
    }

    @Override
    public void putRangedWeapon(IInventory inventory) {
        this.inventory.putRangedWeapon(inventory);
    }

    @Override
    public void removeRangedWeapon() {
        inventory.removeRangedWeapon();
    }

    @Override
    public IInventory getRangedWeapon() {
        return inventory.getRangedWeapon();
    }

    @Override
    public void putAmulet(IInventory inventory) {
        this.inventory.putAmulet(inventory);
    }

    @Override
    public void removeAmulet() {
        inventory.removeAmulet();
    }

    @Override
    public IInventory getAmulet() {
        return inventory.getAmulet();
    }

    public static class CreatureDTOBuilder {

        private Long id;
        private final Symbol symbol;
        private String name;
        private String image;
        private Double x;
        private Double y;
        private Double weight;
        private Integer hP;
        private Integer pV;
        private Integer dV;
        private IAttributes attributes;
        private IStateOfMind stateOfMind;
        private String race;
        private boolean isFireproof;
        private boolean isWaterproof;
        private boolean isVisible;
        private boolean isAlive;

        public CreatureDTOBuilder(Symbol symbol) {
            this.symbol = symbol;
        }

        public CreatureDTOBuilder name(String name) {
            this.name = name;
            return this;
        }

        public CreatureDTOBuilder image(String image) {
            this.image = image;
            return this;
        }

        public CreatureDTOBuilder x(Double x) {
            this.x = x;
            return this;
        }

        public CreatureDTOBuilder y(Double y) {
            this.y = y;
            return this;
        }

        public CreatureDTOBuilder weight(Double weight) {
            this.weight = weight;
            return this;
        }

        public CreatureDTOBuilder pV(Integer pV) {
            this.pV = pV;
            return this;
        }

        public CreatureDTOBuilder dV(Integer dV) {
            this.dV = dV;
            return this;
        }

        public CreatureDTOBuilder hP(Integer hP) {
            this.hP = hP;
            return this;
        }

        public CreatureDTOBuilder attributes(IAttributes attributes) {
            this.attributes = attributes;
            return this;
        }

        public CreatureDTOBuilder stateOfMind(IStateOfMind stateOfMind) {
            this.stateOfMind = stateOfMind;
            return this;
        }

        public CreatureDTOBuilder isVisible(boolean isVisible) {
            this.isVisible = isVisible;
            return this;
        }

        public CreatureDTOBuilder isAlive(boolean isAlive) {
            this.isAlive = isAlive;
            return this;
        }

        public CreatureDTOBuilder isFireproof(boolean isFireproof) {
            this.isFireproof = isFireproof;
            return this;
        }

        public CreatureDTOBuilder isWaterproof(boolean isWaterproof) {
            this.isWaterproof = isWaterproof;
            return this;
        }

        public CreatureDTOBuilder race(String race) {
            this.race = race;
            return this;
        }

        public CreatureDTOBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public Creature build() {
            return new Creature(this);
        }

    }
}
