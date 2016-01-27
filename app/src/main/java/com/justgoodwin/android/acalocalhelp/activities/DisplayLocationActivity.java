package com.justgoodwin.android.acalocalhelp.activities;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Goodwin on 1/24/16.
 */
public class DisplayLocationActivity extends ListActivity {
    public final static String INTENT_RESULTS_RESPONSE="RESULTS_RESPONSE";
    private String url = "https://localhelp.healthcare.gov/api/v1/resources/agents/all/38.8845126_-77.0938583.json?lat=38.8845126&lng=-77.0938583&medicaidState=VA&radius=50&order=proximity&limit=none&offset=0";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        if(intent.getAction().equals(INTENT_RESULTS_RESPONSE)) {
            //Deserialize data
        }


    }
}
