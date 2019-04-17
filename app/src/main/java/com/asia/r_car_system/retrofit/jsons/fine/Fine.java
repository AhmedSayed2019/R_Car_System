
package com.asia.r_car_system.retrofit.jsons.fine;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Fine {

    @SerializedName("fine id")
    @Expose
    private String fineId;
    @SerializedName("fine time")
    @Expose
    private String fineTime;
    @SerializedName("car speed")
    @Expose
    private String carSpeed;
    @SerializedName("fine value")
    @Expose
    private String fineValue;
    @SerializedName("lng")
    @Expose
    private String lng;
    @SerializedName("lat")
    @Expose
    private String lat;
    @SerializedName("user plaint")
    @Expose
    private Object userPlaint;
    @SerializedName("paied check")
    @Expose
    private String paiedCheck;

    public String getFineId() {
        return fineId;
    }

    public void setFineId(String fineId) {
        this.fineId = fineId;
    }

    public Fine withFineId(String fineId) {
        this.fineId = fineId;
        return this;
    }

    public String getFineTime() {
        return fineTime;
    }

    public void setFineTime(String fineTime) {
        this.fineTime = fineTime;
    }

    public Fine withFineTime(String fineTime) {
        this.fineTime = fineTime;
        return this;
    }

    public String getCarSpeed() {
        return carSpeed;
    }

    public void setCarSpeed(String carSpeed) {
        this.carSpeed = carSpeed;
    }

    public Fine withCarSpeed(String carSpeed) {
        this.carSpeed = carSpeed;
        return this;
    }

    public String getFineValue() {
        return fineValue;
    }

    public void setFineValue(String fineValue) {
        this.fineValue = fineValue;
    }

    public Fine withFineValue(String fineValue) {
        this.fineValue = fineValue;
        return this;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public Fine withLng(String lng) {
        this.lng = lng;
        return this;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public Fine withLat(String lat) {
        this.lat = lat;
        return this;
    }

    public Object getUserPlaint() {
        return userPlaint;
    }

    public void setUserPlaint(Object userPlaint) {
        this.userPlaint = userPlaint;
    }

    public Fine withUserPlaint(Object userPlaint) {
        this.userPlaint = userPlaint;
        return this;
    }

    public String getPaiedCheck() {
        return paiedCheck;
    }

    public void setPaiedCheck(String paiedCheck) {
        this.paiedCheck = paiedCheck;
    }

    public Fine withPaiedCheck(String paiedCheck) {
        this.paiedCheck = paiedCheck;
        return this;
    }

}
