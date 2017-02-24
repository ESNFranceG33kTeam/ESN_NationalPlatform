package org.np.esn.esnnationalplatform.model;

import com.google.gson.annotations.SerializedName;

public class EsnEvent {

    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description;

    @SerializedName("start")
    private String start;

    @SerializedName("end")
    private String end;

    public EsnEvent() {
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }
}
