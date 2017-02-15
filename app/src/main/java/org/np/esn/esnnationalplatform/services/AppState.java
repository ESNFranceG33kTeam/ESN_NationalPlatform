package org.np.esn.esnnationalplatform.services;

import org.np.esn.esnnationalplatform.model.NationalPlatformInfo;
import org.np.esn.esnnationalplatform.utils.inject.InjectUtil;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AppState {

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
    }
}
