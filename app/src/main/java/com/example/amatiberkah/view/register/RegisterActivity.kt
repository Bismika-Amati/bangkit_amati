package com.example.amatiberkah.view.register

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.amatiberkah.databinding.ActivityRegisterBinding
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
            val registerBtn = buttonRegister

            registerBtn.setOnClickListener {
                val fullName = editTextName.text.toString()
                val email = editTextEmail.text.toString()
                val password = editTextPassword.text.toString()
                val phoneNumber = editTextPhoneNumber.text.toString()
                when {
                    fullName.isEmpty() -> {
                        editTextName.error = "Name is Required"
                    }
                    email.isEmpty() -> {
                        editTextEmail.error = "Email is Required"
                    }
                    password.isEmpty() -> {
                        editTextPassword.error = "Password is Required"
                    }
                    phoneNumber.isEmpty() -> {
                        editTextPhoneNumber.error = "Phone Number is Required"
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