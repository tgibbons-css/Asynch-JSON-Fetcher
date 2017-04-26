package cis3334.asynch_fetcher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

import android.util.Log;

public class CountryDataFetcher {
	
    public Country fetchCountryData(String countryName) {
        try {
            String jsonStr;
            URL chargerURL =  new URL("https://restcountries.eu/rest/v2/name/"+countryName);
            InputStream stream = chargerURL.openStream();
            jsonStr = getStringFromInputStream(stream);
            // see this website for details === http://www.androidhive.info/2012/01/android-json-parsing-tutorial/
            JSONArray jsonArr = new JSONArray(jsonStr);
            JSONObject jsonCountry = jsonArr.getJSONObject(0);
            String capital = jsonCountry.getString("capital");
            Long population = Long.parseLong( jsonCountry.getString("population") );
            Country fetchedCountry = new Country(countryName, capital, population);
            return fetchedCountry;        // return result to activity
        }  catch (Exception e) {
            Log.v("CIS3334","fetchCountryData error " + e.getMessage());
            return(new Country());
        }
    }

    // convert InputStream to String
    private static String getStringFromInputStream(InputStream is) {
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();
        String line;
        try {
            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }

}