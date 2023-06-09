package com.example.amatiberkah.view.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.amatiberkah.R
import com.example.amatiberkah.view.DescriptionFragment
import com.example.amatiberkah.view.MapsFragment
class CourseDescriptionFragment : Fragment() {

    companion object {
        private const val ARG_DESCRIPTION = "description"
        fun newInstance(description: String): CourseDescriptionFragment {
            val fragment = CourseDescriptionFragment()
            val args = Bundle()
            args.putString(ARG_DESCRIPTION, description)
            fragment.arguments = args
            return fragment
        }
    }


    private var description: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            description = it.getString(ARG_DESCRIPTION)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val descriptionTextView: TextView = view.findViewById(R.id.courseDescription)
        descriptionTextView.text = description
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_course_description, container, false)

    }




}
