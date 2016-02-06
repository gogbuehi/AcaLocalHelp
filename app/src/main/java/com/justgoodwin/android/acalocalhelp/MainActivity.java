package com.justgoodwin.android.acalocalhelp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.justgoodwin.android.acalocalhelp.activities.DisplayLocationActivity;
import com.justgoodwin.android.acalocalhelp.services.ApiService;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity extends Activity {
    private EditText addressSearch;
    private Button searchButton;
    private TextView introTitle;
    private TextView introDescription;
    private TextView introSearchLabel;
    public Geocoder geocoder;
    public Typeface BITTER_REGULAR;
    public Typeface OPEN_SANS_REGULAR;
    public Typeface OPEN_SANS_BOLD;
    private Toast invalidSearchToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Activity self = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // Fonts
        BITTER_REGULAR = Typeface.createFromAsset(getAssets(), getString(R.string.bitter_regular));
        OPEN_SANS_REGULAR = Typeface.createFromAsset(getAssets(), getString(R.string.open_sans_regular));
        OPEN_SANS_BOLD = Typeface.createFromAsset(getAssets(), getString(R.string.open_sans_bold));

        // UI Elements
        addressSearch = (EditText) this.findViewById(R.id.addressSearch);
        searchButton = (Button) this.findViewById(R.id.searchButton);
        introTitle = (TextView) this.findViewById(R.id.introTitleTextView);
        introDescription = (TextView) this.findViewById(R.id.introDiscriptionTextView);
        introSearchLabel = (TextView) this.findViewById(R.id.introSearchLabelTextView);

        introTitle.setTypeface(BITTER_REGULAR);
        introDescription.setTypeface(OPEN_SANS_REGULAR);
        introSearchLabel.setTypeface(OPEN_SANS_BOLD);
        addressSearch.setTypeface(OPEN_SANS_REGULAR);
        searchButton.setTypeface(OPEN_SANS_BOLD);

        geocoder = new Geocoder(this, Locale.getDefault());
        Context context = getApplicationContext();

        CharSequence text = "You must enter a valid City and State or Zip code.";
        int duration = Toast.LENGTH_SHORT;
        invalidSearchToast = Toast.makeText(context, text, duration);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideSoftKeyboard(self);
                String searchText = addressSearch.getText().toString();
                Address location;

                if(searchText.equals("")){
                    invalidSearchToast.show();
                }else{
                    try {
                        //FIXME: Needs safetey catch if search is invalid
                        List<Address> address = geocoder.getFromLocationName(searchText.toString(), 1);
                        double latitude, longitude;
                        Intent apiServiceIntent = new Intent(getApplicationContext(), ApiService.class);
                        if(address.size()!= 0) {
                            location = geocoder.getFromLocationName(searchText.toString(), 1).get(0);

                            apiServiceIntent.putExtra("latitude",location.getLatitude());
                            apiServiceIntent.putExtra("longitude", location.getLongitude());
                        }
                        startService(apiServiceIntent);
                    } catch (IOException e) {
                        e.printStackTrace();
                        invalidSearchToast.show();
                    }
                }
                Intent i = new Intent(getApplicationContext(), DisplayLocationActivity.class);
                startActivity(i);

            }
        };

        searchButton.setOnClickListener(listener);


    }

    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager)  activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        if(inputMethodManager.isAcceptingText()) {
            inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
        }

    }
}
