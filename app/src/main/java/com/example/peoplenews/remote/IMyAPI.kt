package com.example.peoplenews.remote



import com.example.peoplenews.model.APIResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface IMyAPI {
    @FormUrlEncoded
    @POST("register")
    fun registerUser(@Field("name") name:String, @Field("pass") password: String): Call<APIResponse>

    @FormUrlEncoded
    @POST("login")
    fun loginUser(@Field("name") name:String, @Field("pass") password: String): Call<APIResponse>
}