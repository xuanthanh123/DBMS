package com.example.izuna.baitapketnoi;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.izuna.baitapketnoi.class_list.ClassFragment;

/**
 * Created by buivu on 02/05/2017.
 */

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    //private DatabaseAdapter databaseAdapter;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private Toolbar toolbar;
    private View headerView;
    private ImageView imgAvatar;
    private TextView txtName, txtEmail;
    public static Activity mainActivity;

    //tag using for fragment
    private static final String TAG_LOPHOC = "class";
    private static final String TAG_MONHOC = "subject";
    private static final String TAG_SINHVIEN = "student";
    private static final String TAG_TROGIUP = "help";
    private static final String TAG_THONGTIN = "info";
    public static String CURRENT_TAG = TAG_LOPHOC;

    private String[] activityTitles;
    private Handler mHandler;
    public static int navItemIndex = 0;
    private boolean isShowIconLogOut = false;
    private boolean isClickLogout = false;
    private boolean exit = false;
    // flag to load home fragment when user presses back key

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainActivity = this;
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mHandler = new Handler();
        //createData();
        initViews();
        setUpNavigationView();
        if (savedInstanceState == null) {
            navItemIndex = 0;
            CURRENT_TAG = TAG_LOPHOC;
            loadFragment();
        }
    }

    private void initViews() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        //end init
        setSupportActionBar(toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        headerView = navigationView.getHeaderView(0);
        imgAvatar = (ImageView) headerView.findViewById(R.id.img_avatar);
        txtName = (TextView) headerView.findViewById(R.id.txt_header_name);
        txtEmail = (TextView) headerView.findViewById(R.id.txt_header_email);
        //init title
        activityTitles = getResources().getStringArray(R.array.nav_item_activity_titles);
        //event click avatar
        imgAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }

    //set title for toolbar
    private void setToolbarTitle() {
        getSupportActionBar().setTitle(activityTitles[navItemIndex]);
    }

    private void selectNavMenu() {
        navigationView.getMenu().getItem(navItemIndex).setChecked(true);
    }

    private void loadFragment() {
        selectNavMenu();
        //set toolbar title
        setToolbarTitle();
        // if user select the current navigation menu again, don't do anything
        // just close the navigation drawer
        if (getSupportFragmentManager().findFragmentByTag(CURRENT_TAG) != null) {
            drawerLayout.closeDrawers();
            // show or hide the fab button

            return;
        }
        // Sometimes, when fragment has huge data, screen seems hanging
        // when switching between navigation menus
        // So using runnable, the fragment is loaded with cross fade effect
        // This effect can be seen in GMail app
        Runnable mPendingRunnable = new Runnable() {
            @Override
            public void run() {
                // update the main content by replacing fragments
                Fragment fragment = getFragment();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame, fragment, CURRENT_TAG);
                //overridePendingTransition(R.anim.comming_in_right, R.anim.comming_out_right);
                fragmentTransaction.commitAllowingStateLoss();
            }
        };
        // If mPendingRunnable is not null, then add to the message queue
        if (mPendingRunnable != null) {
            mHandler.post(mPendingRunnable);
        }

        //Closing drawer on item click
        drawerLayout.closeDrawers();

        // refresh toolbar menu
        invalidateOptionsMenu();

    }

    private Fragment getFragment() {
        switch (navItemIndex) {
            case 0: {
                ClassFragment classFragment = new ClassFragment();
                return classFragment;
            }
            case 1: {
                SubjectFragment subjectFragment = new SubjectFragment();
                return subjectFragment;
            }
            case 2: {
                StudentFragment studentFragment = new StudentFragment();
                return studentFragment;
            }
            case 3: {
                StudentFragment studentFragment = new StudentFragment();
                return studentFragment;
            }
            case 4: {
                StudentFragment studentFragment = new StudentFragment();
                return studentFragment;
            }
            default:
                return new ClassFragment();
        }
    }

    private void setUpNavigationView() {
        //Setting Navigation View Item Selected Listener to handle the item click of the navigation menu
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_class:
                        isClickLogout = false;
                        CURRENT_TAG = TAG_LOPHOC;
                        navItemIndex = 0;
                        break;
                    case R.id.nav_subject:
                        isClickLogout = false;
                        CURRENT_TAG = TAG_MONHOC;
                        navItemIndex = 1;
                        break;
                    case R.id.nav_student:
                        isClickLogout = false;
                        CURRENT_TAG = TAG_SINHVIEN;
                        navItemIndex = 2;
                        break;
                    case R.id.nav_help:
                        isClickLogout = false;
                        CURRENT_TAG = TAG_TROGIUP;
                        navItemIndex = 3;
                        break;
                    case R.id.nav_info:
                        isClickLogout = false;
                        CURRENT_TAG = TAG_THONGTIN;
                        navItemIndex = 4;
                        break;
                    default:
                        navItemIndex = 0;
                }
                //checking if the item is in checked or not, if not make it in checked state
                if (item.isChecked()) {
                    item.setChecked(false);
                } else {
                    item.setChecked(true);
                }
                item.setChecked(true);
                if (!isClickLogout) {
                    loadFragment();
                }


                return true;
            }

        });
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {

            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank
                super.onDrawerOpened(drawerView);
            }
        };

        //Setting the actionbarToggle to drawer layout
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        //calling sync state is necessary or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else
            // rather than home
            if (navItemIndex != 0) {
                navItemIndex = 0;
                CURRENT_TAG = TAG_LOPHOC;
                loadFragment();
                return;
            } else {
                if (exit) {
                    finish();
                } else {
                    Toast.makeText(MainActivity.this, getResources().getString(R.string.pressBackAgain), Toast.LENGTH_LONG).show();
                    exit = true;
                    //sau 3s thì set exit thành false;
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            exit = false;
                        }
                    }, 3000);
                }
            }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
