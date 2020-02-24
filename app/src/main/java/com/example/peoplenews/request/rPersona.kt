package com.example.peoplenews.request

import com.example.peoplenews.model.mPersona
import io.reactivex.Completable
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

public interface rPersona{

    @GET("persona/{personaid}")
    fun getPersona(@Path("personaid") personaid: Int) : Observable<mPersona>

    @POST("persona")
    fun postPersona(mpersona : mPersona) : Completable

}