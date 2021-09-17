package com.example.mobibar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.birjuvachhani.locus.Locus
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class LocationActivity : AppCompatActivity(), OnMapReadyCallback {
    private var googleMap: GoogleMap? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location)

        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        var moved = false

        Locus.startLocationUpdates(this) { result ->
            result.location?.let {
                val mobiBar = LatLng(result.location!!.latitude, result.location!!.longitude)
                googleMap?.addMarker((MarkerOptions().position(mobiBar).title("MobiSite")))

                if (moved == false) {
                    googleMap?.moveCamera(CameraUpdateFactory.newLatLng(mobiBar))
                    moved = true
                }
            }

            result.error?.let {

            }
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        this.googleMap = googleMap

        val hartie = LatLng(-25.0, 27.0)
        googleMap.addMarker(MarkerOptions().position(hartie).title("Marker in harties"))
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(hartie))
    }
}