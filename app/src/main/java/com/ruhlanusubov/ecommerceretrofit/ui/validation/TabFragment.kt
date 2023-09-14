package com.ruhlanusubov.ecommerceretrofit.ui.validation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayoutMediator
import com.ruhlanusubov.ecommerceretrofit.R
import com.ruhlanusubov.ecommerceretrofit.adapter.ViewPageradapter
import com.ruhlanusubov.ecommerceretrofit.databinding.FragmentTabBinding

class TabFragment : Fragment() {
    val title= arrayOf("Login","Register")
    private var _binding:FragmentTabBinding?=null
    private val binding:FragmentTabBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentTabBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setuptab()
    }

    private fun setuptab(){
        val adapter=ViewPageradapter(requireActivity().supportFragmentManager,lifecycle)
        binding.viewpager.adapter=adapter
        TabLayoutMediator(binding.tabLayout,binding.viewpager){ tab,position->
            tab.text=title[position]

        }.attach()
    }
    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}