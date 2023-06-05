package com.example.amatiberkah.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.amatiberkah.R
import com.example.amatiberkah.databinding.ActivityExploreBinding

class ExploreActivity : AppCompatActivity() {


    lateinit var binding : ActivityExploreBinding
    companion object {
        const val EXTRA_TOKEN = "extra_token"
        const val ROLE = "role"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExploreBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}