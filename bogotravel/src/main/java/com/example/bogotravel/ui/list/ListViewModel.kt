package com.example.bogotravel.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bogotravel.data.PoiRepository
import com.example.bogotravel.model.Poi
import com.example.bogotravel.model.PoiItem
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.InputStream

class ListViewModel : ViewModel() {
    private var poiLoad: MutableLiveData<ArrayList<PoiItem>> = MutableLiveData()
    val onPoiLoaded: LiveData<ArrayList<PoiItem>> = poiLoad

    private val repository = PoiRepository()
    fun getPoiFromServer() {
        GlobalScope.launch(Dispatchers.IO) {
            poiLoad.postValue(repository.getPoi())
        }


        fun loadMockPoiFromJson(poiString: InputStream?) {
            val poiString = poiString?.bufferedReader().use { it!!.readText() }
            val gson = Gson()
            poiLoad.value = gson.fromJson(poiString, Poi::class.java)

        }

    }
}