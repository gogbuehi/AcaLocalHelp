package com.justgoodwin.android.acalocalhelp.models.acaprovider;

import com.justgoodwin.android.acalocalhelp.models.JsonOrm;

import org.json.JSONObject;

/**
 * Created by Goodwin on 1/25/16.
 */
public class GeoLocation extends JsonOrm {
    protected float latitude;
    protected float longitude;

    public GeoLocation(JSONObject json) {
        super(json);
        latitude = floatingPoint("latitude");
        longitude = floatingPoint("longitude");

    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }
}
