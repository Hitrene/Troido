package com.example.myapplication.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemCurrencyBinding

class MainRecyclerViewAdapter : RecyclerView.Adapter<MainRecyclerViewAdapter.MainViewHolder>() {
    var items: List<PriceUIData> = emptyList()
    set(value) {
        val diffUtilCallback = DiffUtilCallback(items, value)
        val result = DiffUtil.calculateDiff(diffUtilCallback)

        field = value

        result.dispatchUpdatesTo(this)
    }

    inner class MainViewHolder(private val itemCurrencyBinding: ItemCurrencyBinding) :
        RecyclerView.ViewHolder(itemCurrencyBinding.root) {

            fun bind(item: PriceUIData) {
                itemCurrencyBinding.price.text = item.priceInDollars.toString()
                itemCurrencyBinding.time.text = item.timeStamp
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val binding = ItemCurrencyBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size
}