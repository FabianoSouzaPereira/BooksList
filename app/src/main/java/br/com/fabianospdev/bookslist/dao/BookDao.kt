package br.com.fabianospdev.bookslist.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import br.com.fabianospdev.bookslist.dao.entity.Books


@Dao
interface BookDao {
    @Query("SELECT * FROM books")
    fun getAll(): List<Books>

    @Query("SELECT * FROM books WHERE uid IN (:BookIds)")
    fun loadAllByIds(BookIds: IntArray): List<Books>

    @Query("SELECT * FROM books WHERE name LIKE :name LIMIT 1")
    fun findByName(name: String): Books

    @Insert
    fun insertAll(vararg Books: Books)

    @Delete
    fun delete(Book: Books)
}