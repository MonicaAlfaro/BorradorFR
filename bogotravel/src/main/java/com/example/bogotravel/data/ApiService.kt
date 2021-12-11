package com.example.bogotravel.data

import com.example.bogotravel.model.Poi
import retrofit2.http.GET

interface ApiService {
    @GET("MonicaAlfaro/BorradorFR/poi")
    suspend fun getPoi(): Poi
}