package com.flexicondev.weather.network.response

import com.google.gson.annotations.SerializedName

data class IPDataResponse(

    @field:SerializedName("country_code")
    val countryCode: String,

    @field:SerializedName("city")
    val city: String,

    @field:SerializedName("ip")
    val ip: String,

    @field:SerializedName("latitude")
    val latitude: Double,

    @field:SerializedName("country_name")
    val countryName: String,

    @field:SerializedName("region_name")
    val regionName: String,

    @field:SerializedName("time_zone")
    val timeZone: String,

    @field:SerializedName("zip_code")
    val zipCode: String,

    @field:SerializedName("longitude")
    val longitude: Double
)

