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
    var nickname: String,
    @NotNull
    var imgName: String
) {
    constructor(): this(
        0,
        0,
        "",
        ""
    ) {

    }

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0


}