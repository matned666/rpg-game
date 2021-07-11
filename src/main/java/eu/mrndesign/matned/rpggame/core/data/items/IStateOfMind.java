package eu.mrndesign.matned.rpggame.core.data.items;

public interface IStateOfMind {

    int getScared();

    void setScared(int scared);

    int getClear();

    void setClear(int clear);

    int getAnger();

    void setAnger(int anger);

    boolean isConscious();

    void setConscious(boolean conscious);
}
