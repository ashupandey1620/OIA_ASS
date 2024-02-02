package com.ashutosh.openinapp.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ashutosh.openinapp.API.OIAApi
import com.ashutosh.openinapp.Model.ResponseData
import javax.inject.Inject

class OIARepository @Inject constructor(private val oiaApi : OIAApi) {

    suspend fun getLinkData(accessToken:String): ResponseData? {
        return try {
            val response = oiaApi.getData("Bearer $accessToken")
            response.body()
        } catch (e: Exception) {
            null
        }
    }


}