package com.gallopingtech.medicare.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gallopingtech.medicare.data.ktor.medicineRepository
import com.gallopingtech.medicare.model.ProblemsResponse
import kotlinx.coroutines.flow.MutableStateFlow

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class modicinesViewModel(private val repository: medicineRepository) : ViewModel(){
    private val _medState = MutableStateFlow<Result<ProblemsResponse>>(Result.Loading)
    val problemsState: StateFlow<Result<ProblemsResponse>> = _medState


    init {
        fetchMeds()
    }

    private fun fetchMeds() {
        viewModelScope.launch {
            try {
                var response = repository.getMedicines()
                _medState.value = Result.Success(response)



            }catch (e:Exception){
                _medState.value = Result.Error(e.message ?: "Unknown error")

            }
        }
    }
    class MedicinesViewModelFactory(
        private val repository: medicineRepository
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(modicinesViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return modicinesViewModel(repository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }


}