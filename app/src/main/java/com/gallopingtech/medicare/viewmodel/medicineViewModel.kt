package com.gallopingtech.medicare.viewmodel

import com.gallopingtech.medicare.model.ProblemsResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gallopingtech.medicare.data.retrofit.apiService

class medicineViewModel : ViewModel(){
    private val _medicationData = MutableStateFlow<ProblemsResponse?>(null)
    val ProblemsResponse: StateFlow<ProblemsResponse?> = _medicationData

    init {
        fetchMedications()
    }

    private fun fetchMedications() {
        viewModelScope.launch {
            val result = apiService.getProblems()  // Assuming Retrofit call here
            _medicationData.value = result
        }
    }
}