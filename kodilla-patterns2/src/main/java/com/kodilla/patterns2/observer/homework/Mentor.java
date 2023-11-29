package com.kodilla.patterns2.observer.homework;

class Mentor implements Observer {
    private final String name;
    private int updateCount;

    public Mentor(String name) {
        this.name = name;
    }
    public int getUpdateCount() {
        return updateCount;
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof StudentTaskQueue && arg instanceof String) {
            System.out.println("Mentor " + name + " received a new task: " + arg);
        }
    }
}