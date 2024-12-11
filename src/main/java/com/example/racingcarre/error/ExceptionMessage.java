package com.example.racingcarre.error;

public enum ExceptionMessage {
    OVER_CAR_NAME_SIZE("자동차 이름의 길이가 5자 넘습니다. "),
    EMPTY_CAR_NAME("자동차 이름에 공백이 올 수 없습니다. "),
    ONLY_ONE_CAR("자동차는 2개 이상 존재해야 합니다. "),
    DUPLICATED_CAR_NAME_EXIST("자동차 이름이 중복될 수 없습니다. "),
    WRONG_ROUND_COUNT("유효하지 않는 실행 횟수입니다. "),
    ZERO_ROUND_COUNT("실행 횟수는 1회 이상이어야 합니다. ")
    ;

    private final String ERROR_MESSAGE_HEAD = "[ERROR] ";
    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String toString() {
        return this.ERROR_MESSAGE_HEAD + message;
    }

}
