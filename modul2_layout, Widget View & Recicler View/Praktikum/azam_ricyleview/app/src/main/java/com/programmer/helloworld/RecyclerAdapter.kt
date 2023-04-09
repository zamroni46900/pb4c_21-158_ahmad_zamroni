package com.programmer.helloworld

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){
    //Image list
    private val images = intArrayOf(
        R.drawable.cardview_10,
        R.drawable.cardview_11,
        R.drawable.cardview_12,
        R.drawable.cardview_13,
        R.drawable.cardview_14,
        R.drawable.cardview_15)
    //Title list
    private val titles = arrayOf(
        "1 HIU MEGALODON",
        "2 IKAN TUNA",
        "3 IKAN MUJAIR",
        "4 IKAN KERAPU",
        "5 IKAN PARI",
        "6 IKAN TERI")
    //Detail list
    private val details = arrayOf(
        "megalodon adalah ikan ganas terbesar",
        "ikan tuna adalah hewan yang sering dicari",
        "ikan mujair adalah ikan air tawar",
        "ikan kerapu adalah ikan dasar",
        "ikan pari adalah ikan listrik",
        "ikan teri adalah sosok ikan kecil")
    //ViewHolder class
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView
        init{
            itemImage = itemView.findViewById(R.id.cardImage)
            itemTitle = itemView.findViewById(R.id.cardTitle)
            itemDetail = itemView.findViewById(R.id.cardDetail)

            itemView.setOnClickListener { v: View ->
                var position: Int = getAdapterPosition()
                Snackbar.make(v, "MAAF IKAN SEDANG TIDUR ${titles[position]}",
                    Snackbar.LENGTH_LONG).setAction("Action",null).show()
            }
        }

    }

    //onCreateViewHolder()
    override fun onCreateViewHolder(ViewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(ViewGroup.context)
            .inflate(R.layout.card_layout, ViewGroup, false)
        return ViewHolder(v)
    }
    //onBindViewHolder()
    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemTitle.text = titles[i]
        viewHolder.itemDetail.text = details[i]
        viewHolder.itemImage.setImageResource(images[i])
    }
    //getItemCount()
    override fun getItemCount(): Int {
        return titles.size
    }
}