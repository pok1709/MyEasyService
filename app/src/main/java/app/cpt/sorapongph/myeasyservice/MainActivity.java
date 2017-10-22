package app.cpt.sorapongph.myeasyservice;

import android.content.res.Configuration;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import app.cpt.sorapongph.myeasyservice.fragment.MainFragment;
import app.cpt.sorapongph.myeasyservice.fragment.SecondFragment;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Add Fragment to Activity
        addFragment(savedInstanceState);

        //Setup Drawer Menu
        setupDrawerMenu();

        //Text Controller
        textController();

        //Create Toolbar
        createToolbar();

    }   // Main Method

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        actionBarDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        actionBarDrawerToggle.syncState();

    }

    private void createToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolBarMain);
        setSupportActionBar(toolbar);
        actionBarDrawerToggle = new ActionBarDrawerToggle(
                MainActivity.this,
                drawerLayout,
                R.string.open,
                R.string.close
        );

        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void textController() {
        TextView mainTextView = (TextView) findViewById(R.id.txtMainFragment);
        TextView secondTextView = (TextView) findViewById(R.id.txtSecondFragment);
        TextView exitTextView = (TextView) findViewById(R.id.txtExit);

        //For MainFragment
        mainTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.contentFrangmentMain, new MainFragment())
                        .commit();
                //Close Drawer
                drawerLayout.closeDrawers();
            }
        });

        //For SecondFragment
        secondTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.contentFrangmentMain, new SecondFragment())
                        .commit();
                drawerLayout.closeDrawers();
            }
        });

        //For ExitFragment
        exitTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                drawerLayout.closeDrawers();
            }
        });

    }

    private void setupDrawerMenu() {
        drawerLayout = (DrawerLayout) findViewById(R.id.myDrawerLayout);
    }

    private void addFragment(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            // Load Fragment View
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentFrangmentMain, new MainFragment()).commit();
        }
    }

}   // Main Class
