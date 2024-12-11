package com.example.racingcarre.entity;

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
}
