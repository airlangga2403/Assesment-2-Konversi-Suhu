package org.d3if2024.assesment2.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.d3if2024.assesment2.R
import org.d3if2024.assesment2.model.ModelSuhu
import org.d3if2024.assesment2.ui.SejarahSingkat.SejarahSingkatSuhuFragment

class SejarahSingkatAdapter(
    private val context: SejarahSingkatSuhuFragment,
    private val dataset: List<ModelSuhu>
) : RecyclerView.Adapter<SejarahSingkatAdapter.ConvertViewHolder>() {

    class ConvertViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_title)
        val imageView: ImageView = view.findViewById(R.id.item_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConvertViewHolder {
        // create a new view
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return ConvertViewHolder(adapterLayout)
    }

    /**
     * Replace the contents of a view (invoked by the layout manager)
     */
    override fun onBindViewHolder(holder: ConvertViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text = context.resources.getString(item.stringResourceId)
        holder.imageView.setImageResource(item.imageResourceId)
    }

    /**
     * Return the size of your dataset (invoked by the layout manager)
     */
    override fun getItemCount() = dataset.size
}