package com.justgoodwin.android.acalocalhelp.models.acaprovider;

import com.justgoodwin.android.acalocalhelp.models.JsonOrm;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Iterator;

/**
 * Created by Goodwin on 1/25/16.
 */
public class Hours extends JsonOrm {
    protected DayOfTheWeek[] days;
    public Hours() {
        super();
    }
    public Hours(JSONObject json) {
        super(json);
        Iterator<String> keys = json.keys();
        String key;
        days = new DayOfTheWeek[json.length()];
        int i = 0;
        while(keys.hasNext()) {
            key = keys.next();
            days[i] = new DayOfTheWeek(getJson(),key);
            i++;
        }
    }

    public DayOfTheWeek get(String key) {
        for(int i = 0; i < days.length; i++) {
            if(days[i].getKey().equals(key)) {
                return days[i];
            }
        }
        return null;
    }

    public class DayOfTheWeek extends JsonOrm {
        protected String key;
        protected HourSet[] hours;
        public DayOfTheWeek() {
            super();
        }
        public DayOfTheWeek(JSONObject json, String key) {
            super(json);
            setKey(key);
            setHours(jsonArray("hours"));
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public HourSet[] getHours() {
            return hours;
        }

        public void setHours(HourSet[] hours) {
            this.hours = hours;
        }

        public void setHours(JSONArray hoursArray) {
            HourSet[] hourSets = new HourSet[hoursArray != null ? hoursArray.length() : 0];
            for(int i = 0; i < hourSets.length; i++) {
                hourSets[i] = new HourSet(hoursArray.optJSONObject(i));
            }
        }

        public class HourSet extends JsonOrm{
            protected String startTime;
            protected String endTime;
            protected String dayOfWeek;
            protected boolean appointmentRequired;
            public HourSet() {
                super();
            }
            public HourSet(JSONObject json) {
                super(json);
                setStartTime(string("startTime"));
                setEndTime(string("endTime"));
                setDayOfWeek(string("dayOfWeek"));
                setAppointmentRequired(bool("appointmentRequired"));

            }

            public String getStartTime() {
                return startTime;
            }

            public void setStartTime(String startTime) {
                this.startTime = startTime;
            }

            public String getEndTime() {
                return endTime;
            }

            public void setEndTime(String endTime) {
                this.endTime = endTime;
            }

            public String getDayOfWeek() {
                return dayOfWeek;
            }

            public void setDayOfWeek(String dayOfWeek) {
                this.dayOfWeek = dayOfWeek;
            }

            public boolean isAppointmentRequired() {
                return appointmentRequired;
            }

            public void setAppointmentRequired(boolean appointmentRequired) {
                this.appointmentRequired = appointmentRequired;
            }
        }
    }
}
