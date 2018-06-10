package me.dmba.f2ftransitions.screens.main

import android.support.v7.widget.RecyclerView.Adapter
import android.support.v7.widget.RecyclerView.ViewHolder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.card_data_item.view.*
import me.dmba.f2ftransitions.R
import me.dmba.f2ftransitions.data.DataItem

/**
 * Created by dmba on 6/10/18.
 */

typealias DataItemClickListener = (item: DataItem, shareImageView: View) -> Unit

class DataItemViewHolder(
    itemView: View
) : ViewHolder(itemView) {

    private val picasso: Picasso by lazy {
        Picasso.get()
    }

    fun bindData(item: DataItem) {
        itemView.dataItemName.text = item.name
        picasso.load(item.imgUrl)
            .placeholder(R.drawable.ic_launcher_background)
            .into(itemView.dataItemImage)
    }

}

class DataItemsAdapter(
    private val data: List<DataItem>,
    private val layoutInflater: LayoutInflater,
    private val onClick: DataItemClickListener
) : Adapter<DataItemViewHolder>() {

    override fun getItemCount(): Int = data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataItemViewHolder {
        val view = layoutInflater.inflate(R.layout.card_data_item, parent, false)
        return DataItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: DataItemViewHolder, position: Int) {
        holder.bindData(data[position])
        holder.itemView.setOnClickListener { onClick(data[position], it) }
    }

}
