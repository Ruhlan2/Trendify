package com.ruhlanusubov.ecommerceretrofit.ui

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ruhlanusubov.ecommerceretrofit.R
import com.ruhlanusubov.ecommerceretrofit.databinding.FragmentIntroBinding

class IntroFragment : Fragment() {
    private var _binding:FragmentIntroBinding?=null
    private val binding:FragmentIntroBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentIntroBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setup()
    }
    private fun setup(){
        val handler=Handler(Looper.getMainLooper())
        val runnable=Runnable{
           findNavController().navigate(IntroFragmentDirections.actionIntroFragmentToStartFragment())
        }
        handler.postDelayed(runnable,8000L)


    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}