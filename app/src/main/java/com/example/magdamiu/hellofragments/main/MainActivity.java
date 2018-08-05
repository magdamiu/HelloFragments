package com.example.magdamiu.hellofragments.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.magdamiu.hellofragments.R;
import com.example.magdamiu.hellofragments.base.BaseFragment;
import com.example.magdamiu.hellofragments.companies.CompaniesFragment;
import com.example.magdamiu.hellofragments.departments.DepartmentsFragment;
import com.example.magdamiu.hellofragments.home.HomeFragment;
import com.example.magdamiu.hellofragments.users.UsersFragment;
import com.example.magdamiu.hellofragments.utils.Logging;
import com.example.magdamiu.hellofragments.utils.ViewUtils;

public class MainActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener {

    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mActionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setToolbarTitle(getString(R.string.app_name));
    }

    @Override
    public void onBackPressed() {
        ViewUtils.hideKeyboard(this, getCurrentFocus());

        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawers();
            return;
        }

        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
            if (getSupportFragmentManager().getBackStackEntryCount() == 1) {
                setToolbarTitle(getString(R.string.app_name));
            }
        } else {
            finish();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment currentFragment = getSupportFragmentManager()
                .findFragmentById(R.id.content_main);

        switch (item.getItemId()) {
            case R.id.menu_nav_home:
                if (!(currentFragment instanceof HomeFragment)) {
                    BaseFragment.addFragment(this,
                            R.id.content_main,
                            new HomeFragment());
                }
                break;

            case R.id.menu_nav_companies:
                if (!(currentFragment instanceof CompaniesFragment)) {
                    BaseFragment.addFragment(this,
                            R.id.content_main,
                            new CompaniesFragment());
                }
                break;

            case R.id.menu_nav_users:
                if (!(currentFragment instanceof UsersFragment)) {
                    BaseFragment.addFragment(this,
                            R.id.content_main,
                            new UsersFragment());
                }
                break;

            case R.id.menu_nav_departments:
                if (!(currentFragment instanceof DepartmentsFragment)) {
                    BaseFragment.addFragment(this,
                            R.id.content_main,
                            new DepartmentsFragment());
                }
                break;

            case R.id.menu_nav_logout:
                Logging.show("logout", "yes");
                break;
        }

        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    public DrawerLayout getDrawerLayout() {
        return mDrawerLayout;
    }

    public ActionBarDrawerToggle getDrawerToggle() {
        return mActionBarDrawerToggle;
    }

    public void setToolbarTitle(String title) {
        mToolbar.setTitle(title);
    }

    public void hideToolbarMenu() {
        mToolbar.getMenu().clear();
    }


    private void initView() {
        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        mDrawerLayout = findViewById(R.id.drawer_layout);
        mActionBarDrawerToggle = new ActionBarDrawerToggle(
                this,
                mDrawerLayout,
                mToolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);

        mDrawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
                ViewUtils.hideKeyboard(MainActivity.this, getCurrentFocus());
            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {
            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {
            }

            @Override
            public void onDrawerStateChanged(int newState) {
            }
        });

        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.openDrawer(GravityCompat.START);
            }
        });

        mActionBarDrawerToggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        /*Fragment currentFragment = getSupportFragmentManager()
                .findFragmentById(R.id.content_main);
        if (!(currentFragment instanceof HomeFragment)) {
            BaseFragment.addFragment(this,
                    R.id.content_main,
                    new HomeFragment());
        }*/
    }
}
