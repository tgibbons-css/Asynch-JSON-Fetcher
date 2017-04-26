package cis3334.asynch_fetcher;

import android.os.AsyncTask;

/**
 * Created by cssuser on 4/26/2017.
 */

public class AsyncFetchTask  extends AsyncTask<MainActivity, Void, Country> {

    MainActivity mainActivity;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        // do anything needed before the fetch begins
    }

    @Override
    protected Country doInBackground(MainActivity... params) {
        /* If there's no country, there's nothing to look up. */
        if (params.length == 0) {
            return null;
        }
        mainActivity =  params[0];    // country name should be the only string given
        CountryDataFetcher fetcher = new CountryDataFetcher();
        Country fetchedCountry  = fetcher.fetchCountryData(mainActivity.countryToFetch);
        return fetchedCountry;
    }

    @Override
    protected void onPostExecute(Country fetchedCountry) {
        // returns Country when fetched by doInBackground
        mainActivity.updateCountryData( fetchedCountry );
    }

}
