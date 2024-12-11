package com.example.racingcarre.service;

import camp.nextstep.edu.missionutils.Randoms;
import com.example.racingcarre.entity.Car;
import com.example.racingcarre.entity.TotalCar;
import java.util.Iterator;

public class Racing {
    TotalCar cars;
    int roundCounts;

    public Racing(TotalCar cars, int roundCounts) {
        this.cars = cars;
        this.roundCounts = roundCounts;
    }

    public void runRacing(){
        for(int i = 0; i < roundCounts; i++){
            runRound();
        }
    }

    public void runRound(){
        for (Iterator<Car> it = cars.getAllCar(); it.hasNext(); ) {
            Car car = it.next();
            carTurn(car);
        }
    }

    public void carTurn(Car car){
        if(isFastForward()){
            car.addDistance();
        }
    }

    public boolean isFastForward(){
        return generateRandomState() >= 4;
    }

    private int generateRandomState(){
        return Randoms.pickNumberInRange(0,9);
    }
}
