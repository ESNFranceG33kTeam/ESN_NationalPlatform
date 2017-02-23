package org.np.esn.esnnationalplatform.model;

import android.support.annotation.Keep;

import com.google.gson.annotations.SerializedName;

@Keep
public class Member {

    @SerializedName("firstname")
    private String firstname;

    @SerializedName("lastname")
    private String lastname;

    @SerializedName("nickname")
    private String nickname;

    @SerializedName("role")
    private String role;

    @SerializedName("tel")
    private String tel;

    @SerializedName("profile_picture")
    private String profilePicture;

    public Member() {
    }

    public Member(String firstname, String lastname, String profilePicture) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.profilePicture = profilePicture;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }
}
