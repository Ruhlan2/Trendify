package com.ruhlanusubov.ecommerceretrofit.ui.bottom_navigation.home

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.ruhlanusubov.ecommerceretrofit.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment() {
    private var _binding: FragmentDetailsBinding?=null
    private val binding: FragmentDetailsBinding get() = _binding!!
    private val args by navArgs<DetailsFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentDetailsBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setup()
    }
    private fun setup(){

            val product=args.data
            Glide.with(requireContext()).load(product.image).into(binding.detailimg)
            binding.detailname.text=product.title
            binding.detailprice.text="${product.price} $"
            binding.rating.text="${product.rating?.rate} ⭐"

        binding.heartcheck.setOnClickListener {
            Toast.makeText(requireContext(),"Added to wishlist",Toast.LENGTH_SHORT).show()
        }

        binding.back.setOnClickListener {
            findNavController().popBackStack()
        }


    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}