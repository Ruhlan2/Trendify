package com.ruhlanusubov.ecommerceretrofit.ui.validation

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.navigation.fragment.findNavController
import com.ruhlanusubov.ecommerceretrofit.R
import com.ruhlanusubov.ecommerceretrofit.databinding.FragmentLoginBinding
import com.ruhlanusubov.ecommerceretrofit.databinding.FragmentRegisterBinding
import www.sanju.motiontoast.MotionToast
import www.sanju.motiontoast.MotionToastStyle

class RegisterFragment : Fragment() {
    private var _binding: FragmentRegisterBinding?=null
    private val binding: FragmentRegisterBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentRegisterBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setup()
    }
    private fun setup(){
        binding.register.setOnClickListener {
            val email=binding.email.text.toString()
            val password=binding.password.text.toString()
            val phone=binding.phone.text.toString()
    if(email.isNotEmpty()&&password.isNotEmpty()&&phone.isNotEmpty()){

        val sharedPreferences=requireContext().getSharedPreferences("user",Context.MODE_PRIVATE)
        val data=sharedPreferences.edit()
        data.putString("user_email",email)
        data.apply()

        findNavController().navigate(TabFragmentDirections.actionTabFragmentToHomeFragment())
        MotionToast.createToast(requireActivity(),
            "Successful 😍",
            "Register process",
            MotionToastStyle.SUCCESS,
            MotionToast.GRAVITY_BOTTOM,
            MotionToast.SHORT_DURATION,
            ResourcesCompat.getFont(requireContext(), www.sanju.motiontoast.R.font.helvetica_regular))
    }else{
        MotionToast.createToast(requireActivity(),
            "Failed ☹️",
            "Please fill the blanks!",
            MotionToastStyle.ERROR,
            MotionToast.GRAVITY_BOTTOM,
            MotionToast.SHORT_DURATION,
            ResourcesCompat.getFont(requireContext(), www.sanju.motiontoast.R.font.helvetica_regular))
    }
}

    }





    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}