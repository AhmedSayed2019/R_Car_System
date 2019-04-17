package com.asia.r_car_system.main;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.asia.r_car_system.profile.ProfileFragment;
import com.asia.r_car_system.R;
import com.asia.r_car_system.fine.FineFragment;
import com.asia.r_car_system.helperTools.ChangeFragment;
import com.asia.r_car_system.login.LoginActivity;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, MainInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //load Fragment and set title
        ChangeFragment.loadFragment(new FineFragment(), "Fine", this, getSupportFragmentManager());

        checkUserLogin();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_profile) {
            ChangeFragment.loadFragment(new ProfileFragment(), "Profile", this, getSupportFragmentManager());
            // Handle the camera action
        } else if (id == R.id.nav_unpaid) {
            ChangeFragment.loadFragment(new FineFragment(), "Fine", this, getSupportFragmentManager());
        } else if (id == R.id.nav_aboutUs) {

        } else if (id == R.id.nav_help) {

        } else if (id == R.id.nav_logout) {
            logout();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void logout() {
        //  save LoginJson in shared preference
        SharedPreferences share = getSharedPreferences("user", MODE_PRIVATE);
        SharedPreferences.Editor editor = share.edit();
        editor.putBoolean("isLogin", false);
        editor.putString("userId", "");
        editor.apply();
        editor.commit(); // commit changes

        Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);

        loginIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);   //clear activitys History
        startActivity(loginIntent);//finish main activity
        finish();//finish login activity
    }


    @Override
    public void checkUserLogin() {
        SharedPreferences share = this.getSharedPreferences("user", MODE_PRIVATE);
        final boolean isLoggedIn = share.getBoolean("isLogin", false);

        if (!isLoggedIn) {
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        }
    }
}
