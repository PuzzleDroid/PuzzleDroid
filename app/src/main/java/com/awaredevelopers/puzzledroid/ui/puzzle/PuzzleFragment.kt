package com.awaredevelopers.puzzledroid.ui.puzzle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.awaredevelopers.puzzledroid.R
import com.awaredevelopers.puzzledroid.ui.gallery.PuzzleViewModel

class PuzzleFragment : Fragment() {

    private lateinit var puzzleViewModel: PuzzleViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        puzzleViewModel =
                ViewModelProviders.of(this).get(PuzzleViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_gallery, container, false)
        val textView: TextView = root.findViewById(R.id.text_gallery)
        puzzleViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}
