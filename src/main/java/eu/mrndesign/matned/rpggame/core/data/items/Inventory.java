package eu.mrndesign.matned.rpggame.core.data.items;


import eu.mrndesign.matned.rpggame.core.data.items.utils.Direction;
import javafx.scene.paint.Color;

import java.util.Objects;

public class Inventory extends BaseMovingObject implements IInventory {


    private InventoryType inventoryType;
    private Integer mHC; //  melee hit chance
    private Integer mHV; // melee hit value
    private Integer rHC; // ranged hit chance
    private Integer rHV; // rabged hit value
    private boolean isFireproof;
    private boolean isWaterproof;
    private Integer fireResistance;
    private Integer waterResistance;
    private final IAttributes attributesModifier;


    public Inventory(InventoryDTOBuilder builder) {
        this.inventoryType = builder.inventoryType;
        this.id = builder.id;
        this.symbol = builder.symbol;
        this.name = builder.name;
        this.image = builder.image;
        this.hP = builder.HP;
        this.x = builder.x;
        this.y = builder.y;
        this.weight = builder.weight;
        this.isVisible = builder.isVisible;
        this.pV = builder.pV;
        this.dV = builder.dV;
        this.mHC = builder.mHC;
        this.mHV = builder.mHV;
        this.rHC = builder.rHC;
        this.rHV = builder.rHV;
        this.isFireproof = builder.isFireproof;
        this.isWaterproof = builder.isWaterproof;
        this.fireResistance = builder.fireResistance;
        this.waterResistance = builder.waterResistance;
        this.attributesModifier = builder.attributesModifier;
    }


    @Override
    public boolean collide(Direction direction, IGameObject collider) {
        if (collider instanceof IMovingObject)
            return false;
        else
            return (Direction.changeX(direction) + collider.getX() == this.x) &&
                    (Direction.changeY(direction) + collider.getY() == this.y);
    }


    @Override
    public InventoryType getInventoryType() {
        return inventoryType;
    }

    @Override
    public Integer getPV() {
        return pV;
    }

    @Override
    public void setPV(Integer PVModifier) {
        this.pV += PVModifier;
    }

    @Override
    public Integer getDV() {
        return dV;
    }

    @Override
    public void setDV(Integer DVModifier) {
        this.dV += DVModifier;
    }

    @Override
    public Integer getMeleeHitChance() {
        return mHC;
    }

    @Override
    public void setMeleeHitChance(Integer mHCModifier) {
        this.mHC += mHCModifier;
    }

    @Override
    public Integer getMeleeHitPoints() {
        return mHV;
    }

    @Override
    public void setMeleeHitPoints(Integer mHPModifier) {
        mHV += mHPModifier;
    }

    @Override
    public Integer getRangedHitChance() {
        return rHC;
    }

    @Override
    public void setRangeHitChance(Integer rHCModifier) {
        this.rHC += rHCModifier;
    }

    @Override
    public Integer getRangeHitPoints() {
        return rHV;
    }

    @Override
    public void setRangeHitPoints(Integer rHPModifier) {
        rHV += rHPModifier;
    }

    @Override
    public IAttributes getAttributes() {
        return attributesModifier;
    }


    @Override
    public Integer fireResistance() {
        return fireResistance;
    }

    @Override
    public void setFireResistance(Integer fireResistanceModifier) {
        fireResistance += fireResistanceModifier;
    }

    @Override
    public Integer waterResistance() {
        return waterResistance;
    }

    @Override
    public void setWaterResistance(Integer waterResistanceModifier) {
        waterResistance += waterResistanceModifier;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inventory that = (Inventory) o;
        return hP == that.hP && isVisible == that.isVisible && isFireproof == that.isFireproof && isWaterproof == that.isWaterproof && Objects.equals(symbol, that.symbol) && Objects.equals(x, that.x) && Objects.equals(y, that.y) && Objects.equals(weight, that.weight) && Objects.equals(pV, that.pV) && Objects.equals(dV, that.dV) && Objects.equals(mHC, that.mHC) && Objects.equals(mHV, that.mHV) && Objects.equals(rHC, that.rHC) && Objects.equals(rHV, that.rHV) && Objects.equals(fireResistance, that.fireResistance) && Objects.equals(waterResistance, that.waterResistance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol, hP, x, y, weight, isVisible, pV, dV, mHC, mHV, rHC, rHV, isFireproof, isWaterproof, fireResistance, waterResistance);
    }

