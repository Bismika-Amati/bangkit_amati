package com.example.amatiberkah.view.detailsub

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.example.amatiberkah.R
import com.example.amatiberkah.databinding.ActivityDetailSubModuleBinding
import com.example.amatiberkah.databinding.ActivityExploreBinding
import com.example.amatiberkah.model.remote.response.ArticleSubModuleItem
import com.example.amatiberkah.model.remote.response.Data
import com.example.amatiberkah.view.detail.DetailCourseActivity
import com.example.amatiberkah.view.explore.ExploreActivity
import com.example.amatiberkah.view.explore.ExploreViewModel
import com.example.amatiberkah.view.submodule.SubModuleActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailSubModuleActivity : AppCompatActivity() {


    lateinit var binding : ActivityDetailSubModuleBinding
    private val detailSubModuleViewModel: DetailSubModuleViewModel by viewModels()
    companion object {
        const val EXTRA_COURSE = "extra_course"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailSubModuleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupDetailSubModule()
    }

    private fun setupDetailSubModule(){

        val subModulId = intent.getStringExtra(SubModuleActivity.EXTRA_COURSE)



        lifecycleScope.launch {
            detailSubModuleViewModel.getToken().collect { tokenUser ->
                if (tokenUser != null && subModulId != null) {
                    val accessToken = "Bearer $tokenUser"
                    detailSubModuleViewModel.getDetailSubModule(subModulId, accessToken).collect { result ->
                        if (result.isSuccess) {
                            val courseDetail = result.getOrThrow()
                            setCourseDetail(courseDetail.data.articleSubModule[0])
                        } else {
                            Log.d("Error Detail", "detail view : $result")
                            val intent = Intent(this@DetailSubModuleActivity, ExploreActivity::class.java)
                            startActivity(intent)
                        }
                    }
                    detailSubModuleViewModel.getUserId().collect{ userId ->
                        binding.buttonDone.setOnClickListener {
                            doneModules(userId ?: "Opo ae wes", subModulId, accessToken)
                        }
                    }

                }
            }
        }
    }

    private fun doneModules(userId: String, subModuleId: String, accessToken: String) {
        lifecycleScope.launch {
            try {
                detailSubModuleViewModel.doneModules(userId, subModuleId, accessToken).collect {result ->
                    if(result.isSuccess) {
                    showToast("BERHASIL BRUHHH")
                    } else {
                        Log.d("Error Detail", "detail view : $result")
                        showToast("Detail Failed: $accessToken")
                    }
                }
            } catch (e: Exception) {
                showToast("Login Failed: ${e.message}")
            }
        }
    }

    private fun setCourseDetail(subModulDetail: ArticleSubModuleItem) {
        Glide.with(this).load(subModulDetail.picture).into(binding.vvCourse)
        binding.tvCourseTitle1.text = subModulDetail.title
        binding.tvCourseContent1.text = subModulDetail.description
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}