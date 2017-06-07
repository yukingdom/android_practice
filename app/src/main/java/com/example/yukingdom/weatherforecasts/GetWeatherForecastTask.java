package com.example.yukingdom.weatherforecasts;

/**
 * Created by yukingdom on 2017/06/07.
 */

import android.os.AsyncTask;
import java.io.IOException;
import org.json.JSONException;

//public class GetWeatherForecastTask extends AsyncTask <String,Void,String> {
public class GetWeatherForecastTask extends AsyncTask <String,Void,WeatherForecast> {
    Exception exception;

    @Override
//    protected String doInBackground(String...params){
    protected WeatherForecast doInBackground(String...params){

        try {
            return WeatherApi.getWeather(params[0]);
//        } catch (IOException e) {
        } catch (IOException | JSONException e) {
            exception = e;
        }
        return null;
    }
}
