package org.np.esn.esnnationalplatform.model;

import com.google.gson.annotations.SerializedName;

public class Place {

    @SerializedName("title")
    private String title;

    @SerializedName("description")
    private String description;

    @SerializedName("coord_x")
    private String coordX;

    @SerializedName("coord_y")
    private String coordY;

    public Place() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCoordX() {
        return coordX;
    }

    public void setCoordX(String coordX) {
        this.coordX = coordX;
    }

    public String getCoordY() {
        return coordY;
    }

    public void setCoordY(String coordY) {
        this.coordY = coordY;
    }
}
