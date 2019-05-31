package com.asia.r_car_system.fine;

public class FindModel {

    private String id, date, value, speed;

    FindModel(String id, String date, String value, String speed) {
        this.id = id;

        this.date = date;
        this.value = value;
        this.speed = speed;
    }

    public String getId() {
        return id;
    }


    String getDate() {
        return date;
    }

    String getValue() {
        return value;
    }

    String getSpeed() {
        return speed;
    }
}
