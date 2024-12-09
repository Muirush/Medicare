package com.gallopingtech.medicare.viewmodel

import com.gallopingtech.medicare.model.ProblemsResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gallopingtech.medicare.data.retrofit.apiService
import kotlin.Result

class medicineViewModel : ViewModel(){
    private val _medicationData = MutableStateFlow<com.gallopingtech.medicare.viewmodel.Result<ProblemsResponse?>>(com.gallopingtech.medicare.viewmodel.Result.Loading)
    val ProblemsResponse: StateFlow<com.gallopingtech.medicare.viewmodel.Result<ProblemsResponse?>> = _medicationData

    init {
        fetchMedications()
    }

    private fun fetchMedications() {
        viewModelScope.launch {
            try {
                val result = apiService.getProblems()
                _medicationData.value = com.gallopingtech.medicare.viewmodel.Result.Success(result)

            }catch (e:Exception){
                val result = apiService.getProblems()
                _medicationData.value = com.gallopingtech.medicare.viewmodel.Result.Error(result.toString())

            }

        }


    }
}