package com.awaredevelopers.puzzledroid.ui.home

import kotlinx.coroutines.*

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.room.Room
import com.awaredevelopers.puzzledroid.ui.nPuzzle.NPuzzleActivity
import com.awaredevelopers.puzzledroid.R
import com.awaredevelopers.puzzledroid.ui.gameModes.GameModesFragment
import java.lang.System.exit
import kotlin.system.exitProcess
import com.awaredevelopers.puzzledroid.db.AppDatabase
import com.awaredevelopers.puzzledroid.db.dao.ScoreDao
import com.awaredevelopers.puzzledroid.db.entity.ScoreEntity

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var scoreList: List<ScoreEntity>

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        /*val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it

            //TODO quitar el click listener...
            textView.setOnClickListener{
                val sdf = SimpleDateFormat("ss")
                val currentDate = Integer.parseInt(sdf.format(Date()))
                println(" C DATE is  $currentDate")
                if( textView.text != "Pinto un texto"){
                    textView.text = "Pinto un texto"
                } else {
                    textView.text = "Pinot otro texto!!!!!"
                }*/

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
