package com.example.racingcarre.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TotalCar {
    List<Car> cars;

    public TotalCar() {
        cars = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public boolean isCarNameExist(String newCarName){
        return getAllCarName().contains(newCarName);
    }

    private List<String> getAllCarName(){
        List<String> carNames = new ArrayList<>();
        for (Car car : cars) {
            carNames.add(car.name);
        }
        return carNames;
    }

    public Iterator<Car> getAllCar(){
        return cars.iterator();
    }

    public int getTotalCarCount(){
        return cars.size();
    }

}
