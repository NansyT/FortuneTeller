package com.example.fortuneteller;

import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class JokeApi {
    String urlText = "http://yerkee.com/api/fortune";

    public String getJoke() {
        HttpURLConnection con = null;
        try{
            URL url = new URL(urlText);
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = reader.readLine()) != null) {
                content.append(inputLine);
            }
            reader.close();
            return content.toString();
        }
        catch(Exception e){
            e.getStackTrace();
        }
        finally {
            con.disconnect();
        }
        return null;
    }
}
