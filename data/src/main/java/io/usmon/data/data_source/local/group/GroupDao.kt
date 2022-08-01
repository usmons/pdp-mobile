package io.usmon.data.data_source.local.group

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import io.usmon.data.data_source.local.group.relations.GroupAndStudents
import kotlinx.coroutines.flow.Flow

// Created by Usmon Abdurakhmanv on 7/31/2022.

@Dao
interface GroupDao {

    @Insert(onConflict = REPLACE)
    suspend fun insert(group: GroupEntity)

    @Delete
    suspend fun delete(group: GroupEntity)

    @Transaction
    @Query("SELECT * FROM groups WHERE name = :groupName")
    suspend fun getGroupByName(groupName: String): GroupEntity?

    @Transaction
    @Query("SELECT * FROM groups WHERE id = :groupId")
    suspend fun getGroupById(groupId: Int): GroupEntity?

    @Transaction
    @Query("SELECT * FROM groups WHERE courseId = :courseName")
    fun getGroupsByCourse(courseName: String): Flow<List<GroupAndStudents>>
}