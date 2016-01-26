package com.justgoodwin.android.acalocalhelp.models;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by Goodwin on 1/25/16.
 */
public class JsonOrm {
    protected JSONObject json;

    public JsonOrm(JSONObject json) {
        this.json = json;
    }

    public JSONObject getJson() {
        return json;
    }

    public void setJson(JSONObject json) {
        this.json = json;
    }

    public String string(String key) {
        return getJson().optString(key,null);
    }

    public String[] stringArray(String key) {
        String[] result;
        JSONArray array = jsonArray(key);
        result = new String[array == null ? 0 : array.length()];
        for(int i = 0; i < result.length; i++) {
            result[i] = array.optString(i);
        }
        return result;
    }

    public int integer(String key) {
        return getJson().optInt(key, 0);
    }

    public float floatingPoint(String key) {
        return (float)getJson().optDouble(key,0.0);
    }

    public double doubleFloatingPoint(String key) {
        return getJson().optDouble(key,0.0);
    }

    public boolean bool(String key) {
        return getJson().optBoolean(key, false);
    }

    public JSONObject jsonObject(String key) {
        return getJson().optJSONObject(key);
    }

    public JSONArray jsonArray(String key) {
        return getJson().optJSONArray(key);
    }


}
