package com.awaredevelopers.puzzledroid.ui.globalScores

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.awaredevelopers.puzzledroid.R
import com.awaredevelopers.puzzledroid.db.entity.ScoreEntity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.GenericTypeIndicator
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class GlobalScoresFragment : Fragment() {

    private lateinit var scoresModel: GlobalScoresModel


    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val applicationContext = requireContext().getApplicationContext()
        scoresModel =
            ViewModelProviders.of(this).get(GlobalScoresModel::class.java)
        val root = inflater.inflate(R.layout.fragment_scores, container, false)

        val listView = root.findViewById<ListView>(R.id.score_list_view)

        val scoresAdapter = GlobalScoresAdapter(requireContext())

        listView.adapter = scoresAdapter

        val scoresDbRef = Firebase.database.getReference("scores")
            // .orderByChild("score")
            .limitToLast(10)

        scoresDbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val t: GenericTypeIndicator<ScoreEntity> =
                    object : GenericTypeIndicator<ScoreEntity>() {}


                var value: HashMap<String, ScoreEntity> = HashMap()

                for (child in dataSnapshot.children) {
                    val element = child.getValue(t)

                    value.put(child.key!!, element!!)
                }

                value = value.entries.sortedBy {
                    it.value.score
                }.associateBy({ it.key }, { it.value }) as HashMap<String, ScoreEntity>

                value = value.entries.sortedBy {
                    it.value.level
                }.asReversed().associateBy({ it.key }, { it.value }) as HashMap<String, ScoreEntity>

                Log.d("Firebase", "Value is: $value")

                scoresAdapter.setScores(value)
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w("Firebase", "Failed to read value.", error.toException())
            }
        })

        return root
    }
}
