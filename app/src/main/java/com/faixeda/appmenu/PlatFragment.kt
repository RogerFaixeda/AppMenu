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
import com.faixeda.appmenu.databinding.FragmentPlatBinding

class PlatFragment : Fragment() {
    private val viewModel: MenusSharedViewModel by activityViewModels()
    private lateinit var binding: FragmentPlatBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inicializa el binding correctamente
        binding = FragmentPlatBinding.inflate(inflater, container, false)

        binding.imageButton.setOnClickListener{

            var plat : String = binding.editText1Plat.text.toString()
            var quantitat : String = binding.editTextQuantitat.text.toString()

            if (plat.isEmpty() || quantitat.isEmpty() || !(quantitat.isDigitsOnly())){
                Toast.makeText(context, "Omple tots els camps!", Toast.LENGTH_SHORT).show()
            } else {

                viewModel.afegirAlMenu(MenuModel(tipus = "plat", nom = plat, quantitat = quantitat.toInt(), preuUnitari = 10))

                findNavController().navigate(R.id.action_platFragment_to_begudaFragment, null)
            }
        }

        return binding.root
    }
}