package com.kapil.hashgenerator

import android.os.Bundle
import android.view.*
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.kapil.hashgenerator.databinding.FragmentHomeBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding?=null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding= FragmentHomeBinding.inflate(inflater, container, false)

        setHasOptionsMenu(true)



        val hashAlgorithms = resources.getStringArray(R.array.hash_algorithms)
        val arrayAdapter = ArrayAdapter(requireContext(),R.layout.dropdown_item,hashAlgorithms)
        binding.autoCompleteTextView.setAdapter(arrayAdapter)

        binding.generateButton.setOnClickListener {
            lifecycleScope.launch {
                applyAnimation()
            }

        }




        return binding.root
    }

    private suspend fun applyAnimation(){
        binding.titleTextView.animate().alpha(0f).duration = 400L
        binding.generateButton.animate().alpha(0f).duration = 400L

        binding.textInputLayout.animate().alpha(0f).translationXBy(1200f).duration=400L
        binding.plainText.animate().alpha(0f).translationXBy(-1200f).duration=400L

        delay(300)


        binding.successBackground
            .animate()
            .alpha(1f)
            .duration=800L

        binding.successBackground
            .animate()
            .rotationBy(720f)
            .duration=800L

        binding.successBackground.animate().scaleXBy(900f).duration=1000L
        binding.successBackground.animate().scaleYBy(900f).duration=1000L

        delay(300)
        binding.successImageView.animate().alpha(1f).duration=1200L

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.home_menu,menu)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}
