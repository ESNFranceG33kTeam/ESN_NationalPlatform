package org.np.esn.esnnationalplatform.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

import org.np.esn.esnnationalplatform.R;
import org.np.esn.esnnationalplatform.services.providers.DummyDataProvider;
import org.np.esn.esnnationalplatform.utils.inject.InjectUtil;

import java.util.List;

import javax.inject.Inject;

public class MapFragment extends BaseFragment implements OnMapReadyCallback {

    private MapView mapView;
    private GoogleMap googleMap;

    @Inject
    DummyDataProvider dummyDataProvider;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_map, container, false);

        InjectUtil.component().inject(this);
        mapView = (MapView) rootView.findViewById(R.id.map_view);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);
        return rootView;
    }

    @Override
    public String getFragmentTag() {
        return "MAP";
    }

    @Override
    public void onMapReady(GoogleMap gMap) {
        this.googleMap = gMap;
        BitmapDescriptor icon = BitmapDescriptorFactory.fromResource(R.drawable.esn_star);
        LatLngBounds bounds = markLocationsAndComputeBounds(dummyDataProvider.getLocations(), icon);
        int boundsPadding = 30;
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngBounds(bounds, boundsPadding);
        this.googleMap.moveCamera(cameraUpdate);
        this.googleMap.animateCamera(cameraUpdate);
    }

    private LatLngBounds markLocationsAndComputeBounds(List<LatLng> locations, BitmapDescriptor icon) {
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        for (LatLng location: locations) {
            googleMap.addMarker(new MarkerOptions().position(location).icon(icon));
            builder.include(location);
        }
        return builder.build();
    }

    @Override
    public void onResume() {
        mapView.onResume();
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }
}

