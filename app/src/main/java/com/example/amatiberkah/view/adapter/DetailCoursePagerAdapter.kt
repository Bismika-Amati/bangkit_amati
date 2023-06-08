package com.example.amatiberkah.view.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.amatiberkah.view.DescriptionFragment
import com.example.amatiberkah.view.MapsFragment
import com.example.amatiberkah.view.ProblemsFragment
import com.example.amatiberkah.view.detail.CourseDescriptionFragment
import com.example.amatiberkah.view.detail.CourseSkillFragment

class DetailCoursePagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    override fun createFragment(position: Int): Fragment {
        var fragment : Fragment? = null;
        fragment = when (position) {
            0 -> CourseDescriptionFragment()
            else -> CourseSkillFragment()
        }
        return fragment
    }

    override fun getItemCount(): Int {
        return 2
    }
}