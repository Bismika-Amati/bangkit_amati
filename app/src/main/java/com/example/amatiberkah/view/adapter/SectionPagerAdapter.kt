package com.example.amatiberkah.view.adapter
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.amatiberkah.view.DescriptionFragment
import com.example.amatiberkah.view.MapsFragment
import com.example.amatiberkah.view.ProblemsFragment

class SectionPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    private var description: String? = null
    private var problems1: String? = null
    private var problems2: String? = null
    private var problems3: String? = null
    private var location: String? = null

    fun setData(description: String, problems1: String, problems2: String, problems3: String, location: String) {
        this.description = description
        this.problems1 = problems1
        this.problems2 = problems2
        this.problems3 = problems3
        this.location = location
    }

    override fun createFragment(position: Int): Fragment {
        var fragment : Fragment? = null;
        fragment = when (position) {
            0 -> DescriptionFragment.newInstance(description ?: "apa aja")
            1 -> ProblemsFragment.newInstance(problems1 ?: "apa aja", problems2 ?: "apa aja", problems3 ?: "apa aja")
            else -> MapsFragment.newInstance(location ?: "apa aja")
        }
        return fragment
    }

    override fun getItemCount(): Int {
        return 3
    }
}