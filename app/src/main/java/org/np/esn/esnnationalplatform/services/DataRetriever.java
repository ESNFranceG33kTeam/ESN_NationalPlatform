package org.np.esn.esnnationalplatform.services;

import com.google.android.gms.maps.model.LatLng;

import org.np.esn.esnnationalplatform.model.Tip;

import java.lang.reflect.Member;
import java.util.List;

public interface DataRetriever {
    List<LatLng> getLocations();
    List<Member> getMembers();
    List<Tip> getTips();
}
