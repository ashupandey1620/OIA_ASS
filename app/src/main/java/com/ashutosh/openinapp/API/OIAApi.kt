package com.ashutosh.openinapp.API

import com.ashutosh.openinapp.Model.ResponseData

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface OIAApi {

    @Headers("Content-Type: application/json")
    @GET("/api/v1/dashboardNew")
    suspend fun getData(
        @Header("Authorization") access: String
    ): Response<ResponseData>

}








