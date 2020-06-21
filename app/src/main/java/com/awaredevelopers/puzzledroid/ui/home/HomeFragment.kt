package com.awaredevelopers.puzzledroid.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProviders
import androidx.room.Room
import com.awaredevelopers.puzzledroid.ui.nPuzzle.NPuzzleActivity
import com.awaredevelopers.puzzledroid.R
import com.awaredevelopers.puzzledroid.db.AppDatabase
import com.awaredevelopers.puzzledroid.db.dao.ScoreDao
import com.awaredevelopers.puzzledroid.db.entity.ScoreEntity

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

        val applicationContext = context!!.getApplicationContext()

        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "database-name"
        ).build()

        db.scoreDao().insertScore(ScoreEntity(10, 1))

        val scores = db.scoreDao().loadAllScores()


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


        root.findViewById<ImageButton>(R.id.predefined).setOnClickListener {
//            Para navegar a los diferentes fragments desde cualquier punto del contenedor.
//            findNavController().navigate(R.id.action_HomeFragment_to_PuzzleFragment)
            val intent = Intent(context, NPuzzleActivity::class.java).apply {
            }
            startActivity(intent)
        }

        root.findViewById<ImageButton>(R.id.camera).setOnClickListener {
            val intent = Intent(context, NPuzzleActivity::class.java).apply {
            }
            startActivity(intent)
        }

        root.findViewById<ImageButton>(R.id.galery).setOnClickListener {

            val intent = Intent(context, NPuzzleActivity::class.java).apply {
            }
            startActivity(intent)
        }

        root.findViewById<ImageButton>(R.id.online).setOnClickListener {
            val intent = Intent(context, NPuzzleActivity::class.java).apply {
            }
            startActivity(intent)
        }
        return root
    }
}
