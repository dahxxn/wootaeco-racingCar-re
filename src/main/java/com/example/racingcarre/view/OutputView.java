package com.example.racingcarre.view;

import com.example.racingcarre.entity.Car;
import java.util.Iterator;

public class OutputView {
    public void printLineBreak() {
        System.out.println();
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public String makeLineByDistance(long distance){
        StringBuilder sb = new StringBuilder();
        for(long i = 0 ; i<distance ; i++){
            sb.append("-");
        }
        return sb.toString();
    }

    public void printCurrentRound(Iterator<Car> currentCars){
        while (currentCars.hasNext()) {
            Car car = currentCars.next();
            car.printState();
        }
        printLineBreak();
    }

    public void printCarState(String name, long distance){
        String CAR_STATE_FORMAT = "%s : %s";
        String distanceVisual = makeLineByDistance(distance);
        System.out.printf(CAR_STATE_FORMAT,name, distanceVisual);
        printLineBreak();
    }

}
