package com.awaredevelopers.puzzledroid.db;

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.awaredevelopers.puzzledroid.utility.DATABASE_NAME
import com.awaredevelopers.puzzledroid.db.dao.ScoreDao
import com.awaredevelopers.puzzledroid.db.entity.ScoreEntity

// https://github.com/android/sunflower/blob/master/app/src/main/java/com/google/samples/apps/sunflower/data/AppDatabase.kt
@Database(entities = [ScoreEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun scoreDao(): ScoreDao

    companion object {

        @Volatile private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(
                context,
                AppDatabase::class.java, DATABASE_NAME
            ).createFromAsset("database/puzzledroid.db").build()
        }
    }
}