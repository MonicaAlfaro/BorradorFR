package com.example.bogotravel.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bogotravel.model.Poi
import com.example.bogotravel.model.PoiItem
import com.google.gson.Gson
import java.io.InputStream

class ListViewModel : ViewModel() {
    private var poiLoad : MutableLiveData<ArrayList<PoiItem>> = MutableLiveData()
    val onPoiLoaded : LiveData<ArrayList<PoiItem>> = poiLoad


    fun loadMockPoiFromJson(poiString: InputStream?) {
        val poiString = poiString?.bufferedReader().use { it!!.readText() }
        val gson = Gson()
        poiLoad.value = gson.fromJson(poiString, Poi::class.java)

    }

}