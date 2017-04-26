package cis3334.asynch_fetcher;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText editTextCountry;
    private EditText editTextCaptial;
	public String countryToFetch;
	private Country countryData;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_weather);
		
		// set up our edit text variables
		editTextCountry =  (EditText) findViewById(R.id.textCountry);
        editTextCaptial =  (EditText) findViewById(R.id.textCapital);
	}

	//public void btnClick (View v) throws XmlPullParserException, ClientProtocolException, URISyntaxException, IOException {
	public void btnClick (View v) {
		// fetch the country data asynchronously
		countryToFetch = editTextCountry.getText().toString();
        new AsyncFetchTask().execute(this);
	}

	public void updateCountryData(Country countryData) {
		this.countryData = countryData;
        editTextCaptial.setText(countryData.getCapital());
		Toast toast=Toast.makeText(getApplicationContext(), "Updating country data",Toast.LENGTH_LONG );
		toast.show();
	}
	

}
