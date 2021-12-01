package com.example.chinawok.ui.Maps;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.chinawok.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsFragment extends Fragment {

    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        @Override
        public void onMapReady(GoogleMap googleMap) {





            LatLng MallTobalaba = new LatLng(-33.56905640824466, -70.55487153045652);
            LatLng MallOeste = new LatLng(-33.51704722653109, -70.71808451801986);
            LatLng MallAraucoMaipu = new LatLng(-33.481441438942916, -70.752045273508);
            LatLng PaseoAraucoEstacion = new LatLng(-33.452228073970666, -70.67991393725067);
            LatLng MallSur = new LatLng(-33.631615107701194, -70.71022074870852);
            LatLng MallAlameda = new LatLng(-33.45223556179365, -70.68240334992313);
            LatLng MallVespucio = new LatLng(-33.51790915965344, -70.59948695867547);
            LatLng MallVivoCentro = new LatLng(-33.43515932365421, -70.65145644336386);
            LatLng EusebioLillo = new LatLng(-33.42877862670543, -70.6446053713652);
            LatLng MallCostaneraCenter = new LatLng(-33.41785853393282, -70.60769693602458);
            LatLng MallParqueArauco = new LatLng(-33.40249628487317, -70.57940965259888);
            LatLng MallPlazaNorte = new LatLng(-33.36588157461525, -70.67864213443578);

            googleMap.addMarker(new MarkerOptions().position(MallPlazaNorte).title("ChinaWok Mall Plaza Norte"));
            googleMap.addMarker(new MarkerOptions().position(MallParqueArauco).title("ChinaWok Mall Parque Arauco"));
            googleMap.addMarker(new MarkerOptions().position(MallCostaneraCenter).title("ChinaWok Mall Costanera Center"));
            googleMap.addMarker(new MarkerOptions().position(EusebioLillo).title("ChinaWok Eusebio Lillo"));
            googleMap.addMarker(new MarkerOptions().position(MallVivoCentro).title("ChinaWok Mall Vivo Centro"));
            googleMap.addMarker(new MarkerOptions().position(MallVespucio).title("ChinaWok Mall Plaza Vespucio"));
            googleMap.addMarker(new MarkerOptions().position(MallAlameda).title("ChinaWok Mall Plaza Alameda"));
            googleMap.addMarker(new MarkerOptions().position(PaseoAraucoEstacion).title("ChinaWok Paseo Arauco Estacion"));
            googleMap.addMarker(new MarkerOptions().position(MallAraucoMaipu).title("ChinaWok Mall Arauco Maipu"));
            googleMap.addMarker(new MarkerOptions().position(MallTobalaba).title("ChinaWok Mall Plaza Tobalaba"));
            googleMap.addMarker(new MarkerOptions().position(MallOeste).title("ChinaWok Mall Plaza Oeste"));
            googleMap.addMarker(new MarkerOptions().position(MallSur).title("ChinaWok Mall Plaza Sur"));
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(MallCostaneraCenter, 10));


        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_maps, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }
}