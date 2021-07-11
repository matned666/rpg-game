package eu.mrndesign.matned.rpggame.core.data.items;

import java.util.Objects;

public class Attributes implements IAttributes {

    private Integer strength;
    private Integer learning;
    private Integer willpower;
    private Integer dexterity;
    private Integer toughness;
    private Integer charisma;
    private Integer appearance;
    private Integer mana;
    private Integer perception;
    private Integer luck;

    private Attributes(AttributesBuilder builder) {
        this.strength = builder.strength != null? builder.strength: 0;
        this.learning = builder.learning != null? builder.learning: 0;
        this.willpower = builder.willpower != null? builder.willpower: 0;
        this.dexterity = builder.dexterity != null? builder.dexterity: 0;
        this.toughness = builder.toughness != null? builder.toughness: 0;
        this.charisma = builder.charisma != null? builder.charisma: 0;
        this.appearance = builder.appearance != null? builder.appearance: 0;
        this.mana = builder.mana != null? builder.mana: 0;
        this.perception = builder.perception != null? builder.perception: 0;
        this.luck = builder.luck != null? builder.luck: 0;
    }

    @Override
    public Integer getStrength() {
        return strength;
    }

    @Override
    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    @Override
    public Integer getLearning() {
        return learning;
    }

    @Override
    public void setLearning(Integer learning) {
        this.learning = learning;
    }

    @Override
    public Integer getWillpower() {
        return willpower;
    }

    @Override
    public void setWillpower(Integer willpower) {
        this.willpower = willpower;
    }

    @Override
    public Integer getDexterity() {
        return dexterity;
    }

    @Override
    public void setDexterity(Integer dexterity) {
        this.dexterity = dexterity;
    }

    @Override
    public Integer getToughness() {
        return toughness;
    }

    @Override
    public void setToughness(Integer toughness) {
        this.toughness = toughness;
    }

    @Override
    public Integer getCharisma() {
        return charisma;
    }

    @Override
    public void setCharisma(Integer charisma) {
        this.charisma = charisma;
    }

    @Override
    public Integer getAppearance() {
        return appearance;
    }

    @Override
    public void setAppearance(Integer appearance) {
        this.appearance = appearance;
    }

    @Override
    public Integer getMana() {
        return mana;
    }

    @Override
    public void setMana(Integer mana) {
        this.mana = mana;
    }

    @Override
    public Integer getPerception() {
        return perception;
    }

    @Override
    public void setPerception(Integer perception) {
        this.perception = perception;
    }

    @Override
    public Integer getLuck() {
        return perception;
    }

    @Override
    public void setLuck(Integer luck) {
        this.luck = luck;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attributes that = (Attributes) o;
        return Objects.equals(strength, that.strength) && Objects.equals(learning, that.learning) && Objects.equals(willpower, that.willpower) && Objects.equals(dexterity, that.dexterity) && Objects.equals(toughness, that.toughness) && Objects.equals(charisma, that.charisma) && Objects.equals(appearance, that.appearance) && Objects.equals(mana, that.mana) && Objects.equals(perception, that.perception) && Objects.equals(luck, that.luck);
    }

    @Override
    public int hashCode() {
        return Objects.hash(strength, learning, willpower, dexterity, toughness, charisma, appearance, mana, perception, luck);
    }

    @Override
    public String toString() {
        return "Attributes{" +
                "strength=" + strength +
                ", learning=" + learning +
                ", willpower=" + willpower +
                ", dexterity=" + dexterity +
                ", toughness=" + toughness +
                ", charisma=" + charisma +
                ", appearance=" + appearance +
                ", mana=" + mana +
                ", perception=" + perception +
                ", luck=" + luck +
                '}';
    }

    public static class AttributesBuilder{

        private Integer strength;
        private Integer learning;
        private Integer willpower;
        private Integer dexterity;
        private Integer toughness;
        private Integer charisma;
        private Integer appearance;
        private Integer mana;
        private Integer perception;
        private Integer luck;

        public AttributesBuilder() {
        }

        public AttributesBuilder strength(int strength){
            this.strength = strength;
            return this;
        }

        public AttributesBuilder learning(int learning){
            this.learning = learning;
            return this;
        }

        public AttributesBuilder willpower(int willpower){
            this.willpower = willpower;
            return this;
        }

        public AttributesBuilder dexterity(int dexterity){
            this.dexterity = dexterity;
            return this;
        }

        public AttributesBuilder toughness(int toughness){
            this.toughness = toughness;
            return this;
        }

        public AttributesBuilder charisma(int charisma){
            this.charisma = charisma;
            return this;
        }

        public AttributesBuilder appearance(int appearance){
            this.appearance = appearance;
            return this;
        }

        public AttributesBuilder mana(int mana){
            this.mana = mana;
            return this;
        }

        public AttributesBuilder perception(int perception){
            this.perception = perception;
            return this;
        }

        public AttributesBuilder luck(int luck){
            this.luck = luck;
            return this;
        }

        public Attributes build(){
            return new Attributes(this);
        }

    }
}
