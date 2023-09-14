package com.ruhlanusubov.ecommerceretrofit.ui.bottom_navigation

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.ruhlanusubov.ecommerceretrofit.R
import com.ruhlanusubov.ecommerceretrofit.databinding.FragmentHomeBinding
import com.ruhlanusubov.ecommerceretrofit.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding?=null
    private val binding: FragmentProfileBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentProfileBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setup()
        getData()
    }
    private fun setup(){

    }
    private fun getData(){
        val storedemail=requireActivity().getSharedPreferences("user",Context.MODE_PRIVATE)
        val user=storedemail.getString("user_email",null)
       binding.info.text="Email: $user"
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}