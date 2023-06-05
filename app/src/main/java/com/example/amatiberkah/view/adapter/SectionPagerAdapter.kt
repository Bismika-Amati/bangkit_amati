package com.example.amatiberkah.view.adapter
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.amatiberkah.view.DescriptionFragment
import com.example.amatiberkah.view.MapsFragment
import com.example.amatiberkah.view.ProblemsFragment

class SectionPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
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