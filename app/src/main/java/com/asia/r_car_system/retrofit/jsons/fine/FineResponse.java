
package com.asia.r_car_system.retrofit.jsons.fine;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FineResponse {

    @SerializedName("fines")
    @Expose
    private List<Fine> fines = null;

    public List<Fine> getFines() {
        return fines;
    }
}
