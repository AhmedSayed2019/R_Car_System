package com.asia.r_car_system.helperTools;

import android.app.Activity;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.widget.TextView;


import com.asia.r_car_system.R;

import java.util.Objects;

public class ChangeFragment {
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static void changeTitle(Activity mActivity, String title) {
        //setTitle
        TextView mTextTitle = Objects.requireNonNull(mActivity)
                .findViewById(R.id.toolbar_txVw_title);
        mTextTitle.setText(title);


    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static boolean loadFragment(Fragment fragment , String title, Activity activity, FragmentManager fragmentManager) {
        if (fragment != null) {
            //create main object

            changeTitle(activity,title);
            //load Fragment
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }
}
