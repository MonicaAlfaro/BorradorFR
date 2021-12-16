package com.example.bogotravel.ui.login


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController

import com.example.bogotravel.databinding.LoginFragmentBinding
import com.example.bogotravel.utils.isEmailValid

class LoginFragment : Fragment() {


    private lateinit var loginViewModel: LoginViewModel
    private lateinit var loginBiding: LoginFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        loginBiding = LoginFragmentBinding.inflate(inflater, container, false)
        loginViewModel = ViewModelProvider(this)[LoginViewModel::class.java]
        loginViewModel.onUserLoggedIn.observe(viewLifecycleOwner,{ result ->
            onUserLoggedInSubscribe(result)

        })

        return loginBiding.root

    }

    private fun onUserLoggedInSubscribe(result: Boolean?) {
        result?.let { isLoggedIn ->
            if(isLoggedIn){
              findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToNavigationList())
            }else
                Toast.makeText(context,"Error en el inicio de sesión", Toast.LENGTH_SHORT).show()

        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(loginBiding){
            loginButton.setOnClickListener{
                val email = emailEditText.text.toString()
                val password = passwordEditText.text.toString()

                if (email.isEmpty() || password.isEmpty())
                    Toast.makeText(context,"Debe digitar correo y contraseña", Toast.LENGTH_SHORT).show()
                else
                    if (!isEmailValid(email))
                        Toast.makeText(context,"El correo está mal formateado", Toast.LENGTH_SHORT).show()
                   else
                    loginViewModel.login(email,password)
            }
            registerTextView.setOnClickListener{
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToRegisterFragment())
            }

        }
    }
}


