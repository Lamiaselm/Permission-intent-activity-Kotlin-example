package com.example.doctors

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {
    val doctorInterface:DoctorInterface by lazy {
        Retrofit.Builder().baseUrl("http://192.168.1.6:8082/"). addConverterFactory(
            GsonConverterFactory.create()). build().create(DoctorInterface::class.java)
    }
}