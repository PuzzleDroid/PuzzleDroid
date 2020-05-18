package com.awaredevelopers.puzzledroid.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.awaredevelopers.puzzledroid.ui.NPuzzle.NPuzzleActivity
import com.awaredevelopers.puzzledroid.R
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.util.*

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
        val textView: TextView = root.findViewById(R.id.text_home)
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
                }
            }
        })

        root.findViewById<ImageButton>(R.id.button_puzzle_cities).setOnClickListener {
//            Para navegar a los diferentes fragments desde cualquier punto del contenedor.
//            findNavController().navigate(R.id.action_HomeFragment_to_PuzzleFragment)
            val intent = Intent(activity, NPuzzleActivity::class.java).apply {
//               Para pasar argumentos al Activity
//                putExtra(EXTRA_MESSAGE, message)
            }
            startActivity(intent)
        }
        return root
    }
}
