package org.d3if2024.assesment2.ui.CelciusToFarenhit

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import org.d3if2024.assesment2.R
import org.d3if2024.assesment2.databinding.FragmentCelciusToFarenhitBinding
import org.d3if2024.assesment2.db.SuhuDb
import org.d3if2024.assesment2.model.KategoriSuhu


class CelciusToFarenhitFragment : Fragment() {
//    private val viewModel: CelciusToFarenhitViewModel by activityViewModels {
//        CelciusToFarenhitViewModelFactory(
//            (activity?.application as InventoryApplication).database.itemDao()
//        )
//    }

    private val viewModel: CelciusToFarenhitViewModel by lazy{
        val db = SuhuDb.getInstance(requireContext())
        val factory = CelciusToFarenhitViewModelFactory(db.itemDao)
        ViewModelProvider(this,factory)[CelciusToFarenhitViewModel::class.java]
    }

    private lateinit var binding: FragmentCelciusToFarenhitBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCelciusToFarenhitBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.calculateBtn.setOnClickListener {
            hitungKonversiSuhu()
        }
    }

    private fun hitungKonversiSuhu(){
        val suhuCelcius = binding.celciusToFarenheitEditText.text.toString()
        viewModel.hitungKonversiSuhuCecliusToFarenhit(suhuCelcius.toFloat())
//        val suhuFarenhit = viewModel.hitungKonversiSuhuCecliusToFarenhit(suhuCelcius.toFloat())
//        viewModel.addNewItems(
//            binding.celciusToFarenheitEditText.text.toString(),
//            suhuFarenhit.toString()
//        )
    }

//    private fun isEntryValid(): Boolean {
//        return viewModel.isEntryValid(
//            binding.celciusToFarenheitEditText.text.toString()
//        )
//    }



    private fun displayConvert(dataCelcius: Double) {
        binding.result.text = "Nilai Hasil Konversi: ${dataCelcius}" + "\u2103"
    }
}
