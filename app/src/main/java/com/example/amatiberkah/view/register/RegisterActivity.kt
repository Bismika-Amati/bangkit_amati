package com.example.amatiberkah.view.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.amatiberkah.databinding.ActivityRegisterBinding
import com.example.amatiberkah.model.remote.response.RegisterDataResponse
import com.example.amatiberkah.model.remote.response.RegisterResponse
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private val viewModel: RegisterViewModel by viewModels()

    companion object {
        const val ROLE = "ROLE"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun setUpViews() {
        binding.apply {
            val registerBtn = btnSignup

            registerBtn.setOnClickListener {
                val fullName = edName.text.toString()
                val email = edEmail.text.toString()
                val password = edPassword.text.toString()
                val phoneNumber = edPhone.text.toString()
                when {
                    fullName.isEmpty() -> {
                        edName.error = "Name is Required"
                    }
                    email.isEmpty() -> {
                        edEmail.error = "Email is Required"
                    }
                    password.isEmpty() -> {
                        edPassword.error = "Password is Required"
                    }
                    phoneNumber.isEmpty() -> {
                        edPhone.error = "Phone Number is Required"
                    }
                    else -> {
                        registerByRole(fullName, email, password, ROLE, phoneNumber)
                    }
                }
            }

        }
    }

    private fun registerByRole(
        fullName: String,
        email: String,
        password: String,
        role: String,
        phoneNumber: String,
        photo: String? = null,
        provinceId: String? = null,
        cityId: String? = null,
        districtId: String? = null,
        subDistrictId: String? = null,
        postcode: String? = null,
        address: String? = null
    ) {
        lifecycleScope.launch {
            try {
                viewModel.registerByRole(
                    fullName,
                    email,
                    password,
                    role,
                    phoneNumber,
                    photo,
                    provinceId,
                    cityId,
                    districtId,
                    subDistrictId,
                    postcode,
                    address
                ).collect { response ->
                    if (response.isSuccess) {
                        showToast("Register Success")
                    } else {
                        showToast("Register Failed: ${response.exceptionOrNull()}")
                    }
                }
            } catch (exception: Throwable) {
                showToast("Register Failed: ${exception.message}")
            }
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this@RegisterActivity, message, Toast.LENGTH_SHORT).show()
    }
}