package com.example.peoplenews.request

import com.example.peoplenews.model.NotificacionResult
import com.example.peoplenews.model.mNotificacion
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface rNotifacion {
    @GET("notificacion/{notificacionid}")
    fun getNotificacion(@Path("notificacionid") notificacionid: Int) : Observable<mNotificacion>

    @GET("notificacion")
    fun getNotificaciones() : Observable<ArrayList<mNotificacion>>

}