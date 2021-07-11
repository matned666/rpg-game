package eu.mrndesign.matned.rpggame.core.data.items;

import java.util.Objects;

public class StateOfMind implements IStateOfMind {

    private int scared;
    private int clear;
    private int anger;
    private boolean isConscious;

    public StateOfMind() {
        isConscious = true;
    }

    public StateOfMind(boolean isConscious) {
        this.isConscious = isConscious;
    }

    private StateOfMind(StateOfMindBuilder builder) {
        this.scared = builder.scared;
        this.clear = builder.clear;
        this.anger = builder.anger;
        this.isConscious = builder.isConscious;
    }

    @Override
    public int getScared() {
        return scared;
    }

    @Override
    public void setScared(int scared) {
        this.scared = scared;
    }

    @Override
    public int getClear() {
        return clear;
    }

    @Override
    public void setClear(int clear) {
        this.clear = clear;
    }

    @Override
    public int getAnger() {
        return anger;
    }

    @Override
    public void setAnger(int anger) {
        this.anger = anger;
    }

    @Override
    public boolean isConscious() {
        return isConscious;
    }

    @Override
    public void setConscious(boolean conscious) {
        isConscious = conscious;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StateOfMind that = (StateOfMind) o;
        return scared == that.scared && clear == that.clear && anger == that.anger && isConscious == that.isConscious;
    }

    @Override
    public int hashCode() {
        return Objects.hash(scared, clear, anger, isConscious);
    }

    @Override
    public String toString() {
        return "StateOfMind{" +
                "scared=" + scared +
                ", clear=" + clear +
                ", anger=" + anger +
                ", isConscious=" + isConscious +
                '}';
    }

    public static class StateOfMindBuilder{

        private int scared;
        private int clear;
        private int anger;
        private boolean isConscious;

        public StateOfMindBuilder() {
        }

        public StateOfMindBuilder scared(int scared){
            this.scared = scared;
            return this;
        }

        public StateOfMindBuilder clear(int clear){
            this.clear = clear;
            return this;
        }

        public StateOfMindBuilder anger(int anger){
            this.anger = anger;
            return this;
        }

        public StateOfMindBuilder isConscious(boolean isConscious){
            this.isConscious = isConscious;
            return this;
        }

        public StateOfMind build(){
            return new StateOfMind(this);
        }

    }
}