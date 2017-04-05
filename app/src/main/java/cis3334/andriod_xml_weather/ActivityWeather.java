package cis3334.andriod_xml_weather;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

//import org.apache.http.HttpResponse;
//import org.apache.http.client.ClientProtocolException;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.impl.client.DefaultHttpClient;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityWeather extends Activity {

	EditText etLoc;
	EditText etTemp;
	EditText etWind;
	EditText etVis;
	public String weatherStrURL; 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_weather);
		
		// set up our edit text variables 
		etLoc =  (EditText) findViewById(R.id.textLoc);
		etTemp =  (EditText) findViewById(R.id.textTemp);
		etWind =  (EditText) findViewById(R.id.textWind);
		etVis =  (EditText) findViewById(R.id.textVis);
		
	}

	//public void btnClick (View v) throws XmlPullParserException, ClientProtocolException, URISyntaxException, IOException {
	public void btnClick (View v) throws XmlPullParserException, URISyntaxException, IOException {

        URL weatherURL =  new URL("http://w1.weather.gov/xml/current_obs/KDLH.xml");
      //  String  weatherStrURL =  "http://w1.weather.gov/xml/current_ob/" + locStr + ".xml";
		
       
        
        // AsyncTask subclass
        //new AsyncDownloadXML().execute(weatherStrURL);
        new AsyncDownloadXML().execute(this);
		
		
	}
	
	public void setTemp(String newTemp) {
		etTemp.setText(newTemp);
	}
	
	public void setWind(String newWind) {
		etWind.setText(newWind);
	}
	
	public void setVis(String newVis) {
		etVis.setText(newVis);
	}
	
	
	public void setStatus(String newStatus) {
		Toast toast=Toast.makeText(getApplicationContext(), newStatus,Toast.LENGTH_LONG );
		toast.show();
	}
	

}
