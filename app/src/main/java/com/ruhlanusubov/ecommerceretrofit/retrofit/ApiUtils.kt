package com.ruhlanusubov.ecommerceretrofit.retrofit

import com.ruhlanusubov.ecommerceretrofit.BASE_URL
import com.ruhlanusubov.ecommerceretrofit.service.Service

class ApiUtils {
    companion object{
        fun getService():Service{
            return RetrofitUtil.initretrofit(BASE_URL).create(Service::class.java)
        }
    }
}