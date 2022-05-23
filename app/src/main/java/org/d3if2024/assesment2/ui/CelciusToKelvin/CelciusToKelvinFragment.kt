package org.d3if2024.assesment2.ui.CelciusToKelvin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.d3if2024.assesment2.databinding.FragmentCelciusToKelvinBinding


class CelciusToKelvinFragment : Fragment() {
    private lateinit var binding: FragmentCelciusToKelvinBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCelciusToKelvinBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

}