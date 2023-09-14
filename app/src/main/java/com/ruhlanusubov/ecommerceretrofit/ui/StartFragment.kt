package com.ruhlanusubov.ecommerceretrofit.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ruhlanusubov.ecommerceretrofit.databinding.FragmentStartBinding

class StartFragment : Fragment() {
    private var _binding:FragmentStartBinding?=null
    private val binding:FragmentStartBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentStartBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setup()
    }

    private fun setup(){
        binding.letsstarted.setOnClickListener {
            findNavController().navigate(StartFragmentDirections.actionStartFragmentToTabFragment())
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}