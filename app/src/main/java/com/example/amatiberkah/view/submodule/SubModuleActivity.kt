
package com.example.amatiberkah.view.submodule

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.amatiberkah.databinding.ActivitySubModuleBinding
import com.example.amatiberkah.model.remote.response.Data
import com.example.amatiberkah.model.remote.response.SubModuleItem
import com.example.amatiberkah.view.adapter.CourseAdapter
import com.example.amatiberkah.view.adapter.SubModuleAdapter
import com.example.amatiberkah.view.detail.DetailCourseActivity
import com.example.amatiberkah.view.detailsub.DetailSubModuleActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SubModuleActivity : AppCompatActivity() {

    lateinit var binding : ActivitySubModuleBinding
    private val subModulViewModel: SubModuleViewModel by viewModels()

    companion object {
        const val EXTRA_COURSE = "extra_course"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubModuleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupSubModule()

        supportActionBar?.hide()

        val layoutManager = LinearLayoutManager(this)
        binding.rvCourse.layoutManager = layoutManager

    }

    private fun setupSubModule(){

        val courseId = intent.getStringExtra(EXTRA_COURSE)

        lifecycleScope.launch {
            subModulViewModel.getToken().collect { tokenUser ->
                if (tokenUser != null && courseId != null) {
                    val accessToken = "Bearer $tokenUser"
                    subModulViewModel.getListSubModule(courseId,accessToken).collect { result ->
                        if (result.isSuccess) {
                            val subModule = result.getOrThrow()
                            setListSubModule(subModule.data?.subModule)
                            Log.d("Error Detail", "detail view : $subModule")
                        } else {
                            showToast("No token attached")
                            Log.d("Error Detail", "detail view : $result")
                        }
                    }
                }
            }
        }
    }

    private fun setListSubModule(listSubModule: List<SubModuleItem>?){
        val adapter = SubModuleAdapter(listSubModule ?: emptyList())
        Log.d("SubModuleAdapter", "listSubModule: $listSubModule")
        binding.rvCourse.adapter = adapter

        adapter.setOnItemClickCallback(object : SubModuleAdapter.OnItemClickCallback {
            override fun onItemClicked(data: SubModuleItem) {
                val intentDetail = Intent(this@SubModuleActivity, DetailSubModuleActivity::class.java)
                intentDetail.putExtra(DetailSubModuleActivity.EXTRA_COURSE, data.id)
                startActivity(intentDetail)
            }
        })
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}