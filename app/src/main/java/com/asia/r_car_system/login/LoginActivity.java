package com.asia.r_car_system.login;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.asia.r_car_system.helperTools.ButtonAnim;
import com.asia.r_car_system.helperTools.Dialogs;
import com.asia.r_car_system.helperTools.InternetConnection;
import com.asia.r_car_system.main.MainActivity;
import com.asia.r_car_system.R;
import com.asia.r_car_system.retrofit.RetrofitClient;
import com.asia.r_car_system.retrofit.jsons.login.LoginResponse;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements LoginInterface, View.OnClickListener {
    private EditText edtx_phone, edtx_password;
    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initUI();
    }


    @Override
    public void initUI() {

        edtx_phone = findViewById(R.id.login_edtx_phone);
        edtx_password = findViewById(R.id.login_edtx_password);
        findViewById(R.id.login_btn_signIn).setOnClickListener(this);

        //TODO : remove
        edtx_phone.setText("01001949923");
        edtx_password.setText("951236874 ");

    }


    @Override
    public void onClick(final View v) {

        ViewCompat.animate(v)
                .setDuration(150)
                .scaleX(0.9f)
                .scaleY(0.9f)
                .setInterpolator(new ButtonAnim())
                .setListener(new ViewPropertyAnimatorListener() {
                    @Override
                    public void onAnimationStart(final View view) {

                    }

                    @Override
                    public void onAnimationEnd(final View view) {
                        switch (v.getId()) {
                            case R.id.login_btn_signIn:
                                if (InternetConnection.isInternetConnection(LoginActivity.this)) {
                                    dialog = Dialogs.createProgressBarDialog(LoginActivity.this, "");
                                    loginUser();

                                } else {
                                    Toast.makeText(LoginActivity.this, getResources().getString(R.string.no_internet_connection), Toast.LENGTH_SHORT).show();
                                }

                                break;
                            default:
                                break;
                        }
                    }

                    @Override
                    public void onAnimationCancel(final View view) {

                    }
                })
                .withLayer()
                .start();
    }

    @Override
    public void loginUser() {
        final String phone = edtx_phone.getText().toString().trim();
        final String password = edtx_password.getText().toString();
        if (phone.isEmpty()) {
            edtx_phone.setError("Email is required");
            edtx_phone.requestFocus();

        } else {


            if (password.isEmpty()) {
                edtx_password.setError("Password is required");
                edtx_password.requestFocus();
            } else {
                dialog.show();
                Call<LoginResponse> call =
                        RetrofitClient
                                .getInstance()
                                .getAPI()
                                .userLogin(phone, password);


                call.enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        if (response.isSuccessful()) {
                            try {
                                LoginResponse loginResponse = response.body();
                                if (Objects.requireNonNull(loginResponse).getStatus()) {
                                    Toast.makeText(LoginActivity.this, "done", Toast.LENGTH_SHORT).show();
                                    //  save LoginJson in shared preference
                                    SharedPreferences share = getSharedPreferences("user", MODE_PRIVATE);
                                    SharedPreferences.Editor editor = share.edit();
                                    editor.putBoolean("isLogin", true);
                                    editor.putString("userId", loginResponse.getId());
                                    editor.apply();
                                    editor.commit(); // commit changes

//                                 go to main  activity
                                    Intent bus = new Intent(LoginActivity.this, MainActivity.class);
                                    startActivity(bus);
                                    bus.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                    finish();
                                }else {
                                    Toast.makeText(LoginActivity.this, loginResponse.getMessage(), Toast.LENGTH_SHORT).show();
                                }

                            }catch (NullPointerException e){
                                Toast.makeText(LoginActivity.this, "Error "+e.getMessage(), Toast.LENGTH_SHORT).show();
                            }


                        } else {
                            Toast.makeText(LoginActivity.this, "No data", Toast.LENGTH_SHORT).show();
                        }

                        dialog.dismiss();
                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {
                        Toast.makeText(LoginActivity.this, "Error " + t.getMessage(), Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });


//                edtx_phone.setText("01001949923");
//                edtx_password.setText("951236874 ");
//                call.enqueue(new Callback<ProfileResponse>() {
//                    @Override
//                    public void onResponse(Call<ProfileResponse> call, retrofit2.Response<ProfileResponse> response) {
//                        if (response.isSuccessful()) {
//                            Toast.makeText(LoginActivity.this, "done", Toast.LENGTH_SHORT).show();
//                        }else {
//                            Toast.makeText(LoginActivity.this, "no", Toast.LENGTH_SHORT).show();
//                        }
//                        ProfileResponse loginResponse = response.body();
//                        try {
//
//                            if (!loginResponse.getStatus()) {
//                                String id = loginResponse.getId();
                ////                add user infromation to user table in DBLite
//
//                                Toast.makeText(LoginActivity.this, id, Toast.LENGTH_SHORT).show();
//                                dialog.dismiss();

                ////                                save LoginJson in shared preference
//                                SharedPreferences share = getSharedPreferences("user", MODE_PRIVATE);
//                                SharedPreferences.Editor editor = share.edit();
//                                editor.putBoolean("isLogin", true);
//                                editor.apply();
//                                editor.commit(); // commit changes
//
//                                 go to main  activity
//   //                             Intent bus = new Intent(LoginActivity.this, MainActivity.class);
//                                startActivity(bus);
//                                bus.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                                finish();
//
//

//                            } else {
//                                Toast.makeText(LoginActivity.this, loginResponse.getMessage(), Toast.LENGTH_SHORT).show();
//
//                            }
//                        }catch (NullPointerException e){
//                            Toast.makeText(LoginActivity.this, "null", Toast.LENGTH_SHORT).show();
//
//
//                        }

//                        dialog.dismiss();
//                    }
//
//                    @Override
//                    public void onFailure(Call<ProfileResponse> call, Throwable t) {
//                        Toast.makeText(LoginActivity.this, "error " + t.getMessage(), Toast.LENGTH_SHORT).show();
//                        dialog.dismiss();
//                    }
//                });


            }
        }
    }


}
