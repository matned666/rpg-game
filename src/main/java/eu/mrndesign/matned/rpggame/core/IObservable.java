package eu.mrndesign.matned.rpggame.core;

public interface IObservable {

    void addObserver(IObserver observer);
    void notifyObservers(String action);
}
