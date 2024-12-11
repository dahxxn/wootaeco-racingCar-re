package com.example.racingcarre.entity;

import com.example.racingcarre.view.OutputView;

public class Car {
    String name;
    long distance;

    public Car(String name){
        this.name = name;
        this.distance = 0;
    }

    public long addDistance(){
        this.distance += 1;
        return this.distance;
    }

    public void printState(){
        OutputView outputView = new OutputView();
        outputView.printCarState(name, distance);
    }

    public long getDistance(){
        return this.distance;
    }

    public String getName(){
        return this.name;
    }
}
