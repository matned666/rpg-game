package eu.mrndesign.matned.rpggame.core.data.items;

public interface IAttributes {

    Integer getStrength();
    void setStrength(Integer strength);

    Integer getLearning();
    void setLearning(Integer learning);

    Integer getWillpower();
    void setWillpower(Integer willpower);

    Integer getDexterity();
    void setDexterity(Integer dexterity);

    Integer getToughness();
    void setToughness(Integer toughness);

    Integer getCharisma();
    void setCharisma(Integer charisma);

    Integer getAppearance();
    void setAppearance(Integer appearance);

    Integer getMana();
    void setMana(Integer mana);

    Integer getPerception();
    void setPerception(Integer perception);

    Integer getLuck();
    void setLuck(Integer luck);
}
