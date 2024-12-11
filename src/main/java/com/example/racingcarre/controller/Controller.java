package com.example.racingcarre.controller;

import com.example.racingcarre.entity.Car;
import com.example.racingcarre.entity.TotalCar;
import com.example.racingcarre.error.CustomException;
import com.example.racingcarre.error.ExceptionMessage;
import com.example.racingcarre.view.InputView;
import com.example.racingcarre.view.OutputView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;

public class Controller {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public Controller() {

    }

    public void checkCarNameHasWhiteSpace(String carInputToken){
        String[] checkCarName= carInputToken.split(" ");
        if(checkCarName.length == 2){
            throw new CustomException(ExceptionMessage.EMPTY_CAR_NAME);
        }
    }

    public String validateCarInputToken(String carInputToken){
        carInputToken = carInputToken.trim();
        checkCarNameHasWhiteSpace(carInputToken);
        if(carInputToken.length() >= 5) {
            throw new CustomException(ExceptionMessage.OVER_CAR_NAME_SIZE);
        }
        return carInputToken;
    }

    public void validateCarTotalCount(TotalCar cars){
        if(cars.getTotalCarCount() < 2){
            throw new CustomException(ExceptionMessage.ONLY_ONE_CAR);
        }
    }

    public TotalCar preprocessingRawCarInput(String rawCarInput){
        String[] carInputTokens = rawCarInput.split(",");
        TotalCar cars = new TotalCar();

        for(String carInputToken : carInputTokens){
            String newCarName = validateCarInputToken(carInputToken);
            if(cars.isCarNameExist(newCarName)){
                throw new CustomException(ExceptionMessage.DUPLICATED_CAR_NAME_EXIST);
            }
            cars.addCar(new Car(newCarName));
        }

        validateCarTotalCount(cars);
        return cars;
    }

    public boolean isNumber(String maybeNumber){
        String regex = "([1-9])([0-9])*|([0-9])";
        return maybeNumber.matches(regex);
    }

    public int preprocessingRawRoundCount(String rawRoundCount){
        rawRoundCount = rawRoundCount.trim();
        if(!isNumber(rawRoundCount)){
            throw new CustomException(ExceptionMessage.WRONG_ROUND_COUNT);
        }
        return Integer.parseInt(rawRoundCount);
    }

    public void run(){
        // 사용자에게 입력받기 & 전처리하기
        String rawCarsInput = inputView.readInput("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        TotalCar cars = preprocessingRawCarInput(rawCarsInput);

        String rawRoundCountInput = inputView.readInput("시도할 횟수는 몇 회 인가요?");
        int roundCount = preprocessingRawRoundCount(rawRoundCountInput);
        // 자동차 경주 실행하기(매라운드 별 실행 결과 출력하기)

        // 사용자에게 우승자 출력하기
    }
}
