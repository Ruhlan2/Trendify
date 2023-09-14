package com.ruhlanusubov.ecommerceretrofit.ui.bottom_navigation.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.ruhlanusubov.ecommerceretrofit.adapter.ProductAdapter
import com.ruhlanusubov.ecommerceretrofit.databinding.FragmentHomeBinding
import com.ruhlanusubov.ecommerceretrofit.model.ProductResponse
import com.ruhlanusubov.ecommerceretrofit.retrofit.ApiUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {
    private val service=ApiUtils.getService()
    private val adapter=ProductAdapter()
    private var _binding: FragmentHomeBinding?=null
    private val binding: FragmentHomeBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setup()
        requestdata()
    }
    private fun setup(){
        binding.rvProducts.layoutManager=StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        binding.rvProducts.adapter=adapter
    }
    private fun requestdata(){
            val response=service.getProducts()

            response.enqueue(object :Callback<ProductResponse>{
                override fun onResponse(
                    call: Call<ProductResponse>,
                    response: Response<ProductResponse>
                ) {
                   if (response.isSuccessful){
                       response.body()?.let {
                           adapter.updatelist(it)
                           Log.e("response",it.toString())
                       }
                   }
                }

                override fun onFailure(call: Call<ProductResponse>, t: Throwable) {
                    Log.e("response","error")
                }

            })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }

}