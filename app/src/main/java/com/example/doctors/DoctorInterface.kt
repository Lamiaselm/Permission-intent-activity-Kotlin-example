package com.example.doctors


import retrofit2.Call
import retrofit2.http.GET

interface DoctorInterface {
    @GET("all")
    fun getDoctors(): Call<List<Doctor>>
}