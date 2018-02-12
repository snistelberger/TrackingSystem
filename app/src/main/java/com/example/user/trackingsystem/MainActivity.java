package com.example.user.trackingsystem;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements LocationListener {
    private static LocationManager locMan = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        locMan = (LocationManager) getSystemService(LOCATION_SERVICE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ActivityCompat.requestPermissions(this, new String [] {Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locMan.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 5, this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        locMan.removeUpdates(this);
    }

    @Override
    public void onLocationChanged(Location location) {
        if (location == null) return;
        displayLocation(location);
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    private void displayLocation(Location location) {
        double latitude = location.getLatitude();
        double longitude = location.getLongitude();
        double altitude = location.getAltitude();
        TextView tv_latitude = (TextView) findViewById(R.id.tv_latitude);
        TextView tv_longitude = (TextView) findViewById(R.id.tv_longitude);
        TextView tv_altitude = (TextView) findViewById(R.id.tv_altitude);
        TextView tv_date = (TextView) findViewById(R.id.tv_date);
        tv_longitude.setText(String.format("%.4f", longitude));
        tv_latitude.setText(String.format("%.4f", latitude));
        tv_altitude.setText(String.format("%.4f", altitude));
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy  hh:mm");
        tv_date.setText(sdf.format(new Date()));
    }
}
