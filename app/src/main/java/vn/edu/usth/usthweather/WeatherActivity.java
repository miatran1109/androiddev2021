package vn.edu.usth.usthweather;

import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import com.google.android.material.tabs.TabLayout;

public class WeatherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

//        WeatherFragment weatherFragment = new WeatherFragment();
//
//        getSupportFragmentManager().beginTransaction()
//                .add(android.R.id.content, weatherFragment).commit();
//
//        ForecastFragment forecastFragment = new ForecastFragment();
//
//        getSupportFragmentManager().beginTransaction()
//                .add(android.R.id.content, forecastFragment).commit();


        PagerAdapter adapter = new HomeFragmentPagerAdapter(
                getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.pager);
        viewPager.setOffscreenPageLimit(3);
        viewPager.setAdapter(adapter);

        TabLayout tableLayout = findViewById(R.id.tabLayout);
        tableLayout.setupWithViewPager(viewPager);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.i("Weather", "Start now");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.i("Weather", "Resume now");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.i("Weather", "Pause now");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.i("Weather", "Stop now");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.i("Weather", "Destroy now");
    }
}

