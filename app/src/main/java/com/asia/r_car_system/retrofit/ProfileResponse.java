package com.asia.r_car_system.retrofit;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProfileResponse {

    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("car number")
    @Expose
    private String carNumber;
    @SerializedName("chasiss number")
    @Expose
    private String chasissNumber;
    @SerializedName("motor number")
    @Expose
    private String motorNumber;
    @SerializedName("car qwner")
    @Expose
    private String carQwner;
    @SerializedName("car color")
    @Expose
    private String carColor;
    @SerializedName("car model")
    @Expose
    private String carModel;
    @SerializedName("car type")
    @Expose
    private String carType;
    @SerializedName("phone number")
    @Expose
    private String phoneNumber;
    @SerializedName("station")
    @Expose
    private String station;
    @SerializedName("car brand")
    @Expose
    private String carBrand;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public ProfileResponse withStatus(Boolean status) {
        this.status = status;
        return this;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public ProfileResponse withCarNumber(String carNumber) {
        this.carNumber = carNumber;
        return this;
    }

    public String getChasissNumber() {
        return chasissNumber;
    }

    public void setChasissNumber(String chasissNumber) {
        this.chasissNumber = chasissNumber;
    }

    public ProfileResponse withChasissNumber(String chasissNumber) {
        this.chasissNumber = chasissNumber;
        return this;
    }

    public String getMotorNumber() {
        return motorNumber;
    }

    public void setMotorNumber(String motorNumber) {
        this.motorNumber = motorNumber;
    }

    public ProfileResponse withMotorNumber(String motorNumber) {
        this.motorNumber = motorNumber;
        return this;
    }

    public String getCarQwner() {
        return carQwner;
    }

    public void setCarQwner(String carQwner) {
        this.carQwner = carQwner;
    }

    public ProfileResponse withCarQwner(String carQwner) {
        this.carQwner = carQwner;
        return this;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public ProfileResponse withCarColor(String carColor) {
        this.carColor = carColor;
        return this;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public ProfileResponse withCarModel(String carModel) {
        this.carModel = carModel;
        return this;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public ProfileResponse withCarType(String carType) {
        this.carType = carType;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ProfileResponse withPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public ProfileResponse withStation(String station) {
        this.station = station;
        return this;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public ProfileResponse withCarBrand(String carBrand) {
        this.carBrand = carBrand;
        return this;
    }

}
