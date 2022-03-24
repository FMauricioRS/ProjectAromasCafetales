package com.fmauriciors.projectaromascafetales.ui.listregisters

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fmauriciors.projectaromascafetales.local.Register
import com.fmauriciors.projectaromascafetales.local.repositorybd.RegisterRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ListRegisterViewModel  : ViewModel() {
    val registerRepository = RegisterRepository()

    private val loadRegisters: MutableLiveData<ArrayList<Register>> = MutableLiveData()
    val loadRegisterDone: LiveData<ArrayList<Register>> = loadRegisters

    fun loadRegisters() {
        GlobalScope.launch(Dispatchers.IO) {
            loadRegisters.postValue(registerRepository.loadRegisters())
        }
    }
}