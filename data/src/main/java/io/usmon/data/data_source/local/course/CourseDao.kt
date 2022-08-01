package io.usmon.data.data_source.local.course

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow

// Created by Usmon Abdurakhmanv on 7/31/2022.

@Dao
interface CourseDao {

    @Insert(onConflict = REPLACE)
    suspend fun insert(course: CourseEntity)

    @Transaction
    @Query("SELECT * FROM courses WHERE name = :courseName")
    suspend fun getCourse(courseName: String): CourseEntity?

    @Transaction
    @Query("SELECT * FROM courses")
    fun getCourses(): Flow<List<CourseEntity>>
}