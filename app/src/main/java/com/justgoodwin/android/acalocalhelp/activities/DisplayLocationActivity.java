package com.justgoodwin.android.acalocalhelp.activities;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.util.Log;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.justgoodwin.android.acalocalhelp.models.AcaProvider;

/**
 * Created by Goodwin on 1/24/16.
 */
public class DisplayLocationActivity extends ListActivity {
    public final static String INTENT_RESULTS_RESPONSE="RESULTS_RESPONSE";
    private String url = "https://localhelp.healthcare.gov/api/v1/resources/agents/all/38.8845126_-77.0938583.json?lat=38.8845126&lng=-77.0938583&medicaidState=VA&radius=50&order=proximity&limit=none&offset=0";
    SimpleCursorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Show progress bar
        ProgressBar progressBar = new ProgressBar(this);
        progressBar.setLayoutParams(new ListView.LayoutParams(ListView.LayoutParams.MATCH_PARENT, ListView.LayoutParams.MATCH_PARENT, Gravity.CENTER));
        progressBar.setIndeterminate(true);
        getListView().setEmptyView(progressBar);

        ViewGroup root = (ViewGroup) findViewById(android.R.id.content);
        root.addView(progressBar);

        String[] fromColumns = {};
        int[] toViews = {android.R.id.text1};
        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, android.R.id.text1, null, fromColumns, toViews);
        setListAdapter(adapter);

        Intent intent = getIntent();
        Log.d("AcaLocalHelp", intent.getAction() == null ? "NULL" : intent.getAction());
        if(INTENT_RESULTS_RESPONSE.equals(intent.getAction())) {
            //Deserialize data
            AcaProvider[] results = (AcaProvider[])intent.getSerializableExtra("results");
            Log.d("ACALocalHelp", "Results: " + results.length);

        }

    }
}
