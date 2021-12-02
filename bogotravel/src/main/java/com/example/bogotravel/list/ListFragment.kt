package com.example.bogotravel.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bogotravel.R
import com.example.bogotravel.databinding.FragmentListBinding
import com.example.bogotravel.main.MainActivity
import com.example.bogotravel.model.Poi
import com.example.bogotravel.model.PoiItem
import com.google.gson.Gson


class ListFragment : Fragment() {
    private lateinit var listBinding: FragmentListBinding
    private lateinit var poiAdapter: PoiAdapter
    private lateinit var listPoi: ArrayList<PoiItem>



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        listBinding= FragmentListBinding.inflate(inflater, container, false)

        return listBinding.root
    }

    override fun onViewCreated(view: android.view.View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity?)?.hideIcon()
        listPoi = loadMockPoiFromJson()
        poiAdapter= PoiAdapter(listPoi, onItemClicked = { onPoiClicked (it) })
        listBinding.poiRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = poiAdapter
            setHasFixedSize(false)
        }
    }

    private fun onPoiClicked(poi: PoiItem) {
        findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment(poi = poi))

    }

    private fun loadMockPoiFromJson(): ArrayList<PoiItem> {
        var poiString: String = context?.assets?.open("InfoPoi.json")?.bufferedReader().use { it!!.readText() }//TODO reparar//
        val gson = Gson()
        val poiList = gson.fromJson(poiString, Poi::class.java)
        return poiList
    }

}