package com.ntg.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.ntg.database.model.CategoryEntity

@Dao
interface CategoryDao {

    @Insert
    fun insert(categoryEntity: CategoryEntity)

    @Insert
    fun insertAll(categoryEntities: List<CategoryEntity>)

    @Delete
    fun delete(categoryEntity: CategoryEntity)

    @Query("SELECT * FROM category")
    fun getAll(): LiveData<CategoryEntity>

}