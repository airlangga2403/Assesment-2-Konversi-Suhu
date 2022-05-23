package org.d3if2024.assesment2.ui.CelciusToReamur

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import org.d3if2024.assesment2.databinding.FragmentCelciusToReamurBinding
import org.d3if2024.assesment2.db.SuhuDb


class CelciusToReamurFragment : Fragment() {

    private val viewModel: CelciusToReamurViewModel by lazy {
        val db = SuhuDb.getInstance(requireContext())
        val factory = CelciusToReamurViewModelFactory(db.itemDao)
        ViewModelProvider(this, factory)[CelciusToReamurViewModel::class.java]
    }

    private lateinit var binding: FragmentCelciusToReamurBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCelciusToReamurBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.calculateBtn.setOnClickListener {
            hitungKonversiSuhu()
            convertSuhuReamur()
        }
    }

    private fun convertSuhuReamur() {
        val stringInTextField = binding.celciusToReamurEditText.text.toString()
        val suhu = stringInTextField.toDoubleOrNull()

        // Hitung Conversi Suhu Celcius Ke Reamur
        if (suhu == null || suhu == 0.0) {
            displayConvert(0.0)
            return
        }
        var reamur = suhu * 4 / 5
        displayConvert(reamur)
    }

    private fun hitungKonversiSuhu() {
        val suhuCelcius = binding.celciusToReamurEditText.text.toString()
        viewModel.hitungKonversiSuhuCelciusToReamur(suhuCelcius.toFloat())
    }


    private fun displayConvert(dataCelcius: Double) {
        binding.result.text = "Nilai Hasil Konversi: ${dataCelcius}" + "°R"
    }
}