package com.awaredevelopers.puzzledroid.ui.scores

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.awaredevelopers.puzzledroid.R
import com.awaredevelopers.puzzledroid.db.entity.ScoreEntity

class ScoresAdapter(private val context: Context) : BaseAdapter() {
    private val inflater: LayoutInflater
            = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    private var dataSource: List<ScoreEntity> = listOf()

    override fun getCount(): Int {
        return dataSource.size
    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // Get view for row item
        val rowView = inflater.inflate(R.layout.list_item_score, parent, false)

        // Get title element
        val timeTextView = rowView.findViewById(R.id.score_time) as TextView
        val levelTextView = rowView.findViewById(R.id.score_level) as TextView
        val nicknameTextView = rowView.findViewById(R.id.score_nickname) as TextView

        val score = getItem(position) as ScoreEntity

        timeTextView.text = score.score.toString()
        levelTextView.text = score.level.toString()
        nicknameTextView.text = score.nickname

        return rowView
    }

    open fun setScores(scores: List<ScoreEntity>) {
        dataSource = scores

        this.notifyDataSetChanged();
    }
}