package com.estebanposada.indicadores.ui.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.estebanposada.domain.Serie
import com.estebanposada.indicadores.databinding.SeriesItemBinding

class SeriesAdapter : RecyclerView.Adapter<SeriesAdapter.ViewHolder>() {

    private val series = mutableListOf<Serie>()

    inner class ViewHolder(private val binding: SeriesItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Serie) {
            binding.date.text = data.date
            binding.value.text = data.value.toString()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        SeriesItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = series[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = series.size

    fun setData(series: List<Serie>) {
        this.series.clear()
        this.series.addAll(series)
        notifyDataSetChanged()
    }
}