package com.example.amatiberkah.view.detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.example.amatiberkah.R
import com.example.amatiberkah.databinding.ActivityDetailCourseBinding
import com.example.amatiberkah.model.remote.response.Data
import com.example.amatiberkah.model.remote.response.DataItem
import com.example.amatiberkah.view.adapter.DetailCoursePagerAdapter
import com.example.amatiberkah.view.adapter.SectionPagerAdapter
import com.example.amatiberkah.view.submodule.SubModuleActivity
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailCourseActivity : AppCompatActivity() {

    lateinit var binding : ActivityDetailCourseBinding
    private val detailCourseViewModel : DetailCourseViewModel by viewModels()

    companion object {
        @Suppress
        private val TAB_TITLES = intArrayOf(
            R.string.tab_text_1_course,
            R.string.tab_text_2_course,
        )

        const val EXTRA_COURSE = "extra_course"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailCourseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupDetail()

        val sectionPagerAdapter = DetailCoursePagerAdapter(this)
        val viewPager: ViewPager2 = binding.courseViewPager
        viewPager.adapter = sectionPagerAdapter
        val tabs: TabLayout = binding.tabs
        TabLayoutMediator(tabs, viewPager) {tab, position ->
            tab.text = resources.getString(TAB_TITLES[position])
        }.attach()
    }

    private fun setupDetail(){

        val courseId = intent.getStringExtra(EXTRA_COURSE)

        lifecycleScope.launch {
            detailCourseViewModel.getToken().collect { tokenUser ->
                if (tokenUser !== null && courseId !== null) {
                    val accessToken = "Bearer $tokenUser"
                    detailCourseViewModel.getCourseDetail(courseId, accessToken).collect { result ->
                        if (result.isSuccess) {
                            val courseDetail = result.getOrThrow()
                            setCourseDetail(courseDetail.data)
                        } else {
                            showToast("No token attached")
                            Log.d("Error Detail", "detail view : $result")
                        }
                    }
                }
            }
        }
    }

    private fun setCourseDetail(courseDetail: Data?) {
        Glide.with(this).load(courseDetail?.photo).into(binding.courseImage)
        binding.courseTitle.text = courseDetail?.title
        binding.courseHours.text = courseDetail?.estimateCompleated.toString()
        binding.coursePrice.text = courseDetail?.amount.toString()
        binding.startButton.setOnClickListener {
            val intent = Intent(this@DetailCourseActivity, SubModuleActivity::class.java)
            startActivity(intent)
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}