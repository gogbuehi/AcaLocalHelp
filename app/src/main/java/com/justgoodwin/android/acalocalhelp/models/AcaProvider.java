package com.justgoodwin.android.acalocalhelp.models;

import com.justgoodwin.android.acalocalhelp.models.acaprovider.Address;
import com.justgoodwin.android.acalocalhelp.models.acaprovider.Hours;
import com.justgoodwin.android.acalocalhelp.models.acaprovider.Parent;
import com.justgoodwin.android.acalocalhelp.models.acaprovider.Type;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Goodwin on 1/25/16.
 */
public class AcaProvider extends JsonOrm{
    protected int id;
    protected String name;
    protected String acronym;
    protected Type[] types;
    protected Address address;
    protected double distance;
    protected Hours hours;
    protected String[] phoneNumbers;
    protected String[] emailAddresses;
    protected String[] websites;
    protected String[] languages;
    protected String[] accessibilityServices;
    protected Parent parent;
    protected String additionalInformation;
    protected boolean published;
    public AcaProvider() {
        super();
    }
    public AcaProvider(JSONObject json) throws JSONException {
        super(json);
        setId(integer("id"));
        setName(string("name"));
        setAcronym("acronym");
        setTypes(Type.processJsonArray(jsonArray("types")));
        setAddress(jsonObject("address"));
        setDistance(doubleFloatingPoint("distance"));
        setHours(jsonObject("hours"));
        setPhoneNumbers(stringArray("phoneNumbers"));
        setEmailAddresses(stringArray("emailAddresses"));
        setWebsites(stringArray("websites"));
        setLanguages(stringArray("languages"));
        setAccessibilityServices(stringArray("accessibilityServices"));
        setParent(jsonObject("parent"));
        setAdditionalInformation(string("additionalInformation"));
        setPublished(bool("published"));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public Type[] getTypes() {
        return types;
    }

    public void setTypes(Type[] types) {
        this.types = types;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setAddress(JSONObject json) {
        setAddress(new Address(json));
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Hours getHours() {
        return hours;
    }

    public void setHours(Hours hours) {
        this.hours = hours;
    }

    public void setHours(JSONObject json) {
        setHours(new Hours(json));
    }

    public String[] getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(String[] phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public String[] getEmailAddresses() {
        return emailAddresses;
    }

    public void setEmailAddresses(String[] emailAddresses) {
        this.emailAddresses = emailAddresses;
    }

    public String[] getWebsites() {
        return websites;
    }

    public void setWebsites(String[] websites) {
        this.websites = websites;
    }

    public String[] getLanguages() {
        return languages;
    }

    public void setLanguages(String[] languages) {
        this.languages = languages;
    }

    public String[] getAccessibilityServices() {
        return accessibilityServices;
    }

    public void setAccessibilityServices(String[] accessibilityServices) {
        this.accessibilityServices = accessibilityServices;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public void setParent(JSONObject json) {
        if(json == null) {
            this.parent = null;
        } else {
            setParent(new Parent(json));
        }

    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public static AcaProvider[] processJsonArray(JSONArray array) throws JSONException {
        return processJsonArray(array, 30);
    }

    public static AcaProvider[] processJsonArray(JSONArray array, int max) throws JSONException {
        AcaProvider[] result = new AcaProvider[array.length() > max ? max : array.length()];
        for(int i = 0; i < array.length() && i < max; i++) {
            result[i] = new AcaProvider(array.optJSONObject(i));
        }
        return result;
    }


}
