package com.example.amatiberkah.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.amatiberkah.R

class ExploreActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_TOKEN = "extra_token"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_explore)


    }
}