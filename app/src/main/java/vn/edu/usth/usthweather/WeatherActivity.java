package vn.edu.usth.usthweather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class WeatherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
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