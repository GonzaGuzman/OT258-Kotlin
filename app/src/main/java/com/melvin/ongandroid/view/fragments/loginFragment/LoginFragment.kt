package com.melvin.ongandroid.view.fragments.loginFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.melvin.ongandroid.databinding.FragmentLoginBinding
import com.melvin.ongandroid.util.checkMail
import com.melvin.ongandroid.util.checkPassword
import com.melvin.ongandroid.viewmodel.InputTypeLogIn
import com.melvin.ongandroid.viewmodel.ViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
        }
        initComponent()
        viewModel.statusButtonLogin.observe(viewLifecycleOwner, Observer {
            binding.loginBtn.isEnabled = it
        })
    }

    private fun initComponent(){
        // Checking whether both email input and password input meet the conditions
        binding.etEmailLogin.doOnTextChanged { text, start, before, count ->  viewModel.manageButtonLogin(binding.etEmailLogin.text.toString(), InputTypeLogIn.EMAIL) } // Email
        binding.etPasswordLogin.doOnTextChanged { text, start, before, count ->  viewModel.manageButtonLogin(binding.etPasswordLogin.text.toString(), InputTypeLogIn.PASSWORD) } // Password
    }
}