package com.justgoodwin.android.acalocalhelp.activities;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.justgoodwin.android.acalocalhelp.R;
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

        Intent intent = getIntent();
        Log.d("AcaLocalHelp", intent.getAction() == null ? "NULL" : intent.getAction());
        if(INTENT_RESULTS_RESPONSE.equals(intent.getAction())) {
            //Deserialize data
            AcaProvider[] results = (AcaProvider[])intent.getSerializableExtra("results");
            Log.d("ACALocalHelp", "Results: " + results.length);
            if(results.length > 0) {
                Log.d("ACALocalHelp", "First Result Name: " + results[0].getName());
                ProviderAdapter adapter = new ProviderAdapter(this,results);
                getListView().setAdapter(adapter);
            }


        }

    }

    class ProviderAdapter extends ArrayAdapter<AcaProvider> {

        public ProviderAdapter(Context context, AcaProvider[] objects) {
            super(context,0, objects);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            AcaProvider provider = getItem(position);
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.provider, parent, false);
            }
            TextView nameView = (TextView)convertView.findViewById(R.id.provider_name);
            nameView.setText(provider.getName());
            return convertView;
        }
    }
}
