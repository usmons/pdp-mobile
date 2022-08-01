package io.usmon.domain.repository.group

import io.usmon.domain.util.Resource
import kotlinx.coroutines.flow.Flow

// Created by Usmon Abdurakhmanv on 7/31/2022.

interface GroupRepository {

    suspend fun insertGroup(group: Group): Resource<Unit>

    suspend fun isGroupNameAlreadyExist(groupName: String): Boolean

    suspend fun getGroupById(groupId: Int): Group?

    suspend fun deleteGroup(group: Group): Resource<Unit>

    fun getGroupsByCourse(courseName: String): Flow<List<GroupedStudents>>
}
