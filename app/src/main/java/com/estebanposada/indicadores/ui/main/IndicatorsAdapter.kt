package com.estebanposada.indicadores.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.estebanposada.domain.IndicatorDetails
import com.estebanposada.indicadores.databinding.IndicatorItemBinding

class IndicatorsAdapter : RecyclerView.Adapter<IndicatorsAdapter.ViewHolder>() {

    var onItemClicked: ((String) -> Unit)? = null
    private val indicators = mutableListOf<IndicatorDetails>()
    private var sortedAsc = true

    inner class ViewHolder(private val binding: IndicatorItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: IndicatorDetails) {
            binding.name.text = data.name
            binding.measurementUnit.text = data.measurementUnit
            binding.value.text = data.value.toString()
            binding.item.setOnClickListener { onItemClicked?.invoke(data.code) }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        IndicatorItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = indicators[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = indicators.size

    fun setData(indicators: List<IndicatorDetails>) {
        this.indicators.clear()
        this.indicators.addAll(indicators)
        sort()
    }

    fun sort() {
        if (sortedAsc) {
            indicators.sortBy { it.name }
        } else {
            indicators.sortByDescending { it.name }
        }
        sortedAsc = !sortedAsc
        notifyDataSetChanged()
    }
}