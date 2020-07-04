package com.awaredevelopers.puzzledroid.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "scores")
class ScoreEntity() {
    @PrimaryKey(autoGenerate = true)
    @NotNull
    private var id: Long = 0
    @ColumnInfo(defaultValue = "0")
    @NotNull
    private var level: Int = 0
    @ColumnInfo(defaultValue = "0")
    @NotNull
    private var score: Int = 0
    @NotNull
    private var nickname: String = ""
    
    fun getId(): Long {
        return id
    }

    fun setId(id: Long) {
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

    fun getNickname(): String {
        return this.nickname
    }

    fun setNickname(nickname: String) {
        this.nickname = nickname
    }
}