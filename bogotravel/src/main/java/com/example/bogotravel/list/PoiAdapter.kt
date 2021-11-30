package com.example.bogotravel.list

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bogotravel.R
import com.example.bogotravel.model.PoiItem
import com.squareup.picasso.Picasso

class PoiAdapter (
    private val poiList: ArrayList<PoiItem>,
    private val onItemClicked: (PoiItem) -> Unit
) : RecyclerView.Adapter<PoiAdapter.PoiViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PoiViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view_poi_item, parent, false)
        return PoiViewHolder(view)
    }

    override fun onBindViewHolder(holder: PoiViewHolder, position: Int) {
        val poi = poiList[position]
        holder.itemView.setOnClickListener { onItemClicked(poiList[position])}
        holder.bind(poi)
    }

    override fun getItemCount(): Int = poiList.size

    class PoiViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        private var namePoiView: TextView = itemView.findViewById(R.id.name_poi_view)
        private var descripcortaView: TextView = itemView.findViewById(R.id.descripcorta_view)
        private var valoracionView: TextView = itemView.findViewById(R.id.valoracion_view)
        private var pictureImageView: ImageView = itemView.findViewById(R.id.picture_image_view)

        fun bind(poi: PoiItem){
            Log.d("nombre",poi.name)
            namePoiView.text = poi.name
            descripcortaView.text = poi.descripcorta
            valoracionView.text = poi.valoracion
            Picasso.get().load(poi.urlPicture).into(pictureImageView);
            //picture
        }
    }
}