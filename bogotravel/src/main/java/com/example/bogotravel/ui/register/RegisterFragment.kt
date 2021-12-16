package com.example.bogotravel.ui.register

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.bogotravel.R
import com.example.bogotravel.databinding.RegisterFragmentBinding
import com.example.bogotravel.ui.login.LoginViewModel

class RegisterFragment : Fragment() {


    private lateinit var registerViewModel: RegisterViewModel
    private lateinit var registerBiding: RegisterFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        registerBiding = RegisterFragmentBinding.inflate(inflater, container, false)
        registerViewModel = ViewModelProvider(this)[RegisterViewModel::class.java]

        registerViewModel.onUserCreated.observe(viewLifecycleOwner, { result ->
            onUserCreatedSubscribe(result)

        })

        return registerBiding.root
    }

    private fun onUserCreatedSubscribe(result: Boolean?) {
        result?.let { isRegister ->
            if (isRegister){
                Toast.makeText(context, "Registro existoso", Toast.LENGTH_SHORT).show()
            findNavController().navigate(RegisterFragmentDirections.actionRegisterFragmentToLoginFragment())
            } else
            Toast.makeText(context, "Registro exitoso", Toast.LENGTH_SHORT).show()
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(registerBiding) {
            registerButton.setOnClickListener {
                val email = emailEditText.text.toString()
                val username = usernameEditText.text.toString()
                val password = passwordEditText.text.toString()

                registerViewModel.register(email, password)

            }
        }
    }
}


