package com.awaredevelopers.puzzledroid.ui.gameModes

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.awaredevelopers.puzzledroid.R
import com.awaredevelopers.puzzledroid.ui.home.HomeViewModel
import com.awaredevelopers.puzzledroid.ui.intentActivity.IntentActivity
import com.awaredevelopers.puzzledroid.ui.nPuzzle.NPuzzleActivity

@Suppress("DEPRECATION")
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
            startNPuzzleActivityGameMode(1, NPuzzleActivity::class.java)
        }

        root.findViewById<TextView>(R.id.textViewMode2).setOnClickListener {
            startNPuzzleActivityGameMode(2, IntentActivity::class.java)
        }

        root.findViewById<TextView>(R.id.textViewMode3).setOnClickListener {
            startNPuzzleActivityGameMode(3, IntentActivity::class.java)
        }

        root.findViewById<TextView>(R.id.textViewMode4).setOnClickListener {
            startNPuzzleActivityGameMode(4, IntentActivity::class.java)
        }
        return root
    }
    private fun startNPuzzleActivityGameMode(gameModeValue: Int, activity: Class<*>) {
        val intent = Intent(context, activity)
        val b = Bundle()
        b.putInt("GameModeKey", gameModeValue)
        intent.putExtras(b)

        startActivity(intent)
    }
}
