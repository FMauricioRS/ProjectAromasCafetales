package com.fmauriciors.projectaromascafetales.ui.loginuser

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.fmauriciors.projectaromascafetales.R
import com.fmauriciors.projectaromascafetales.databinding.FragmentListProductsBinding
import com.fmauriciors.projectaromascafetales.databinding.FragmentLoginUserBinding
import com.fmauriciors.projectaromascafetales.ui.listproducts.ListProductsFragmentDirections
import com.fmauriciors.projectaromascafetales.ui.listproducts.ListProductsViewModel
import com.fmauriciors.projectaromascafetales.ui.register.RegisterActivity

class LoginUserFragment : Fragment() {

    companion object {
        fun newInstance() = LoginUserFragment()
    }

    private lateinit var loginUserBinding: FragmentLoginUserBinding
    private lateinit var loginUserViewModel: LoginUserViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        loginUserBinding = FragmentLoginUserBinding.inflate(inflater, container, false)
        loginUserViewModel = ViewModelProvider(this)[LoginUserViewModel::class.java]
        return loginUserBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loginUserBinding.registerTextView.setOnClickListener(){
            findNavController().navigate(LoginUserFragmentDirections.actionLoginUserFragmentToRegisterUserFragment())
        }
        loginUserBinding.signInButton.setOnClickListener(){
            findNavController().navigate(LoginUserFragmentDirections.actionLoginUserFragmentToListProductsFragment())
        }
    }

}