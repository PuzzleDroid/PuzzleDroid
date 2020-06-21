package com.awaredevelopers.puzzledroid.db.entity

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "scores")
class ScoreEntity(val scoreParam: Int, val levelParam: Int) {
    @PrimaryKey(autoGenerate = true)
    private var id: Int = 0
    private var score: Int = 0
    private var level: Int = 0

    init {
        setScore(scoreParam)
        setLevel(levelParam)
    }
    
    fun getId(): Int {
        return id
    }

    fun setId(id: Int) {
        this.id = id
    }

    fun getScore(): Int {
        return score
    }

    fun setScore(score: Int) {
        this.score = score
    }

    fun getLevel(): Int {
        return level
    }

    fun setLevel(level: Int) {
        this.level = level
    }
}