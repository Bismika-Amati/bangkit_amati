package com.example.amatiberkah.view.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.amatiberkah.databinding.ActivityLoginBinding
import com.example.amatiberkah.view.AdminActivity
import com.example.amatiberkah.view.DetailCourseActivity
import com.example.amatiberkah.view.explore.ExploreActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    lateinit var binding : ActivityLoginBinding
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViews()

    }

    private fun setupViews() {
        binding.apply {
            val loginBtn = btnLogin
            loginBtn.setOnClickListener {
                val email = binding.edtEmail.text.toString()
                val password = binding.edPassword.text.toString()
                when {
                    email.isEmpty() -> {
                        edtEmail.error = "Email is Required"
                    }
                    password.isEmpty() -> {
                        edPassword.error = "Password is Required"
                    }
                    else -> {
                        login(email, password)
                    }
                }
            }
        }
    }

    private fun login(email: String, password: String) {
        lifecycleScope.launch {
            try {
                viewModel.login(email, password).collect {result ->
                    if(result.isSuccess) {
                        val loginResponse = result.getOrThrow().data
                        val role = loginResponse.user.role.name
                        if (role === "student") {
                            navigateActivity(role)
                        } else {
                            navigateActivity(role)
                        }
                    }
                }
            } catch (e: Exception) {
                showToast("Login Failed: ${e.message}")
            }
        }
    }
    private fun showToast(message: String) {
        Toast.makeText(this@LoginActivity, message, Toast.LENGTH_SHORT).show()
    }

    private fun navigateActivity(role: String) {
        when(role) {
            "student" -> {
                val intent = Intent(this@LoginActivity, ExploreActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
            }
            "admin" -> {
                val intent = Intent(this@LoginActivity, AdminActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
            }
        }

    }
}