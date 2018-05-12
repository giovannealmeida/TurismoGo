package br.com.giovannemobile.turismogo.fragments;


import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import br.com.giovannemobile.turismogo.R;

public class MapFragment extends Fragment {

    private GoogleMap mMap;
    private int PERMISSION_REQUEST = 1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_maps, container, false);

        MapView mMapView = view.findViewById(R.id.map);
        mMapView.onCreate(savedInstanceState);

        mMapView.onResume();

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        mMapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                mMap = googleMap;

                // For showing a move to my location button
                if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    if (ContextCompat.checkSelfPermission(getActivity(),
                            Manifest.permission.ACCESS_FINE_LOCATION)
                            != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(getActivity(),
                                new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                                PERMISSION_REQUEST);
                    } else {
                        getLocation();
                    }
                    return;
                } else {

                    mMap.setMyLocationEnabled(true);
                    getLocation();
                }
            }
        });

        return view;
    }

    private void getLocation() {
        mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
        CameraPosition cameraPosition = new CameraPosition.Builder().target(new LatLng(-14.7855501, -39.0325091)).zoom(15).build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

        LatLng vesuvio = new LatLng(-14.7990243, -39.0326597);
        LatLng catedral = new LatLng(-14.7993664, -39.0322974);
        LatLng teatro = new LatLng(-14.7989926, -39.0327484);
        LatLng bataclan = new LatLng(-14.7998747,-39.0332405);
        LatLng jorge = new LatLng(-14.7986217,-39.0329582);
        mMap.addMarker(new MarkerOptions().position(vesuvio).title("Bar Vesúvio"));
        mMap.addMarker(new MarkerOptions().position(catedral).title("Catedral de São Sebastião"));
        mMap.addMarker(new MarkerOptions().position(teatro).title("Teatro Municipal de Ilhéus"));
        mMap.addMarker(new MarkerOptions().position(bataclan).title("Bataclan"));
        mMap.addMarker(new MarkerOptions().position(jorge).title("Museu Casa de Jorge Amado"));
    }

}
