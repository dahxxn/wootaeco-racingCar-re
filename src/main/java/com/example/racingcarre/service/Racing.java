package com.example.racingcarre.service;

import camp.nextstep.edu.missionutils.Randoms;
import com.example.racingcarre.entity.Car;
import com.example.racingcarre.entity.TotalCar;
import com.example.racingcarre.view.OutputView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Racing {
    TotalCar cars;
    int roundCounts;
    OutputView outputView = new OutputView();

    public Racing(TotalCar cars, int roundCounts) {
        this.cars = cars;
        this.roundCounts = roundCounts;
    }

    public void runRacing() {
        OutputView outputView = new OutputView();
        outputView.printMessage("실행결과");
        for (int i = 0; i < roundCounts; i++) {
            runRound();
        }
    }

    public void runRound() {
        for (Iterator<Car> it = cars.getAllCar(); it.hasNext(); ) {
            Car car = it.next();
            carTurn(car);
        }
        outputView.printCurrentRound(cars.getAllCar());
    }

    public void carTurn(Car car) {
        if (isFastForward()) {
            car.addDistance();
        }
    }

    public boolean isFastForward() {
        return generateRandomState() >= 4;
    }

    private int generateRandomState() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public List<String> getWinners() {
        List<String> winners = new ArrayList<>();
        Iterator<Car> totalCars = cars.getAllCar();
        long max = 0;
        while (totalCars.hasNext()) {
            Car car = totalCars.next();
            long currentDistance = car.getDistance();
            if (currentDistance > max) {
                max = currentDistance;
                winners.add(car.getName());
                continue;
            }
            if (currentDistance == max) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}
