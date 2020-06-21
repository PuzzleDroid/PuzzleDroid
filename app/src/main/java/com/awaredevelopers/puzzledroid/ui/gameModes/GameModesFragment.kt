package com.awaredevelopers.puzzledroid.ui.gameModes

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.ui.navigateUp
import com.awaredevelopers.puzzledroid.R
import com.awaredevelopers.puzzledroid.ui.home.HomeViewModel
import com.awaredevelopers.puzzledroid.ui.nPuzzle.NPuzzleActivity

class GameModesFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_gamemodes, container, false)

        root.findViewById<TextView>(R.id.textViewMode1).setOnClickListener {
            startNPuzzleActivityGameMode(1)
        }

        root.findViewById<TextView>(R.id.textViewMode2).setOnClickListener {
            startNPuzzleActivityGameMode(2)
        }

        root.findViewById<TextView>(R.id.textViewMode3).setOnClickListener {
            startNPuzzleActivityGameMode(3)
        }

        root.findViewById<TextView>(R.id.textViewMode4).setOnClickListener {
            startNPuzzleActivityGameMode(4)
        }
        return root
    }
    private fun startNPuzzleActivityGameMode(gameModeValue: Int) {
        val intent = Intent(context, NPuzzleActivity::class.java)
        val b = Bundle()
        b.putInt("GameModeKey", gameModeValue)
        intent.putExtras(b)
        startActivity(intent)
    }
}
