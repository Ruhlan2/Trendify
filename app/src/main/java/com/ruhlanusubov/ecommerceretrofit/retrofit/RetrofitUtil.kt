package com.ruhlanusubov.ecommerceretrofit.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitUtil{
    companion object{
            fun initretrofit(baseurl:String):Retrofit{
               return Retrofit.Builder().baseUrl(baseurl).addConverterFactory(GsonConverterFactory.create()).build()
            }
    }
}