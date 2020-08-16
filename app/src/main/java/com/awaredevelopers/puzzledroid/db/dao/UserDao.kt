package com.awaredevelopers.puzzledroid.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.awaredevelopers.puzzledroid.db.entity.UserEntity
import kotlin.collections.List

@Dao
interface UserDao {
    @Query("Select * FROM users")
    fun loadLiveUsers(): LiveData<List<UserEntity>>
//
//    @Query("UPDATE users SET level = :level WHERE id = :id")
//    fun setLevel(id: Long, level: Int)
//
//    @Query("UPDATE users SET name = :name WHERE id = :id")
//    fun setName(id: Long, name: String)
//
//    @Query("UPDATE users SET isEnabledBackgroundAudio = :isEnabledBackgroundAudio WHERE id = :id")
//    fun setBackgroundAudio(id: Long, isEnabledBackgroundAudio: Boolean)
//
//    @Query("UPDATE users SET isEnabledAudioEffects = :isEnabledAudioEffects WHERE id = :id")
//    fun setAudioEffects(id: Long, isEnabledAudioEffects: Boolean)

    @Update
    suspend fun updateUser(user: UserEntity)
}