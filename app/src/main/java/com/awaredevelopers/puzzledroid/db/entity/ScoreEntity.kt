package com.awaredevelopers.puzzledroid.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "scores")
class ScoreEntity(
    @ColumnInfo(defaultValue = "0")
    @NotNull
    var level: Int,
    @ColumnInfo(defaultValue = "0")
    @NotNull
    var score: Int,
    @NotNull
    var nickname: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}