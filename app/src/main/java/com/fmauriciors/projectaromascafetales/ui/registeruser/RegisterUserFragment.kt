package com.fmauriciors.projectaromascafetales.ui.registeruser

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.util.PatternsCompat
import androidx.navigation.fragment.findNavController
import com.fmauriciors.projectaromascafetales.R
import com.fmauriciors.projectaromascafetales.databinding.FragmentRegisterUserBinding
import java.util.regex.Pattern

class RegisterUserFragment : Fragment() {

    private lateinit var registerUserViewModel: RegisterUserViewModel
    private lateinit var registerUserBinding: FragmentRegisterUserBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        context?.theme?.applyStyle(R.style.AppTheme_styleRegister, true)
        registerUserBinding = FragmentRegisterUserBinding.inflate(inflater, container, false)
        registerUserViewModel = ViewModelProvider(this)[RegisterUserViewModel::class.java]
        return registerUserBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        registerUserViewModel.msgDone.observe(viewLifecycleOwner,{ result ->
            onMsgDoneSubscribe(result)
        })
        registerUserViewModel.dataValidated.observe(viewLifecycleOwner, { result ->
            onDataValidatedSubscribe(result)
        })

        with(registerUserBinding) {

            registerUserButton.setOnClickListener {
                registerUserViewModel.validateFields(
                    nameRegisterEditText.text.toString(),
                    phoneRegisterEditText.text.toString(),
                    emailRegisterEditText.text.toString(),
                    passwordRegisterEditText.text.toString(),
                    repasswordRegisterEditText.text.toString()
                )
                //findNavController().navigate(RegisterUserFragmentDirections.actionRegisterUserFragmentToListRegisterFragment())
            }
        }
    }
    private fun onDataValidatedSubscribe(result: Boolean?) {
        with(registerUserBinding) {
            val nameUser = nameRegisterEditText.text.toString()
            val phone = phoneRegisterEditText.text.toString()
            val email = emailRegisterEditText.text.toString()
            val password = passwordRegisterEditText.text.toString()
            //val repassword = repasswordRegisterEditText.text.toString()
            registerUserViewModel.saveRegister(nameUser, phone, email, password)
        }
    }

    private fun onMsgDoneSubscribe(msg: String?) {
        Toast.makeText(
            requireContext(),
            msg,
            Toast.LENGTH_SHORT
        ).show()
    }
}


