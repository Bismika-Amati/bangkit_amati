package com.example.amatiberkah.view.explore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.amatiberkah.R
import com.example.amatiberkah.databinding.ActivityExploreBinding
import com.example.amatiberkah.model.remote.response.*
import com.example.amatiberkah.view.adapter.CourseAdapter
import com.example.amatiberkah.view.adapter.VillageAdapter
import com.example.amatiberkah.view.login.LoginViewModel
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

        val layoutManager = LinearLayoutManager(this)
        binding.courseReview.layoutManager = layoutManager
        val itemDecoration = DividerItemDecoration(this, layoutManager.orientation)
        binding.courseReview.addItemDecoration(itemDecoration)

        val spanCount = 2
        val layoutManager2 = GridLayoutManager(this, spanCount, LinearLayoutManager.HORIZONTAL, false)
        binding.villageReview.layoutManager = layoutManager2

    }



    private fun setListVillage(listVillage: List<ListVillageResponse>){
        val adapter = VillageAdapter(listVillage) {

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

                    viewModel.getUserDataEmail().collect {email ->
                        binding.statusBox.text = email
                    }

                    viewModel.getUserDataName().collect {name ->
                        binding.usernameBox.text = name
                    }

                    viewModel.getVillages(
                        token
                    ).collectLatest { result ->
                        if(result.isSuccess) {
                            val villageResponse = result.getOrThrow()
                            setListVillage(villageResponse.data)
                        } else {
                            Log.d("ERROR LIST","Home Failed: ${result.exceptionOrNull()?.message}")
                            showToast("Home Failed: ${result.exceptionOrNull()?.message}")
                        }
                    }
                }
            }
        }
    }

    private fun setListCourse(listCourse: List<DataItem>?){
        val adapter = CourseAdapter((listCourse ?: emptyList()))
        Log.d("CourseAdapter", "ListCourse: $listCourse")
        binding.courseReview.adapter = adapter
    }


    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}