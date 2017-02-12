package org.np.esn.esnnationalplatform.model;

import android.support.annotation.Keep;

import com.google.gson.annotations.SerializedName;

@Keep
public class Tip {

    @SerializedName("title")
    private String title;

    @SerializedName("content")
    private String content;
}
