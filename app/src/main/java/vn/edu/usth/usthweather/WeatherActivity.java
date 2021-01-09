package vn.edu.usth.usthweather;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.io.IOException;
import java.io.InputStream;

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

        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.rain);
        mediaPlayer.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_refresh:
            {
                AsyncTask<String, Integer, Bitmap> task = new AsyncTask<String, Integer, Bitmap>() {
                    @Override
                    protected void onPreExecute() {
                        // do some preparation here, if needed
                    }
                    @Override
                    protected Bitmap doInBackground(String... params) {
                        // This is where the worker thread's code is executed
                        // params are passed from the execute() method call
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        return null;
                    }
                    @Override
                    protected void onProgressUpdate(Integer... values) {
                        // This method is called in the main thread, so it's possible
                        // to update UI to reflect the worker thread progress here.
                        // In a network access task, this should update a progress bar
                        // to reflect how many percent of data has been retrieved
                    }
                    @Override
                    protected void onPostExecute(Bitmap bitmap) {
                        // This method is called in the main thread. After #doInBackground returns
                        // the bitmap data, we simply set it to an ImageView using ImageView.setImageBitmap()
                        //                // Assume that we got our data from server
                        Toast.makeText(getApplicationContext(), "some sample json here", Toast.LENGTH_SHORT).show();
                    }
                };
                task.execute("http://ict.usth.edu.vn/wp-content/uploads/usth/usthlogo.png");
                return true;
            }
            case R.id.action_settings:
            {
                Intent intent = new Intent(this, PrefActivity.class);
                startActivity(intent);
                return true;
            }
            default:
                super.onOptionsItemSelected(item);
        }
        return false;
    }

}

