package com.example.bogotravel.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class PoiItem(
    @SerializedName("descripcorta")
    val descripcorta: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("urlPicture")
    val urlPicture: String,
    @SerializedName("valoracion")
    val valoracion: String,
    @SerializedName("descripcion")
    val descripcion: String,
    @SerializedName("temperatura")
    val temperatura: String,
    @SerializedName("urlPictureBig")
    val urlPictureBig: String,
    @SerializedName("longitud")
    val loingitud: Double,
    @SerializedName("latitud")
    val latitud: Double

) : Serializable