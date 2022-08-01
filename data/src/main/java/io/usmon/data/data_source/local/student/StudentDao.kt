package io.usmon.data.data_source.local.student

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

// Created by Usmon Abdurakhmanv on 7/31/2022.

@Dao
interface StudentDao {

    @Insert(onConflict = REPLACE)
    suspend fun insert(student: StudentEntity)

    @Query("SELECT * FROM students WHERE id = :id")
    suspend fun getStudentById(id: Int): StudentEntity?

    @Delete
    suspend fun delete(student: StudentEntity)

    @Query("SELECT * FROM students WHERE groupId = :groupId")
    fun getStudentsByGroup(groupId: Int): Flow<List<StudentEntity>>
}