package org.np.esn.esnnationalplatform.services.providers;

import com.google.android.gms.maps.model.LatLng;

import org.np.esn.esnnationalplatform.model.Tip;
import org.np.esn.esnnationalplatform.utils.inject.InjectUtil;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DummyDataProvider {

    @Inject
    public DummyDataProvider() {
    }

    public List<LatLng> getLocations() {
        List<LatLng> locations = new ArrayList<>();
        locations.add(new LatLng(45.764, 4.8357));
        locations.add(new LatLng(45.78, 4.854));
        locations.add(new LatLng(45.781, 4.845));
        locations.add(new LatLng(45.77, 4.9));
        return locations;
    }
}
