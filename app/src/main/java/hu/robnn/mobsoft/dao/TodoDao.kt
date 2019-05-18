package hu.robnn.mobsoft.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import hu.robnn.mobsoft.model.Todo

@Dao
interface TodoDao {

    @Query("SELECT * from todo_table")
    fun getTodos(): LiveData<List<Todo>>

    @Insert
    fun insert(todo: Todo)

    @Query("DELETE FROM todo_table")
    fun deleteAll()
}