package com.awaredevelopers.puzzledroid.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.awaredevelopers.puzzledroid.db.entity.ScoreEntity
import kotlin.collections.List

@Dao
interface ScoreDao {
    @Query("Select * FROM scores ORDER BY level DESC, score ASC")
    fun loadLiveScores(): LiveData<List<ScoreEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertScore(score: ScoreEntity) : Long
}