package org.np.esn.esnnationalplatform.services;

import android.content.Context;

import com.google.gson.Gson;

import org.apache.commons.io.IOUtils;
import org.np.esn.esnnationalplatform.model.NationalPlatformInfo;
import org.np.esn.esnnationalplatform.utils.inject.ForApplication;

import java.nio.charset.StandardCharsets;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AppState {

    private NationalPlatformInfo nationalPlatformInfo;

    @Inject
    public AppState() {
    }

    public NationalPlatformInfo getNationalPlatformInfo(){

        if (nationalPlatformInfo == null) {
            //TODO read file and put in this object.
            nationalPlatformInfo = new NationalPlatformInfo();
        }

        return nationalPlatformInfo;
    }
}
