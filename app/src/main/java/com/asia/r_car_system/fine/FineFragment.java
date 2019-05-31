package com.asia.r_car_system.fine;


import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.asia.r_car_system.helperTools.Dialogs;
import com.asia.r_car_system.helperTools.InternetConnection;
import com.asia.r_car_system.R;
import com.asia.r_car_system.retrofit.RetrofitClient;
import com.asia.r_car_system.retrofit.jsons.fine.Fine;
import com.asia.r_car_system.retrofit.jsons.fine.FineResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class FineFragment extends Fragment implements FineInterface {


    private ArrayList<FindModel> mList;

    private RecyclerView.Adapter mListAdapter;
    private Dialog dialog;

    public FineFragment() {
        // Required empty public constructor
    }

    private View mView;
    private Context mContext;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_fine, container, false);
        mContext = mView.getContext();
        initializeRecyclerView();

        return mView;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (InternetConnection.isInternetConnection(mContext)) {
            dialog = Dialogs.createProgressBarDialog(mContext, "");
            getData();
        } else {
            Toast.makeText(mContext, getResources().getString(R.string.no_internet_connection), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void getData() {

        mList.clear();
        SharedPreferences share = mContext.getSharedPreferences("user", Context.MODE_PRIVATE);
        final String userId = share.getString("userId", "");
        Call<FineResponse> call =
                RetrofitClient
                        .getInstance()
                        .getAPI()
                        .fine(userId);


        call.enqueue(new Callback<FineResponse>() {
            @Override
            public void onResponse(@NonNull Call<FineResponse> call, @NonNull Response<FineResponse> response) {
                if (response.isSuccessful()) {
                    try {

                        FineResponse listFind = response.body();

                        // get all list_books from server
                        List<Fine> fines = Objects.requireNonNull(listFind).getFines();
                        for (int index = 0; index < fines.size(); index++) {
                            // get fine
                            Fine fine = fines.get(index);
                            // add fines to arrayList
                            mList.add(new FindModel(fine.getFineId(), fine.getFineTime(), fine.getFineValue() + " EGP"
                                    , fine.getCarSpeed() + " KM/H"));
                            mListAdapter.notifyDataSetChanged();

                        }


                    } catch (NullPointerException e) {
                        Toast.makeText(mContext, "Error " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(mContext, "No data", Toast.LENGTH_SHORT).show();
                }


                dialog.dismiss();
            }

            @Override
            public void onFailure(@NonNull Call<FineResponse> call, @NonNull Throwable t) {
                Toast.makeText(mContext, "Error " + t.getMessage(), Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

    }


    @Override
    public void initializeRecyclerView() {
        mList = new ArrayList<>();
        RecyclerView mFineList = mView.findViewById(R.id.fine_rcyVw_fineList);
        mFineList.setNestedScrollingEnabled(false);
        mFineList.setHasFixedSize(false);
        RecyclerView.LayoutManager mAddedBalanceListLayoutManager = new LinearLayoutManager(mContext, LinearLayout.VERTICAL, false);
        mFineList.setLayoutManager(mAddedBalanceListLayoutManager);
        mListAdapter = new FineAdabter(mContext, mList);
        mFineList.setAdapter(mListAdapter);
    }
}
