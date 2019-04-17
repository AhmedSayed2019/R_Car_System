package com.asia.r_car_system.fine;

public class FindModel {

    private String id  , date , value ,speed ;

    public FindModel(String id, String date, String value, String speed) {
        this.id = id;

        this.date = date;
        this.value = value;
        this.speed = speed;

    }

    public String getId() {
        return id;
    }


    public String getDate() {
        return date;
    }

    public String getValue() {
        return value;
    }

    public String getSpeed() {
        return speed;
    }
}
