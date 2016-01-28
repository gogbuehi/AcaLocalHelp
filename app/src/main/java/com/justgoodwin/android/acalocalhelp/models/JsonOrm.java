package com.justgoodwin.android.acalocalhelp.models;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.Serializable;

/**
 * Created by Goodwin on 1/25/16.
 */
public class JsonOrm implements Serializable {
    protected transient JSONObject json =null;

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
        if(json == null) {
            return "";
        }
        return getJson().optString(key,null);
    }

    public String[] stringArray(String key) {
        if(json == null) {
            return new String[0];
        }
        String[] result;
        JSONArray array = jsonArray(key);
        result = new String[array == null ? 0 : array.length()];
        for(int i = 0; i < result.length; i++) {
            result[i] = array.optString(i);
        }
        return result;
    }

    public int integer(String key) {
        if(json == null) {
            return 0;
        }
        return getJson().optInt(key, 0);
    }

    public float floatingPoint(String key) {
        if(json == null) {
            return 0.0f;
        }
        return (float)getJson().optDouble(key,0.0);
    }

    public double doubleFloatingPoint(String key) {
        if(json == null) {
            return 0.0;
        }
        return getJson().optDouble(key,0.0);
    }

    public boolean bool(String key) {
        if(json == null) {
            return false;
        }
        return getJson().optBoolean(key, false);
    }

    public JSONObject jsonObject(String key) {
        if(json == null) {
            return null;
        }
        return getJson().optJSONObject(key);
    }

    public JSONArray jsonArray(String key) {
        if(json == null) {
            return new JSONArray();
        }
        return getJson().optJSONArray(key);
    }


}
