package com.awaredevelopers.puzzledroid.db;

import android.content.Context
import androidx.room.*
import com.awaredevelopers.puzzledroid.utility.DATABASE_NAME
import com.awaredevelopers.puzzledroid.db.dao.ScoreDao
import com.awaredevelopers.puzzledroid.db.dao.UserDao
import com.awaredevelopers.puzzledroid.db.entity.ScoreEntity
import com.awaredevelopers.puzzledroid.db.entity.UserEntity

// https://github.com/android/sunflower/blob/master/app/src/main/java/com/google/samples/apps/sunflower/data/AppDatabase.kt
@Database(entities = [ScoreEntity::class, UserEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun scoreDao(): ScoreDao
    abstract fun userDao(): UserDao

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
