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
        private const val ARG_PROBLEMS = "problems"

        fun newInstance(problems: String): ProblemsFragment {
            val fragment = ProblemsFragment()
            val args = Bundle()
            args.putString(ARG_PROBLEMS, problems)
            fragment.arguments = args
            return fragment
        }
    }

    private var problems: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            problems = it.getString(ARG_PROBLEMS)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val descriptionTextView: TextView = view.findViewById(R.id.problems)
        descriptionTextView.text = problems
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_problems, container, false)
    }

}