package br.com.fabianospdev.bookslist.dao

import androidx.room.Database
import androidx.room.DatabaseConfiguration
import androidx.room.InvalidationTracker
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteOpenHelper
import br.com.fabianospdev.bookslist.dao.entity.Books

@Database(entities = [Books::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun BookDao(): BookDao

    override fun createOpenHelper(config: DatabaseConfiguration?): SupportSQLiteOpenHelper {
        TODO("Not yet implemented")
    }

    override fun createInvalidationTracker(): InvalidationTracker {
        TODO("Not yet implemented")
    }

    override fun clearAllTables() {
        TODO("Not yet implemented")
    }
}