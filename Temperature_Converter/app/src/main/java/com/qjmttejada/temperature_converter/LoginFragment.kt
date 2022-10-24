package com.qjmttejada.temperature_converter

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.findFragment
import androidx.navigation.findNavController
import com.qjmttejada.temperature_converter.databinding.FragmentLoginBinding


class LoginFragment :Fragment(){

    lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        super.onCreate(savedInstanceState)
        binding = FragmentLoginBinding.inflate(layoutInflater)
        binding.btnLogin.setOnClickListener { view : View ->
            val username = binding.inputUsername
            val password = binding.inputPassword

            val userResult = checkUsername() // Gets the result of the login
            val passResult = checkPassword() // Get the result of the login

            when {
                TextUtils.isEmpty(username.text.toString().trim()) ->{
                    username.error = "Required field is empty"
                }
                TextUtils.isEmpty(password.text.toString().trim()) ->{
                    password.error = "Required field is empty"
                }
                else ->{
                    if (userResult && passResult){
                        view.findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
                        Toast.makeText(activity, "Welcome Michael Tejada!", Toast.LENGTH_SHORT).show()
                        clearUserPass()
                    }
                    else {
                        Toast.makeText(activity, "Invalid Credentials!", Toast.LENGTH_SHORT).show()
                        clearUserPass()
                    }
                }
            }
        }

        return binding.root
    }

    private fun checkUsername(): Boolean { // Check if the Username is correct
        val username = binding.inputUsername.text.toString()
        return (username == "qjmttejada")
    }

    private fun checkPassword(): Boolean {  // Check if the Password is correct
        val password = binding.inputPassword.text.toString()
        return (password == "password")
    }

    private fun clearUserPass(){ // Clears the inputs
        binding.inputUsername.setText("")
        binding.inputPassword.setText("")
    }

}