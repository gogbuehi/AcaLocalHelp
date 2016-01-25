package com.justgoodwin.android.acalocalhelp.activities;

import android.app.ListActivity;
import android.os.Bundle;

/**
 * Created by Goodwin on 1/24/16.
 */
public class DisplayLocationActivity extends ListActivity {
    private String url = "https://localhelp.healthcare.gov/api/v1/resources/agents/all/38.8845126_-77.0938583.json?lat=38.8845126&lng=-77.0938583&medicaidState=VA&radius=50&order=proximity&limit=none&offset=0";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
