package org.d3if2024.assesment2.ui.histori

import android.annotation.SuppressLint
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import org.d3if2024.assesment2.R
import org.d3if2024.assesment2.databinding.ItemHistoriBinding
import org.d3if2024.assesment2.db.SuhuEntity
import org.d3if2024.assesment2.model.KategoriSuhu
import org.d3if2024.assesment2.model.hitungKonversiSuhu
import java.text.SimpleDateFormat
import java.util.*

class HistoriAdapter :
    ListAdapter<SuhuEntity, HistoriAdapter.ViewHolder>(DIFF_CALLBACK) {
    companion object {
        private val DIFF_CALLBACK =
            object : DiffUtil.ItemCallback<SuhuEntity>() {
                override fun areItemsTheSame(
                    oldData: SuhuEntity, newData: SuhuEntity
                ): Boolean {
                    return oldData.id == newData.id
                }

                override fun areContentsTheSame(
                    oldData: SuhuEntity, newData: SuhuEntity
                ): Boolean {
                    return oldData == newData
                }
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemHistoriBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(
        private val binding: ItemHistoriBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        private val dateFormatter = SimpleDateFormat(
            "dd MMMM yyyy",
            Locale("id", "ID")
        )
        fun bind(item: SuhuEntity) = with(binding) {
            val hasilKonversiSuhu = item.hitungKonversiSuhu()
            kategoriTextView.text = hasilKonversiSuhu.suhuConvert
            val colorRes = when (hasilKonversiSuhu.suhuConvert) {
                "Farenhit" -> R.color.farenhit
                "KELVIN" -> R.color.kelvin
                else -> R.color.reamur
            }
            val circleBg = kategoriTextView.background as GradientDrawable
            circleBg.setColor(ContextCompat.getColor(root.context, colorRes))
            tanggalTextView.text = dateFormatter.format(Date(item.tanggal))
            bmiTextView.text = item.suhuCelcius.toString()
            dataTextView.text = item.hasilConvertCelcius
        }
    }


}