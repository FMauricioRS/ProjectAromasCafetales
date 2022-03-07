package com.fmauriciors.projectaromascafetales.ui.registeruser

import android.provider.ContactsContract
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.util.PatternsCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.fmauriciors.projectaromascafetales.databinding.FragmentRegisterUserBinding
import com.fmauriciors.projectaromascafetales.ui.repositorybd.ProductRepository
import com.fmauriciors.projectaromascafetales.ui.repositorybd.RegisterRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.regex.Pattern

class RegisterUserViewModel : ViewModel() {

    private val registerRepository = RegisterRepository()
    private lateinit var registerUserBinding: FragmentRegisterUserBinding
    private val msg: MutableLiveData<String> = MutableLiveData()
    val msgDone: LiveData<String> = msg

    private val dataValidate: MutableLiveData<Boolean> = MutableLiveData()
    val dataValidated: LiveData<Boolean> = dataValidate

    fun validateFields(nameRegister: String, phoneRegister: String, emailRegister: String, passwordRegister: String, repasswordRegister: String) {

        if(nameRegister.isEmpty()  || phoneRegister.isEmpty() == true ||
            emailRegister.isEmpty()  || passwordRegister.isEmpty() ||
            repasswordRegister.isEmpty()){
            msg.value = "Verifique que los campos Nombre, Teléfono, Email, Contraseña y Verificación de la contraseña estén completos"
        }else{
            validated()
            if (validatedEmail() && validatedPassword()){
                val nameUser: String = nameRegister.toString()
                val numberPhone: String = phoneRegister.toString()
                val email: String = emailRegister.toString()
                val password: String = passwordRegister.toString()
                val rePassword: String = repasswordRegister.toString()

                if (password == rePassword) {
                    /*val user = User (
                        nameUser = nameUser,
                        //gender = gender,
                        numberPhone = numberPhone,
                        email = email,
                        password = password
                    )
                    findNavController().navigate(RegisterUserFragmentDirections.actionRegisterUserFragmentToLoginUserFragment())*/
                }else {

                    msg.value = "Las contraseñas no coinciden"
                }
            }else {

                msg.value = "Verifique correo y contraseña"
            }
            dataValidate.value = true

        }


    }

    fun saveRegister(
        nameUser: String,
        phone: String,
        email: String,
        password: String
    ) {
        GlobalScope.launch(Dispatchers.IO){
           registerRepository.saveRegister(nameUser, phone, email,password)
        }
    }


    private fun validated(){
        val result = arrayOf(validatedEmail(), validatedPassword())
        if (false in result){
            return
        }
    }

    private fun validatedEmail() : Boolean {
        val email = registerUserBinding.emailRegisterEditText?.text.toString()
        return if (!PatternsCompat.EMAIL_ADDRESS.matcher(email).matches()) {
            registerUserBinding.emailRegisterEditText.error = "Ingrese un correo válido"
            false
        } else{
            registerUserBinding.emailRegisterEditText.error = null
            true
        }
    }

    private fun validatedPassword() : Boolean {
        val password = registerUserBinding.passwordRegisterEditText?.text.toString()
        val passwordRegex = Pattern.compile(
            "^(.{6,})$"
        )
        return if (!passwordRegex.matcher(password).matches()) {
            registerUserBinding.passwordRegisterEditText.error = "La contraseña debe ser mayor a 6 caracteres"
            false
        }else{
            registerUserBinding.passwordRegisterEditText.error = null
            true
        }
    }
}