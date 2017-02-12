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

    @SerializedName("start")
    private Date startDate;

    @SerializedName("end")
    private Date endDate;

    @SerializedName("oc_members")
    private ArrayList<Member> members;

    @SerializedName("tips")
    private ArrayList<Tip> tips;

    @SerializedName("awards")
    private ArrayList<String> awards;

    public NationalPlatformInfo() {
        members = new ArrayList<>();
        tips = new ArrayList<>();
        awards = new ArrayList<>();
    }

    public NationalPlatformInfo(String name, String logoUrl, Date startDate, Date endDate, ArrayList<Member> members, ArrayList<Tip> tips, ArrayList<String> awards) {
        this.name = name;
        this.logoUrl = logoUrl;
        this.startDate = startDate;
        this.endDate = endDate;
        this.members = members;
        this.tips = tips;
        this.awards = awards;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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
}
