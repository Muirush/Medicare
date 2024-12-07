package com.gallopingtech.medicare.data.retrofit

import com.gallopingtech.medicare.model.ProblemsResponse
import retrofit2.http.GET

interface ApiService {
        @GET("https://run.mocky.io/v3/e8af3ab6-dbd3-4fb1-97a9-dbbcee3cb96e")

    suspend fun getProblems(): ProblemsResponse
}