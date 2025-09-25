package com.example.ecommerkpm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecommerkpm.data.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val _products = MutableStateFlow<List<Product>>(listOf())
    val products = _products.asStateFlow()

    val homeRepository = HomeRepository()
    init {
        viewModelScope.launch {
            homeRepository.getProducts().collect { products ->
                _products.update { it + products }
            }
        }
    }
}