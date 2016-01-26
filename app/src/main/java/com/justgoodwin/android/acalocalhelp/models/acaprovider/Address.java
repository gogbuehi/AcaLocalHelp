package com.justgoodwin.android.acalocalhelp.models.acaprovider;

import com.justgoodwin.android.acalocalhelp.models.JsonOrm;

import org.json.JSONObject;

/**
 * Created by Goodwin on 1/25/16.
 */
public class Address extends JsonOrm{
    protected String city;
    protected String state;
    protected String zip;
    protected boolean statewideService;
    protected String comment;
    protected boolean hide;
    protected VisibilityState visibility;
    protected boolean accessibleLocation;
    protected boolean walkIns;
    protected boolean inPersonAssistance;
    protected GeoLocation geoLocation;
    protected boolean published;
    protected String[] street;

    public Address(JSONObject json) {
        super(json);
        setCity(string("city"));
        setState(string("state"));
        setZip(string("zip"));
        setStatewideService(bool("statewideService"));
        setComment(string("comment"));
        setHide(bool("hide"));
        setVisibility(VisibilityState.get(string("visibility")));
        setAccessibleLocation(bool("accessibleLocation"));
        setWalkIns(bool("walkIns"));
        setInPersonAssistance(bool("inPersonAssistance"));
        setGeoLocation(jsonObject("geoLocation"));
        setPublished(bool("published"));
        setStreet(stringArray("street"));
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public boolean isStatewideService() {
        return statewideService;
    }

    public void setStatewideService(boolean statewideService) {
        this.statewideService = statewideService;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isHide() {
        return hide;
    }

    public void setHide(boolean hide) {
        this.hide = hide;
    }

    public VisibilityState getVisibility() {
        return visibility;
    }

    public void setVisibility(VisibilityState visibility) {
        this.visibility = visibility;
    }

    public boolean isAccessibleLocation() {
        return accessibleLocation;
    }

    public void setAccessibleLocation(boolean accessibleLocation) {
        this.accessibleLocation = accessibleLocation;
    }

    public boolean isWalkIns() {
        return walkIns;
    }

    public void setWalkIns(boolean walkIns) {
        this.walkIns = walkIns;
    }

    public boolean isInPersonAssistance() {
        return inPersonAssistance;
    }

    public void setInPersonAssistance(boolean inPersonAssistance) {
        this.inPersonAssistance = inPersonAssistance;
    }

    public GeoLocation getGeoLocation() {
        return geoLocation;
    }

    public void setGeoLocation(GeoLocation geoLocation) {
        this.geoLocation = geoLocation;
    }
    public void setGeoLocation(JSONObject json) {
        if(json == null) {
            this.geoLocation = null;
        } else {
            setGeoLocation(new GeoLocation(json));
        }
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public String[] getStreet() {
        return street;
    }

    public void setStreet(String[] street) {
        this.street = street;
    }




    public enum VisibilityState {
        DISPLAY ("DISPLAY"), PARTIAL ("PARTIAL"), HIDE ("HIDE");
        private String state;
        VisibilityState(String state) {
            this.state = state;
        }

        public static VisibilityState get(String state) {
            if(state.equals("DISPLAY")) {
                return DISPLAY;
            } else if (state.equals("PARTIAL")) {
                return PARTIAL;
            } else if (state.equals("HIDE")) {
                return HIDE;
            }
            return null;
        }
    }
}
