package com.example.peoplenews.network

import com.example.peoplenews.model.RepososResult
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface RepososApi {
    @GET("entity.reposos")
    fun getReposos(): Call<RepososResult>
    companion object{
        val BASE_URL= "http://95f629b3.ngrok.io/REST_New_People/webresources/"
        fun create(): RepososApi  {
            val retrofit= Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(RepososApi::class.java)
        }
    }
}