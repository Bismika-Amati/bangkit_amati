package com.example.amatiberkah.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.amatiberkah.R

class AdminActivity : AppCompatActivity() {

    companion object {
        const val ROLE = "role"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)
    }
}