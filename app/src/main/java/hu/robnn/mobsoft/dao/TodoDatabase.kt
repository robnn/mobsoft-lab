package hu.robnn.mobsoft.dao

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import android.content.Context
import android.os.AsyncTask
import hu.robnn.mobsoft.model.Converters
import hu.robnn.mobsoft.model.Todo

@Database(entities = [Todo::class], version = 1)
@TypeConverters(Converters::class)
abstract class TodoDatabase : RoomDatabase() {
    abstract fun todoDao(): TodoDao

    companion object {
        @Volatile
        private var INSTANCE: TodoDatabase? = null

        fun getDatabase(context: Context): TodoDatabase {
            if (INSTANCE == null) {
                synchronized(TodoDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(context.applicationContext,
                            TodoDatabase::class.java, "todo_database")
                            .fallbackToDestructiveMigration()
                            .allowMainThreadQueries()
                            .addCallback(sRoomDatabaseCallback).build()
                    }
                }
            }
            return INSTANCE!!
        }

        private val sRoomDatabaseCallback = object: RoomDatabase.Callback() {
            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)

                PopulateDbAsync(INSTANCE).execute()
            }
        }

        private class PopulateDbAsync internal constructor(db: TodoDatabase?) : AsyncTask<Void, Void, Void>() {

            private val mDao: TodoDao? = db?.todoDao()

            override fun doInBackground(vararg params: Void): Void? {

                return null
            }
        }

        fun resetInstance() {
            INSTANCE = null
        }

        fun close() {
            INSTANCE?.close()
        }
    }

}