package com.fmauriciors.projectaromascafetales.ui.deleteproduct

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fmauriciors.projectaromascafetales.local.Product
import com.fmauriciors.projectaromascafetales.local.repositorybd.ProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DeleteProductViewModel : ViewModel() {
    val productRepository = ProductRepository()

    private val findProduct: MutableLiveData<Product> = MutableLiveData()
    val findProductDone: LiveData<Product> = findProduct

    fun searchProduct(nameProduct: String) {
        GlobalScope.launch(Dispatchers.IO) {
            findProduct.postValue(productRepository.searchProduct(nameProduct))
        }
    }

    fun deleteProduct(product: Product) {
        GlobalScope.launch(Dispatchers.IO) {
            productRepository.deleteProduct(product)
        }
    }
}