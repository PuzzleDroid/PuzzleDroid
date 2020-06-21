package com.awaredevelopers.puzzledroid.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.awaredevelopers.puzzledroid.ui.nPuzzle.NPuzzleActivity
import com.awaredevelopers.puzzledroid.R
import com.awaredevelopers.puzzledroid.ui.gameModes.GameModesFragment
import java.lang.System.exit
import kotlin.system.exitProcess

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        root.findViewById<ImageView>(R.id.start).setOnClickListener {
            findNavController().navigate(R.id.action_HomeFragment_to_GameModesFragment)
        }

        root.findViewById<ImageView>(R.id.score).setOnClickListener {
            findNavController().navigate(R.id.action_HomeFragment_to_ScoresFragment)
        }

        root.findViewById<ImageView>(R.id.exit).setOnClickListener {
            exitProcess(0)
        }
        return root
    }
}
