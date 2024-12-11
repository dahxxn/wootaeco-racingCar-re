package com.example.racingcarre.controller;

import com.example.racingcarre.view.InputView;
import com.example.racingcarre.view.OutputView;

public class Controller {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public Controller() {

    }


    public void run(){
        // 사용자에게 입력받기
        String rawCarsInput = inputView.readInput("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String rawRoundCountInput = inputView.readInput("시도할 횟수는 몇 회 인가요?");

        // 입력받은 값 전처리하기


        // 자동차 경주 실행하기(매라운드 별 실행 결과 출력하기)

        // 사용자에게 우승자 출력하기
    }
}
