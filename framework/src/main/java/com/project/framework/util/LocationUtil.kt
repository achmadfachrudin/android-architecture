package com.project.framework.util

import android.content.Context
import android.location.Geocoder
import android.util.Log
import java.io.IOException
import java.util.*

/**
 * Created by achmad.fachrudin on 21-Mar-19
 */
object LocationUtil {

    /**
     * @param context
     * @param lat
     * @param lng
     * @return String of Location(city) Name
     */
    fun getCurrentLocationFromLatLng(context: Context, lat: Double, lng: Double): String {
        if (Geocoder.isPresent()) {
            try {
                val gc = Geocoder(context, Locale.getDefault())
                val addresses = gc.getFromLocation(lat, lng, 1)
                if (addresses.size > 0) {
                    return when {
                        addresses[0].subAdminArea != null -> addresses[0].subAdminArea
                        addresses[0].adminArea != null -> addresses[0].adminArea
                        addresses[0].subLocality != null -> addresses[0].subLocality
                        addresses[0].locality != null -> addresses[0].locality
                        else -> ""
                    }
                }
            } catch (e: IOException) {
                e.let {
                    Log.e(context.toString(), e.toString())
                }
            }
        }
        return "Bekasi"
    }
}