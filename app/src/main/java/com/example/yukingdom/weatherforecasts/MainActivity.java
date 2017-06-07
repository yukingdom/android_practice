package com.example.yukingdom.weatherforecasts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    private TextView result;

//    private Handler handler = new Handler();

    public class ApiTask extends GetWeatherForecastTask{
        @Override
//        protected void onPostExecute(String data){
        protected void onPostExecute(WeatherForecast data){
            super.onPostExecute(data);

            if (data != null) {
//                result.setText(data);
                result.setText(data.location.area + " " + data.location.prefecture + " " + data.location.city);

                for (WeatherForecast.Forecast forecast : data.forecastList) {
                    result.append("¥n");
                    result.append(forecast.dateLabel + " " + forecast.telop);
                }
            } else if (exception != null){
                Toast.makeText(getApplicationContext(),exception.getMessage(),Toast.LENGTH_SHORT).show();
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = (TextView) findViewById(R.id.tv_result);

        new ApiTask().execute("400040");

//        try {
//            String data = WeatherApi.getWeather("400040");
//
//            result.setText(data);
//        } catch (IOException e) {
//            Toast.makeText(getApplicationContext(),"IOException is occurred.",Toast.LENGTH_SHORT).show();
//        }
//        Thread subThread = new Thread() {
//
//            @Override
//            public void run(){
//                try {
////                    String data = WeatherApi.getWeather("400040");
//                    final String data = WeatherApi.getWeather("400040");
//
//                    handler.post(new Runnable() {
//                        @Override
//                        public void run() {
//                            result.setText(data);
//                        }
//                    });
//                } catch (IOException e) {
////                    Toast.makeText(getApplicationContext(),"IOException is occurred.",Toast.LENGTH_SHORT).show();
//                    handler.post(new Runnable() {
//                        @Override
//                        public void run() {
//                            @Override
//                                    public void run() {
//                                Toast.makeText(getApplicationContext(), "IOException is occurred.", Toast.LENGTH_SHORT).show();
//                            }
//                        }
//                    });
//                }
//            }
//        };
//
//        subThread.start();
    }
}