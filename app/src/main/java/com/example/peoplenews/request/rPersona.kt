package com.example.peoplenews.request

import com.example.peoplenews.model.mPersona
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

public interface rPersona{

    @GET("persona/{personaid}")
    fun getPersona(@Path("personaid") personaid: Int) : Observable<mPersona>

}