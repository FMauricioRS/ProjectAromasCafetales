package com.fmauriciors.projectaromascafetales.ui.newproduct

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fmauriciors.projectaromascafetales.local.repositorybd.ProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class NewProductViewModel : ViewModel() {

    private val productRepository = ProductRepository()

    private val msg: MutableLiveData<String> = MutableLiveData()
    val msgDone: LiveData<String> = msg

    private val dataValidate: MutableLiveData<Boolean> = MutableLiveData()
    val dataValidated: LiveData<Boolean> = dataValidate

    fun validateFields(nameProduct: String, cost: String, resumePlantation: String) {

        if(nameProduct.isEmpty() || cost.isEmpty() ||  resumePlantation.isEmpty()){
            msg.value = "Debe digitar nombre, precio, nombre de la finca y realizar una breve descripcion"
        }else{
            dataValidate.value = true
        }
    }

    fun saveProduct(
        nameProduct: String,
        cost: String,
        resumePlantation: String
    ) {
        GlobalScope.launch(Dispatchers.IO){
            productRepository.saveProduct(nameProduct, cost, resumePlantation)
        }
    }
}
