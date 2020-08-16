package com.awaredevelopers.puzzledroid.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import org.jetbrains.annotations.Nullable

@Entity(tableName = "users")
class UserEntity(
    @ColumnInfo(defaultValue = "Player")
    @NotNull
    var name: String,
    @ColumnInfo(defaultValue = "0")
    @NotNull
    var level: Int,
    @ColumnInfo(defaultValue = "1")
    @NotNull
    var isEnabledBackgroundAudio: Int,
    @ColumnInfo(defaultValue = "1")
    @NotNull
    var isEnabledAudioEffects: Int,
    @NotNull
    var excludedImages: List<String>
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}