package com.faixeda.appmenu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.text.isDigitsOnly
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.faixeda.appmenu.databinding.FragmentBegudaBinding
import com.faixeda.appmenu.databinding.FragmentPagarBinding
import kotlin.time.Duration.Companion.milliseconds

class BegudaFragment : Fragment() {

    private val viewModel: MenusSharedViewModel by activityViewModels()
    private lateinit var binding: FragmentBegudaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inicializa el binding correctamente
        binding = FragmentBegudaBinding.inflate(inflater, container, false)

        binding.imageButton.setOnClickListener{

            var beguda : String = binding.editTextBeguda.text.toString()
            var quantitat : String = binding.editTextQuantitat.text.toString()

            if (beguda.isEmpty() || quantitat.isEmpty() || !(quantitat.isDigitsOnly())){
                Toast.makeText(context, "Omple tots els camps!", Toast.LENGTH_SHORT).show()
            } else {

                viewModel.afegirAlMenu(MenuModel(tipus = "beguda", nom = beguda, quantitat = quantitat.toInt(), preuUnitari = 3))

                findNavController().navigate(R.id.action_begudaFragment_to_pagarFragment, null)
            }
        }

        return binding.root
    }
}