package com.fmauriciors.projectaromascafetales.ui.listproducts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fmauriciors.projectaromascafetales.local.Product
import com.fmauriciors.projectaromascafetales.local.repositorybd.ProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ListProductsViewModel : ViewModel() {
    val productRepository = ProductRepository()

    private val loadProducts: MutableLiveData<ArrayList<Product>> = MutableLiveData()
    val loadProductDone: LiveData<ArrayList<Product>> = loadProducts

    fun loadProducts(){
        GlobalScope.launch(Dispatchers.IO){
            loadProducts.postValue( productRepository.loadProducts())
        }
    }
}