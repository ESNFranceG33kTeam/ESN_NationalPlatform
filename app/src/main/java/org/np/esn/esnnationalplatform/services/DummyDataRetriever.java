package org.np.esn.esnnationalplatform.services;

import com.google.android.gms.maps.model.LatLng;

import org.np.esn.esnnationalplatform.model.Tip;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;

public class DummyDataRetriever implements DataRetriever {
    @Override
    public List<LatLng> getLocations() {
        List<LatLng> locations = new ArrayList<>();
        locations.add(new LatLng(45.764, 4.8357));
        locations.add(new LatLng(45.78, 4.854));
        locations.add(new LatLng(45.781, 4.845));
        locations.add(new LatLng(45.77, 4.9));
        return locations;
    }

    @Override
    public List<Member> getMembers() {
        return new ArrayList<>();
    }

    @Override
    public List<Tip> getTips() {
        return new ArrayList<>();
    }
}
