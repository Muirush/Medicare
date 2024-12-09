package com.gallopingtech.medicare.data.retrofit

import com.gallopingtech.medicare.model.ProblemsResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

interface ApiService {

//    https://run.mocky.io/v3/48826389-07cd-498c-bb77-c86ed73c27d2
//        @GET("v3/e8af3ab6-dbd3-4fb1-97a9-dbbcee3cb96e")
        @GET("v3/48826389-07cd-498c-bb77-c86ed73c27d2")

    suspend fun getProblems(): ProblemsResponse
}
val retrofit =Retrofit.Builder()
    .baseUrl("https://run.mocky.io/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

var apiService = retrofit.create(ApiService::class.java)