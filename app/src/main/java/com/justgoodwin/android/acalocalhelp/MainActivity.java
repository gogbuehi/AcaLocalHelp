package com.justgoodwin.android.acalocalhelp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.justgoodwin.android.acalocalhelp.activities.DisplayLocationActivity;

import java.io.IOException;
import java.util.Locale;

/**
 * Created by Goodwin on 1/24/16.
 */
public class MainActivity extends Activity {
    private EditText addressSearch;
    private TextView resultTextView;
    private Button searchButton;
    public Geocoder geocoder;
    private Toast invalidSearchToast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        addressSearch = (EditText) this.findViewById(R.id.addressSearch);
        searchButton = (Button) this.findViewById(R.id.searchButton);
        Log.d("ACA","Button is: " + (searchButton == null ? "NULL": "NOT NULL"));
        resultTextView = (TextView) this.findViewById(R.id.resultTextView);
        geocoder = new Geocoder(this, Locale.getDefault());
        Context context = getApplicationContext();
        CharSequence text = "You must enter a valid City and State or Zip code.";
        int duration = Toast.LENGTH_SHORT;
        invalidSearchToast = Toast.makeText(context, text, duration);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //hideSoftKeyboard(thisActivity);
                String searchText = addressSearch.getText().toString();
                Address location;

                if(searchText.contains("")){
                    invalidSearchToast.show();
                }else{
                    try {
                        location = geocoder.getFromLocationName(searchText.toString(), 1).get(0);

                        resultTextView.setText(
                                "Latitude: " + location.getLatitude() + "\n" +
                                        "Longitude: " + location.getLongitude() + "\n" +
                                        "State: " + location.getAdminArea()
                        );

                        Intent DisplayLocationIntent = new Intent(getApplicationContext(), DisplayLocationActivity.class);
                        startActivity(DisplayLocationIntent);
                    } catch (IOException e) {
                        e.printStackTrace();
                        invalidSearchToast.show();
                    }
                }
            }
        };

        searchButton.setOnClickListener(listener);


    }
}
