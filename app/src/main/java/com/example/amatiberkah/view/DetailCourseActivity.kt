package com.example.amatiberkah.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.amatiberkah.R
import com.example.amatiberkah.databinding.ActivityDetailCourseBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class DetailCourseActivity : AppCompatActivity() {

    lateinit var binding : ActivityDetailCourseBinding

    companion object {
        @Suppress
        private val TAB_TITLES = intArrayOf(
            R.string.tab_text_1_course,
            R.string.tab_text_2_course,
            R.string.tab_text_3_course
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailCourseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sectionPagerAdapter = SectionPagerAdapter(this)
        val viewPager: ViewPager2 = binding.courseViewPager
        viewPager.adapter = sectionPagerAdapter
        val tabs: TabLayout = binding.tabs
        TabLayoutMediator(tabs, viewPager) {tab, position ->
            tab.text = resources.getString(DetailCourseActivity.TAB_TITLES[position])
        }.attach()
    }
}