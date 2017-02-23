package org.np.esn.esnnationalplatform.services;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;

import org.np.esn.esnnationalplatform.model.NationalPlatformInfo;
import org.np.esn.esnnationalplatform.utils.inject.ForApplication;
import org.np.esn.esnnationalplatform.utils.inject.InjectUtil;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AppState {

    @ForApplication
    @Inject
    Context context;

    private NationalPlatformInfo nationalPlatformInfo;

    @Inject
    public AppState() {
        InjectUtil.component().inject(this);
    }

    public NationalPlatformInfo getNationalPlatformInfo(){
        if (nationalPlatformInfo == null) {
            nationalPlatformInfo = new NationalPlatformInfo();
        }

        return nationalPlatformInfo;
    }

    public void setNationalPlatformInfo(NationalPlatformInfo nationalPlatformInfo){
        this.nationalPlatformInfo = nationalPlatformInfo;
        saveToCache(nationalPlatformInfo);
    }

    public void loadFromCache() {
        Gson gson = new Gson();
        SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        String json = mPrefs.getString("NationalPlatformInfo", "");
        NationalPlatformInfo nationalPlatformInfo = gson.fromJson(json, NationalPlatformInfo.class);
        if (nationalPlatformInfo != null) {
            this.nationalPlatformInfo = nationalPlatformInfo;
        }
    }

    public void saveToCache(NationalPlatformInfo nationalPlatformInfo) {
        SharedPreferences mPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor = mPrefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(nationalPlatformInfo);
        prefsEditor.putString("NationalPlatformInfo", json);
        prefsEditor.apply();
    }
}
