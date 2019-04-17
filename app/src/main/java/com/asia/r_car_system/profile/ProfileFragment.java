package com.asia.r_car_system.profile;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.asia.r_car_system.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {


    public ProfileFragment() {
        // Required empty public constructor
    }

    private View mView ;
    private Context mContext;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView =  inflater.inflate(R.layout.fragment_profile, container, false);
        mContext = mView.getContext() ;
        initUI();
        return mView;
    }



    private void initUI() {

//        btn_addedBalance = mView.findViewById(R.id.balanceControl_btn_addedBalance);
//        btn_addedBalance.setOnClickListener(this);
//        btn_deductedBalance = mView.findViewById(R.id.balanceControl_btn_deductedBalance);
//        btn_deductedBalance.setOnClickListener(this);


    }
}
