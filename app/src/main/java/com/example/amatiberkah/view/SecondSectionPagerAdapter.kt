package com.example.amatiberkah.view

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class SecondSectionPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    override fun createFragment(position: Int): Fragment {
        var fragment : Fragment? = null;
        fragment = when (position) {
            0 -> DescriptionFragment()
            1 -> ProblemsFragment()
            else -> MapsFragment()
        }
        return fragment
    }

    override fun getItemCount(): Int {
        return 3
    }
}