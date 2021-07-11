package eu.mrndesign.matned.rpggame.core.data.items;


import java.util.Objects;

public class Creature extends BaseMovingObject implements ICreature {


    private final IAttributes attributes;
    private final IStateOfMind stateOfMind;
    private final String race;
    private boolean isAlive;


    private Creature(CreatureDTOBuilder builder) {

        this.id = builder.id;
        this.symbol = builder.symbol;
        this.x = builder.x;
        this.y = builder.y;
        this.pV = builder.pV;
        this.dV = builder.dV;
        this.weight = builder.weight;
        this.name = builder.name;
        this.hP = builder.hP;
        this.attributes = builder.attributes;
        this.stateOfMind = builder.stateOfMind;
        this.race = builder.race;
        this.isVisible = builder.isVisible;
        this.isAlive = builder.isAlive;
        this.isFireproof = builder.isFireproof;
        this.isWaterproof = builder.isWaterproof;
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

    public static class CreatureDTOBuilder {

        private Long id;
        private Symbol symbol;
        private String name;
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

        public CreatureDTOBuilder species(String race) {
            this.race = race;
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
