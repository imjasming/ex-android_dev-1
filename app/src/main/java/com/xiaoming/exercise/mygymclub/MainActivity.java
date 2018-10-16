package com.xiaoming.exercise.mygymclub;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private Toolbar toolbar;
    private LinearLayout mBottomNavigationBar;
    private TextView mTabMenuHome;
    private TextView mTabMenuBooking;

    private boolean isSignIn = false;

    private FragmentManager mFragmentManager;
    private Fragment mFragmentShown;
    private HomePageFragment mHomePageFragment;
    private TrainerBookingFragment mBookingFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //绑定实例域
        bindField();

        //这里自动生成，不是我写的
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //这才是
        mTabMenuHome.performClick();  //触发点击以进入HomePage
    }

//Begin Auto Generated
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
//End of Auto Generated

    private void bindField() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        mFragmentManager = getSupportFragmentManager();
        mBottomNavigationBar = findViewById(R.id.bottomNavigationBar);

        mTabMenuHome = findViewById(R.id.tab_home_page);
        mTabMenuHome.setOnClickListener(this::onBottomNavigationBarSelected);

        mTabMenuBooking = findViewById(R.id.tab_train);
        mTabMenuBooking.setOnClickListener(this::onBottomNavigationBarSelected);
    }

    private void setSelected() {
        mTabMenuHome.setSelected(false);
        mTabMenuBooking.setSelected(false);
    }

    private void onBottomNavigationBarSelected(View v) {
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        //先隐藏全部Fragment
        switch (v.getId()) {
            case R.id.tab_home_page:
                //set all tab item selected to false
                setSelected();
                mTabMenuHome.setSelected(true);
                mFragmentShown = new HomePageFragment();
                transaction.replace(R.id.fragment_container_main, mHomePageFragment);
                toolbar.setTitle(R.string.home_title);
                break;
            case R.id.tab_train:
                setSelected();
                mTabMenuBooking.setSelected(true);
                mFragmentShown = new TrainerBookingFragment();
                transaction.replace(R.id.fragment_container_main, mBookingFragment);
                toolbar.setTitle(R.string.trainer_list_title);
                break;
        }

        transaction.commit();
    }
}
