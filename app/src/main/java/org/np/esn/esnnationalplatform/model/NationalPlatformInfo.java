package org.np.esn.esnnationalplatform.model;

import android.support.annotation.Keep;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;

@Keep
public class NationalPlatformInfo {

    @SerializedName("name")
    private String name;

    @SerializedName("logo_url")
    private String logoUrl;

    @SerializedName("calendar")
    private String calendarLink;

    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("oc_members")
    private ArrayList<Member> members;

    @SerializedName("tips")
    private ArrayList<Tip> tips;

    @SerializedName("places")
    private ArrayList<Place> places;

    @SerializedName("awards")
    private ArrayList<String> awards;

    @SerializedName("events")
    private ArrayList<EsnEvent> events;

    public NationalPlatformInfo() {
        members = new ArrayList<>();
        tips = new ArrayList<>();
        awards = new ArrayList<>();
        events = new ArrayList<>();
        places = new ArrayList<>();
    }

    public NationalPlatformInfo(String name, String logoUrl, String calendarLink, ArrayList<Member> members, ArrayList<Tip> tips, ArrayList<String> awards, ArrayList<EsnEvent> events) {
        this.name = name;
        this.logoUrl = logoUrl;
        this.calendarLink = calendarLink;
        this.members = members;
        this.tips = tips;
        this.awards = awards;
        this.events = events;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public ArrayList<Member> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<Member> members) {
        this.members = members;
    }

    public ArrayList<Tip> getTips() {
        return tips;
    }

    public void setTips(ArrayList<Tip> tips) {
        this.tips = tips;
    }

    public ArrayList<String> getAwards() {
        return awards;
    }

    public void setAwards(ArrayList<String> awards) {
        this.awards = awards;
    }

    public ArrayList<Place> getPlaces() {
        return places;
    }

    public void setPlaces(ArrayList<Place> places) {
        this.places = places;
    }

    public ArrayList<EsnEvent> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<EsnEvent> events) {
        this.events = events;
    }
}
