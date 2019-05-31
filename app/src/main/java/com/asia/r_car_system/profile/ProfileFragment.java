package com.asia.r_car_system.profile;


import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.asia.r_car_system.R;
import com.asia.r_car_system.helperTools.Dialogs;
import com.asia.r_car_system.helperTools.InternetConnection;
import com.asia.r_car_system.retrofit.ProfileResponse;
import com.asia.r_car_system.retrofit.RetrofitClient;


import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment implements profileInterface {


    private TextView txVw_carNumber,
            chasissNumber,
            txVw_motorNumber,
            txVw_carQwner,
            txVw_carColor,
            txVw_carModel,
            txVw_carType,
            txVw_station,
            txVw_carBrand;

    public ProfileFragment() {
        // Required empty public constructor
    }

    private View mView;
    private Context mContext;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_profile, container, false);
        mContext = mView.getContext();
        initUI();
        if (InternetConnection.isInternetConnection(mContext)) {
            getData();
        } else {
            Toast.makeText(mContext, getResources().getString(R.string.no_internet_connection), Toast.LENGTH_SHORT).show();
        }
        return mView;
    }


    @Override
    public void initUI() {
        txVw_carNumber = mView.findViewById(R.id.profile_txVw_carNumber);
        chasissNumber = mView.findViewById(R.id.profile_txVw_chasissNumber);
        txVw_motorNumber = mView.findViewById(R.id.profile_txVw_motorNumber);
        txVw_carQwner = mView.findViewById(R.id.profile_txVw_carQwner);
        txVw_carColor = mView.findViewById(R.id.profile_txVw_carColor);
        txVw_carModel = mView.findViewById(R.id.profile_txVw_carModel);
        txVw_carType = mView.findViewById(R.id.profile_txVw_carType);
        txVw_station = mView.findViewById(R.id.profile_txVw_station);
        txVw_carBrand = mView.findViewById(R.id.profile_txVw_carBrand);
//        btn_addedBalance = mView.findViewById(R.id.balanceControl_btn_addedBalance);
//        btn_addedBalance.setOnClickListener(this);
//        btn_deductedBalance = mView.findViewById(R.id.balanceControl_btn_deductedBalance);
//        btn_deductedBalance.setOnClickListener(this);


    }

    @Override
    public void getData() throws NullPointerException {
        final Dialog dialog = Dialogs.createProgressBarDialog(mContext, "");
        dialog.show();
        SharedPreferences share = mContext.getSharedPreferences("user", Context.MODE_PRIVATE);
        final String userId = share.getString("userId", "");

        Call<ProfileResponse> call =
                RetrofitClient
                        .getInstance()
                        .getAPI()
                        .profile(userId);


        call.enqueue(new Callback<ProfileResponse>() {
            @Override
            public void onResponse(@NonNull Call<ProfileResponse> call, @NonNull Response<ProfileResponse> response) {
                if (response.isSuccessful()) {
                    try {
                        ProfileResponse profileResponse = response.body();
                        if (Objects.requireNonNull(profileResponse).getStatus()) {

                            //set data into veiws
                            txVw_carNumber.setText(profileResponse.getCarNumber());
                            chasissNumber.setText(profileResponse.getChasissNumber());
                            txVw_motorNumber.setText(profileResponse.getMotorNumber());
                            txVw_carQwner.setText(profileResponse.getCarQwner());
                            txVw_carColor.setText(profileResponse.getCarColor());
                            txVw_carModel.setText(profileResponse.getCarModel());
                            txVw_carType.setText(profileResponse.getCarType());
                            txVw_station.setText(profileResponse.getStation());
                            txVw_carBrand.setText(profileResponse.getCarBrand());

                        } else {
                            Toast.makeText(mContext, mContext.getString(R.string.no_data_found), Toast.LENGTH_SHORT).show();
                        }

                    } catch (NullPointerException e) {
                        Toast.makeText(mContext, "Error " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }


                } else {
                    Toast.makeText(mContext, mContext.getString(R.string.no_data_found), Toast.LENGTH_SHORT).show();
                }

                dialog.dismiss();
            }

            @Override
            public void onFailure(@NonNull Call<ProfileResponse> call, @NonNull Throwable t) {
                Toast.makeText(mContext, "Error " + t.getMessage(), Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

    }
}
