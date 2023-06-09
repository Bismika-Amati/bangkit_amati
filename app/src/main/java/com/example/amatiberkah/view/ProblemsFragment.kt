package com.example.amatiberkah.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.amatiberkah.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ProblemsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProblemsFragment : Fragment() {

    companion object {
        private const val ARG_PROBLEMS1 = "problems1"
        private const val ARG_PROBLEMS2 = "problems2"
        private const val ARG_PROBLEMS3 = "problems3"

        fun newInstance(problems1: String, problems2: String, problems3: String): ProblemsFragment {
            val fragment = ProblemsFragment()
            val args = Bundle()
            args.putString(ARG_PROBLEMS1, problems1)
            args.putString(ARG_PROBLEMS2, problems2)
            args.putString(ARG_PROBLEMS3, problems3)
            fragment.arguments = args
            return fragment
        }
    }

    private var problems1: String? = null
    private var problems2: String? = null
    private var problems3: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            problems1 = it.getString(ARG_PROBLEMS1)
            problems2 = it.getString(ARG_PROBLEMS2)
            problems3 = it.getString(ARG_PROBLEMS3)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val descriptionTextView1: TextView = view.findViewById(R.id.problems_1)
        descriptionTextView1.text = problems1

        val descriptionTextView2: TextView = view.findViewById(R.id.problems_2)
        descriptionTextView2.text = problems2

        val descriptionTextView3: TextView = view.findViewById(R.id.problems_3)
        descriptionTextView3.text = problems3
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_problems, container, false)
    }

}