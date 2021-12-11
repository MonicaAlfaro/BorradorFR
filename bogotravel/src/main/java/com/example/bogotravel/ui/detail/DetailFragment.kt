package com.example.bogotravel.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.bogotravel.databinding.FragmentDetailBinding
import com.example.bogotravel.ui.main.MainActivity

class DetailFragment : Fragment() {
    private lateinit var detailBiding: FragmentDetailBinding
    private val detailViewModel: DetailViewModel by viewModels()
    private val args: DetailFragmentArgs by navArgs()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as MainActivity?)?.showIcon()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        detailBiding = FragmentDetailBinding.inflate(inflater, container, false)

        return detailBiding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val poi = args.poi


        with(detailBiding){
            tituloView.text = poi.name
            descripcionView.text = poi.descripcion
            temperaturaView.text = poi.temperatura
            com.squareup.picasso.Picasso.get().load(poi.urlPictureBig).into(imageView2)

            mapButton.setOnClickListener {
                findNavController().navigate(DetailFragmentDirections.actionNavigationDetailToMapsFragment())
            }


        }

    }
}