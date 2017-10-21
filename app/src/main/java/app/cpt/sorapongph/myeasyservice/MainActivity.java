package app.cpt.sorapongph.myeasyservice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import app.cpt.sorapongph.myeasyservice.fragment.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            // Load Fragment View
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentFrangmentMain, new MainFragment()).commit();
        }
    }   // Main Method

}   // Main Class
