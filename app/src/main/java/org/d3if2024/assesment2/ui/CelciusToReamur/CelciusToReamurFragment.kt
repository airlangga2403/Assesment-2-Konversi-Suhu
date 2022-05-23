package org.d3if2024.assesment2.ui.CelciusToReamur

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.d3if2024.assesment2.R
import org.d3if2024.assesment2.databinding.FragmentCelciusToFarenhitBinding
import org.d3if2024.assesment2.databinding.FragmentCelciusToReamurBinding

class CelciusToReamurFragment : Fragment() {

    private lateinit var binding: FragmentCelciusToReamurBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCelciusToReamurBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}