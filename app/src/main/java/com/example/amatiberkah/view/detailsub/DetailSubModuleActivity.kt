package com.example.amatiberkah.view.detailsub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.amatiberkah.R

class DetailSubModuleActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_COURSE = "extra_course"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_sub_module)
    }
}