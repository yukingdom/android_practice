package com.example.yukingdom.weatherforecasts;

/**
 * Created by yukingdom on 2017/06/07.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONException;
import org.json.JSONObject;


public class WeatherApi {
    private static final String API_ENDPOINT
            = "http://weather.livedoor.com/forecast/webservice/json/vl?city=";
//    public static String getWeather(String cityId)
    public static WeatherForecast getWeather(String cityId) throws IOException, JSONException {

        URL uri = new URL(API_ENDPOINT + cityId);
        HttpURLConnection connection = (HttpURLConnection) uri.openConnection();

        StringBuilder sb = new StringBuilder();

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String line;
            while ((line = br.readLine()) != null){
                sb.append(line);
            }
        } finally {
            connection.disconnect();
        }
//        return sb.toString();
        return new WeatherForecast(new JSONObject(sb.toString()));

    }
}
