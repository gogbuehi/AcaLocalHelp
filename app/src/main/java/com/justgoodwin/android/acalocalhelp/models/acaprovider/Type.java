package com.justgoodwin.android.acalocalhelp.models.acaprovider;

import com.justgoodwin.android.acalocalhelp.models.JsonOrm;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Goodwin on 1/25/16.
 */
public class Type extends JsonOrm {
    protected int id;
    protected String name;
    protected String title;
    protected String key;
    public Type() {
        super();
    }
    public Type(JSONObject json) {
        super(json);
        setId(integer("id"));
        setName(string("name"));
        setTitle(string("title"));
        setKey(string("key"));
    }

    public static Type[] processJsonArray(JSONArray jsonArray) throws JSONException {
        Type[] result = new Type[jsonArray.length()];
        for (int i = 0; i < jsonArray.length(); i++) {
            result[i] = new Type(jsonArray.getJSONObject(i));
        }
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

}
