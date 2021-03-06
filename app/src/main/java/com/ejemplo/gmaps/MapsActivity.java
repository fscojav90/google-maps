package com.ejemplo.gmaps;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    private EditText etLatitud;
    private EditText etLongitud;
    private Button btBuscar;
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        //iniciar componentes
        etLatitud = (EditText) findViewById(R.id.etLatitud);
        etLongitud = (EditText) findViewById(R.id.etLongitud);
        btBuscar = (Button) findViewById(R.id.btBuscar);
        btBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //tomar valores de los EditText
                try {
                    double lat = Double.parseDouble(etLatitud.getText().toString());
                    double lng = Double.parseDouble(etLongitud.getText().toString());
                    //marcador
                    LatLng marcador = new LatLng(lat, lng);
                    //título
                    //mMap.addMarker(new MarkerOptions().position(marcador).title("Mi marcador"));
                    mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_mi_marcador_round))
                            .anchor(0.0f, 1.0f).position(marcador).title("Mi marcador"));
                    //mover camara
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(marcador, 16));
                }catch (Exception ex){
                    Toast.makeText(MapsActivity.this, "Valor inválido!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
//        LatLng arica = new LatLng(-18.478518, -70.32106);
        LatLng ust = new LatLng(-18.483474, -70.310192);
//        mMap.addMarker(new MarkerOptions().position(arica).title("Arica"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(arica));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ust, 16));
//        mMap.addMarker(new MarkerOptions().position(ust).title("Santo Tomás"));
        mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_mi_marcador_round))
                .anchor(0.0f, 1.0f).position(ust).title("Santo Tomás"));
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

    }
}
