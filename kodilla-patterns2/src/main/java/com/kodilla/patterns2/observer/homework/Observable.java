package com.kodilla.patterns2.observer.homework;

public interface Observable {
    void addObserver(Observer observer);
    void deleteObserver(Observer observer);
    void notifyObservers(String task);
    void setChanged();
}
