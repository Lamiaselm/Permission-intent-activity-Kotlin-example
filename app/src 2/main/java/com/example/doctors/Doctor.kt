package com.example.doctors

import java.io.Serializable

data class Doctor(
    val nom:String, val prenom:String, val num:String,
    val speciality:String, val img:Int, val lat: Double, val lang: Double
):Serializable