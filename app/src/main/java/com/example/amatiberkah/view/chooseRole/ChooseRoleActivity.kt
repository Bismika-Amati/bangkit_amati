package com.example.amatiberkah.view.chooseRole

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.amatiberkah.databinding.ActivityChooseRoleBinding
import com.example.amatiberkah.view.register.RegisterActivity

class ChooseRoleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityChooseRoleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChooseRoleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.studentRole.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            intent.putExtra(RegisterActivity.ROLE, "student")
            startActivity(intent)
        }

        binding.picDesaRole.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            intent.putExtra(RegisterActivity.ROLE, "pic village")
            startActivity(intent)
        }


    }
}
