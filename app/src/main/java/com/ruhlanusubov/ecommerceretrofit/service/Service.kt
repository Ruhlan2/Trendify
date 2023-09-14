package com.ruhlanusubov.ecommerceretrofit.service

import com.ruhlanusubov.ecommerceretrofit.model.ProductResponse
import retrofit2.Call
import retrofit2.http.GET

interface Service{
    @GET("products")
    fun getProducts():Call<ProductResponse>
}