package com.example.amatiberkah.view.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.amatiberkah.R
import com.example.amatiberkah.databinding.ActivityLoginBinding
import com.example.amatiberkah.databinding.ActivityMainBinding
import com.example.amatiberkah.view.ExploreActivity
import com.example.amatiberkah.view.ViewModelFactory
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {

    lateinit var binding : ActivityLoginBinding
    private val loginViewModel by viewModels<LoginViewModel> {
        ViewModelFactory.getInstance(application)
    }
    private lateinit var tokenUser: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupLoginAdmin()
        setupLoginStudent()
    }

    private fun setupLoginStudent() {
        binding.apply {
            buttonLogin.setOnClickListener {
                if (!edLoginEmail.error.isNullOrEmpty() || !edLoginPassword.error.isNullOrEmpty()) {
                    when {
                        !edLoginEmail.error.isNullOrEmpty() -> showToast(edLoginEmail.error.toString())
                        !edLoginPassword.error.isNullOrEmpty() -> showToast(edLoginPassword.error.toString())
                    }
                } else {
                    loginViewModel.apply {
                        loginStudent(
                            binding.edLoginEmail.text.toString(),
                            binding.edLoginPassword.text.toString()
                        ).also {
                            token.observe(this@LoginActivity) { tokenUser = it }
                            isLoggedIn.observe(this@LoginActivity) {
                                if (it) {
                                    Log.d("LoginActivity", "login worked")
                                    showToast("Login Succeed")
                                    navigateToken(tokenUser)
                                }
                            }
                            error.observe(this@LoginActivity) {
                                if (!it.isNullOrEmpty()) showToast(
                                    it
                                )
                            }
                        }
                    }
                }
            }
        }
    }

    private fun setupLoginAdmin() {
        binding.apply {
            buttonLogin.setOnClickListener {
                if (!edLoginEmail.error.isNullOrEmpty() || !edLoginPassword.error.isNullOrEmpty()) {
                    when {
                        !edLoginEmail.error.isNullOrEmpty() -> showToast(edLoginEmail.error.toString())
                        !edLoginPassword.error.isNullOrEmpty() -> showToast(edLoginPassword.error.toString())
                    }
                } else {
                    loginViewModel.apply {
                        loginAdmin(
                            binding.edLoginEmail.text.toString(),
                            binding.edLoginPassword.text.toString()
                        ).also {
                            token.observe(this@LoginActivity) { tokenUser = it }
                            isLoggedIn.observe(this@LoginActivity) {
                                if (it) {
                                    Log.d("LoginActivity", "login worked")
                                    showToast("Login Succeed")
                                    navigateToken(tokenUser)
                                }
                            }
                            error.observe(this@LoginActivity) {
                                if (!it.isNullOrEmpty()) showToast(
                                    it
                                )
                            }
                        }
                    }
                }
            }
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this@LoginActivity, message, Toast.LENGTH_SHORT).show()
    }

    private fun navigateToken(token: String) {
        Intent(this@LoginActivity, ExploreActivity::class.java).also {
            it.putExtra(ExploreActivity.EXTRA_TOKEN, token)
            startActivity(it)
            finish()
        }
    }
}