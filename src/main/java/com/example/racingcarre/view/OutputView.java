package com.example.racingcarre.view;

import com.example.racingcarre.entity.Car;
import java.util.Iterator;
import java.util.List;

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

    public void printWinners(List<String> winners){
        String WINNERS_FORMAT_HEAD = "최종 우승자 : ";
        if(winners.size() == 1){
            printMessage(WINNERS_FORMAT_HEAD + winners.getFirst());
            return;
        }
        printMessage(makeLineByWinners(winners));
    }

    public String makeLineByWinners(List<String> winners){
        String WINNERS_FORMAT_HEAD = "최종 우승자 : ";
        StringBuilder sb = new StringBuilder(WINNERS_FORMAT_HEAD);
        for(String winner : winners){
            sb.append(winner);
            sb.append(", ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

}
