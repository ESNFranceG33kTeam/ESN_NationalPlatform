package org.np.esn.esnnationalplatform.activities;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.support.annotation.NonNull;


import org.np.esn.esnnationalplatform.R;
import org.np.esn.esnnationalplatform.fragments.AboutFragment;
import org.np.esn.esnnationalplatform.fragments.AwardsFragment;
import org.np.esn.esnnationalplatform.fragments.BaseFragment;
import org.np.esn.esnnationalplatform.fragments.MapFragment;
import org.np.esn.esnnationalplatform.fragments.OCMembersFragment;
import org.np.esn.esnnationalplatform.fragments.ScheduleFragment;
import org.np.esn.esnnationalplatform.fragments.TipsFragment;
import org.np.esn.esnnationalplatform.services.AppState;
import org.np.esn.esnnationalplatform.services.ConnectUtil;
import org.np.esn.esnnationalplatform.services.providers.DataProvider;
import org.np.esn.esnnationalplatform.utils.inject.InjectUtil;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Inject
    DataProvider dataProvider;
    @Inject
    AppState appState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InjectUtil.component().inject(this);
        dataProvider.getData();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        addFragment(new ScheduleFragment());
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_about:
                addFragment(new AboutFragment());
                break;
            case R.id.menu_awards:
                addFragment(new AwardsFragment());
                break;
            case R.id.menu_map:
                addFragment(new MapFragment());
                break;
            case R.id.menu_oc_members:
                addFragment(new OCMembersFragment());
                break;
            case R.id.menu_tips:
                addFragment(new TipsFragment());
                break;
            case R.id.menu_schedule:
                addFragment(new ScheduleFragment());
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void addFragment(BaseFragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content, fragment, fragment.getFragmentTag())
                .disallowAddToBackStack()
                .commit();
    }
}
