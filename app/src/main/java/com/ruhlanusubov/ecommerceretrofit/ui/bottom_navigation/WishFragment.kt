package com.ruhlanusubov.ecommerceretrofit.ui.bottom_navigation

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ruhlanusubov.ecommerceretrofit.R
import com.ruhlanusubov.ecommerceretrofit.databinding.FragmentStoreBinding
import com.ruhlanusubov.ecommerceretrofit.databinding.FragmentWishBinding

class WishFragment : Fragment() {
    private var _binding: FragmentWishBinding?=null
    private val binding: FragmentWishBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentWishBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setup()
    }
    private fun setup(){

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}