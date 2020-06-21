package com.awaredevelopers.puzzledroid.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.awaredevelopers.puzzledroid.db.entity.ScoreEntity
import java.util.List

@Dao
interface ScoreDao {
    @Query("Select * FROM scores")
    fun loadAllScores(): LiveData<List<ScoreEntity>>

    @Insert
    fun insertScore(score: ScoreEntity)

    // @Insert
    // fun insertAll(scores: List<ScoreEntity>)
}