    @Override
    public String toString() {
        return "InventoryDTO{" +
                "symbol=" + symbol.toString() +
                ", HP=" + hP +
                ", x=" + x +
                ", y=" + y +
                ", weight=" + weight +
                ", isVisible=" + isVisible +
                ", pV=" + pV +
                ", dV=" + dV +
                ", mHC=" + mHC +
                ", mHV=" + mHV +
                ", rHC=" + rHC +
                ", rHV=" + rHV +
                ", isFireproof=" + isFireproof +
                ", isWaterproof=" + isWaterproof +
                ", fireResistance=" + fireResistance +
                ", waterResistance=" + waterResistance +
                ", attributesModifier=" + attributesModifier.toString() +
                '}';
    }

    public static class InventoryDTOBuilder {

        private final InventoryType inventoryType;
        private Long id;
        private Symbol symbol;
        private String name;
        private String image;
        private int HP;
        private Double x;
        private Double y;
        private Double weight;
        private boolean isVisible;
        private Integer pV;
        private Integer dV;
        private Integer mHC;
        private Integer mHV;
        private Integer rHC;
        private Integer rHV;
        private boolean isFireproof;
        private boolean isWaterproof;
        private Integer fireResistance;
        private Integer waterResistance;
        private IAttributes attributesModifier;

        public InventoryDTOBuilder(InventoryType inventoryType) {
            initDefaultValues();
            this.inventoryType = inventoryType;
        }

        public InventoryDTOBuilder(InventoryType inventoryType, Symbol symbol) {
            initDefaultValues();
            this.inventoryType = inventoryType;
            this.symbol = symbol;
        }

        private void initDefaultValues(){
            id = 0L;
            symbol = new Symbol('!', Color.RED);
            name = "Item";
            HP = 0;
            x = 0.0;
            y = 0.0;
            weight = 0.0;
            isVisible = true;
            pV = 0;
            dV = 0;
            mHC = 0;
            mHV = 0;
            rHC = 0;
            rHV = 0;
            isFireproof = false;
            isWaterproof = false;
            fireResistance = 0;
            waterResistance = 0;
            attributesModifier = new Attributes.AttributesBuilder().build();
        }

        public InventoryDTOBuilder HP(int HP) {
            this.HP = HP;
            return this;
        }

        public InventoryDTOBuilder x(Double x) {
            this.x = x;
            return this;
        }

        public InventoryDTOBuilder y(Double y) {
            this.y = y;
            return this;
        }

        public InventoryDTOBuilder weight(Double weight) {
            this.weight = weight;
            return this;
        }

        public InventoryDTOBuilder isVisible(boolean isVisible) {
            this.isVisible = isVisible;
            return this;
        }

        public InventoryDTOBuilder pV(Integer pV) {
            this.pV = pV;
            return this;
        }

        public InventoryDTOBuilder dV(Integer dV) {
            this.dV = dV;
            return this;
        }

        public InventoryDTOBuilder mHC(Integer mHC) {
            this.mHC = mHC;
            return this;
        }

        public InventoryDTOBuilder mHV(Integer mHV) {
            this.mHV = mHV;
            return this;
        }

        public InventoryDTOBuilder rHC(Integer rHC) {
            this.rHC = rHC;
            return this;
        }

        public InventoryDTOBuilder rHV(Integer rHV) {
            this.rHV = rHV;
            return this;
        }

        public InventoryDTOBuilder isFireproof(boolean isFireproof) {
            this.isFireproof = isFireproof;
            return this;
        }

        public InventoryDTOBuilder isWaterproof(boolean isWaterproof) {
            this.isWaterproof = isWaterproof;
            return this;
        }

        public InventoryDTOBuilder fireResistance(Integer fireResistance) {
            this.fireResistance = fireResistance;
            return this;
        }

        public InventoryDTOBuilder waterResistance(Integer waterResistance) {
            this.waterResistance = waterResistance;
            return this;
        }

        public InventoryDTOBuilder attributesModifier(IAttributes attributesModifier) {
            this.attributesModifier = attributesModifier;
            return this;
        }

        public InventoryDTOBuilder name(String name) {
            this.name = name;
            return this;
        }

        public InventoryDTOBuilder image(String image) {
            this.image = image;
            return this;
        }

        public InventoryDTOBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public Inventory build() {
            return new Inventory(this);
        }
    }
}
