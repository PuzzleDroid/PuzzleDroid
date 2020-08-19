package com.awaredevelopers.puzzledroid.ui.scores

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.lifecycleScope
import com.awaredevelopers.puzzledroid.R
import com.awaredevelopers.puzzledroid.db.AppDatabase
import com.awaredevelopers.puzzledroid.db.entity.ScoreEntity
import kotlinx.coroutines.launch

class ScoresFragment : Fragment() {

    private lateinit var scoresModel: ScoresModel

    fun loadScores() : LiveData<List<ScoreEntity>> {
        val applicationContext = requireContext().getApplicationContext()

        val db = AppDatabase.getInstance(applicationContext)

        return db.scoreDao().loadLiveScores()
    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        scoresModel =
                ViewModelProviders.of(this).get(ScoresModel::class.java)
        val root = inflater.inflate(R.layout.fragment_scores, container, false)

        val listView = root.findViewById<ListView>(R.id.score_list_view)

        val scoresAdapter = ScoresAdapter(requireContext())

        listView.adapter = scoresAdapter

        viewLifecycleOwner.lifecycleScope.launch {
            loadScores().observe(viewLifecycleOwner, Observer {
                scoresAdapter.setScores(it)
            })
        }

        return root
    }
}
