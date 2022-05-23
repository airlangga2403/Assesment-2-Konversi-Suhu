package org.d3if2024.assesment2.ui.SejarahSingkat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.d3if2024.assesment2.R
import org.d3if2024.assesment2.adapter.SejarahSingkatAdapter
import org.d3if2024.assesment2.data.DataSuhu
import org.d3if2024.assesment2.databinding.FragmentCelciusToFarenhitBinding
import org.d3if2024.assesment2.databinding.FragmentSejarahSingkatSuhuBinding


class SejarahSingkatSuhuFragment : Fragment() {
    private lateinit var binding: FragmentSejarahSingkatSuhuBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSejarahSingkatSuhuBinding.inflate(layoutInflater, container, false)
        return binding.root
        val myDataSet = DataSuhu().loadDataSuhu()
        binding.sejarahSingkatSuhuRecyclerView.adapter = SejarahSingkatAdapter(this, myDataSet)
        with(binding.sejarahSingkatSuhuRecyclerView){
            addItemDecoration(DividerItemDecoration(context, RecyclerView.VERTICAL))
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
        }
    }
}