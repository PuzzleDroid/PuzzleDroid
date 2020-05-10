package com.awaredevelopers.puzzledroid.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
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
                if(currentDate % 2 == 0){
                    textView.text = "otro"
                } else {
                    textView.text = "sdfaosdfnaosdnmvfckasdvfasd"
                }
            }
        })
        return root
    }
}
