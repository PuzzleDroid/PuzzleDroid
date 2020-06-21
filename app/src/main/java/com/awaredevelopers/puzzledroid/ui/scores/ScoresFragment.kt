package com.awaredevelopers.puzzledroid.ui.scores

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.awaredevelopers.puzzledroid.R

class ScoresFragment : Fragment() {

    private lateinit var scoresModel: ScoresModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        scoresModel =
                ViewModelProviders.of(this).get(ScoresModel::class.java)
        val root = inflater.inflate(R.layout.fragment_scores, container, false)
        val textView: TextView = root.findViewById(R.id.text_scores)
        scoresModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}
