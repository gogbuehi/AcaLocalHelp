package com.justgoodwin.android.acalocalhelp.services;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.justgoodwin.android.acalocalhelp.models.AcaProvider;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Goodwin on 1/24/16.
 */
public class ApiService extends IntentService {
    protected int GET = 0;
    protected int POST = 1;
    protected int PUT = 2;
    protected int DELETE = 3;

    protected String endPoint = "https://localhelp.healthcare.gov/api/v1/resources/agents/all/38.8845126_-77.0938583.json?lat=38.8845126&lng=-77.0938583&medicaidState=VA&radius=50&order=proximity&limit=none&offset=0";
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     */
    public ApiService() {
        super("API Service");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        //Send off an API request
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        JsonObjectRequest request;
        JSONObject params = null;
        request = new JsonObjectRequest(GET,
                endPoint,
                params,
                new ResponseListener(),
                new ErrorListener());
        queue.add(request);

    }

    private class ResponseListener implements Response.Listener<JSONObject> {

        @Override
        public void onResponse(JSONObject response) {
            Log.d("ACALocalHelp", "RESPONSE RECEIVED: " + response.toString());
            try {
                JSONArray results = response.getJSONArray("results");
                AcaProvider[] providers = AcaProvider.processJsonArray(results);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }

    private class ErrorListener implements Response.ErrorListener {
        @Override
        public void onErrorResponse(VolleyError error) {
            Log.d("ACALocalHelp", "Error: " + error.getMessage());
        }
    }
}
