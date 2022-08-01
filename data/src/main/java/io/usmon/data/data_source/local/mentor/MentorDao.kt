package io.usmon.data.data_source.local.mentor

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

// Created by Usmon Abdurakhmanv on 7/31/2022.

@Dao
interface MentorDao {

    @Insert(onConflict = REPLACE)
    suspend fun insert(mentor: MentorEntity)

    @Delete
    suspend fun delete(mentor: MentorEntity)

    @Query("SELECT * FROM mentors WHERE courseId = :courseName")
    fun getMentorsByCourse(courseName: String): Flow<List<MentorEntity>>
}
