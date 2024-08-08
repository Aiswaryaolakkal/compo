package com.example.wom.conversion

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.wom.data.ConversionRepository
import javax.inject.Inject

class ConverterViewModelFactory @Inject constructor(private val repository: ConversionRepository) :NewInstanceFactory(){
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T = ConverterViewModel(repository) as T

}