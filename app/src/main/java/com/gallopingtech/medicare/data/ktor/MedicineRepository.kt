package com.gallopingtech.medicare.data.ktor

import com.gallopingtech.medicare.model.ProblemsResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse

data class medicineRepository(private val client: HttpClient){
    suspend fun  getMedicines(): ProblemsResponse {
        return client.get("https://run.mocky.io/v3/e8af3ab6-dbd3-4fb1-97a9-dbbcee3cb96e").body()
    }
}



