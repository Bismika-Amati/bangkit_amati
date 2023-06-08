package com.example.amatiberkah.view.exploreVillageDetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.example.amatiberkah.R
import com.example.amatiberkah.databinding.ActivityExploreVillageDetailBinding
import com.example.amatiberkah.model.remote.response.ListVillageResponse
import com.example.amatiberkah.model.remote.response.ListVillageResponseDetail
import com.example.amatiberkah.view.adapter.SectionPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ExploreVillageDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityExploreVillageDetailBinding
    private val viewModel: ExploreVillageDetailViewModel by viewModels()

    companion object {
        @Suppress
        private val TAB_TITLES = intArrayOf(
            R.string.tab_text_1,
            R.string.tab_text_2,
            R.string.tab_text_3
        )
        const val VILLAGE_ID = "VILLAGE_ID"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExploreVillageDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val villageId = intent.getStringExtra(VILLAGE_ID)
        observeVillageDetail(villageId)

    }


    private fun observeVillageDetail(villageId: String?) {
        lifecycleScope.launch {
            viewModel.getToken().collect { token ->
                if (token != null && villageId != null) {
                    val jwt = "Bearer $token"
                    viewModel.getVillagesDetail(villageId, jwt).collect { result ->
                        if (result.isSuccess) {
                            val villageDetail = result.getOrThrow()
                            val description = villageDetail.data.description
                            val problems = villageDetail.data.problemStatement[0].description
                            val location = villageDetail.data.address
                            val sectionPagerAdapter = SectionPagerAdapter(this@ExploreVillageDetailActivity)
                            val viewPager: ViewPager2 = findViewById(R.id.view_pager)
                            viewPager.adapter = sectionPagerAdapter
                            val tabs: TabLayout = findViewById(R.id.tabs)
                            TabLayoutMediator(tabs, viewPager) {tab, position ->
                                tab.text = resources.getString(TAB_TITLES[position])
                            }.attach()
                            sectionPagerAdapter.setData(description, problems, location)
                            setVillageDetail(villageDetail.data)

                        } else {
                            val errorMessage = result.exceptionOrNull()?.message
                            showToast("Detail Failed: $errorMessage")
                        }
                    }
                }
            }
        }
    }

    private fun setVillageDetail(villageDetail: ListVillageResponseDetail?) {
        if (villageDetail != null) {
            Glide.with(this)
                .load(villageDetail.villagePicture[0].photo)
                .into(binding.imageView)
            binding.textTitle.text = villageDetail.name
            binding.address.text = villageDetail.address
        } else {
            showToast("Story detail is null")
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}