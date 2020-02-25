package com.example.peoplenews.request

import com.example.peoplenews.model.mAusencia
import io.reactivex.Completable
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface rAusencia {
    @GET("entity.ausencias/{ausenciaid}")
    fun getAusencia(@Path("ausenciaid") ausenciaid :  Int): Observable<mAusencia>

    @POST("entity.ausencias")
    fun postAusencia(@Body mAusencia: mAusencia): Completable
}