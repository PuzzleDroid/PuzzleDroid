package com.awaredevelopers.puzzledroid.db;

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.awaredevelopers.puzzledroid.db.dao.ScoreDao
import com.awaredevelopers.puzzledroid.db.entity.ScoreEntity


@Database(entities = arrayOf(ScoreEntity::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    // abstract var sInstance: AppDatabase

    abstract fun scoreDao(): ScoreDao

    /**
    private val mIsDatabaseCreated = MutableLiveData<Boolean>()

    open fun getInstance(context: Context, executors: AppExecutors?): AppDatabase? {
        if (sInstance == null) {
            synchronized(AppDatabase::class.java) {
                if (sInstance == null) {
                    sInstance = buildDatabase(context.getApplicationContext(), executors)
                    sInstance.updateDatabaseCreated(context.getApplicationContext())
                }
            }
        }
        return sInstance
    }

    /**
     * Build the database. [Builder.build] only sets up the database configuration and
     * creates a new instance of the database.
     * The SQLite database is only created when it's accessed for the first time.
     */
    open fun buildDatabase(
        appContext: Context,
        executors: AppExecutors
    ): AppDatabase? {
        return Room.databaseBuilder(appContext, AppDatabase::class, DATABASE_NAME)
            .addCallback(object : Callback() {
                fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                    executors.diskIO().execute({

                        // Generate the data for pre-population
                        val database: AppDatabase = AppDatabase.getInstance(appContext, executors)
                        val products: List<ScoreEntity> =
                            DataGenerator.generateScores()
                        insertData(database, scores)
                        // notify that the database was created and it's ready to be used
                        database.setDatabaseCreated()
                    })
                }
            })
            .addMigrations(MIGRATION_1_2)
            .build()
    }

    /**
     * Check whether the database already exists and expose it via [.getDatabaseCreated]
     */
    open fun updateDatabaseCreated(context: Context) {
        if (context.getDatabasePath(DATABASE_NAME).exists()) {
            setDatabaseCreated()
        }
    }

    private fun setDatabaseCreated() {
        mIsDatabaseCreated.postValue(true)
    }

    open fun insertData(
        database: AppDatabase, scores: List<ScoreEntity>,
    ) {
        database.runInTransaction {
            database.scoreDao().insertAll(scores)
        }
    }

    private open fun addDelay() {
        try {
            Thread.sleep(4000)
        } catch (ignored: InterruptedException) {
        }
    }

    open fun getDatabaseCreated(): LiveData<Boolean?>? {
        return mIsDatabaseCreated
    }

    /**
    private val MIGRATION_1_2: Migration = object : Migration(1, 2) {
        fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL(
                "CREATE VIRTUAL TABLE IF NOT EXISTS `productsFts` USING FTS4("
                        + "`name` TEXT, `description` TEXT, content=`products`)"
            )
            database.execSQL(
                "INSERT INTO productsFts (`rowid`, `name`, `description`) "
                        + "SELECT `id`, `name`, `description` FROM products"
            )
        }
    }**/
    **/
}
