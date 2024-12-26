package com.faixeda.appmenu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.faixeda.appmenu.databinding.FragmentPagarBinding

class PagarFragment : Fragment() {

    private val viewModel: MenusSharedViewModel by activityViewModels()
    private lateinit var binding: FragmentPagarBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inicializa el binding correctamente
        binding = FragmentPagarBinding.inflate(inflater)

        viewModel.calcularPreu()

        viewModel.plat.observe(viewLifecycleOwner) { primerPlat ->
            val textPrimerPlat = primerPlat.quantitat.toString() + " " +  primerPlat.nom + " " + viewModel.preuTotalPrimerPlat.value.toString() + "€"
            binding.textViewTotal1rPlat.text = textPrimerPlat
        }

        viewModel.beguda.observe(viewLifecycleOwner) { beguda ->
            val textBeguda = beguda.quantitat.toString() + " " + beguda.nom + " " + viewModel.preuTotalBeguda.value.toString() + "€"
            binding.textViewTotalBeguda.text = textBeguda
        }

        viewModel.preuTotal.observe(viewLifecycleOwner) { preuTotal ->
            binding.textViewTotalTotal.text = preuTotal.toString() + "€"
        }

        // Devuelve la raíz de la vista
        return binding.root
    }
}