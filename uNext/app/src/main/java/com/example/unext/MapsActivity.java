package com.example.unext;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.EventLogTags;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.unext.databinding.ActivityMapsBinding;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    private LinearLayout linearLayout;
    private Button btnStart;
    private List<CaruNextItem> caruNextItems;
    private List<LatLng> position_uNext;
    private ListView listuNext;
    private Marker marker;
    private MarkerOptions car_uNext;
    private Object BitmapDescriptor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        linearLayout = findViewById(R.id.layoutLocalização);
        btnStart=findViewById(R.id.btnStart);
        listuNext=findViewById(R.id.listLocation);
        // Configurar list view

        caruNextItems = new ArrayList<>();
        caruNextItems.add(new CaruNextItem(R.drawable.car_1, "Mais próximo", " 5 km"));
        caruNextItems.add(new CaruNextItem(R.drawable.car_2, "Mais tecnológico", " 30 km"));
        caruNextItems.add(new CaruNextItem(R.drawable.car_3, "Mais Ágil", " 180 km"));

        listuNext.setAdapter(new ListuNextAdapter(getApplicationContext(), caruNextItems));

        //Posições do uNext

        position_uNext = new ArrayList<>();
        position_uNext.add(new LatLng(-22.155404,-50.0128199));
        position_uNext.add(new LatLng(-22.1555226,-50.0117392));
        position_uNext.add(new LatLng(-22.1554825,-50.0121072));
        position_uNext.add(new LatLng(-22.1554375,-50.0131103));
        position_uNext.add(new LatLng(-22.1553228,-50.0136632));
        position_uNext.add(new LatLng(-22.1552298,-50.0144992));




        btnStart.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                linearLayout.setVisibility(View.GONE);
                mMap.moveCamera(CameraUpdateFactory.newLatLng(position_uNext.get(1)));

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        marker.remove();
                        car_uNext.position(position_uNext.get(1));
                        marker = mMap.addMarker(car_uNext);
                        mMap.moveCamera(CameraUpdateFactory.newLatLng(position_uNext.get(1)));

                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                marker.remove();
                                car_uNext.position(position_uNext.get(2));
                                marker = mMap.addMarker(car_uNext);
                                mMap.moveCamera(CameraUpdateFactory.newLatLng(position_uNext.get(2)));

                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        marker.remove();
                                        car_uNext.position(position_uNext.get(3));
                                        marker = mMap.addMarker(car_uNext);
                                        mMap.moveCamera(CameraUpdateFactory.newLatLng(position_uNext.get(3)));

                                        new Handler().postDelayed(new Runnable() {
                                            @Override
                                            public void run() {
                                                marker.remove();
                                                car_uNext.position(position_uNext.get(4));
                                                marker = mMap.addMarker(car_uNext);
                                                mMap.moveCamera(CameraUpdateFactory.newLatLng(position_uNext.get(4)));

                                                new Handler().postDelayed(new Runnable() {
                                                    @Override
                                                    public void run() {
                                                        marker.remove();
                                                        car_uNext.position(position_uNext.get(5));
                                                        marker = mMap.addMarker(car_uNext);
                                                        mMap.moveCamera(CameraUpdateFactory.newLatLng(position_uNext.get(5)));

                                                        new Handler().postDelayed(new Runnable() {
                                                            @Override
                                                            public void run() {
                                                                marker.remove();
                                                                car_uNext.position(position_uNext.get(6));
                                                                marker = mMap.addMarker(car_uNext);
                                                                mMap.moveCamera(CameraUpdateFactory.newLatLng(position_uNext.get(6)));
                                                                Toast.makeText(getApplicationContext(), "Chegou");

                                                            }
                                                        }, 2000);

                                                    }
                                                }, 2000);
                                            }
                                        }, 2000);

                                    }
                                }, 2000);

                            }
                        }, 2000);

                    }
                }, 2000);

            }
            });


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
        LatLng home = new LatLng(-22.1551196, -50.0151128);

        MarkerOptions destino = new MarkerOptions().position(home).title("Sua localização").icon(BitmapDescriptorFactory.fromResource(R.drawable.marker));
        car_uNext = new MarkerOptions().position(position_uNext.get(0)).title("Máquina se aproximando").icon(BitmapDescriptorFactory.fromResource(R.drawable.car_uber));



        mMap.addMarker(destino);

        marker = mMap.addMarker(car_uNext);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(home));
    }
}