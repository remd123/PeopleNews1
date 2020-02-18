package com.example.peoplenews.consumer

import com.example.peoplenews.remote.IMyAPI
import com.example.peoplenews.remote.RetrofitClient


object Common {
    val BASE_URL="http://630ded24.ngrok.io/REST_New_People/webresources/entity.usuarios"

    val api: IMyAPI
    get() = RetrofitClient.getClient(BASE_URL).create(IMyAPI::class.java)
}