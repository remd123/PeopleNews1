package com.example.peoplenews.recursos

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val URL = "http://169.254.227.89:5050/"

fun connector() : Retrofit {

    return Retrofit.Builder()
        .baseUrl(URL)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

}