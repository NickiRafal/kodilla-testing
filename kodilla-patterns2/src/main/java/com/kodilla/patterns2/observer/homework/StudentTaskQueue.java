package com.kodilla.patterns2.observer.homework;


import java.util.ArrayList;
import java.util.List;

class StudentTaskQueue implements Observable {
    private final List<String> tasks = new ArrayList<>();

    public void addTask(String task) {
        tasks.add(task);
        setChanged();
        notifyObservers(task);
    }
    public String getLastTask() {
        if (tasks.isEmpty()) {
            return "No tasks available";
        }
        return tasks.get(tasks.size() - 1);
    }
    @Override
    public void addObserver(Observer observer) {

    }

    @Override
    public void deleteObserver(Observer observer) {

    }

    @Override
    public void notifyObservers(String task) {

    }

    @Override
    public void setChanged() {

    }
}
