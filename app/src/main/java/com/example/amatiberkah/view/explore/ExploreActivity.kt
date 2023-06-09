package com.example.amatiberkah.view.explore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.amatiberkah.databinding.ActivityExploreBinding
import com.example.amatiberkah.model.remote.response.*
import com.example.amatiberkah.view.exploreVillageDetail.ExploreVillageDetailActivity
import com.example.amatiberkah.view.adapter.CourseAdapter
import com.example.amatiberkah.view.adapter.VillageAdapter
import com.example.amatiberkah.view.detail.DetailCourseActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


@AndroidEntryPoint
class ExploreActivity : AppCompatActivity() {


    lateinit var binding : ActivityExploreBinding
    private val viewModel: ExploreViewModel by viewModels()
    companion object {
        const val EXTRA_TOKEN = "extra_token"
        const val ROLE = "role"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExploreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupMain()

        supportActionBar?.hide()

        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.courseReview.layoutManager = layoutManager

        val layoutManager2 = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.villageReview.layoutManager = layoutManager2

    }



    private fun setListVillage(listVillage: List<ListVillageResponse>){
        val adapter = VillageAdapter(listVillage) {village ->
            val intent = Intent(this, ExploreVillageDetailActivity::class.java)
            intent.putExtra(ExploreVillageDetailActivity.VILLAGE_ID, village.id)
            startActivity(intent)
        }
        binding.villageReview.adapter = adapter
    }

    private fun setupMain() {
        lifecycleScope.launch {
            viewModel.getToken().collect { tokenUser ->
                if (tokenUser !== null) {
                    val token = "Bearer $tokenUser"
                    viewModel.getAllModule(
                        token
                    ).collectLatest { result ->
                        if (result.isSuccess) {
                            val courseResponse = result.getOrThrow()
                            setListCourse(courseResponse.data)
                        } else {
                            Log.d("ERROR LIST","Home Failed: ${result.exceptionOrNull()?.message}")
                            showToast("Home Failed: ${result.exceptionOrNull()?.message}")
                        }
                    }

                    viewModel.getVillages(
                        token
                    ).collectLatest { result ->
                        if(result.isSuccess) {
                            val villageResponse = result.getOrThrow()
                            Log.d("Data LIST Village","Data: $villageResponse")
                            setListVillage(villageResponse.data)
                        } else {
                            Log.d("ERROR LIST","Home Failed: ${result.exceptionOrNull()?.message}")
                            showToast("Home Failed: ${result.exceptionOrNull()?.message}")
                        }
                    }

                    viewModel.getUserDataEmail().collect {email ->
                        binding.statusBox.text = email
                    }

                    viewModel.getUserDataName().collect {name ->
                        binding.usernameBox.text = name
                    }


                }
            }
        }
    }

    private fun setListCourse(listCourse: List<DataItem>?){
        val adapter = CourseAdapter((listCourse ?: emptyList()))
        Log.d("CourseAdapter", "ListCourse: $listCourse")
        binding.courseReview.adapter = adapter

        adapter.setOnItemClickCallback(object : CourseAdapter.OnItemClickCallback {
            override fun onItemClicked(data: DataItem) {
                val intentDetail = Intent(this@ExploreActivity, DetailCourseActivity::class.java)
                intentDetail.putExtra(DetailCourseActivity.EXTRA_COURSE, data.id)
                startActivity(intentDetail)
            }
        })
    }


    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}