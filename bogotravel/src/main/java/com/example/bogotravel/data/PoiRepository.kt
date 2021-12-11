package com.example.bogotravel.data

class PoiRepository {
    suspend fun getPoi() = ApiFactory.retrofit.getPoi()
}