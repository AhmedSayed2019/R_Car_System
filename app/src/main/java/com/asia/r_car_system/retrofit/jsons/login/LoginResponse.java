
package com.asia.r_car_system.retrofit.jsons.login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("username")
    @Expose
    private String username;

    public Boolean getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }
}