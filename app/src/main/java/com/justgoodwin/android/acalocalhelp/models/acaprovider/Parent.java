package com.justgoodwin.android.acalocalhelp.models.acaprovider;

import com.justgoodwin.android.acalocalhelp.models.JsonOrm;

import org.json.JSONObject;

/**
 * Created by Goodwin on 1/25/16.
 */
public class Parent extends JsonOrm {
    protected int id;
    protected String name;
    protected String acronym;
    protected boolean published;
    public Parent() {
        super();
    }
    public Parent(JSONObject json) {
        super(json);
        setId(integer("id"));
        setName(string("name"));
        setAcronym(string("acronym"));
        setPublished(bool("published"));
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

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }
}
