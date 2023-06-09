package com.example.amatiberkah.view.explore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.amatiberkah.databinding.ActivityListCourseExploreBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListCourseExploreActivity : AppCompatActivity() {

    lateinit var binding : ActivityListCourseExploreBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListCourseExploreBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}