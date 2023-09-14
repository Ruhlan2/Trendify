package com.ruhlanusubov.ecommerceretrofit.ui.validation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.core.widget.doOnTextChanged
import androidx.navigation.fragment.findNavController
import com.ruhlanusubov.ecommerceretrofit.R
import com.ruhlanusubov.ecommerceretrofit.databinding.FragmentLoginBinding
import com.ruhlanusubov.ecommerceretrofit.databinding.FragmentTabBinding
import com.ruhlanusubov.ecommerceretrofit.ui.IntroFragmentDirections
import www.sanju.motiontoast.MotionToast
import www.sanju.motiontoast.MotionToastStyle

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding?=null
    private val binding: FragmentLoginBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentLoginBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setup()
    }
    private fun setup() {

        binding.login.setOnClickListener {
            val email=binding.email.text.toString()
            val password=binding.password.text.toString()
            if(email.isNotEmpty()&&password.isNotEmpty()){
                findNavController().navigate(TabFragmentDirections.actionTabFragmentToHomeFragment())
                MotionToast.createToast(requireActivity(),
                    "Successful 😍",
                    "Login process",
                    MotionToastStyle.SUCCESS,
                    MotionToast.GRAVITY_BOTTOM,
                    MotionToast.SHORT_DURATION,
                    ResourcesCompat.getFont(requireContext(), www.sanju.motiontoast.R.font.helvetica_regular))
            }else{
                MotionToast.createColorToast(requireActivity(),
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